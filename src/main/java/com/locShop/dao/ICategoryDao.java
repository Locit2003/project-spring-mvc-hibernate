package com.locShop.dao;

import java.util.List;

import com.locShop.model.CategoryEntity;

public interface ICategoryDao {
	public List<CategoryEntity> findAll();
	public boolean insert(CategoryEntity c);
	public boolean update(CategoryEntity c);
	public boolean delete(Long proId);
	public CategoryEntity getCategoryById(Long catId);
}
