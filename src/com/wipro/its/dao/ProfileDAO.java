package com.wipro.its.dao;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.ProfileBean;

public interface ProfileDAO {
	String createProfile(ProfileBean pb);
	void delete(String id);

}
