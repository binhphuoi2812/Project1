package com.linkin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.CategoryDao;
import com.linkin.entity.Category;
import com.linkin.model.SearchCategoryDTO;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private EntityManager entityManager;

	public void add(Category category) {
		entityManager.persist(category);
	}

	public void delete(Category category) {
		entityManager.remove(category);
	}

	public void update(Category category) {
		entityManager.merge(category);
	}

	public Category getId(Long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> find(SearchCategoryDTO searchCategoryDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
		Root<Category> root = criteriaQuery.from(Category.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchCategoryDTO.getKeyword())) {
			Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + searchCategoryDTO.getKeyword().toLowerCase() + "%");
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		// order
		if (StringUtils.equals(searchCategoryDTO.getSortBy().getData(), "id")) {
			if (searchCategoryDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
			}
		} else if (StringUtils.equals(searchCategoryDTO.getSortBy().getData(), "name")) {
			if (searchCategoryDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("name")));
			}
		}

		TypedQuery<Category> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchCategoryDTO.getStart() != null) {
			typedQuery.setFirstResult((searchCategoryDTO.getStart()));
			typedQuery.setMaxResults(searchCategoryDTO.getLength());
		}
		return typedQuery.getResultList();
	}

	@Override
	public Long count(SearchCategoryDTO searchCategoryDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Category> root = criteriaQuery.from(Category.class);

		// Constructing list of parameters
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (StringUtils.isNotBlank(searchCategoryDTO.getKeyword())) {
			Predicate predicate1 = builder.like(builder.lower(root.get("name")),
					"%" + searchCategoryDTO.getKeyword().toLowerCase() + "%");
			predicates.add(predicate1);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(builder.count(root)));
		return typedQuery.getSingleResult();
	}

	@Override
	public Long countTotal(SearchCategoryDTO searchCategoryDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Category> root = criteriaQuery.from(Category.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(builder.count(root)));
		return typedQuery.getSingleResult();
	}

}
