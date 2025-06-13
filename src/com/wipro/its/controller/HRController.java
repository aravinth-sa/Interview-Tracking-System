package com.wipro.its.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.HRPanelImpl;

@Controller
public class HRController {
	@Autowired
	HRPanelImpl hrPanelImpl;

	@RequestMapping("viewInterview(hr)")
	public ModelAndView viewInterviewSchedule(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		System.out.println(interviewScheduleBean.getEmpHRID());
		System.out.println(interviewScheduleBean.getEmpHRInterviewDate());
		ArrayList<CandidateBean> V = hrPanelImpl.viewCandidates(
				interviewScheduleBean.getEmpHRID(),
				interviewScheduleBean.getEmpHRInterviewDate());
		System.out.println(V);
		ModelAndView modelAndView = new ModelAndView("candidateview",
				"interviewScheduleBeanList", V);
		return modelAndView;
	}

	@RequestMapping("hrrating")
	public String hrrating(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		if (hrPanelImpl.submitRatings(interviewScheduleBean.getInterviewID(),
				interviewScheduleBean.getEmpHRID(),
				interviewScheduleBean.getEmpHRRating()))
			return "redirect:/submitRating(hr)";
		else {
			return "submitRating(hr)";
		}

	}

	@RequestMapping("viewrating(hr)")
	public ModelAndView viewRating_hr(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		InterviewScheduleBean i = hrPanelImpl
				.viewFinalResults(interviewScheduleBean.getInterviewID());
		if (i != null) {
			ModelAndView modelAndView = new ModelAndView("viewrating(hr)",
					"interviewScheduleBean", i);
			return modelAndView;
		}
		ModelAndView modelAndView1 = new ModelAndView("not_updated");
		return modelAndView1;

	}
}
