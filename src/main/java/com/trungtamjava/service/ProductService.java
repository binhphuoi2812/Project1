package com.trungtamjava.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.ProductRepository;
import com.trungtamjava.entity.CategoryEntity;
import com.trungtamjava.entity.ProductEntity;
import com.trungtamjava.model.CategoryDTO;
import com.trungtamjava.model.ProductDTO;

public interface ProductService {

	void add(ProductDTO product);

	void update(ProductDTO product);

	void delete(int id);

	List<ProductDTO> search(String findName);

	ProductDTO get(int id);
	List<ProductDTO> searchByCategoryName(String keyword);
}
@Service
@Transactional

 class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void add(ProductDTO product) {
		ProductEntity product2= new ProductEntity();
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		
		CategoryEntity category= new CategoryEntity();
		category.setId(product.getCategoryDTO().getId());
		category.setName(product.getCategoryDTO().getName());
		product2.setCategoryEntity(category);
		productDao.add(product2);
	}

	@Override
	public void update(ProductDTO product) {
		ProductEntity product2=productDao.get(product.getId());
		if(product2!=null) {
			product2.setId(product.getId());
			product2.setName(product.getName());
			product2.setPrice(product.getPrice());

			CategoryEntity category= new CategoryEntity();
			category.setId(product.getCategoryDTO().getId());
			category.setName(product.getCategoryDTO().getName());
			product2.setCategoryEntity(category);
			productDao.update(product2);
		}
	}

	@Override
	public void delete(int id) {
		ProductEntity product2=productDao.get(id);
		if(product2!=null) {
			productDao.delete(product2);
		}
	}

	@Override
	public List<ProductDTO> search(String findName) {
		List<ProductEntity> listProducts= productDao.search(findName);
		List<ProductDTO> productDTOs= new ArrayList<ProductDTO>();
		for(ProductEntity product:listProducts) {
			ProductDTO dto= new ProductDTO();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setPrice(product.getPrice());

			CategoryDTO categoryDTO= new CategoryDTO();
			categoryDTO.setId(product.getCategoryEntity().getId());
			categoryDTO.setName(product.getCategoryEntity().getName());
			dto.setCategoryDTO(categoryDTO);
			productDTOs.add(dto);
		}
		return productDTOs;
	}

	@Override
	public ProductDTO get(int id) {
		ProductEntity product= productDao.get(id);
		ProductDTO dto= new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());

		dto.setPrice(product.getPrice());
		CategoryDTO categoryDTO= new CategoryDTO();
		categoryDTO.setId(product.getCategoryEntity().getId());
		categoryDTO.setName(product.getCategoryEntity().getName());
		dto.setCategoryDTO(categoryDTO);
		return dto;
	}
	@Override
	public List<ProductDTO> searchByCategoryName(String findName) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		List<ProductEntity> productEntities = productRepository.searchByCategoryName(findName);

		for (ProductEntity productEntity : productEntities) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setId(productEntity.getId());
			productDTO.setName(productEntity.getName());
			
			productDTO.setIdcategory(productEntity.getCategoryEntity().getId());

			productDTOs.add(productDTO);
		}

		return productDTOs;
	}

}

