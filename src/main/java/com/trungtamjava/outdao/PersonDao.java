package com.trungtamjava.outdao;

import java.util.List;

import com.trungtamjava.outmodel.Person;

// data access object
public interface PersonDao {
	void create(Person p);

	void update(Person p);

	void delete(int id);

	Person get(int id);

	List<Person> search(String name);

	Person getByUsername(String username);
}
