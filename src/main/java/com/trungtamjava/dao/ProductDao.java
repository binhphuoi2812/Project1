package com.trungtamjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.ProductEntity;

public interface ProductDao {
	void add(ProductEntity product);

	void update(ProductEntity product);

	void delete(ProductEntity product);

	List<ProductEntity> search(String findName);

	ProductEntity get(int id);
}
@Transactional
@Repository
 class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void add(ProductEntity product) {
		entityManager.persist(product);
		
	}

	@Override
	public void update(ProductEntity product) {
		entityManager.merge(product);
		
	}

	@Override
	public void delete(ProductEntity product) {
		entityManager.remove(product);
	}

	@Override
	public List<ProductEntity> search(String findName) {
		String hql = "SELECT p FROM ProductEntity p WHERE p.name LIKE :param ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("param", "%" + findName + "%");

		return query.getResultList();
	}

	@Override
	public ProductEntity get(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(ProductEntity.class, id);
	}
}
