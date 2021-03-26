package com.linkin.service;

import java.util.List;

import com.linkin.model.CommentDTO;
import com.linkin.model.SearchCommentDTO;

public interface CommentService {

	void add(CommentDTO commentDTO);

	void delete(Long id);

	void update(CommentDTO commentDTO);

	List<CommentDTO> find(SearchCommentDTO searchCommentDTO);

	Long count(SearchCommentDTO searchCommentDTO);

	Long countTotal(SearchCommentDTO searchCommentDTO);

	CommentDTO get(Long id);

}
