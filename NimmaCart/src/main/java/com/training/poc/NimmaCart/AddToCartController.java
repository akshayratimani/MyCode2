package com.training.poc.NimmaCart;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.Cart;
import com.training.poc.service.AddToCartService;

@Controller
public class AddToCartController {

	@Autowired
	AddToCartService a;
	
	@RequestMapping(value="/AddToCart", method = RequestMethod.GET)
	public void AddtoCart(@RequestParam int id, @RequestParam String phoneno, HttpServletResponse resp)
			throws IOException {
			
		//System.out.println("IDI:"+id+phoneno);
		
		Cart c = new Cart();
		
		c.setPid(id);
		c.setPhoneno(phoneno);
		c.setQuantity(1);
		
		a.add(c);
		
		resp.sendRedirect("/Home");
		
		
		
	}
}
