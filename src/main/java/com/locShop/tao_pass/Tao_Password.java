package com.locShop.tao_pass;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.core.context.SecurityContextHolder;

import com.locShop.model.UserEntity;

public class Tao_Password {
	public static void main(String[] args) {
		System.out.println(BCrypt.hashpw("123456",BCrypt.gensalt(12)));
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getRoles());
	}
}
