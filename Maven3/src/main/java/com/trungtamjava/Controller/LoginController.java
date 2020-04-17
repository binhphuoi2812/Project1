package com.trungtamjava.Controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/admin-login")
	public String hello(HttpServletRequest req) {
		return "admin-login";
	}
	
	@GetMapping("/access-deny")
	public String accessDeny(HttpServletRequest req) {
		return "access-deny";
	}
}