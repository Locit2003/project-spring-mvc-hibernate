package com.locShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.locShop.HibernateUtitill.HibernateUtil;
import com.locShop.dao.IProductDao;
import com.locShop.model.ProductEntity;

@Repository
public class ProductDao implements IProductDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<ProductEntity> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<ProductEntity> list = session.createQuery("from com.locShop.model.ProductEntity",ProductEntity.class).list();
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
	public boolean insert(ProductEntity c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(c);
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
