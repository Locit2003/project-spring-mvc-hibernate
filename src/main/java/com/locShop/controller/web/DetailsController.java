package com.locShop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.locShop.DTO.ProductDetailsDTO;
import com.locShop.service.IProductService;

@Controller(value = "detailsControllerOfWeb")
public class DetailsController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("/chi-tiet-san-pham/{id}")
	public String detailsPage(@PathVariable("id") Long id,Model model) {
		model.addAttribute("productDetailsDTO", new ProductDetailsDTO());
		model.addAttribute("proDetails", productService.findById(id));
		return "web/details-product";
	}
}
