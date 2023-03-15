package com.locShop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "ProductControllerOfAdmin")
public class ProductController {
	@RequestMapping(value = "/admin-product-list", method = RequestMethod.GET)
	public ModelAndView product_list_page() {
		ModelAndView nav = new ModelAndView("admin/product/list");
		return nav;
	}
	@RequestMapping(value = "/admin-product-add", method = RequestMethod.GET)
	public ModelAndView product_add_page() {
		ModelAndView nav = new ModelAndView("admin/product/add");
		return nav;
	}
	@RequestMapping(value = "/admin-product-edit", method = RequestMethod.GET)
	public ModelAndView product_edit_page() {
		ModelAndView nav = new ModelAndView("admin/product/edit");
		return nav;
	}
}
