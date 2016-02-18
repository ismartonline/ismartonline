package br.org.ismartonline.lab;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Runner {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		
		System.out.println(crypt.encode("ismart2015"));
	}

}
