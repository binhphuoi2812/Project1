package com.trungtamjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

	@Query("SELECT p FROM PersonEntity p WHERE p.name LIKE :param OR username LIKE :param")
	List<PersonEntity> search(@Param("param") String keyword);

	
}
