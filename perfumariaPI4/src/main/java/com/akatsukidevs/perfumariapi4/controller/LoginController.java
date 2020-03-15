package com.akatsukidevs.perfumariapi4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")//toda vez que digitar / vai para o Index
	public String index() {
		return("login");
	}

}
