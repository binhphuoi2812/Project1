package com.linkin.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PostDTO {
	private Long id;
	private String title;
	private String description;
	private List<String> images;
	private Long categoryId;
	private String categoryName;
	private String createBy;
	private String createdDate;

	@JsonIgnore
	private List<MultipartFile> imageFile;

}
