package com.linkin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.linkin.model.UserDTO;
import com.linkin.model.UserPrincipal;
import com.linkin.service.UserService;

@Controller
public class UserWebController extends BaseWebController {
	@Autowired
	private UserService userService;

	@GetMapping("/dang-ky")
	public String register(HttpServletRequest request) {
		request.setAttribute("code", request.getParameter("code"));
		return "client/user/register";
	}

	@RequestMapping(value = "/dang-nhap")
	private String login(HttpSession httpSession, HttpServletRequest request,
			@RequestParam(required = false, name = "e") String error) {

		if (isLogin()) {
			return "redirect:/member/profile";
		}

		return getViewName(request, "client/user/login");
	}

	@GetMapping(value = "/member/doi-mat-khau")
	private String changePassword(Model model) {
		model.addAttribute("userAccountDTO", new UserDTO());
		return "admin/userAccount/changePassword";
	}

	@GetMapping(value = "/member/profile")
	private String profile(Model model) {
		UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		UserDTO accountDTO = userService.getUserById(currentUser.getId());
		model.addAttribute("userAccountDTO", accountDTO);

		return "admin/userAccount/profile";
	}
	@PostMapping(value = "/member/doi-mat-khau")
	private String changePassword(Model model, @ModelAttribute(name = "userAccountDTO") UserDTO userDTO,
			BindingResult bindingResult) {
		validateUserPassword(userDTO, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/userAccount/changePassword";
		}
		UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		userDTO.setId(currentUser.getId());
		try {
			userService.changePassword(userDTO);
		} catch (DataIntegrityViolationException ex) {
			bindingResult.rejectValue("password", "user.bad.password");
			return "admin/userAccount/changePassword";
		}
		return "redirect:/dang-xuat";
	}
	private void validateUserPassword(Object object, Errors errors) {
		UserDTO accountDTO = (UserDTO) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.msg.empty.account.password");
		if (accountDTO.getPassword().length() < 6 && StringUtils.isNotBlank(accountDTO.getPassword())) {
			errors.rejectValue("password", "error.msg.empty.account.password");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repassword", "error.msg.empty.account.password");
		if (accountDTO.getRepassword().length() < 6 && StringUtils.isNotBlank(accountDTO.getRepassword())) {
			errors.rejectValue("repassword", "error.msg.empty.account.password");
		}
	}

}
