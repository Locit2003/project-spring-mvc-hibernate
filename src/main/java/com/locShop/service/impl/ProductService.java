package com.locShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.locShop.DTO.ProductDTO;
import com.locShop.dao.ICategoryDao;
import com.locShop.dao.IProductDao;
import com.locShop.dao.impl.ProductDao;
import com.locShop.model.ProductEntity;
import com.locShop.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> list = productDao.findAll();
		return list;
	}

	@Override
	public boolean insert(ProductDTO p) {
		ProductEntity prod = new ProductEntity(null, null, null, null, p.getName(), p.getImage(), p.getPrice(), p.getSale_price(), p.getDescription(), categoryDao.getCategoryById(p.getCategory_id()));
		return productDao.insert(prod);
	}

	@Override
	public boolean update(ProductDTO p) {
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

	@Override
	public ProductEntity findById(Long proId) {
		return productDao.findById(proId);
	}

}
