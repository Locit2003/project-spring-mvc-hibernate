package com.locShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locShop.dao.IUserDao;
import com.locShop.model.UserEntity;
import com.locShop.service.IUserService;

@Service
public class UserService implements IUserService{
 
	@Autowired
	IUserDao userDao;
	
	@Override
	public List<UserEntity> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean insert(UserEntity user) {
		// TODO Auto-generated method stub
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
		return userDao.findByUserName(userName);
	}

}
