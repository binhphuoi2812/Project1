package com.linkin.dao;

import java.util.List;

import com.linkin.entity.Comment;
import com.linkin.model.SearchCommentDTO;

public interface CommentDao {

	void add(Comment comment);

	void delete(Comment comment);

	void update(Comment comment);

	List<Comment> find(SearchCommentDTO searchCommentDTO);

	Long count(SearchCommentDTO searchCommentDTO);

	Long countTotal(SearchCommentDTO searchCommentDTO);

	Comment get(Long id);

}
