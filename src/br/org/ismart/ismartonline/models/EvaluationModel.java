package br.org.ismart.ismartonline.models;

import java.util.Calendar;

public class EvaluationModel {
	
	private Long studentMissionId;
	private String studentName;
	private String studentIsmartId;
	private String missionFileLink;
	private Calendar missionDeliveryDate;
	private Long studentMissionGrade;
	
	public EvaluationModel(Long studentMissionId, String studentName, String studentIsmartId, String missionFileLink,
			Calendar missionDeliveryDate, Long studentMissionGrade) {
		super();
		this.studentMissionId = studentMissionId;
		this.studentName = studentName;
		this.studentIsmartId = studentIsmartId;
		this.missionFileLink = missionFileLink;
		this.missionDeliveryDate = missionDeliveryDate;
		this.studentMissionGrade = studentMissionGrade;
	}

	public Long getStudentMissionId() {
		return studentMissionId;
	}

	public void setStudentMissionId(Long studentMissionId) {
		this.studentMissionId = studentMissionId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentIsmartId() {
		return studentIsmartId;
	}

	public void setStudentIsmartId(String studentIsmartId) {
		this.studentIsmartId = studentIsmartId;
	}

	public String getMissionFileLink() {
		return missionFileLink;
	}

	public void setMissionFileLink(String missionFileLink) {
		this.missionFileLink = missionFileLink;
	}

	public Calendar getMissionDeliveryDate() {
		return missionDeliveryDate;
	}

	public void setMissionDeliveryDate(Calendar missionDeliveryDate) {
		this.missionDeliveryDate = missionDeliveryDate;
	}

	public Long getStudentMissionGrade() {
		return studentMissionGrade;
	}

	public void setStudentMissionGrade(Long studentMissionGrade) {
		this.studentMissionGrade = studentMissionGrade;
	}
	
	
	
	

	

}
