package com.locShop.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.locShop.dao.IUserDao;
import com.locShop.model.RoleEntity;
import com.locShop.model.UserEntity;
import com.locShop.service.IUserService;

@Service
public class UserService implements IUserService,UserDetailsService{
 
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
	public UserDetails findByUserName(String userName) {
		return loadUserByUsername(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  UserEntity user = userDao.findByUserName(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthorities(user.getRoles()));
	}
	
	  private static Collection<? extends GrantedAuthority> getAuthorities(List<RoleEntity> list) {
	        return list.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	    }
}
