package com.ooad.project.class_scheduler.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Course> fetchSelectedCourses(ArrayList<Integer> values) {
		ArrayList<Course> resultList = new ArrayList<Course>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Course c where c.id IN (:values)");
			query.setParameterList("values", values);
			resultList = (ArrayList<Course>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Course> searchCourses(String searchString) {
		ArrayList<Course> resultList = new ArrayList<Course>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Course c where LOWER(c.coursename) LIKE LOWER(:searchKeyword)");
			query.setParameter("searchKeyword", "%" + searchString + "%");
			resultList = (ArrayList<Course>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
}
