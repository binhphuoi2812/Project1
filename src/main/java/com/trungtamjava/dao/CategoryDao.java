package com.trungtamjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.CategoryEntity;
import com.trungtamjava.entity.CategoryEntity;

public interface CategoryDao {
	void add(CategoryEntity category);

	void update(CategoryEntity category);

	void delete(CategoryEntity category);

	CategoryEntity get(int id);

	List<CategoryEntity> search(String findName);
	
	
	

}
@Transactional
@Repository
 class CategoryDaoImpl implements CategoryDao {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void add(CategoryEntity category) {
		entityManager.persist(category);
		
	}

	@Override
	public void update(CategoryEntity category) {
		entityManager.merge(category);
		
	}

	@Override
	public void delete(CategoryEntity category) {
		entityManager.remove(category);
		
	}

	@Override
	public CategoryEntity get(int id) {
		
		return entityManager.find(CategoryEntity.class, id);
	}

	@Override
	public List<CategoryEntity> search(String findName) {
		String hql = "SELECT c FROM CategoryEntity c WHERE c.name LIKE :param ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("param", "%" + findName + "%");

		return query.getResultList();
	}
}
