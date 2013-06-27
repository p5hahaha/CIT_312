package test.HQL_Test;

import org.hibernate.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import test.HQL_Test.*;
import test.exceptions.InvalidUserException;

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

	public boolean createUser (String username, String password)throws InvalidUserException{
		boolean success = false;

		try{
			Session session = createSession();
			Transaction transaction = session.beginTransaction();

			MyUser newUser = new MyUser();
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

			MyUser newUser = new MyUser();
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

	public String loginUser(String usern, String password){
		String sessionString = new String();
		
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlQuery = "SELECT count(*) as COUNT FROM MyUser u "
				+ " WHERE uname = :bp_username "
				+ " AND pword = :bp_password "
				;
		
		List<Long> resultSet =(List<Long>) session.createQuery(sqlQuery)
				.setText("bp_username", usern)
				.setText("bp_password", password)
				.list();
		
		if (resultSet.get(0) != 0){
			System.out.println("It hit");
		} else {
			System.out.println("We missed");
		}
		
		
		
		return sessionString;
	}

}
