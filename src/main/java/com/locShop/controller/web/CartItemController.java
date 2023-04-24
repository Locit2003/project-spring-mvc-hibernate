package com.locShop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartItemController {
	
	@GetMapping("/cart-item")
	public String cartPage() {
		
		return "web/cart-item";
	}
}
