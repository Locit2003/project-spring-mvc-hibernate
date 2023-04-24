package com.locShop.service.impl;

import java.util.ArrayList;
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

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//        for (RoleEntity role : list) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
		
		  List<RoleEntity> roles = user.getRoles();
		  List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
	}
}
