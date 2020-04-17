package com.trungtamjava.Controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.model.CategoryDTO;
import com.trungtamjava.model.ProductDTO;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping(value = "/admin/product/add")
	public String AdminProductAddGet(HttpServletRequest request, Model model) {
		model.addAttribute("product", new ProductDTO());
		List<CategoryDTO> list = categoryService.search("");
		request.setAttribute("categoryList", list);
		return "/ThemeProduct/add-product";
	}



	@GetMapping(value = "/admin/product/update")
	public String AdminProductUpdate(Model model, int id) {
		ProductDTO product = productService.get(id);
		List<CategoryDTO> list = categoryService.search("");
		model.addAttribute("product", product);
		model.addAttribute("categoryList", list);
		return "/ThemeProduct/update-product";
	}

	
	@GetMapping(value = "/admin/product/delete")
	public String AdminDeleteProduct(HttpServletRequest request, int id) {
		productService.delete(id);
		return "redirect:/ThemeProduct/search-product";
	}

	@GetMapping(value = "/admin/product/search")
	public String AdminProductSearch(HttpServletRequest request) {

		List<ProductDTO> listPro = productService.search("");
		request.setAttribute("productList", listPro);
		return "/ThemeProduct/search-product";
	}
}
