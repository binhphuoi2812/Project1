package com.trungtamjava.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trungtamjava.dao.PersonRepository;
import com.trungtamjava.entity.PersonEntity;

@Service
@Transactional
public class LoginService implements UserDetailsService {
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PersonEntity p = personRepository.getByUsername(username);
		
		if (p == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		String role = p.getRole();
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(role));
		
		
		User currentUser = new User(username, p.getPassword(), authorities);
		
		
		return currentUser;
	}
}
