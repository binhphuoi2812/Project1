package com.linkin.dao;

import java.util.List;

import com.linkin.entity.Category;
import com.linkin.model.SearchCategoryDTO;

public interface CategoryDao {
	void add(Category category);

	void delete(Category category);

	void update(Category category);

	Category getId(Long id);

	List<Category> find(SearchCategoryDTO searchCategoryDTO);

	Long count(SearchCategoryDTO searchCategoryDTO);

	Long countTotal(SearchCategoryDTO searchCategoryDTO);

}
