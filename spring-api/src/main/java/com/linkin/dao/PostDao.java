package com.linkin.dao;

import java.util.List;

import com.linkin.entity.Post;
import com.linkin.model.SearchPostDTO;

public interface PostDao {
	void addPost(Post post);

	void delPost(Post post);

	void updatePost(Post post);

	Post getPostId(Long id);

	List<Post> find(SearchPostDTO searchPostDTO);

	Long count(SearchPostDTO searchPostDTO);

	Long countTotal(SearchPostDTO searchPostDTO);

}
