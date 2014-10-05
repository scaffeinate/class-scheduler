package com.ooad.project.class_scheduler.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.util.HibernateUtil;

public class Register {
	
	private Session session;
	
	public boolean insertData(User user){
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
