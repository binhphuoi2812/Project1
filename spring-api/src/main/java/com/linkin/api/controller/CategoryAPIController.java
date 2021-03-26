package com.linkin.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkin.model.CategoryDTO;
import com.linkin.model.ResponseDTO;
import com.linkin.model.SearchCategoryDTO;
import com.linkin.service.CategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = -1)
public class CategoryAPIController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/admin/category/add")
	public CategoryDTO addUser(@RequestBody CategoryDTO categoryDTO) {
		categoryService.add(categoryDTO);
		return categoryDTO;
	}
	
	@PostMapping("/admin/category/add-form")
	public CategoryDTO addUserForm(@ModelAttribute CategoryDTO categoryDTO) {
		categoryService.add(categoryDTO);
		return categoryDTO;
	}

	@PutMapping(value = "/admin/category/update")
	public void updateUser(@RequestBody CategoryDTO categoryDTO) {
		categoryService.update(categoryDTO);
	}

	@DeleteMapping(value = "/admin/category/delete")
	public void delete(@RequestParam(name = "id") Long id) {
		categoryService.delete(id);
	}

	@DeleteMapping(value = "/admin/category/delete-multi")
	public void delete(@RequestParam(name = "ids") List<Long> ids) {
		ids.forEach(id -> {
			categoryService.delete(id);
		});
	}

	@GetMapping(value = "/category/{id}")
	public CategoryDTO get(@PathVariable(name = "id") Long id) {
		return categoryService.getId(id);
	}

	@PostMapping(value = "/category/search")
	public ResponseDTO<CategoryDTO> find(@RequestBody SearchCategoryDTO searchCategoryDTO) {
		ResponseDTO<CategoryDTO> responseDTO = new ResponseDTO<CategoryDTO>();
		responseDTO.setData(categoryService.find(searchCategoryDTO));
		responseDTO.setRecordsFiltered(categoryService.count(searchCategoryDTO));
		responseDTO.setRecordsTotal(categoryService.countTotal(searchCategoryDTO));
		return responseDTO;
	}
}