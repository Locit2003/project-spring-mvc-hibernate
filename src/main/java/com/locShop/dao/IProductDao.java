package com.locShop.dao;

import java.util.List;
import com.locShop.model.ProductEntity;

public interface IProductDao {
	public List<ProductEntity> findAll();
	public boolean insert(ProductEntity c);
	public boolean update(ProductEntity c);
	public boolean delete(Long proId);
	public ProductEntity getCategoryById(Long proId);
}
