package com.linkin.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String password;
	private String phone;
	private String repassword;
	private String address;
	private Boolean enabled;
	private String deviceId;
	private String createdDate;
	private String createdBy;
	private List<String> roles;
	private Long createdById;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id) {
		super();
		this.id = id;
	}
	
}
