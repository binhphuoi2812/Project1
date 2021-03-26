package com.linkin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

	@GetMapping("/admin/category/list")
	public String listCategory() {
		return "admin/category/list-category";
	}

}
