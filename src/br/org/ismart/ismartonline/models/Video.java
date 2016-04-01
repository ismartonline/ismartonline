package br.org.ismart.ismartonline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Video {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Mission mission;
	
	private String path;
	
	private String title;

}
