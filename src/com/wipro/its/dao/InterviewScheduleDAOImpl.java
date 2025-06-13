package com.wipro.its.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.its.bean.InterviewScheduleBean;

@Repository
public class InterviewScheduleDAOImpl implements InterviewScheduleDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void CreateSchedule(InterviewScheduleBean interviewScheduleBean) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting SessionFactory");
		Transaction transaction = session.beginTransaction();

		try {

			session.save(interviewScheduleBean);
			transaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}

	@Override
	public InterviewScheduleBean viewRatings(String interviewID) {
		Session session = sessionFactory.openSession();
		return (InterviewScheduleBean) session.get(InterviewScheduleBean.class,
				interviewID);
	}

	@Override
	public boolean finalizeResultDecision(String interviewID, String result) {
		Session session = sessionFactory.openSession();

		InterviewScheduleBean i = (InterviewScheduleBean) session.get(
				InterviewScheduleBean.class, interviewID);
		i.setResult(result);
		Transaction transaction = session.beginTransaction();
		try {
			session.update(i);

			transaction.commit();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean declareResults(String interviewID, int share) {
		Session session = sessionFactory.openSession();

		System.out.println(interviewID);
		InterviewScheduleBean i = (InterviewScheduleBean) session.get(
				InterviewScheduleBean.class, interviewID);
		i.setShareResult(share);
		Transaction transaction = session.beginTransaction();
		try {
			session.update(i);

			transaction.commit();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		return false;

	}

	public String genInterviewSeq() {
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery("select interviewID.nextval from Dual");
		String key = query.uniqueResult().toString();
		return key;
	}

}
