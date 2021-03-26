package com.linkin.model;

import lombok.Data;

@Data
public class SearchCommentDTO extends SearchDTO {
	private Long userId;
	private Long postId;
}
