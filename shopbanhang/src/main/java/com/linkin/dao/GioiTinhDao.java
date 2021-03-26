package com.linkin.dao;

import java.util.List;

import com.linkin.entity.GioiTinh;

public interface GioiTinhDao {

	void add(GioiTinh gioiTinh);

	void update(GioiTinh gioiTinh);

	void delete(Long id);

	GioiTinh getById(Long id);

	List<GioiTinh> Search(String name, int start, int length);

}
