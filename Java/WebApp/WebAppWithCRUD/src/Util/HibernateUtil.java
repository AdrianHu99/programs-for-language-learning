package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getCurrentSession(){
		session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {  
		  
        if (null != session) {  
            session.close();  
        }  
    }  
}
