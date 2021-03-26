package com.linkin.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkin.model.ResponseDTO;
import com.linkin.model.SearchUserDTO;
import com.linkin.model.UserDTO;
import com.linkin.model.UserPrincipal;
import com.linkin.service.UserService;
import com.linkin.utils.RoleEnum;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/api")
public class UserAPIController {

	@Autowired
	private UserService userService;

	// login me
	@PostMapping(value = "/member/me")
	private UserDTO me(@RequestParam(name = "token", required = false) String token) {
		UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		UserDTO userDTO = new UserDTO();
		userDTO.setId(currentUser.getId());
		userDTO.setDeviceId(token);
		return userService.getUserById(currentUser.getId());
	}

	@PostMapping("/user/register")
	public UserDTO register(@RequestBody UserDTO userDTO) {
		userDTO.setEnabled(true);
		userDTO.setRoles(Arrays.asList("ROLE_" + RoleEnum.MEMBER.name()));
		userService.addUser(userDTO);
		return userDTO;
	}

	@PostMapping("/admin/user/add")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		userDTO.setEnabled(true);
		userService.addUser(userDTO);
		return userDTO;
	}

	@PutMapping(value = "/admin/user/update")
	public void updateUser(@RequestBody UserDTO userDTO) {
		userService.updateUser(userDTO);
	}

	@DeleteMapping(value = "/admin/user/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
	}

	@DeleteMapping(value = "/admin/user/delete-multi")
	public void delete(@RequestParam(name = "ids") List<Long> ids) {
		for (Long id : ids) {
			try {
				userService.deleteUser(id);
			} catch (Exception e) {

			}
		}
	}

	@PostMapping(value = "/admin/accounts")
	public ResponseDTO<UserDTO> findCustomers(@RequestBody SearchUserDTO searchUserDTO) {
		ResponseDTO<UserDTO> responseDTO = new ResponseDTO<UserDTO>();
		responseDTO.setData(userService.find(searchUserDTO));
		responseDTO.setRecordsFiltered(userService.count(searchUserDTO));
		responseDTO.setRecordsTotal(userService.countTotal(searchUserDTO));
		return responseDTO;
	}

}
