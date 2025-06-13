package com.wipro.its.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_hrpanel")
public class HRPanelBean {
	private String empHRID;
	private String empHRName;

	public String getEmpHRID() {
		return empHRID;
	}

	public void setEmpHRID(String empHRID) {
		this.empHRID = empHRID;
	}

	public String getEmpHRName() {
		return empHRName;
	}

	public void setEmpHRName(String empHRName) {
		this.empHRName = empHRName;
	}

}
