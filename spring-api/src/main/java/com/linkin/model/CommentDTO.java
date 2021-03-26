package com.linkin.model;

import lombok.Data;

@Data
public class CommentDTO {
	private Long id;
	private String content;
	private Long userId;
	private String createdDate;
	private Long postId;

}
