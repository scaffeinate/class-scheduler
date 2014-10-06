package com.ooad.project.class_scheduler.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.util.HibernateUtil;

public class UserDao {
	
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
			session.getTransaction().rollback();
		}
		
		return false;
	}
	
	public User fetchUserById(int id) {
		User user = new User();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			user = (User) session.get(User.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
	
	public User fetchUserByUsername(String username) {
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", username));
			user = (User) criteria.list().get(0);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		} catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return user;
	}

	public User checkCredentails(com.ooad.project.class_scheduler.bean.Session sessionBean) {
		// TODO Auto-generated method stub
		User user = fetchUserByUsername(sessionBean.getUsername());
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if(user != null){
			if(user.getPassword().equals(sessionBean.getPassword())){
				return user;
			}
		} 
		
		return null;
	}
}
