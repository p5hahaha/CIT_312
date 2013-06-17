package test.HQL_Test;

import org.hibernate.Session;

public class Hibernate_test {
	public static void main(String[] args){
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
	}
}
