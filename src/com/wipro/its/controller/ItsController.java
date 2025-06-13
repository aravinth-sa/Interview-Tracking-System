package com.wipro.its.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.AdministratorImpl;
import com.wipro.its.util.UserImpl;

@Controller
public class ItsController {

	UserImpl userImpl = new UserImpl();

	@Autowired
	AdministratorImpl administratorImpl;

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@RequestMapping("admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("tech")
	public String tech() {
		return "tech";
	}

	@RequestMapping("hr")
	public String hr() {
		return "hr";
	}

	@RequestMapping("add")
	public String add() {
		return "add";
	}

	@RequestMapping("logged")
	public String logged() {
		return "logged";
	}

	@RequestMapping("change_password")
	public String change_password() {
		return "change_password";
	}
	
	@RequestMapping("scheduled_success")
	public String scheduled_success() {
		return "scheduled_success";
	}

	@RequestMapping("view_rating")
	public String view_rating(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,
			Map<String, Object> map) {

		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "view_rating";
	}

	@RequestMapping("declare_result")
	public String declare_result(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,
			Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);

		return "declare_result";
	}

	@RequestMapping("finalise_result")
	public String finalise_result(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "finalise_result";
	}

	@RequestMapping("interview_schedule")
	public String interview_schedule(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,
			Map<String, Object> idMap) {
		ArrayList<String> idList = administratorImpl.fetchcandID();
		ArrayList<String> subject = administratorImpl.fetchSubject();
		ArrayList<String> techId = administratorImpl.fetchtechId();
		ArrayList<String> hrId = administratorImpl.fetchhrId();
		idMap.put("idList", idList);
		idMap.put("sub", subject);
		idMap.put("techId", techId);
		idMap.put("hrId", hrId);

		return "interview_schedule";
	}

	

	@RequestMapping("submitRating(hr)")
	public String submitRating_hr(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "submitRating(hr)";
	}

	@RequestMapping("submitRating")
	public String submitRating(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "submitRating";
	}

	

	@RequestMapping("viewFinalResult(hr)")
	public String viewFinalResult_hr(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "viewFinalResult(hr)";
	}

	@RequestMapping("viewFinalResult")
	public String viewFinalResult(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean,Map<String, Object> map) {
		ArrayList<String> id = administratorImpl.fetchInterviewIdService();

		map.put("id", id);
		return "viewFinalResult";
	}

	@RequestMapping("invalid")
	public String invalid() {
		return "invalid";
	}

	@RequestMapping("forgot_password")
	public String forgot_password() {
		return "forgot_password";
	}

	@RequestMapping("new_user")
	public String new_user() {
		return "new_user";
	}

	@RequestMapping("viewinterviewcandidate(hr)")
	public String viewinterviewcandidate_hr(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		return "viewinterviewcandidate(hr)";
	}

	@RequestMapping("viewinterviewcandidate")
	public String viewinterviewcandidate(
			@ModelAttribute InterviewScheduleBean interviewScheduleBean) {
		return "viewinterviewcandidate";
	}

	// ////////////////////////////////////

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		CredentialsBean cb = new CredentialsBean();
		cb.setUserID(request.getParameter("username"));
		cb.setPassword(request.getParameter("password"));
		String s = userImpl.login(cb);
		HttpSession session = request.getSession();
		session.setAttribute("cb", cb);
		System.out.println(session);
		if (s.equals("A"))
			return "admin";
		else if (s.equals("T"))
			return "tech";
		else if (s.equals("H"))
			return "hr";
		else if (s.equals("logged"))
			return "logged";
		return "invalid";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession ses = request.getSession(false);
		CredentialsBean cb = (CredentialsBean) ses.getAttribute("cb");
		userImpl.logout(cb.getUserID());
		ses.invalidate();
		System.out.println(ses);

		return "logout";
	}

	@RequestMapping("changepassword")
	public String changepassword(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("in change password");
		CredentialsBean cb = new CredentialsBean();

		cb.setPassword(request.getParameter("old_password"));
		cb.setUserID(request.getParameter("userid"));
		String s = userImpl.changePassword(cb,
				request.getParameter("new_password"));
		System.out.println(s);
		if (s.equals("SUCCESS")) {
			return "index";
		}

		return "index";

	}

	@RequestMapping("forgotpassword")
	public String forgotpassword(HttpServletRequest request,
			HttpServletResponse response) {

		CredentialsBean cb = new CredentialsBean();
		cb.setUserID(request.getParameter("userid"));
		cb.setPassword(request.getParameter("new_password"));
		String s = userImpl.changePassword(cb,
				request.getParameter("new_password"));
		if (s.equals("SUCCESS")) {
			return "index";

		}

		return null;

	}

	@RequestMapping("view")
	public String viewcandidate(@ModelAttribute CandidateBean candidateBean) {
		System.out.println("redirecting to viewCandidate page");
		return "view";
	}

}
