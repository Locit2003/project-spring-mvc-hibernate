package com.locShop.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.locShop.model.ProductEntity;

@Repository
public interface IProductService {
	public List<ProductEntity> findAll();
	public boolean insert(ProductEntity c);
	public boolean update(ProductEntity c);
	public boolean delete(Long proId);
	public ProductEntity getCategoryById(Long proId);
}
