package com.training.poc.NimmaCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.Products;
import com.training.poc.service.ProductDetailsService;

@Controller
public class ProductDetailsController {
	
	@Autowired
	ProductDetailsService pds;

	@RequestMapping(value="/ProductDetails",method=RequestMethod.GET)
	public String getName(@RequestParam int id,ModelMap map) {
		
		System.out.println("ID:"+id);
		
		List<Products> list = pds.getProductById(id);
		map.put("list", list);
		return "ProductHome";
	}
}
