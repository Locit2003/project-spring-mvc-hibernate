package com.locShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.locShop.DTO.ProductDTO;
import com.locShop.HibernateUtitill.HibernateUtil;
import com.locShop.dao.IProductDao;
import com.locShop.model.ProductEntity;

@Repository
public class ProductDao implements IProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductEntity> findAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<ProductEntity> list = session.createQuery("from ProductEntity",ProductEntity.class).list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public boolean insert(ProductEntity p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(ProductEntity p) {
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
	public ProductEntity findById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			ProductEntity prodById = session.get(ProductEntity.class,id);
			return prodById;
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
		return null;
	}

}
