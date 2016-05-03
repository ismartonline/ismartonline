package br.org.ismart.ismartonline.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentMission {

	@Id
	@GeneratedValue
	private Long id;
	
	private Double grade;
	
	private Calendar deliveryDate;

	private String fileLink;
	
	private String fileName;
	
	private int deliveryIn;
	private int deliveryOut;
	
	private int videoNoiseless;
	private int videoTimeOk;
	
	private int assayCharsRespect;
	private int assayParagraphsDivision;
	
	private int audioNoiseless;
	private int audioClearTalk;
	
	private int sheetAndReportFormatting;
	private int sheetInfoOrganization;
	
	@ManyToOne
	private Mission mission;
	
	@ManyToOne
	private User user;

	private int valued;

	private int lateDelivery;

	public StudentMission(Calendar deliveryDate, String fileLink, Mission mission, User user, String fileName) {
		super();
		this.deliveryDate = deliveryDate;
		this.fileLink = fileLink;
		this.mission = mission;
		this.user = user;
		this.fileName = fileName;
		
		this.grade = -1.0;
		
		this.deliveryIn = 0;
		this.deliveryOut = 0;
		
		this.lateDelivery = 0;
		
		this.videoNoiseless = 0;
		this.videoTimeOk = 0;
		
		this.assayCharsRespect = 0;
		this.assayParagraphsDivision = 0;
		
		this.audioNoiseless = 0;
		this.audioClearTalk = 0;
		
		this.sheetAndReportFormatting = 0;
		this.sheetInfoOrganization = 0;
		
		this.valued = 0;
	}

	public StudentMission() {
		// TODO Auto-generated constructor stub
	}

	
	public int getValued() {
		return valued;
	}

	public void setValued(int valued) {
		this.valued = valued;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDeliveryIn() {
		return deliveryIn;
	}

	public void setDeliveryIn(int deliveryIn) {
		this.deliveryIn = deliveryIn;
	}

	public int getDeliveryOut() {
		return deliveryOut;
	}

	public void setDeliveryOut(int deliveryOut) {
		this.deliveryOut = deliveryOut;
	}

	public int getVideoNoiseless() {
		return videoNoiseless;
	}

	public void setVideoNoiseless(int videoNoiseless) {
		this.videoNoiseless = videoNoiseless;
	}

	public int getVideoTimeOk() {
		return videoTimeOk;
	}

	public void setVideoTimeOk(int videoTimeOk) {
		this.videoTimeOk = videoTimeOk;
	}

	public int getAssayCharsRespect() {
		return assayCharsRespect;
	}

	public void setAssayCharsRespect(int assayCharsRespect) {
		this.assayCharsRespect = assayCharsRespect;
	}

	public int getAssayParagraphsDivision() {
		return assayParagraphsDivision;
	}

	public void setAssayParagraphsDivision(int assayParagraphsDivision) {
		this.assayParagraphsDivision = assayParagraphsDivision;
	}

	public int getAudioNoiseless() {
		return audioNoiseless;
	}

	public void setAudioNoiseless(int audioNoiseless) {
		this.audioNoiseless = audioNoiseless;
	}

	public int getAudioClearTalk() {
		return audioClearTalk;
	}

	public void setAudioClearTalk(int audioClearTalk) {
		this.audioClearTalk = audioClearTalk;
	}

	public int getSheetAndReportFormatting() {
		return sheetAndReportFormatting;
	}

	public void setSheetAndReportFormatting(int sheetAndReportFormatting) {
		this.sheetAndReportFormatting = sheetAndReportFormatting;
	}

	public int getSheetInfoOrganization() {
		return sheetInfoOrganization;
	}

	public void setSheetInfoOrganization(int sheetInfoOrganization) {
		this.sheetInfoOrganization = sheetInfoOrganization;
	}

	public int getLateDelivery() {
		return lateDelivery;
	}

	public void setLateDelivery(int lateDelivery) {
		this.lateDelivery = lateDelivery;
	}

	
}
