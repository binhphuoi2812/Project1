package com.trungtamjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	@Query("SELECT p FROM ProductEntity p WHERE p.id LIKE :param")
	List<ProductEntity> search(@Param("param") String id);

	@Query("SELECT p FROM ProductEntity p JOIN p.categoryEntity category WHERE category.name LIKE :param")
	List<ProductEntity> searchByCategoryName(@Param("param") String categoryName);
}
