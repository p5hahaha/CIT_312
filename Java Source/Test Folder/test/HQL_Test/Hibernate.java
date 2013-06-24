package test.HQL_Test;

import org.hibernate.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import test.HQL_Test.*;

public class Hibernate {

	private SessionFactory sessionFactory;
	
	public Hibernate(){
		sessionFactory = HibernateUtilSingleton2.getSessionFactory();
	}

	Session createSession(){
		return sessionFactory.getCurrentSession();
	}

	public void showAllUsers(){
		try{
			Session session = createSession();
			Transaction transaction = session.beginTransaction();
			
			List<MyUser> resultSet;
			HashMap<Integer, MyUser> users = new HashMap<Integer, MyUser>();
			Iterator iterator;
			
			Query allUsersQuery = session.createQuery("SELECT u from MyUser as u");
			resultSet = (List<MyUser>) allUsersQuery.list();
			
			iterator = resultSet.iterator();
			while(iterator.hasNext()){
				MyUser temp = (MyUser) iterator.next();
				users.put(temp.getId(), (MyUser)temp);
			}
			
			System.out.println(users.toString());
			
			transaction.commit();

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void createUser(String username, String password){
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		MyUser newUser = new MyUser();
		newUser.setUname(username);
		newUser.setPword(password);
		
		session.save(newUser);
		transaction.commit();
	}
	
	public void createUser(String username, String password, String firstName, String lastName){
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		MyUser newUser = new MyUser();
		newUser.setUname(username);
		newUser.setPword(password);
		newUser.setFirst_name(firstName);
		newUser.setLast_name(lastName);
		
		session.save(newUser);
		transaction.commit();
	}


}
