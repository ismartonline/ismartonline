package br.org.ismart.ismartonline.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mission {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String videos;
	
	private String file;
	
	

}
