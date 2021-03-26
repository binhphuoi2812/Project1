package com.linkin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {

	@GetMapping("/admin/comment/list")
	public String listComment(Model model) {
		return "admin/comment/list-comment";
	}

}
