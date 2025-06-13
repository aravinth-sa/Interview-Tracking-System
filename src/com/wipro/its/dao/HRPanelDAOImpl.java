package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;

@Repository
public class HRPanelDAOImpl implements HRPanelDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean submitRatings(String interviewID, String empHRID,
			float empHRRating) {

		Session session = sessionFactory.openSession();

		InterviewScheduleBean i = (InterviewScheduleBean) session.get(
				InterviewScheduleBean.class, interviewID);
		i.setEmpHRRating(empHRRating);
		Transaction transaction = session.beginTransaction();
		try {
			session.update(i);

			transaction.commit();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<CandidateBean> viewCandidates(String empHRID,
			Date empHRInterviewDate) {

		System.out.println(empHRID + " " + empHRInterviewDate);
		Session session = sessionFactory.openSession();
		ArrayList<CandidateBean> c = new ArrayList<CandidateBean>();
		Criteria cr = session.createCriteria(InterviewScheduleBean.class);
		cr.add(Restrictions.eq("empHRID", empHRID));

		cr.add(Restrictions.eq("empHRInterviewDate", empHRInterviewDate));
		cr.add(Restrictions.eq("shareResult", 0));

		ArrayList<InterviewScheduleBean> d = (ArrayList<InterviewScheduleBean>) cr
				.list();
		System.out.println(d);
		Iterator<InterviewScheduleBean> it = d.iterator();
		while (it.hasNext()) {
			InterviewScheduleBean is = it.next();
			System.out.println(is);
			String candidateID = is.getCandidateID();
			CandidateBean cb = (CandidateBean) session.get(CandidateBean.class,
					candidateID);
			if(cb.getShareDetails()==1)
			c.add(cb);
		}

		return c;
	}

	@Override
	public InterviewScheduleBean viewFinalResults(String interviewID) {
		Session session = sessionFactory.openSession();

		InterviewScheduleBean i = (InterviewScheduleBean) session.get(
				InterviewScheduleBean.class, interviewID);
		CandidateBean c = (CandidateBean) session.get(CandidateBean.class,
				i.getCandidateID());
		System.out.println(c + "val " + c.getShareDetails());
		if (i.getShareResult() == 1) {
			return i;
		} else
			return null;
	}

}
