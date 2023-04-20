package com.locShop.dao;

import java.util.List;

import com.locShop.DTO.ProductDTO;
import com.locShop.model.ProductEntity;

public interface IProductDao {
	public List<ProductEntity> findAll();
	public boolean insert(ProductEntity p);
	public boolean update(ProductEntity p);
	public boolean delete(Long proId);
	public ProductEntity findById(Long id);
	public ProductEntity getCategoryById(Long proId);
}
