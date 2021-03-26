package com.linkin.service;

import java.util.List;

import com.linkin.model.CategoryDTO;
import com.linkin.model.SearchCategoryDTO;

public interface CategoryService {
	void add(CategoryDTO category);

	void delete(Long id);

	void update(CategoryDTO category);

	CategoryDTO getId(Long id);

	List<CategoryDTO> find(SearchCategoryDTO searchCategoryDTO);

	Long count(SearchCategoryDTO searchCategoryDTO);

	Long countTotal(SearchCategoryDTO searchCategoryDTO);
}
