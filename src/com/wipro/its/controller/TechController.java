package com.wipro.its.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.TechPanelImpl;

@Controller
public class TechController {
	@Autowired
	TechPanelImpl techPanelImpl;

	@RequestMapping("viewInterview")
	public ModelAndView viewInterviewSchedule(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		System.out.println(interviewScheduleBean.getTechID());
		System.out.println(interviewScheduleBean.getInterviewDate());
		ArrayList<CandidateBean> V = techPanelImpl.viewCandidates(
				interviewScheduleBean.getTechID(),
				interviewScheduleBean.getInterviewDate());
		System.out.println(V);
		ModelAndView modelAndView = new ModelAndView("candidateView(tech)",
				"interviewScheduleBeanList", V);
		return modelAndView;
	}

	@RequestMapping("techrating")
	public String techrating(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		if (techPanelImpl.submitRatings(interviewScheduleBean.getInterviewID(),
				interviewScheduleBean.getTechID(),
				interviewScheduleBean.getTechRating()))
			return "redirect:/submitRating";
		else {
			return "submitRating";
		}

	}

	@RequestMapping("viewrating")
	public ModelAndView viewRating(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		InterviewScheduleBean i = techPanelImpl
				.viewFinalResults(interviewScheduleBean.getInterviewID());
		if (i != null) {
			ModelAndView modelAndView = new ModelAndView("viewrating",
					"interviewScheduleBean", i);
			return modelAndView;
		}
		ModelAndView modelAndView1 = new ModelAndView("not_updated");
		return modelAndView1;
	}

}
