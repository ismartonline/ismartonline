package br.org.ismart.ismartonline.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.models.IsmartCourse;
import br.org.ismart.ismartonline.services.GoogleClassroomClient;

@Controller
public class ModuloController {
	
	@Autowired
	private GoogleClassroomClient googleClassroomClient;

	@RequestMapping("/cultura")
	public ModelAndView cultura(){
		
		ModelAndView model = new ModelAndView("modulo/cultura");
		
	//	try {
			
		//	List<IsmartCourse> courses = googleClassroomClient.getCourses();
			
			 
			
			
			//model.addObject("cursos", courses);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return model;
	}
	
	@RequestMapping("/materias")
	public String materias(){
		return "modulo/materias";
	}
	
	@RequestMapping("/desempenho")
	public String desempenho(){
		return "modulo/desempenho";
	}
	
	@RequestMapping("/interacao")
	public String interacao(){
		return "modulo/interacao";
	}

}
