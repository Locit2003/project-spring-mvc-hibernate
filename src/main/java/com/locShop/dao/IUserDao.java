package com.locShop.dao;

import java.util.List;

import com.locShop.model.UserEntity;

public interface IUserDao {
	public List<UserEntity> findAll();
	public boolean insert(UserEntity user);
	public boolean update(UserEntity user);
	public boolean delete(Long proId);
	public UserEntity getCategoryById(Long catId);
	public UserEntity findByUserName(String userName);
}
