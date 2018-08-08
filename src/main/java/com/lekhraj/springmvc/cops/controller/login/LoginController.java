package com.lekhraj.springmvc.cops.controller.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lekhraj.springmvc.cops.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService ;

	@RequestMapping(value = "/"  , method = RequestMethod.GET)
	public String showLoginPage() {
		System.out.println("inside showLogin controller");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password)
	{
		if (!loginService.validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		
		model.put("name", name); System.out.println("name : "+name);
		model.put("password", password); System.out.println("password : "+password);
		return "home";
	}

}