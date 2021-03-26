package com.linkin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("/admin/post/list")
	public String listPost(Model model) {
		return "admin/post/list-post";
	}

}
