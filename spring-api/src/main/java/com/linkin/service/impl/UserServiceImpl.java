package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.linkin.dao.UserDao;
import com.linkin.entity.User;
import com.linkin.model.SearchUserDTO;
import com.linkin.model.UserDTO;
import com.linkin.model.UserPrincipal;
import com.linkin.service.UserService;
import com.linkin.utils.DateTimeUtils;
import com.linkin.utils.PasswordGenerator;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
		user.setEnabled(userDTO.getEnabled());
		if (userDTO.getRoles() != null) {
			user.setRoles(userDTO.getRoles());
		}
		user.setAddress(userDTO.getAddress());

		userDao.add(user);
		userDTO.setId(user.getId());
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user = userDao.getById(userDTO.getId());
		if (user != null) {
			user.setName(userDTO.getName());
			user.setPhone(userDTO.getPhone());
			user.setAddress(userDTO.getAddress());
			userDao.update(user);

		}
	}

	@Override
	public void deleteUser(Long id) {
		User user = userDao.getById(id);
		if (user != null) {
			userDao.delete(user);
		}
	}

	@Override
	public List<UserDTO> find(SearchUserDTO searchUserDTO) {
		List<User> users = userDao.find(searchUserDTO);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		users.forEach(user -> {
			userDTOs.add(convertToDTO(user));
		});

		return userDTOs;
	}

	@Override
	public long count(SearchUserDTO searchUserDTO) {
		return userDao.count(searchUserDTO);
	}

	@Override
	public long countTotal(SearchUserDTO searchUserDTO) {
		return userDao.countTotal(searchUserDTO);
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userDao.getById(id);
		if (user != null) {
			return convertToDTO(user);
		}
		return null;
	}

	private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setAddress(user.getAddress());
		userDTO.setEnabled(user.getEnabled());
		userDTO.setRoles(new ArrayList<>(user.getRoles()));
		userDTO.setCreatedDate(DateTimeUtils.formatDate(user.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
		if (user.getCreatedBy() != null) {
			userDTO.setCreatedBy(user.getCreatedBy().getName());
		}

		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByPhone(username.trim());
		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (String role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		UserPrincipal userPrincipal = new UserPrincipal(user.getPhone(), user.getPassword(), user.getEnabled(), true,
				true, true, authorities);
		userPrincipal.setId(user.getId());
		userPrincipal.setName(user.getName());
		userPrincipal.setRoles(user.getRoles());
		return userPrincipal;
	}

	@Override
	public void changePassword(UserDTO userDTO) {
		User user = userDao.getById(userDTO.getId());
		if (user != null && PasswordGenerator.checkHashStrings(userDTO.getPassword(), user.getPassword())) {
			user.setPassword(PasswordGenerator.getHashString(userDTO.getRepassword()));
			userDao.update(user);
		} else {
			throw new DataIntegrityViolationException("wrong password");
		}
	}
	@Override
	public void setupUserPassword(UserDTO accountDTO) {
		User user = userDao.getById(accountDTO.getId());
		if (user != null) {
			user.setPassword(PasswordGenerator.getHashString(accountDTO.getPassword()));
		}
	}
}
