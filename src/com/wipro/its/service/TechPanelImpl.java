package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.TechPanelBeanDAOImpl;
@Service
public class TechPanelImpl implements TechPanel {

	
	
	@Autowired
	 TechPanelBeanDAOImpl techPanelBeanDAOImpl;



	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {
		
		return techPanelBeanDAOImpl.viewFinalResults(interviewID);
	}

	@Override
	public ArrayList<CandidateBean> viewCandidates(String techID,
			Date interviewDate) {
	
			return (ArrayList<CandidateBean>) techPanelBeanDAOImpl.findAll(techID,  interviewDate);
		
		}

	@Override
	public boolean submitRatings(String interviewID, String techID, float rating) {
		return techPanelBeanDAOImpl.submitRatings(interviewID, techID, rating);
		
	}

	
	}


