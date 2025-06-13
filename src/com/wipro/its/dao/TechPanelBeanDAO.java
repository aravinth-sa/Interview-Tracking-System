package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.TechPanelBean;

public interface TechPanelBeanDAO {

	InterviewScheduleBean viewFinalResults(String interviewID);

	boolean submitRatings(String interviewID, String empHRID, float empHRRating);

	ArrayList<CandidateBean> findAll(String interviewID, Date interviewDate);

}
