package com.edubridge.springboot.springresthib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edubridge.springboot.springresthib.entity.Employee;
import com.edubridge.springboot.springresthib.entity.Product;
import com.edubridge.springboot.springresthib.errors.EmployeeNotFoundException;
import com.edubridge.springboot.springresthib.errors.ProductNotFoundException;
import com.edubridge.springboot.springresthib.service.EmployeeService;
import com.edubridge.springboot.springresthib.service.ProductService;

@Controller
@RequestMapping("/api")
public class ProductController {
	
private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product ptd)
	{
	productService.addProduct(ptd);
	return ptd;
	}
	
	@RequestMapping("/getallptd")
	public String fetchAllProducts(Model theModel)
	{
		System.out.println("Get All products method");
		List<Product> products=productService.findAll();
		theModel.addAttribute("productList", products);
		return "productlist";
	}
	
	@RequestMapping("/formptdadd")
	public String addProduct(Model theModel)
	{
		System.out.println("method formforptd");
		Product theProduct=new Product();
		theModel.addAttribute("product", theProduct);
		return "productaddform";
		
	}
	
	@RequestMapping(value="/saveptd", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product ptd)
	{
		System.out.println("I'm in save method with Id:  "+ptd.getId());
		productService.addProduct(ptd);
		return "redirect:/api/getallptd";
	}
	
	@RequestMapping(value="/formptdupdate")
	public String updateProduct(@RequestParam("productId") int id, Model theModel)
	{
		System.out.println("Product Update Form for ID = " + id);
		Product ptd=productService.findProductById(id);
		theModel.addAttribute("product",ptd);
		return "productaddform";
	}
	
	@RequestMapping(value="/formptddelete")
	public String deleteProduct(@RequestParam("productId") int id, Model theModel)
	{
		System.out.println("Product delete Form for ID = " + id);
		Product ptd=productService.findProductById(id);
		if(ptd==null)
		{
		 throw new ProductNotFoundException("There is no Product with the Id :"+id);
		}
		productService.deleteById(id);
		return "redirect:/api/getallptd";
	}

}
