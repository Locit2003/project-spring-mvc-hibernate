package com.locShop.dao.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.locShop.HibernateUtitill.HibernateUtil;
import com.locShop.dao.ICategoryDao;
import com.locShop.model.CategoryEntity;

@Repository
public class CategoryDao implements ICategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<CategoryEntity> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<CategoryEntity> list = session
					.createQuery("from com.locShop.model.CategoryEntity", CategoryEntity.class).list();
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
	public boolean insert(CategoryEntity c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			c.setCreated_at(null);
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
	public boolean update(CategoryEntity c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Date currentDate = Calendar.getInstance().getTime();
			c.setCreated_at(currentDate);
			session.update(c);
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
	public boolean delete(Long catId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(this.getCategoryById(catId));
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
	public CategoryEntity getCategoryById(Long catId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			CategoryEntity cat = (CategoryEntity) session.get(CategoryEntity.class, catId);
			session.getTransaction().commit();
			session.close();
			return cat;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null; 
	}

}
