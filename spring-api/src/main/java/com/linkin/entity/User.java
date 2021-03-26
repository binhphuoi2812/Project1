package com.linkin.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User extends CreateAuditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "phone", unique = true)
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "device_id", length = 1000)
	private String deviceId;

	@Column(name = "enabled")
	private Boolean enabled;

	@ElementCollection
	@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "user_id", "role" }) })
	@Column(name = "role")
	private List<String> roles;

	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}

}
