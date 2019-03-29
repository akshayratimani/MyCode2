package com.training.poc.NimmaCart;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.User;
import com.training.poc.service.LoginService;
import com.training.poc.service.ProductDetailsService;
import com.training.poc.service.ServiceDao;

@Controller
public class LoginController {
	
	@Autowired
	LoginService l;
	@Autowired
	ServiceDao service;


	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getName() {
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String test(@RequestParam String phno,@RequestParam String pass,HttpServletRequest req,ModelMap map) {
		
		
		if(l.validateUser(phno , pass))
		{
			System.out.println("cmng");
			HttpSession session = req.getSession();
			List<User> list = service.getName(phno);
			User u = list.get(0);
			String n = u.getFirstName()+" "+u.getLastName();
			session.setAttribute("name", n);
			session.setAttribute("phno", phno);
			
			return "error/message2";
		}
		return "error/message3";
	}
}

