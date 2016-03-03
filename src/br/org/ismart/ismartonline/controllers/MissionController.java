package br.org.ismart.ismartonline.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.tools.FileSaver;

@Controller
public class MissionController {
	
	@Autowired
	private FileSaver fileSaver;

	
	@RequestMapping("vQtDNoCxpCa8QIAZPWeIMt4hPuLwZ8a")
	public ModelAndView entrega(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/deliver");
		
		return model;
	}
	
	@RequestMapping("/entrega/submit")
	public ModelAndView submit(MultipartFile delivery){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/delivered");
		
		String webPath = fileSaver.write("deliveries", delivery);
		
		File file = new File(webPath);
		
		model.addObject("webPath", webPath);
		model.addObject("file", file);
		
		System.out.println("WEBPATH " + webPath);
		
		return model;
	}
	
}
