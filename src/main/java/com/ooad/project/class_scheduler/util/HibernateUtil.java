package com.ooad.project.class_scheduler.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = constructSessionFactory();
	
	private static SessionFactory constructSessionFactory() {
		try {
			return new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Hibernate SessionFactory construct Exception");
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void closeFactory(){
		sessionFactory.close();
	}
}
