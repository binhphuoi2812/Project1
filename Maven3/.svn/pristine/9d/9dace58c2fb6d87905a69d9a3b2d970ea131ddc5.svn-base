package com.trungtamjava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.entity.CategoryEntity;
import com.trungtamjava.model.CategoryDTO;

public interface CategoryService {
	void add(CategoryDTO categoryDTO);
	void update(CategoryDTO categoryDTO);
	void delete(int id);
	CategoryDTO get(int id);
	List<CategoryDTO> search(String name);
}
@Transactional
@Repository
 class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	@Override
	public void add(CategoryDTO categoryDTO) {
		CategoryEntity category= new CategoryEntity();
		category.setName(categoryDTO.getName());
		categoryDao.add(category);
	}

	@Override
	public void update(CategoryDTO categoryDTO) {
		CategoryEntity category= categoryDao.get(categoryDTO.getId());
		if(category!=null) {
			category.setId(categoryDTO.getId());
			category.setName(categoryDTO.getName());
			categoryDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryEntity category= categoryDao.get(id);
		if(category!=null) {
			categoryDao.delete(category);
		}
		
	}

	@Override
	public CategoryDTO get(int id) {
		CategoryEntity category= categoryDao.get(id);
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> search(String name) {
		List<CategoryEntity> categories= categoryDao.search(name);
		List<CategoryDTO> categoryDTOs=new ArrayList<CategoryDTO>();
		for(CategoryEntity category:categories) {
			CategoryDTO categoryDTO= new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

}
