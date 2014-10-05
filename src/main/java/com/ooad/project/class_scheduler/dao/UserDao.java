package com.ooad.project.class_scheduler.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
		User user = new User();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String queryString = "from USER where username = :username"; 
			Query query = session.createQuery(queryString);
			query.setString("username", username);
			user = (User) query.uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
}
