package br.org.ismart.ismartonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuBarController extends BaseController {

        
	@RequestMapping("/home")
	public String home(){
		return "index";
	}
        
	@RequestMapping("/404")
	public String error404() {
            return "404";
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
