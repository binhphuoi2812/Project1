
package com.linkin;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.linkin.entity.User;
import com.linkin.service.impl.AuditorAwareImpl;
import com.linkin.utils.FileStore;
import com.linkin.utils.RoleEnum;

@SpringBootApplication
@EnableJpaRepositories 
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class LinkInApplication extends WebMvcConfigurationSupport {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(LinkInApplication.class, args);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Configuration
	@Order(1)
	public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable().antMatcher("/api/**").authorizeRequests().antMatchers("/api/admin/**")
					.hasAnyRole(RoleEnum.ADMIN.getRoleName()).antMatchers("/api/member/**").authenticated().anyRequest()
					.permitAll().and().httpBasic();
		}
	}

	@Configuration
	public class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().authorizeRequests().antMatchers("/admin/**").hasAnyRole(RoleEnum.ADMIN.getRoleName())
					.antMatchers("/member/**").authenticated().anyRequest().permitAll().and().formLogin()
					.loginPage("/dang-nhap").loginProcessingUrl("/dang-nhap").defaultSuccessUrl("/member/home")
					.failureUrl("/dang-nhap?e").and().rememberMe().rememberMeCookieName("app-remember-me")
					.tokenValiditySeconds(24 * 60 * 60 * 30).tokenRepository(persistentTokenRepository()).and().logout()
					.logoutUrl("/dang-xuat").logoutSuccessUrl("/dang-nhap")
					.logoutRequestMatcher(new AntPathRequestMatcher("/dang-xuat")).clearAuthentication(true)
					.invalidateHttpSession(true).deleteCookies("JSESSIONID", "app-remember-me").permitAll().and()
					.exceptionHandling().accessDeniedPage("/access-deny").and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).sessionFixation().migrateSession()
					.maximumSessions(-1).sessionRegistry(sessionRegistry());
			http.headers().frameOptions().sameOrigin();
		}
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
		return bCryptPasswordEncoder;
	}

	@Bean
	public AuditorAware<User> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		SpringSecurityDialect dialect = new SpringSecurityDialect();
		return dialect;
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/image/**").addResourceLocations("file:" + FileStore.UPLOAD_FOLDER)
				.setCacheControl(CacheControl.maxAge(24 * 365, TimeUnit.HOURS).cachePublic());
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
