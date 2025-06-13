package com.wipro.its.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.service.AdministratorImpl;

@Controller
public class AdminController {
	@Autowired
	AdministratorImpl administratorImpl;

	@RequestMapping("addCandidate")
	public String addCandidate(HttpServletRequest request, Map<String, Object> map) {

		CandidateBean cb = new CandidateBean();
		ProfileBean pb = new ProfileBean();

		cb.setPrimarySkills(request.getParameter("primaryskills"));
		cb.setSecondarySkills(request.getParameter("secondaryskills"));
		cb.setExperience(Float.parseFloat(request.getParameter("experience")));
		cb.setLocation(request.getParameter("location"));
		cb.setDesignation(request.getParameter("designation"));
		cb.setNoticePeriod(Integer.parseInt(request
				.getParameter("noticeperiod")));

		cb.setQualification(request.getParameter("qualification"));

		pb.setFirstName(request.getParameter("firstname"));
		pb.setLastName(request.getParameter("lastname"));
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date startDate = null;
		try {
			startDate = df.parse(request.getParameter("dateofbirth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pb.setDateOfBirth(startDate);
		pb.setGender(request.getParameter("gender"));
		pb.setStreet(request.getParameter("street"));
		pb.setLocation(request.getParameter("location"));
		pb.setCity(request.getParameter("city"));
		pb.setState(request.getParameter("state"));
		pb.setPincode(request.getParameter("pincode"));
		pb.setMobileNo(request.getParameter("mobileno"));
		pb.setEmailID(request.getParameter("emailid"));
		pb.setPassword(request.getParameter("password"));
		System.out.println(cb + " " + pb);

		String s = request.getParameter("firstname").substring(0, 2)
				.toUpperCase()
				+ (administratorImpl.generateSeq());
		cb.setCandidateID(s);

		pb.setCandidateID(s);
		
		if (administratorImpl.addCandidate(pb, cb).equals("success")) {
			map.put("msg", "Candidate added Successfully");

		} else {
			map.put("msg", "Something went wrong");
		}

		return "add";

	}

	@RequestMapping("viewinfo")
	public String viewinfo(@ModelAttribute CandidateBean candidateBean,
			Map<String, Object> map) {
		System.out.println(candidateBean.getPrimarySkills());
		ArrayList<CandidateBean> l = administratorImpl.viewCandidate(
				candidateBean.getPrimarySkills(),
				candidateBean.getQualification());
		System.out.println(l);

		map.put("candidateBeanList", l);
		return "viewCandidate";
	}

	@RequestMapping(value = "schedule", method = RequestMethod.POST)
	public String schedule(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,
			Map<String, Object> map) {
		String s = interviewScheduleBean.getSubject().substring(0, 2)
				.toUpperCase()
				+ administratorImpl.genInterviewSeq();
		interviewScheduleBean.setInterviewID(s);
		administratorImpl.scheduleInterview(interviewScheduleBean);
		map.put("msg", "Interview Scheduled Successfully");
		return "scheduled_success";
	}

	@RequestMapping("viewRatingById")
	public ModelAndView viewRatingById(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		InterviewScheduleBean i = administratorImpl
				.viewRatings(interviewScheduleBean.getInterviewID());
		ModelAndView modelAndView = new ModelAndView("viewratingbyid",
				"interviewScheduleBean", i);
		return modelAndView;
	}

	@RequestMapping("finalise")
	public String finalise(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		administratorImpl.finalizeResultDecision(
				interviewScheduleBean.getInterviewID(),
				interviewScheduleBean.getResult());
		return "redirect:/finalise_result";

	}

	@RequestMapping("share")
	public String share(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		if (administratorImpl.declareResults(
				interviewScheduleBean.getInterviewID(),
				interviewScheduleBean.getShareResult()))
			return "redirect:/declare_result";
		return null;
	}

	@RequestMapping("delCandidate/{CandidateID}/{primarySkills}/{qualification}")
	public String delCandidate(@PathVariable("CandidateID") String id,
			@PathVariable("primarySkills") String primarySkills,
			@PathVariable("qualification") String qualification,
			Map<String, Object> map) {
		administratorImpl.delService(id);
		System.out.println(primarySkills + " " + qualification);
		ArrayList<CandidateBean> l = administratorImpl.viewCandidate(
				primarySkills, qualification);
		System.out.println(l);
		map.put("candidateBeanList", l);
		return "redirect:/view";

	}

	@RequestMapping("editCandidate/{CandidateID}")
	public ModelAndView editCandidate(@PathVariable("CandidateID") String id) {
		CandidateBean candidateBean = administratorImpl.editService(id);
		System.out.println(candidateBean + "   $$$ll");
		ModelAndView m = new ModelAndView("edit", "candidateBean",
				candidateBean);
		return m;

	}

	@RequestMapping("viewCandidate")
	public String editCanddidate(Map<String, Object> map) {

		return "viewCandidate";

	}

	@RequestMapping(value = "editCandidate/update", method = RequestMethod.POST)
	public String edit(@ModelAttribute CandidateBean candidateBean) {

		System.out.println(candidateBean + "kkk");
		administratorImpl.update(candidateBean);
		return "redirect:/view";

	}

	@RequestMapping("share_candidate")
	public String sharecand(@ModelAttribute CandidateBean candidateBean,Map<String, Object> idMap) {
		
		
		ArrayList<String> idList = administratorImpl.fetchcandID();
		idMap.put("idList", idList);
		return "share_candidate";
	}
	
	@RequestMapping("shareCandidate")
	public String sharedetailstopanel(@ModelAttribute CandidateBean candidateBean){
		administratorImpl.updateShareDetails(candidateBean,candidateBean.getShareDetails());
		return "redirect:/share_candidate";
		
	}
}
