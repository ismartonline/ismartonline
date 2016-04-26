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
	

	public Mission(String name, String docFilePath, String pdfFilePath, Long number, Long year) {
		super();
		this.name = name;
		this.docFilePath = docFilePath;
		this.pdfFilePath = pdfFilePath;
		this.number = number;
		this.year = year;
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

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public String getDocFilePath() {
		return docFilePath;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public Long getNumber() {
		return number;
	}

	public Long getYear() {
		return year;
	}
	
	
	

}
