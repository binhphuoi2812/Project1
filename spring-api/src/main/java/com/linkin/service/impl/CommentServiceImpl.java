package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkin.dao.CommentDao;
import com.linkin.dao.PostDao;
import com.linkin.dao.UserDao;
import com.linkin.entity.Comment;
import com.linkin.entity.Post;
import com.linkin.entity.User;
import com.linkin.model.CommentDTO;
import com.linkin.model.PostDTO;
import com.linkin.model.SearchCommentDTO;
import com.linkin.service.CommentService;
import com.linkin.utils.DateTimeUtils;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;

	@Autowired
	private PostDao postDao;

	@Override
	public void add(CommentDTO commentDTO) {
		Comment comment = new Comment();
		comment.setContent(commentDTO.getContent());
		comment.setCreatedDate(new Date());
		User user = userDao.getById(commentDTO.getUserId());
		comment.setUser(user);
		Post post= postDao.getPostId(commentDTO.getPostId());
		comment.setPost(post);
		commentDao.add(comment);
		commentDTO.setId(comment.getId());

	}

	@Override
	public void delete(Long id) {
		Comment comment = commentDao.get(id);
		if (comment != null) {
			commentDao.delete(comment);
		}
	}

	@Override
	public void update(CommentDTO commentDTO) {
		Comment comment = commentDao.get(commentDTO.getId());
		if (comment != null) {
			comment.setContent(commentDTO.getContent());
			comment.setCreatedDate(new Date());
			User user = userDao.getById(commentDTO.getUserId());
			comment.setUser(user);
			Post post= postDao.getPostId(commentDTO.getPostId());
			comment.setPost(post);
			commentDao.update(comment);
		}

	}

	@Override
	public List<CommentDTO> find(SearchCommentDTO searchCommentDTO) {
		List<Comment> commentList = commentDao.find(searchCommentDTO);
		List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
		commentList.forEach(comments -> {
			commentDTOs.add(convertToDTO(comments));
		});
		return commentDTOs;
	}

	private CommentDTO convertToDTO(Comment comments) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comments.getId());
		commentDTO.setContent(comments.getContent());
		commentDTO.setUserId(comments.getUser().getId());
		commentDTO.setCreatedDate(DateTimeUtils.formatDate(comments.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
		commentDTO.setPostId(comments.getPost().getId());
		return commentDTO;
	}

	@Override
	public Long count(SearchCommentDTO searchCommentDTO) {
		// TODO Auto-generated method stub
		return commentDao.count(searchCommentDTO);
	}

	@Override
	public Long countTotal(SearchCommentDTO searchCommentDTO) {
		// TODO Auto-generated method stub
		return commentDao.countTotal(searchCommentDTO);
	}

	@Override
	public CommentDTO get(Long id) {
		Comment comment = commentDao.get(id);
//		CommentDTO commentDTO = new CommentDTO();
//
//		comment.setContent(commentDTO.getContent());
//		comment.setCreatedDate(new Date());
//		User user = userDao.getById(commentDTO.getId());
//		comment.setUser(user);

		return convertToDTO(comment);
	}

}
