package com.trungtamjava.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.dao.PersonDao;
import com.trungtamjava.dao.PersonRepository;
import com.trungtamjava.entity.PersonEntity;
import com.trungtamjava.model.PersonDTO;

public interface PersonService {

	void add(PersonDTO p);

	void update(PersonDTO personDTO);

	void delete(int id);

	PersonDTO get(int id);

	List<PersonDTO> search(String keyword);
}

@Service
@Transactional
class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void add(PersonDTO p) {
		System.out.println("Add person");
		
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(p.getId());
		personEntity.setName(p.getName());
		personEntity.setRole(p.getRole());
		personEntity.setUsername(p.getUsername());
		personEntity.setPassword(p.getPassword());
		personEntity.setImageurl(p.getImageurl());
		
		
		personRepository.save(personEntity);
		p.setId(personEntity.getId());
	}

	@Override
	public void update(PersonDTO personDTO) {
		PersonEntity personEntity = personDao.get(personDTO.getId());
		if (personEntity != null) {
			personEntity.setName(personDTO.getName());
			personEntity.setRole(personDTO.getRole());
			personEntity.setUsername(personDTO.getUsername());
			personEntity.setPassword(personDTO.getPassword());
			personEntity.setImageurl(personDTO.getImageurl());
			
			personRepository.save(personEntity);
		}
	}

	@Override
	public void delete(int id) {
		PersonEntity personEntity = personDao.get(id);
		if (personEntity != null) {
			personDao.delete(personEntity);
		}
	}

	@Override
	public PersonDTO get(int id) {
		PersonEntity personEntity = personDao.get(id);
		if (personEntity != null) {
			PersonDTO personDTO = new PersonDTO();

			personDTO.setId(personEntity.getId());
			personDTO.setName(personEntity.getName());
			personEntity.setRole(personDTO.getRole());
			personEntity.setUsername(personDTO.getUsername());
			personEntity.setPassword(personDTO.getPassword());
			personEntity.setImageurl(personDTO.getImageurl());
			return personDTO;
		}

		return null;
	}

	@Override
	public List<PersonDTO> search(String keyword) {
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();

		//List<PersonEntity> personEntities = personDao.search(keyword);
		List<PersonEntity> personEntities = personRepository.search(keyword);
		
		for (PersonEntity personEntity : personEntities) {
			PersonDTO personDTO = new PersonDTO();

			personDTO.setId(personEntity.getId());
			personDTO.setName(personEntity.getName());
			personEntity.setRole(personDTO.getRole());
			personEntity.setUsername(personDTO.getUsername());
			personEntity.setPassword(personDTO.getPassword());
			personEntity.setImageurl(personDTO.getImageurl());
			personDTOs.add(personDTO);
		}

		return personDTOs;
	}
}
