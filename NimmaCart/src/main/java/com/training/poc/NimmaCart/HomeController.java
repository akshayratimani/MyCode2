package com.training.poc.NimmaCart;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.Products;
import com.training.poc.service.ServiceDao;
import com.training.poc.service.ShowProductsService;

@Controller
public class HomeController {
	
	@Autowired
	ShowProductsService s;
	@Autowired
	ServiceDao service;

	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public String getName(ModelMap m,HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		List<Products> list = s.getProducts();
		
		
		int size = 0;
		try {
			String ph = (String) session.getAttribute("phno");
			//System.out.println("Phno:"+ph);
			size = service.getSize(ph);
			
			
			if(session.getAttribute("size")==null) {
				//System.out.println("1a");
				session.setAttribute("size", size);
			}else {
				//System.out.println("1b");
				session.removeAttribute("size");
				session.setAttribute("size", size);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Exception"+e);
		}
		m.put("list", list);
		
		return "Home";	
	}
	
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public void getName2(HttpSession session, HttpServletResponse resp) throws IOException {
		session.invalidate();
		System.out.println("Getting it..!");
		resp.sendRedirect("/Home");
	}
}
 
