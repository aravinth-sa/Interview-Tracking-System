package com.wipro.its.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_Candidate")
public class CandidateBean {
	@Id
	// @SequenceGenerator(name = "sequence", sequenceName = "candidateID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "sequence")
	private String candidateID;
	@Column(name = "primarySkills")
	private String primarySkills;
	@Column(name = "secondarySkills")
	private String secondarySkills;
	@Column(name = "experience")
	private float experience;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "designation")
	private String designation;
	@Column(name = "noticePeriod")
	private int noticePeriod;
	@Column(name = "location")
	private String location;
	@Column(name = "shareDetails")
	private int shareDetails;

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getShareDetails() {
		return shareDetails;
	}

	public void setShareDetails(int shareDetails) {
		this.shareDetails = shareDetails;
	}

	@Override
	public String toString() {
		return "CandidateBean [candidateID=" + candidateID + ", primarySkills="
				+ primarySkills + ", secondarySkills=" + secondarySkills
				+ ", experience=" + experience + ", qualification="
				+ qualification + ", designation=" + designation
				+ ", noticePeriod=" + noticePeriod + ", location=" + location
				+ ", shareDetails=" + shareDetails + "]";
	}

}
