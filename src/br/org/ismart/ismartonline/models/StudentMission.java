package br.org.ismart.ismartonline.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentMission {

	@Id
	@GeneratedValue
	private Long id;
	
	private long grade;
	
	private Calendar deliveryDate;
	
	@ManyToOne
	private Mission mission;
	
	@ManyToOne
	private User user;
	
}
