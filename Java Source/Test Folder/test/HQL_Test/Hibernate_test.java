package test.HQL_Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Hibernate_test {
	public static void main(String[] args){
		try{
			SessionFactory temp = HibernateUtilSingleton.getSessionFactory();
			Session session = temp.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		MyUser james = new MyUser("James", "Super");
		session.save(james);
		transaction.commit();
		}catch (Exception e){
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}
}
