package com.wipro.its.dao;

import java.util.ArrayList;

import com.wipro.its.bean.CandidateBean;

public interface CandidateDAO {
	String createCandidate(CandidateBean cb);

	ArrayList<CandidateBean> findAll(String skills, String qualification);

	void delete(String id);


	ArrayList<String> fetchIds();
}
