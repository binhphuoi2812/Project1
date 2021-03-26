package com.linkin.model;

import java.util.List;

import lombok.Data;

@Data
public class SearchUserDTO extends SearchDTO {

	private Boolean enabled;
	private List<String> roleList;
	private Long createdById;
	private String createdBy;

}
