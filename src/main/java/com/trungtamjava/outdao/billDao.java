package com.trungtamjava.outdao;

import java.util.List;

import com.trungtamjava.outmodel.bill;

public interface billDao {
	static void create(bill b) {
		// TODO Auto-generated method stub
		
	}

	static void update(bill b) {
		// TODO Auto-generated method stub
		
	}

	void delete(int id);

	bill get(int id);

	List<bill> search(String name);

}
