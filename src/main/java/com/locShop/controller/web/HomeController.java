package com.locShop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locShop.model.CategoryEntity;
import com.locShop.model.ProductEntity;
import com.locShop.service.ICategoryService;
import com.locShop.service.IProductService;
import com.locShop.service.impl.ProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IProductService productService;
	
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(Model model) {
		List<CategoryEntity> listCats = categoryService.findAll();
		List<ProductEntity> listPros = productService.findAll();
		ModelAndView nav = new ModelAndView("web/trang-chu");
		nav.addObject("cats",listCats);
		nav.addObject("pros",listPros);
		return nav;
	}
	
	@RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
	public ModelAndView detailsPage() {
		ModelAndView nav = new ModelAndView("web/details-product");
		return nav;
	}
	
}
