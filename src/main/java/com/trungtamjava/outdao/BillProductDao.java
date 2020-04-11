package com.trungtamjava.outdao;

import java.util.List;

import com.trungtamjava.outmodel.BillProduct;

public interface BillProductDao {
	void create(BillProduct b);

	void update(BillProduct b);

	void delete(int id);

	BillProduct get(int id);

	List<BillProduct> search(String name);
}
