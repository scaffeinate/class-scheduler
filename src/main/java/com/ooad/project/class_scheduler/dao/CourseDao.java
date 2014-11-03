package com.ooad.project.class_scheduler.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.util.HibernateUtil;

public class CourseDao {

	private Session session;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Course> fetchCourses() {
		
		ArrayList<Course> resultList = new ArrayList<Course>();
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			resultList = (ArrayList<Course>) session.createCriteria(Course.class).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultList;
	}
}
