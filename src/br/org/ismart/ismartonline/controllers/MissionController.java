package br.org.ismart.ismartonline.controllers;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.daos.MissionDAO;
import br.org.ismart.ismartonline.models.StudentMission;
import br.org.ismart.ismartonline.models.User;
import br.org.ismart.ismartonline.tools.FileManager;

@Transactional
@Controller
public class MissionController {
	
	private static final String AWS_S3_BASE_URL = "https://s3-sa-east-1.amazonaws.com/elasticbeanstalk-sa-east-1-174765381476/";
	
	@Autowired
	private FileManager fileSaver;
	
	@Autowired
	private MissionDAO missionDAO;

	@RequestMapping("/cultura/missao/resultado")
	public ModelAndView resultado(HttpSession session){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao/result");
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		List<StudentMission> missions = missionDAO.listStudentMissions(user);
		
		model.addObject("missions", missions);
		return model;
	}
	
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
	
	@RequestMapping("/cultura/missao-2/ano-1/entrega")
	public ModelAndView entregaMissao2Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-8/entrega")
	public ModelAndView entregaMissao2Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-9/entrega")
	public ModelAndView entregaMissao2Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-3/ano-1/entrega")
	public ModelAndView entregaMissao3Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-3/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-3/ano-8/entrega")
	public ModelAndView entregaMissao3Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-3/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-3/ano-9/entrega")
	public ModelAndView entregaMissao3Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-3/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-4/ano-1/entrega")
	public ModelAndView entregaMissao4Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-4/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-4/ano-8/entrega")
	public ModelAndView entregaMissao4Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-4/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-4/ano-9/entrega")
	public ModelAndView entregaMissao4Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-4/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-5/ano-1/entrega")
	public ModelAndView entregaMissao5Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-5/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-5/ano-8/entrega")
	public ModelAndView entregaMissao5Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-5/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-5/ano-9/entrega")
	public ModelAndView entregaMissao5Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-5/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-6/ano-1/entrega")
	public ModelAndView entregaMissao6Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-6/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-6/ano-8/entrega")
	public ModelAndView entregaMissao6Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-6/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-6/ano-9/entrega")
	public ModelAndView entregaMissao6Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-6/ano-9/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-7/ano-1/entrega")
	public ModelAndView entregaMissao7Ano1(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-7/ano-1/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-7/ano-8/entrega")
	public ModelAndView entregaMissao7Ano8(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-7/ano-8/deliver");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-7/ano-9/entrega")
	public ModelAndView entregaMissao7Ano9(){
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-7/ano-9/deliver");
		
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
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 1L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping("/entrega-missao-2/submit")
	public ModelAndView mission2Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-2", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 2L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping("/entrega-missao-3/submit")
	public ModelAndView mission3Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-3/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-3", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 3L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping("/entrega-missao-4/submit")
	public ModelAndView mission4Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-4/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-4", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 4L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping("/entrega-missao-5/submit")
	public ModelAndView mission5Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-5/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-5", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 5L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@RequestMapping("/entrega-missao-6/submit")
	public ModelAndView mission6Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-6/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-6", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 6L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
        
	
	@RequestMapping("/entrega-missao-7/submit")
	public ModelAndView mission7Submit(MultipartFile delivery, HttpSession session){
		
		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		ModelAndView model = new ModelAndView("modulo/cultura/missao-7/ano-"+user.getAno()+"/delivered");
		
		String fileName = user.getIsmartId() + "_" + delivery.getOriginalFilename();
		
		String webPath = fileSaver.write("deliveries/ano-"+user.getAno()+"/missao-7", delivery, fileName);
		
		File file = new File(webPath);
		
		String urlEncoded;
		try {
			urlEncoded = java.net.URLEncoder.encode(webPath, "UTF-8");
			String link = AWS_S3_BASE_URL+urlEncoded;
			StudentMission studentMission = new StudentMission(Calendar.getInstance(), link, missionDAO.finbMissionByYearAndNumber(Long.valueOf(user.getAno()), 7L), user, fileName);
			missionDAO.saveStudentMission(studentMission);
			
			model.addObject("webPath", webPath);
			model.addObject("file", file);
			
			System.out.println("WEBPATH " + webPath);
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return model;
	}
}
