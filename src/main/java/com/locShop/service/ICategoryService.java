package com.locShop.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.locShop.model.CategoryEntity;

public interface ICategoryService {
	public List<CategoryEntity> findAll();
	public boolean insert(CategoryEntity c);
	public boolean update(CategoryEntity c);
	public boolean delete(Long proId);
	public CategoryEntity getCategoryById(Long catId);
}
