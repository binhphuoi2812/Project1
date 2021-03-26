package com.linkin.model;

import lombok.Data;

@Data
public class SearchPostDTO extends SearchDTO {
	private Long userId;
	private Long categoryId;

}
