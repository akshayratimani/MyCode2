package com.training.poc.NimmaCart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.poc.entity.Cart;
import com.training.poc.entity.Products;
import com.training.poc.entity.User;
import com.training.poc.service.ServiceDao;

@Controller
public class CartDisplayController {
	
	@Autowired
	ServiceDao service; 

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(HttpServletRequest req,ModelMap map) {
		HttpSession s = req.getSession(false);
		List<Products> li = null;
		String ph = "";
		try {
			ph = (String) s.getAttribute("phno");
			li = service.getCartProducts(ph);
			map.put("cart", li);
			
			
			for(Products p: li) {
				System.out.println("Data"+p.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "";
	}
}
