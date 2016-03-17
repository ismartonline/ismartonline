package br.org.ismart.ismartonline.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.ismart.ismartonline.models.User;
import br.org.ismart.ismartonline.services.GeekieClient;
import br.org.ismart.ismartonline.services.GeekieLab;
import br.org.ismart.ismartonline.services.GoogleClassroomClient;

@Controller
public class ModuloController {
	
	@Autowired
	private GeekieLab geekieLab;
	
	@Autowired
	private GeekieClient geekieClient; 

	@RequestMapping("/cultura")
	public ModelAndView cultura(){
		
		ModelAndView model = new ModelAndView("modulo/cultura");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-8")
	public ModelAndView missao2Ano8(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-8");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-8/video-2")
	public ModelAndView missao2Ano8Video2(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-8-video2");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-8/video-3")
	public ModelAndView missao2Ano8Video3(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-8-video3");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-9")
	public ModelAndView missao2Ano9(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-9");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-1")
	public ModelAndView missao2Ano1(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-1");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao-2/ano-1/video-2")
	public ModelAndView missao2Ano1Video2(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao-2/ano-1-video2");
		
		return model;
	}
	
	
	@RequestMapping("/cultura/missao/ano-8")
	public ModelAndView missao8(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-8");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-8/video-2")
	public ModelAndView missao8Video2(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-8-video2");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-8/video-3")
	public ModelAndView missao8Video3(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-8-video3");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-9")
	public ModelAndView missao9(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-9");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-1")
	public ModelAndView missao1(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-1");
		
		return model;
	}
	
	@RequestMapping("/cultura/missao/ano-1/video-2")
	public ModelAndView missao1Video2(String missao){
		ModelAndView model = new ModelAndView("modulo/cultura/missao/ano-1-video2");
		
		return model;
	}
	
	@RequestMapping("/materias")
	public ModelAndView materias(HttpSession session){
		
		ModelAndView model = new ModelAndView("modulo/materias");

		SecurityContextImpl context = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User user = (User) context.getAuthentication().getPrincipal();
		
		String nonce = getRandomString();
		String timeStamp = String.valueOf(System.currentTimeMillis());
		String organizationId = geekieLab.getOrganizationId(user);
		
		model.addObject("userId", user.getGeekieId());
		model.addObject("organizationId", organizationId);
		model.addObject("nonce", nonce);
		model.addObject("timestamp", timeStamp);
		
		String methodAndUrl = "POST&https%3A%2F%2Fwww.geekielab.com.br%2Flogin%2Flaunch&";
		String oauthConsumer ="oauth_consumer_key%3D" + organizationId + "%26";
		String oauthNonce = "oauth_nonce%3D" + nonce + "%26";
		String oauthSignatureMethod = "oauth_signature_method%3DHMAC-SHA1%26";
 		String oauthTimeStamp = "oauth_timestamp%3D" + timeStamp + "%26";
 		String oauthVersion = "oauth_version%3D1.0%26";
 		String oauthUserId = "user_id%3D" + user.getGeekieId();
 		
		String baseString = methodAndUrl + oauthConsumer + oauthNonce + oauthSignatureMethod + oauthTimeStamp + oauthVersion + oauthUserId;
		
		model.addObject("signature", geekieClient.generateHmacSha(baseString, geekieLab.getOauthSigninKey(user)));
		
		
		return model;
	}
	
	private String getRandomString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	
//	
//	@RequestMapping("/desempenho")
//	public String desempenho(){
//		return "modulo/desempenho";
//	}
//	
//	@RequestMapping("/interacao")
//	public String interacao(){
//		return "modulo/interacao";
//	}

}
