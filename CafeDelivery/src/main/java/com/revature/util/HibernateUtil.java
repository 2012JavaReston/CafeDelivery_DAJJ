package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	//Utilizes the singleton design pattern
	//Be sure to close session when done.
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session ses;
	public static Session getSession() {
		if(ses == null) {
			return ses = sf.openSession();
		}else {
			return ses;
		}
		
	}
	
	public static void closeSession() {
		ses.close();
		ses = null;
	}

}
