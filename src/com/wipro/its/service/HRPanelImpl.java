package com.wipro.its.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.dao.HRPanelDAOImpl;
import com.wipro.its.dao.InterviewScheduleDAOImpl;
@Service
public class HRPanelImpl implements HRPanel {

	@Autowired
	HRPanelDAOImpl hrPanelDAOImpl;
	
	@Autowired
	InterviewScheduleDAOImpl interviewScheduleDAOImpl;
	
	@Override
	public ArrayList<CandidateBean> viewCandidates(String empHRID,
			Date empHRInterviewDate) {
		
		
		return hrPanelDAOImpl.viewCandidates(empHRID, empHRInterviewDate);
	}

	@Override
	public boolean submitRatings(String interviewID, String empHRID,
			float rating) {
		
		return hrPanelDAOImpl.submitRatings(interviewID, empHRID, rating);
	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {
		
		return hrPanelDAOImpl.viewFinalResults(interviewID);
	}

	
}
