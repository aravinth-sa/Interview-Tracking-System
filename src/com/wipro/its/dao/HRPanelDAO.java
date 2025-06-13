package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

public interface HRPanelDAO {

	boolean submitRatings(String interviewID, String empHRID, float empHRRating);

	ArrayList<CandidateBean> viewCandidates(String empHRID,
			Date empHRInterviewDate);

	InterviewScheduleBean viewFinalResults(String interviewID);

}
