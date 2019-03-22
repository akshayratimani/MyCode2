package com.training.poc.NimmaCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.Products;
import com.training.poc.service.ShowProductsService;

@Controller
public class HomeController {
	
	@Autowired
	ShowProductsService s;

	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public String getName(ModelMap m) {
		
		List<Products> list = s.getProducts();
		m.put("list", list);
		
		return "Home";	
	}
	
	
	@RequestMapping(value="/yes",method = RequestMethod.GET)
	public String getName2() {
		System.out.println("Getting it..!");
		return "header";
	}
}
 
