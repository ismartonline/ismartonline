package br.org.ismart.ismartonline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController
{

	@RequestMapping("/login")
   public String login()
   {
      return "auth/login";
   }
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}

}
