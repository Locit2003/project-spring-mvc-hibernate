package com.locShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.locShop.HibernateUtitill.HibernateUtil;
import com.locShop.dao.IUserDao;
import com.locShop.model.UserEntity;

@Repository
public class UserDao implements IUserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<UserEntity> findAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<UserEntity> list = session.createQuery("from com.locShop.model.UserEntity", UserEntity.class).list();
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
	public boolean insert(UserEntity user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public boolean update(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long proId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity getCategoryById(Long catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findByUserName(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM UserEntity WHERE username = :username";
			Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
			query.setParameter("username", userName);
			List<UserEntity> userList = query.getResultList();
			if (!userList.isEmpty()) {
			    UserEntity user = userList.get(0);
			    return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
