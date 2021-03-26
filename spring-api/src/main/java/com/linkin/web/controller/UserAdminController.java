package com.linkin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linkin.model.UserDTO;
import com.linkin.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class UserAdminController extends BaseWebController {

	@Autowired
	private UserService userService;

	@GetMapping("/accounts")
	public String listUser(Model model) {
		return "admin/userAccount/listUser";
	}

	@GetMapping("/account/reset-password/{id}")
	public String resetPassword(Model model, @PathVariable(name = "id") Long id) {
		UserDTO userDTO = userService.getUserById(id);
		model.addAttribute("userAccountDTO", userDTO);
		return "admin/userAccount/resetPassword";
	}
	
	@PostMapping("/account/reset-password")
	public String resetPassword(@ModelAttribute(name = "userAccountDTO") UserDTO userDTO, BindingResult bindingResult) {
		validateUserPassword(userDTO, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/userAccount/resetPassword";
		}
		userService.setupUserPassword(userDTO);

		return "redirect:/admin/accounts";
	}
	private void validateUserPassword(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.msg.empty.account.password");
	}
}
