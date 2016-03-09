package br.org.ismart.ismartonline.controllers;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.models.User;
import br.org.ismart.ismartonline.tools.FileSaver;

@Controller
public class MissionController {
	
	@Autowired
	private FileSaver fileSaver;

	
	@RequestMapping("/cultura/missao/ano-1/entrega")
	public ModelAndView entregaAno1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-8/entrega")
	public ModelAndView entregaAno8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-9/entrega")
	public ModelAndView entregaAno9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/entrega/submit")
	public ModelAndView submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-1", delivery, fileName);
		
		File file = new File(webPath);
		
		model.addObject("webPath", webPath);
		model.addObject("file", file);
		
		System.out.println("WEBPATH " + webPath);
		
		return model;
	}
	
}
