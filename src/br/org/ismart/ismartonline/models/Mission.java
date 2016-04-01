package br.org.ismart.ismartonline.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mission {
	
	public Mission(){
		//For JPA...
	}
	
	public Mission(String year, String number, String name, String docFilePath, String pdfFilePath) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="mission")
	private List<Video> videos;
	
	private String docFilePath;
	
	private String pdfFilePath;
	
	private Long number;
	
	private Long year;
	

}
