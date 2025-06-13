package com.wipro.its.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_techpanel")
public class TechPanelBean {
	private String techID;
	private String techName;
	private String subjects;

	public String getTechID() {
		return techID;
	}

	public void setTechID(String techID) {
		this.techID = techID;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

}
