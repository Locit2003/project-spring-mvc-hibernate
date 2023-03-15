package com.locShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.locShop.dao.IProductDao;
import com.locShop.dao.impl.ProductDao;
import com.locShop.model.ProductEntity;
import com.locShop.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	
	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> list = productDao.findAll();
		return list;
	}

	@Override
	public boolean insert(ProductEntity c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProductEntity c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long proId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductEntity getCategoryById(Long proId) {
		// TODO Auto-generated method stub
		return null;
	}

}
