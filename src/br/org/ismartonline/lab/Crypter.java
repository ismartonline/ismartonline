package br.org.ismartonline.lab;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypter {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		
		System.out.println(crypt.encode("adminismart2016"));
	}

}
