package com.locShop.controller.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.locShop.DTO.ProductDTO;
import com.locShop.model.ProductEntity;
import com.locShop.service.ICategoryService;
import com.locShop.service.IProductService;

@Controller(value = "productControllerofAdmin")
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = "/list")
	public String product_list_page(Model model) {
		List<ProductEntity> listPros = productService.findAll();
		
		model.addAttribute("prods", listPros);
		for (ProductEntity productEntity : listPros) {
			model.addAttribute("cat", productEntity.getCategory_id().getName());
		}
		
		return "admin/product/list";
	}

	@GetMapping(value = "/add")
	public String product_add_page(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.findAll());
		return "admin/product/add";
	}

	@PostMapping(value = "insert-product")
	public String uploadFile(@ModelAttribute("productDTO") ProductDTO pro, Model model, HttpServletRequest req,
			@RequestParam("fileUpload") MultipartFile imgFile) {

		try {
			MultipartFile multipartFile = pro.getFileUpload();
			String fileName = multipartFile.getOriginalFilename();
			String path = "C:\\Users\\ADMIN\\git\\project-spring-mvc-hibernate\\src\\main\\webapp\\template\\image";
			File file = new File(path, fileName);
			model.addAttribute("message", "upload success");
			multipartFile.transferTo(file);
			pro.setImage(fileName);
			if (pro.getImage() != null) {
				productService.insert(pro);
				return "redirect:/admin/product/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "upload failed");
			return "admin/product/add";
		}
		return "redirect:/admin/product/list";
	}

	@GetMapping(value = "/edit/{id}")
	public String product_edit_page(Model model,@PathVariable("id") Long id) {
		ProductDTO prod = new ProductDTO();
		prod.setId(productService.findById(id).getId());
		prod.setName(productService.findById(id).getName());
		prod.setImage(productService.findById(id).getImage());
		prod.setPrice(productService.findById(id).getPrice());
		prod.setSale_price(productService.findById(id).getSale_price());
		prod.setDescription(productService.findById(id).getDescription());
		prod.setCategory_id(productService.findById(id).getCategory_id().getId());
		model.addAttribute("productDTO", prod);
		model.addAttribute("categories", categoryService.findAll());
		return "admin/product/edit";
	}
	
	@PostMapping(value = "edit/edit-product")
	public String update_product(@ModelAttribute("productDTO") ProductDTO pro, Model model, HttpServletRequest req,
			@RequestParam("fileUpload") MultipartFile imgFile) {
		try {
			MultipartFile multipartFile = pro.getFileUpload();
			String fileName = multipartFile.getOriginalFilename();
			if(!(fileName == productService.findById(pro.getId()).getImage())) {
				String path = "C:\\Users\\ADMIN\\git\\project-spring-mvc-hibernate\\src\\main\\webapp\\template\\image";
				File file = new File(path, fileName);
				multipartFile.transferTo(file);
				model.addAttribute("message", "Update success!");
				pro.setImage(fileName);
				if (pro.getImage() != null) {
					productService.update(pro);
					return "redirect:/admin/product/list";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Edit failed !");
			return "admin/product/edit";
		}
		return "redirect:/admin/product/list";
	}
}
