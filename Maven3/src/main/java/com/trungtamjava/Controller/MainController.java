package com.trungtamjava.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.dao.PersonDao;
import com.trungtamjava.model.PersonDTO;
import com.trungtamjava.service.PersonService;


@Controller
public class MainController {
	
	@Autowired
	PersonService personService;

	@Autowired
	Environment environment;

	@GetMapping(value = "/admin/dashboard")
	public String AdminDashboard(HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		PersonDTO u=(PersonDTO)httpSession.getAttribute("loginUser");
		request.setAttribute("u", u);
		return "/Dashboard/dashboard";
	}
	@GetMapping(value = "/admin/infor")
	public String AdminInfor(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		PersonDTO u=(PersonDTO)httpSession.getAttribute("loginUser");
		request.setAttribute("u", u);
		return "/Admin-login/list-admin";
	}
	

	@GetMapping(value = "/admin/user/add")
	public String AdminAddUserGet(HttpServletRequest request, Model model) {
		model.addAttribute("useradd", new PersonDTO());
		return "/Admin-login/add-admin";
	}

	@PostMapping(value = "/admin/user/add")
	public String AdminAddUserPost(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "imageFile") MultipartFile imagefile, @ModelAttribute(name = "adduser") PersonDTO user) {
		String originalFilename = imagefile.getOriginalFilename();
		int lastIndex = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(lastIndex);

		String avatarFilename = System.currentTimeMillis() + ext;
		File newfile = new File("C:\\filetest\\" + originalFilename);
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(newfile);
			fileOutputStream.write(imagefile.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String image = imagefile.getOriginalFilename();

		user.setImageurl(image);
		System.out.println(user.getName() + user.getId());
		personService.add(user);

		return "redirect:/Admin-login/list-admin";

	}

	@GetMapping(value = "/admin/user/update")
	public String AdminUpdateUserGet(HttpServletRequest request, Model model, int id) {
		PersonDTO user = personService.get(id);
		request.setAttribute("User", user);
		model.addAttribute("user", user);
		return "/Admin-login/update";
	}

	@PostMapping(value = "/admin/user/update")
	public String AdminUpdateUserPost(HttpServletRequest request, @ModelAttribute(name = "user") PersonDTO user,
			@RequestParam(name = "imageFile") MultipartFile imagefile) {
		System.out.println(user.getName() + user.getRole() + user.getImageurl() + user.getUsername() + user.getPassword());
		File newfile = new File("C:\\filetest\\" + imagefile.getOriginalFilename());
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(newfile);
			fileOutputStream.write(imagefile.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String image = imagefile.getOriginalFilename();
		user.setImageurl(image);
		personService.update(user);
		return "redirect:/Admin-login/list-admin";
	}

	@GetMapping(value = "/admin/user/delete")
	public String AdminDeleteUser(HttpServletRequest request,int id) {
		personService.delete(id);
		return "redirect:/Admin-login/list-admin";
	}

	
	

}