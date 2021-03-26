package com.linkin.service;

import java.util.List;

import com.linkin.model.PostDTO;
import com.linkin.model.SearchPostDTO;

public interface PostService {
	void addPost(PostDTO post);

	void delPost(Long id);

	void updatePost(PostDTO post);

//	List<PostDTO> search(String name);
//
//	List<PostDTO> search(Long categoryid);

	PostDTO getPostId(Long id);

//	PostDTO getPostName(String name);
//
//	List<PostDTO> limit(int offset);

	List<PostDTO> find(SearchPostDTO searchPostDTO);

	Long count(SearchPostDTO searchPostDTO);

	Long countTotal(SearchPostDTO searchPostDTO);
}
