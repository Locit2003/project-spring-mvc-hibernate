package com.locShop.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.locShop.DTO.ProductDTO;
import com.locShop.model.ProductEntity;

public interface IProductService {
	public List<ProductEntity> findAll();
	public boolean insert(ProductDTO p);
	public boolean update(ProductDTO p);
	public boolean delete(Long proId);
	public ProductEntity findById(Long proId);
	public ProductEntity getCategoryById(Long proId);
}
