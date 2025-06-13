package com.wipro.its.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.bean.ProfileBean;

import java.math.BigInteger;

@Repository
public class CandidateDAOImpl implements CandidateDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String createCandidate(CandidateBean cb) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting SessionFactory");
		Transaction transaction = session.beginTransaction();

		try {

			session.save(cb);
			transaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
			return "fail";
		}

		return "added";
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<CandidateBean> findAll(String skills, String qualification) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		Criteria cr = session.createCriteria(CandidateBean.class);
		cr.add(Restrictions.eq("primarySkills", skills));
		cr.add(Restrictions.eq("qualification", qualification));
		ArrayList<CandidateBean> l = (ArrayList<CandidateBean>) cr.list();

		System.out.println(l);
		/*
		 * ArrayList<CandidateBean>
		 * l=(ArrayList<CandidateBean>)session.createSQLQuery
		 * ("from CandidateBean"
		 * ).addScalar(skills).addScalar(qualification).list();
		 * System.out.println(l.get(0).getCandidateID());
		 */
		return l;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		CandidateBean p = (CandidateBean) session.load(CandidateBean.class, id);
		Transaction transaction = session.beginTransaction();
		System.out.println(p);
		if (p != null) {
			session.delete(p);
			System.out.println("can del");
		}
		transaction.commit();

	}

	public String generateseq() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery("select candidateID.nextval from Dual");
		String key = query.uniqueResult().toString();
		return key;

	}

	@Override
	public ArrayList<String> fetchIds() {
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery("select candidateID from Candidate");
		ArrayList<String> ids = (ArrayList<String>) query.list();
		System.out.println(ids);
		return ids;
	}

	public ArrayList<String> fetchsubjects() {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select subjects from techpanel");
		ArrayList<String> subs = (ArrayList<String>) query.list();
		System.out.println(subs);
		return subs;
	}

	public ArrayList<String> fetchtechId() {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select techid from techpanel");
		ArrayList<String> techid = (ArrayList<String>) query.list();
		System.out.println(techid);
		return techid;
	}

	public ArrayList<String> fetchhrId() {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select emphrid from hrpanel");
		ArrayList<String> hrid = (ArrayList<String>) query.list();
		System.out.println(hrid);
		return hrid;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> fetchcandID() {
		Session session = sessionFactory.openSession();

		Query query = session.createSQLQuery("select candidateID from Candidate where shareDetails=1");
		
		ArrayList<String> l = (ArrayList<String>) query.list();
		System.out.println(l);
		return l;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> fetchInterviewIdService() {
		Session session = sessionFactory.openSession();
		Query query = session
				.createSQLQuery("select interviewid from interview_schedule");
		ArrayList<String> id = (ArrayList<String>) query.list();
		System.out.println("3212121"+id);
		return id;
	}

	public CandidateBean editService(String id) {
		Session session = sessionFactory.openSession();
		return (CandidateBean) session.get(CandidateBean.class, id);
	}

	public void update(CandidateBean cb) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting SessionFactory");
		Transaction transaction = session.beginTransaction();

		try {

			session.update(cb);
			transaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}
	
	public void updatedet(CandidateBean cb,int i) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting SessionFactory");
		Transaction transaction = session.beginTransaction();
		CandidateBean cb1=(CandidateBean) session.get(CandidateBean.class, cb.getCandidateID());
		cb1.setShareDetails(i);
		System.out.println(cb1+" asd");
		try {

			session.update(cb1);
			transaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

}
