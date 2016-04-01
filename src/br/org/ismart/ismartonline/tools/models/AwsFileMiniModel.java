package br.org.ismart.ismartonline.tools.models;

import java.util.Calendar;
import java.util.Date;

public class AwsFileMiniModel {
	
	private String key;
	private Date lastModified;

	public AwsFileMiniModel(String key, Date lastModified) {
		this.key = key;
		
		this.lastModified = lastModified;
	}

	public String getKey() {
		return key;
	}

	public Date getLastModified() {
		return lastModified;
	}
	
	public Calendar getLastModifiedAsCalendar(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(lastModified);
		return cal;
	}

}
