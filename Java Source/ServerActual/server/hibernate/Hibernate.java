package server.hibernate;

import org.hibernate.*;

import server.exception.InvalidUserException;
import server.hibernate.tableClasses.User;
import server.hibernate.tableClasses.UserSession;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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

	public boolean createUser (String username, String password) throws InvalidUserException{
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

	public String createUserSession(int userId,HashMap<String, String> a){
		Session session = createSession();
		Transaction transaction = session.beginTransaction();

		Date creationDate = new Date(System.currentTimeMillis());

		UserSession newSession = new server.hibernate.tableClasses.UserSession();

		newSession.setSessionNumber(UUID.randomUUID().toString());
		newSession.setUserId(userId);
		
		if (a.containsKey("androidId")){
			newSession.setAndroidId(a.get("androidId"));
		}
		
		newSession.setCreatedBy(userId);
		newSession.setCreationDate(creationDate);
		newSession.setLastUpdatedBy(userId);
		newSession.setLastUpdateDate(creationDate);

		session.save(newSession);
		transaction.commit();

		return newSession.getSessionNumber();
	}

	public int loginUser(String username, String password) throws InvalidUserException{
		int userId = 0;

		Session session = createSession();
		Transaction transaction = session.beginTransaction();

		String sqlQuery = "SELECT u.user_id as COUNT FROM User u "
				+ " WHERE uname = :bp_username "
				+ " AND pword = :bp_password "
				;

		List<Integer> resultSet =(List<Integer>) session.createQuery(sqlQuery)
				.setText("bp_username", username)
				.setText("bp_password", password)
				.list();

		if (resultSet.size() > 0){

			System.out.println("The size is: " + Integer.toString(resultSet.size()));
			System.out.println("Userid: " + Integer.toString(resultSet.get(0)));
			userId = (int)resultSet.get(0);
		} else{
			System.out.println("FAIL");
			throw new InvalidUserException("Incorrect Username or Password.");
		}

		transaction.commit();
		return  userId;
	}
	
	public User getUser(String sessionId) throws Exception{
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		
		String sqlQuery = "SELECT u "
				+" FROM UserSession s"
				+" , User u"
				+" WHERE s.sessionNumber = :bp_sessionNumber" 
				+" AND u.user_id = s.userId";
		List<User> resultSet = (List<User>) session.createQuery(sqlQuery)
				.setText("bp_sessionNumber", sessionId)
				.list();
		if (resultSet.size() == 0){
			throw new Exception ("Nothing in the result set");
		}
		return resultSet.get(0);
	}
}
