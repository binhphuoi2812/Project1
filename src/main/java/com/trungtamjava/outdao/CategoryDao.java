package com.trungtamjava.outdao;

import java.util.List;

import com.trungtamjava.outmodel.Category;
import com.trungtamjava.outmodel.Person;

public interface CategoryDao {

	void create(Category c);

	void update(Category c);

	void delete(int id);

	Category get(int id);

	List<Category> search(String name);

}
