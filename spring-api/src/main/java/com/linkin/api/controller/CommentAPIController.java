package com.linkin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkin.model.CommentDTO;
import com.linkin.model.ResponseDTO;
import com.linkin.model.SearchCommentDTO;
import com.linkin.service.CommentService;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/api")
public class CommentAPIController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/member/comment/add")
	public CommentDTO addComment(@RequestBody CommentDTO commentDTO) {
		commentService.add(commentDTO);
		return commentDTO;
	}

//	@PutMapping(value = "/admin/comment/update")
//	public void updateComment(@RequestBody CommentDTO commentDTO) {
//		commentService.update(commentDTO);
//	}

	@DeleteMapping(value = "/admin/comment/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		commentService.delete(id);

	}

	@PostMapping(value = "/comment/search")
	public ResponseDTO<CommentDTO> find(@RequestBody SearchCommentDTO searchCommentDTO) {
		ResponseDTO<CommentDTO> responseDTO = new ResponseDTO<CommentDTO>();
		responseDTO.setData(commentService.find(searchCommentDTO));
		responseDTO.setRecordsFiltered(commentService.count(searchCommentDTO));
		responseDTO.setRecordsTotal(commentService.countTotal(searchCommentDTO));
		return responseDTO;
	}

}
