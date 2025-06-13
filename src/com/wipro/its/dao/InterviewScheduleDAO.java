package com.wipro.its.dao;

import com.wipro.its.bean.InterviewScheduleBean;

public interface InterviewScheduleDAO {

	void CreateSchedule(InterviewScheduleBean interviewScheduleBean);

	InterviewScheduleBean viewRatings(String interviewID);

	boolean finalizeResultDecision(String interviewID, String result);

	boolean declareResults(String interviewID, int share);

}
