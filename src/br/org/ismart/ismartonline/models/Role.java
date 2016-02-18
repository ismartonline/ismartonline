package br.org.ismart.ismartonline.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	private String name;
	
	@Override
	public String getAuthority() {
		return name;
	}

}
