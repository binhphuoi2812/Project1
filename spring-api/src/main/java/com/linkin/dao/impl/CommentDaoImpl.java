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
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linkin.dao.CommentDao;
import com.linkin.entity.Comment;
import com.linkin.entity.Post;
import com.linkin.entity.User;
import com.linkin.model.SearchCommentDTO;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void add(Comment comment) {
		entityManager.persist(comment);
	}

	@Override
	public void update(Comment comment) {
		entityManager.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		entityManager.remove(comment);
	}

	@Override
	public Comment get(Long id) {
		return entityManager.find(Comment.class, id);
	}

	@Override
	public List<Comment> find(SearchCommentDTO searchCommentDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
		Root<Comment> root = criteriaQuery.from(Comment.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchCommentDTO.getKeyword())) {
			Predicate predicate1 = criteriaBuilder.like(criteriaBuilder.lower(root.get("content")),
					"%" + searchCommentDTO.getKeyword().toLowerCase() + "%");
			predicates.add(predicate1);
		}

		if (searchCommentDTO.getUserId() != null) {
			Join<Comment, User> comment = root.join("user");

			Predicate predicate = criteriaBuilder.equal(comment.get("id"), searchCommentDTO.getUserId());
			predicates.add(predicate);
		}
		if (searchCommentDTO.getPostId() != null) {
			Join<Comment, Post> comment = root.join("post");

			Predicate predicate = criteriaBuilder.equal(comment.get("id"), searchCommentDTO.getPostId());
			predicates.add(predicate);
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		// order
		if (StringUtils.equals(searchCommentDTO.getSortBy().getData(), "id")) {
			if (searchCommentDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
			}
		} else if (StringUtils.equals(searchCommentDTO.getSortBy().getData(), "content")) {
			if (searchCommentDTO.getSortBy().isAsc()) {
				criteriaQuery.orderBy(criteriaBuilder.asc(root.get("content")));
			} else {
				criteriaQuery.orderBy(criteriaBuilder.desc(root.get("content")));
			}
		}

		TypedQuery<Comment> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchCommentDTO.getStart() != null) {
			typedQuery.setFirstResult((searchCommentDTO.getStart()));
			typedQuery.setMaxResults(searchCommentDTO.getLength());
		}
		return typedQuery.getResultList();
	}

	@Override
	public Long count(SearchCommentDTO searchCommentDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Comment> root = criteriaQuery.from(Comment.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchCommentDTO.getKeyword())) {
			Predicate predicate1 = criteriaBuilder.like(criteriaBuilder.lower(root.get("content")),
					"%" + searchCommentDTO.getKeyword().toLowerCase() + "%");
			predicates.add(predicate1);
		}

		if (searchCommentDTO.getUserId() != null) {
			Join<Comment, User> comment = root.join("user");

			Predicate predicate = criteriaBuilder.equal(comment.get("id"), searchCommentDTO.getUserId());
			predicates.add(predicate);
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

	@Override
	public Long countTotal(SearchCommentDTO searchCommentDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Comment> root = criteriaQuery.from(Comment.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchCommentDTO.getUserId() != null) {
			Join<Comment, User> comment = root.join("user");

			Predicate predicate = criteriaBuilder.equal(comment.get("id"), searchCommentDTO.getUserId());
			predicates.add(predicate);
		}
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<Long> typedQuery = entityManager.createQuery(criteriaQuery.select(criteriaBuilder.count(root)));
		return typedQuery.getSingleResult();
	}

}
