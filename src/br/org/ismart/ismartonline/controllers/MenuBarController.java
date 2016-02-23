package br.org.ismart.ismartonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuBarController {

	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
//	@RequestMapping("/sobre")
//	public String about(){
//		return "about";
//	}
//	
//	@RequestMapping("/faq")
//	public String faq(){
//		return "faq";
//	}
//	
//	@RequestMapping("/contato")
//	public String contact(){
//		return "contact";
//	}
}
