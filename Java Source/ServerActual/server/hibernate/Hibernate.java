package server.hibernate;

import org.hibernate.*;

import server.exception.InvalidUserException;
import server.hibernate.tableClasses.User;
import server.hibernate.tableClasses.UserSession;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Hibernate {

	private SessionFactory sessionFactory;

	public Hibernate(){
		sessionFactory = HibernateUtilSingleton.getSessionFactory();
	}

	Session createSession(){
		return sessionFactory.getCurrentSession();
	}

	public void showAllUsers(){
		try{
			Session session = createSession();
			Transaction transaction = session.beginTransaction();

			List<User> resultSet;
			HashMap<Integer, User> users = new HashMap<Integer, User>();
			Iterator iterator;

			Query allUsersQuery = session.createQuery("SELECT u from User as u");
			resultSet = (List<User>) allUsersQuery.list();

			iterator = resultSet.iterator();
			while(iterator.hasNext()){
				User temp = (User) iterator.next();
				users.put(temp.getId(), (User)temp);
			}

			System.out.println(users.toString());

			transaction.commit();

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public boolean createUser (String username, String password)throws InvalidUserException{
		boolean success = false;

		try{
			Session session = createSession();
			Transaction transaction = session.beginTransaction();

			User newUser = new User();
			newUser.setUname(username);
			newUser.setPword(password);

			if (username == "username"){
				throw new InvalidUserException("Must contain a valid username and password");
			}

			session.save(newUser);
			transaction.commit();
			success = true;
		} catch (InvalidUserException e){
			throw e;
		}catch (Exception e){
			success = false;
		}


		return true;
	}

	public boolean createUser(String username, String password, String firstName, String lastName){
		boolean success = false;

		try{
			Session session = createSession();

			Transaction transaction = session.beginTransaction();

			User newUser = new User();
			newUser.setUname(username);
			newUser.setPword(password);
			newUser.setFirst_name(firstName);
			newUser.setLast_name(lastName);

			session.save(newUser);
			transaction.commit();
			success = true;
		} catch (Exception e){
			success = false;
		}
		return success;
	}

	public String loginUser(String username, String password){
		String sessionString = new String();
		
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlQuery = "SELECT count(*) as COUNT FROM User u "
				+ " WHERE uname = :bp_username "
				+ " AND pword = :bp_password "
				;
		
		List<Long> resultSet =(List<Long>) session.createQuery(sqlQuery)
				.setText("bp_username", username)
				.setText("bp_password", password)
				.list();
		
		if (resultSet.get(0) != 0){
			
		} else {
			System.out.println("We missed");
		}
		
		
		transaction.commit();
		return sessionString;
	}
	public void createUserSession(){
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		UserSession newSession = new server.hibernate.tableClasses.UserSession();
		newSession.setAndroidId("A2fjflsdfkljdsf");
		
	}
}
