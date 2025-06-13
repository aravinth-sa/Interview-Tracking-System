package com.wipro.its.service;

import java.util.ArrayList;



















import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.dao.CandidateDAOImpl;
import com.wipro.its.dao.InterviewScheduleDAOImpl;
import com.wipro.its.dao.ProfileDAOImpl;
@Service
public class AdministratorImpl implements Administrator {

	@Autowired
	 CandidateDAOImpl candidateDAOImpl;
	
	
	@Autowired
	 ProfileDAOImpl profileDAOImpl;
	
	@Autowired
	 InterviewScheduleDAOImpl interviewScheduleDAOImpl;
	
	
	

	@Override
	public String addCandidate(ProfileBean profileBean,
			CandidateBean candidateBean) {
		if(candidateDAOImpl.createCandidate(candidateBean).equals("added")){
			if(profileDAOImpl.createProfile(profileBean).equals("added")){
				return "success";
			}
			else{
				return "fail";
			}
		}
		
		return "fail";
	}

	@Override
	public ArrayList<CandidateBean> viewCandidate(String skills,
			 String qualification) {
		return candidateDAOImpl.findAll(skills,qualification);
		
	}

	@Override
	public boolean shareCandidateDetails(String candidateID, String panel) {
		
		return false;
	}

	@Override
	public void scheduleInterview(InterviewScheduleBean interviewScheduleBean) {
		
		 interviewScheduleDAOImpl.CreateSchedule(interviewScheduleBean);
		
	}

	

	@Override
	public InterviewScheduleBean viewRatings(String interviewID) {
		
		return interviewScheduleDAOImpl.viewRatings(interviewID);
	}

	@Override
	public boolean finalizeResultDecision(String interviewID, String result) {
		
		return interviewScheduleDAOImpl.finalizeResultDecision(interviewID, result);
	}

	@Override
	public boolean declareResults(String interviewID, int share) {
		return interviewScheduleDAOImpl.declareResults(interviewID, share);
		 
	}
	/*
	@Override
	public void delService(String id) {
		
		
		
		
	}
*/

	@Override
	public void delService(String id) {
		// TODO Auto-generated method stub
		candidateDAOImpl.delete(id);
		profileDAOImpl.delete(id);
	}

	@Override
	public CandidateBean editService(String id) {
		return candidateDAOImpl.editService(id);
		
	}

	public String generateSeq() {
		// TODO Auto-generated method stub
		
		
		return candidateDAOImpl.generateseq();
	}
	
	@Override
	public String genInterviewSeq() {
		// TODO Auto-generated method stub
		return interviewScheduleDAOImpl.genInterviewSeq();
	}

	@Override
	public ArrayList<String> fetchIdService() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchIds();
	}

	public ArrayList<String> fetchSubject() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchsubjects();
	}

	public ArrayList<String> fetchtechId() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchtechId();
	}

	public ArrayList<String> fetchhrId() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchhrId();
	}

	public ArrayList<String> fetchInterviewIdService() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchInterviewIdService();
	}

	@Override
	public void update(CandidateBean cb) {
		// TODO Auto-generated method stub
		candidateDAOImpl.update(cb);
	}

	public ArrayList<String> fetchcandID() {
		// TODO Auto-generated method stub
		return candidateDAOImpl.fetchcandID();
	}

	public void updateShareDetails(CandidateBean cb,int i) {
		// TODO Auto-generated method stub
	 candidateDAOImpl.updatedet(cb,i);
	}

	

	

	
}
