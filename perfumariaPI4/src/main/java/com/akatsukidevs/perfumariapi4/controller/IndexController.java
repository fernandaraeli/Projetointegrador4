package com.akatsukidevs.perfumariapi4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")//toda vez que digitar / vai para o Index
	public String index() {
		return("index");
	}

}
