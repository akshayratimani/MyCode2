package com.training.poc.NimmaCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService l;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getName() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String test(@RequestParam String phno,@RequestParam String pass) {
		
		//System.out.println(l.validateUser(phno , pass));
		
		if(l.validateUser(phno , pass))
		{
			return "error/message2";
		}
		
		return "error/message3";
	}
}

