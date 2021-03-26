package com.linkin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.CategoryDao;
import com.linkin.entity.Category;
import com.linkin.model.CategoryDTO;
import com.linkin.model.SearchCategoryDTO;
import com.linkin.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	public void add(CategoryDTO category) {
		Category categoryEntity = new Category();
		categoryEntity.setName(category.getName());
		categoryDao.add(categoryEntity);
	}

	public void delete(Long id) {
		Category category = categoryDao.getId(id);
		if (category != null)
			categoryDao.delete(category);

	}

	public void update(CategoryDTO categoryDTO) {
		Category category = categoryDao.getId(categoryDTO.getId());

		if (category != null) {
			category.setName(categoryDTO.getName());
			categoryDao.update(category);
		}

	}

	public CategoryDTO getId(Long id) {
		Category category = categoryDao.getId(id);
		if (category != null) {
			return convertToDTO(category);
		}
		return null;
	}

	@Override
	public List<CategoryDTO> find(SearchCategoryDTO searchCategoryDTO) {
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		List<Category> categories = categoryDao.find(searchCategoryDTO);
		for (Category category : categories) {
			categoryDTOs.add(convertToDTO(category));
		}

		return categoryDTOs;
	}

	private CategoryDTO convertToDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

	@Override
	public Long count(SearchCategoryDTO searchCategoryDTO) {
		return categoryDao.count(searchCategoryDTO);
	}

	@Override
	public Long countTotal(SearchCategoryDTO searchCategoryDTO) {
		return categoryDao.countTotal(searchCategoryDTO);
	}
}
