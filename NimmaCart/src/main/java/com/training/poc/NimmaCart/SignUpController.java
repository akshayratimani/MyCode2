package com.training.poc.NimmaCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.poc.entity.User;
import com.training.poc.service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	SignUpService s;
	User u;
	

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String getName() {
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String SignUp(@RequestParam String first_name,@RequestParam String last_name,@RequestParam String phone,@RequestParam String email,@RequestParam String password) {
		
		u = new User(first_name, last_name, phone, email, password);
		if(s.registerUser(u)) {
			return "error/message";
		}
		return "error/error";
		
	}
}

