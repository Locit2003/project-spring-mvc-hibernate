package com.locShop.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.locShop.model.UserEntity;
public interface IUserService {
	public List<UserEntity> findAll();
	public boolean insert(UserEntity user);
	public boolean update(UserEntity user);
	public boolean delete(Long proId);
	public UserEntity getCategoryById(Long catId);
	public UserEntity findByUserName(String userName);
}
