package com.wipro.its.service;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

public interface Administrator {
	String addCandidate(ProfileBean profileBean, CandidateBean candidateBean) ;
	ArrayList<CandidateBean> viewCandidate(String skills, String qualification); 
	boolean shareCandidateDetails(String candidateID, String panel);
	void scheduleInterview(InterviewScheduleBean interviewBean);
	InterviewScheduleBean viewRatings(String interviewID) ;
	boolean finalizeResultDecision(String interviewID, String result); 
	boolean declareResults(String interviewID, int share);
	void delService(String id);
	CandidateBean editService(String id);
	String genInterviewSeq();
	ArrayList<String> fetchIdService();
	void update(CandidateBean cb);
	
}
