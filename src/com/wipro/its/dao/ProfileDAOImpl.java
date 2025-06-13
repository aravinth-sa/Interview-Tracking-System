package com.wipro.its.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.wipro.its.bean.ProfileBean;
@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	 SessionFactory sessionFactory;
	
	
	@Override
	public String createProfile(ProfileBean pb) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting SessionFactory");
		Transaction transaction = session.beginTransaction();

		try {

			session.save(pb);
			transaction.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
			return "fail";
		}
		return "added";
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		ProfileBean p=(ProfileBean) session.load( ProfileBean.class,id);
		Transaction transaction=session.beginTransaction();
		
		if(p!=null){
			session.delete(p);
		System.out.println("prof del");
		}
		transaction.commit();
	}

}
