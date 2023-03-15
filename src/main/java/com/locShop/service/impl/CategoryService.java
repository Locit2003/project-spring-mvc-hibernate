package com.locShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locShop.dao.ICategoryDao;
import com.locShop.model.CategoryEntity;
import com.locShop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public List<CategoryEntity> findAll() {
		List<CategoryEntity> list = categoryDao.findAll();
		return list;
	}

	@Override
	public boolean insert(CategoryEntity c) {
		if(categoryDao.insert(c)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(CategoryEntity c) {
		if(categoryDao.update(c)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Long proId) {
		if(categoryDao.delete(proId)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CategoryEntity getCategoryById(Long catId) {
		return categoryDao.getCategoryById(catId);
	}

}
