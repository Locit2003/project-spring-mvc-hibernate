package com.locShop.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.locShop.model.UserEntity;
public interface IUserService {
	public List<UserEntity> findAll();
	public boolean insert(UserEntity user);
	public boolean update(UserEntity user);
	public boolean delete(Long proId);
	public UserEntity getCategoryById(Long catId);
	public UserDetails findByUserName(String userName);
}
