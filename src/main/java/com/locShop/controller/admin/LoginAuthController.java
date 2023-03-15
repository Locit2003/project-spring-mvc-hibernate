package com.locShop.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.captcha.botdetect.web.servlet.Captcha;
import com.locShop.captcha.basicExample.BasicExample;
import com.locShop.model.UserEntity;
import com.locShop.service.IUserService;

@Controller
@RequestMapping("/auth")
public class LoginAuthController {

	@Autowired
	IUserService userService;

	@GetMapping("/login-admin")
	public String loginForm(Model model) {
		model.addAttribute("user", new UserEntity());
		return "admin/account/login-auth";
	}

	@PostMapping("/login-admin")
	public String loginSubmit(@ModelAttribute("user") UserEntity user, BindingResult bindingResult,
			HttpServletRequest request, Model model, @Valid @ModelAttribute("basicExample") BasicExample basicExample) {
		Captcha captcha = Captcha.load(request, "basicExample");
		boolean isHuman = captcha.validate(basicExample.getCaptchaCode());
		
		if (isHuman) {
			UserEntity userLogin = userService.findByUserName(user.getUsername());
			if (userLogin == null || !userLogin.getPassword().equals(user.getPassword())) {
				model.addAttribute("errLogin", "thông tin tài khoản mật khẩu không chính xác!");
				return "admin/account/login-auth";
			}

			HttpSession session = request.getSession();
			System.out.println(session);
			session.setAttribute("loggedInUser", userLogin);
			model.addAttribute("basicExample", basicExample);
			return "redirect:/admin-home";
		} else {
			basicExample.setCaptchaCorrect("");
			basicExample.setCaptchaIncorrect("Incorrect code");
			model.addAttribute("basicExample", basicExample);
			return "redirect:/auth/login-admin";
		}
	}
	
	@GetMapping("/logout-admin")
	public String logoutForm() {
		
		return null;
	}
}
