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

import com.edubridge.springboot.springresthib.entity.Product;
import com.edubridge.springboot.springresthib.entity.Seller;
import com.edubridge.springboot.springresthib.errors.ProductNotFoundException;
import com.edubridge.springboot.springresthib.errors.SellerNotFoundException;
import com.edubridge.springboot.springresthib.service.ProductService;
import com.edubridge.springboot.springresthib.service.SellerService;

@Controller
@RequestMapping("/api")
public class SellerController {
	
	private SellerService sellerService;
	
	@Autowired
	public SellerController(SellerService sellerService)
	{
		this.sellerService = sellerService;
	}
	
	@RequestMapping(value="/sellers", method=RequestMethod.POST)
	public Seller addSeller(@RequestBody Seller slr)
	{
	sellerService.addSeller(slr);
	return slr;
	}
	
	@RequestMapping("/getallslr")
	public String fetchAllSellers(Model theModel)
	{
		System.out.println("Get All sellers method");
		List<Seller> sellers=sellerService.findAll();
		theModel.addAttribute("sellerList", sellers);
		return "sellerlist";
	}
	
	@RequestMapping("/formslradd")
	public String addSeller(Model theModel)
	{
		System.out.println("method addSeller");
		Seller theSeller=new Seller();
		theModel.addAttribute("seller", theSeller);
		return "selleraddform";
		
	}
	
	@RequestMapping(value="/saveslr", method=RequestMethod.POST)
	public String saveSeller(@ModelAttribute("seller") Seller slr)
	{
		System.out.println("I'm in save method with Id:  "+slr.getId());
		sellerService.addSeller(slr);
		return "redirect:/api/getallslr";
	}
	
	@RequestMapping(value="/formslrupdate")
	public String updateSeller(@RequestParam("sellerId") int id, Model theModel)
	{
		System.out.println("Seller Update Form for ID = " + id);
		Seller slr=sellerService.findSellerById(id);
		theModel.addAttribute("seller",slr);
		return "selleraddform";
	}
	
	@RequestMapping(value="/formslrdelete")
	public String deleteSeller(@RequestParam("sellerId") int id, Model theModel)
	{
		System.out.println("Seller deleted for ID = " + id);
		Seller slr=sellerService.findSellerById(id);
		if(slr==null)
		{
		 throw new SellerNotFoundException("There is no Product with the Id :"+id);
		}
		sellerService.deleteById(id);
		return "redirect:/api/getallslr";
	}

}
