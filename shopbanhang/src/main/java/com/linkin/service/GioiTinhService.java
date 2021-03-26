package com.linkin.service;

import java.util.List;

import com.linkin.model.GioiTinhDTO;

public interface GioiTinhService {

	void add(GioiTinhDTO gioiTinhDTO);

	void update(GioiTinhDTO gioiTinhDTO);

	void delete(Long id);

	GioiTinhDTO getById(Long id);

	List<GioiTinhDTO> search(String name, int start, int length);
}
