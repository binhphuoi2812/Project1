package com.trungtamjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.PersonEntity;

public interface PersonDao {
	void add(PersonEntity p);

	void update(PersonEntity p);

	void delete(PersonEntity p);

	PersonEntity get(int id);

	List<PersonEntity> search(String keyword);

	
}

@Repository
@Transactional 
class PersonDaoImpl implements PersonDao {



	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(PersonEntity p) {
		entityManager.persist(p);// add
	}

	@Override
	public void update(PersonEntity p) {
		entityManager.merge(p);
	}

	@Override
	public void delete(PersonEntity p) {
		entityManager.remove(p);
	}

	@Override
	public PersonEntity get(int id) {
		return entityManager.find(PersonEntity.class, id);
	}

	@Override
	public List<PersonEntity> search(String keyword) {

		String hql = "SELECT p FROM PersonEntity p WHERE p.name LIKE :param OR p.username LIKE :param";
		Query query = entityManager.createQuery(hql);
		query.setParameter("param", "%" + keyword + "%");

		return query.getResultList();
	}

	
}