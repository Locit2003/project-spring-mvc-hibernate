package com.locShop.controller.admin;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locShop.model.CategoryEntity;
import com.locShop.service.ICategoryService;

@Controller(value = "CategoryControllerOfAdmin")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/admin-category-list", method = RequestMethod.GET)
	public ModelAndView category_list_page() {
		List<CategoryEntity> list = categoryService.findAll();
		ModelAndView nav = new ModelAndView("admin/category/list");
		nav.addObject("cats",list);
		return nav;
	}
	
	@RequestMapping(value = "/admin-category-add", method = RequestMethod.GET)
	public ModelAndView category_add_page(Model model) {	
		model.addAttribute("cats",new CategoryEntity());
		ModelAndView nav = new ModelAndView("admin/category/add");
		return nav;
	}
	
	
	@RequestMapping(value = "/admin-category-edit/{id}", method = RequestMethod.GET)
	public ModelAndView category_edit_page(@PathVariable("id") Long id,Model model) {
		ModelAndView nav = new ModelAndView("admin/category/edit");
		CategoryEntity cat =  categoryService.getCategoryById(id);
		model.addAttribute("catUpdate",cat);
		nav.addObject("cat",cat);
		return nav;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String category_insert(@ModelAttribute("cats") CategoryEntity cats) {	
		categoryService.insert(cats);
		return "redirect:admin-category-list";
	}

	@RequestMapping(value = "/admin-category-edit/admin-category-update", method = RequestMethod.POST)
	public String category_update(@ModelAttribute("catUpdate") CategoryEntity cat) {
		categoryService.update(cat);
		return "redirect:/admin-category-list";
	}
	@RequestMapping(value = "/admin-category-delete/{id}", method = RequestMethod.GET)
	public String category_delete(@PathVariable("id") Long id) {
		if(categoryService.delete(id)) {
			System.out.println("da xoa thanh cong");
			return "redirect:/admin-category-list";
		}else {
			System.out.println("da xoa that bai");
			return "redirect:/admin-category-list";
		}
	}
}
