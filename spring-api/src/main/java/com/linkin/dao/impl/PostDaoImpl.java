package com.linkin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.linkin.dao.PostDao;
import com.linkin.entity.Category;
import com.linkin.entity.Post;
import com.linkin.entity.User;
import com.linkin.model.SearchPostDTO;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {

	@Autowired
	EntityManager entityManager;

	public void addPost(Post post) {
		entityManager.persist(post);
	}

	public void delPost(Post post) {
		entityManager.remove(post);

	}

	public void updatePost(Post post) {
		entityManager.merge(post);
	}

//	public List<Post> search(String name) {
//		String hql = "SELECT p FROM PostEntity p WHERE p.name like :name ";
//		return entityManager.createQuery(hql, Post.class).setParameter("name", "%" + name + "%").getResultList();
//	}

	public Post getPostId(Long id) {
		return entityManager.find(Post.class, id);
	}

	@Override
	public List<Post> find(SearchPostDTO searchPostDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> root = criteriaQuery.from(Post.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchPostDTO.getKeyword())) {
			Predicate predicate1 = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + searchPostDTO.getKeyword().toLowerCase() + "%");

			predicates.add(predicate1);
		}

		if (searchPostDTO.getCategoryId() != null) {
			Join<Post, Category> category = root.join("category");
			Predicate predicate = criteriaBuilder.equal(category.get("id"), searchPostDTO.getCategoryId());
			predicates.add(predicate);
		}

		if (searchPostDTO.getUserId() != null) {
			Join<Post, User> user = root.join("createdBy");
			Predicate predicate = criteriaBuilder.equal(user.get("id"), searchPostDTO.getUserId());
			predicates.add(predicate);
		}

		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		// order
		if (StringUtils.equals(searchPostDTO.getSortBy().getData(), "id")) {
			if (searchPostDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
			}
		} else if (StringUtils.equals(searchPostDTO.getSortBy().getData(), "name")) {
			if (searchPostDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("name")));
			}
		}

		TypedQuery<Post> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchPostDTO.getStart() != null) {
			typedQuery.setFirstResult((searchPostDTO.getStart()));
			typedQuery.setMaxResults(searchPostDTO.getLength());
		}
		return typedQuery.getResultList();
	}

	@Override
	public Long count(SearchPostDTO searchPostDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Post> root = criteriaQuery.from(Post.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchPostDTO.getKeyword())) {
			Predicate predicate1 = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + searchPostDTO.getKeyword().toLowerCase() + "%");

			predicates.add(predicate1);
		}

		if (searchPostDTO.getCategoryId() != null) {
			Join<Post, Category> category = root.join("category");

			Predicate predicate = criteriaBuilder.equal(category.get("id"), searchPostDTO.getCategoryId());
			predicates.add(predicate);
		}

		if (searchPostDTO.getUserId() != null) {
			Join<Post, User> user = root.join("user");

			Predicate predicate = criteriaBuilder.equal(user.get("id"), searchPostDTO.getUserId());
			predicates.add(predicate);
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

	@Override
	public Long countTotal(SearchPostDTO searchPostDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Post> root = criteriaQuery.from(Post.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchPostDTO.getCategoryId() != null) {
			Join<Post, Category> category = root.join("category");

			Predicate predicate = criteriaBuilder.equal(category.get("id"), searchPostDTO.getCategoryId());
			predicates.add(predicate);
		}

		if (searchPostDTO.getUserId() != null) {
			Join<Post, User> user = root.join("user");

			Predicate predicate = criteriaBuilder.equal(user.get("id"), searchPostDTO.getUserId());
			predicates.add(predicate);
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}
}
