package server.hibernate;

import org.hibernate.*;

import server.CommandBean;
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
	private final int ANDROIDIDLENGTH = 16;

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

	public int createUser (String username, String password) throws InvalidUserException{
		int userId = 0;

		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		try{
			User newUser = new User();
			newUser.setUname(username);
			newUser.setPword(password);

			if (username == "username"){
				throw new InvalidUserException("Must contain a valid username and password");
			}

			session.save(newUser);
			transaction.commit();
			userId = newUser.getId();
		} catch (Exception e){
			transaction.rollback();
			throw new InvalidUserException(e.getMessage());
		}
		return userId;
	}

	public int createUser(String username, String password, String firstName, String lastName) throws InvalidUserException{
		int userId = 0;
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		try{
			User newUser = new User();
			newUser.setUname(username);
			newUser.setPword(password);
			newUser.setFirst_name(firstName);
			newUser.setLast_name(lastName);

			session.save(newUser);
			transaction.commit();
			userId = newUser.getId();
		} catch (Exception e){
			transaction.rollback();
			throw new InvalidUserException(e.getMessage());
		}
		return userId;
	}

	public String createUserSession (int userId, String androidId) {
		Session session = createSession();
		Transaction transaction = session.beginTransaction();

		Date creationDate = new Date(System.currentTimeMillis());

		UserSession newSession = new server.hibernate.tableClasses.UserSession();

		newSession.setSessionNumber(UUID.randomUUID().toString());
		newSession.setUserId(userId);
		newSession.setAndroidId(androidId);
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
		transaction.commit();
		return resultSet.get(0);
	}

	public CommandBean createCommandBean(HashMap a) {
		CommandBean cb = new CommandBean();

		cb.setCommand((String)a.get("command"));
		cb.setData((HashMap)a.get("data"));

		return cb;
	}

	public void removeUser(String username, String password, String sessionNumber){
		Session session = createSession();
		Transaction transaction = session.beginTransaction();
		Iterator iterator;

		String sqlQuery = "SELECT u "
				+" FROM UserSession s"
				+" , User u"
				+" WHERE s.sessionNumber = :bp_sessionNumber" 
				+" AND u.uname = :bp_username"
				+" AND u.pword = :bp_password"
				+" AND s.endDate IS NULL";

		List<User> resultSet = (List<User>) session.createQuery(sqlQuery)
				.setText("bp_sessionNumber", sessionNumber)
				.setText("bp_username", username)
				.setText("bp_password", password)
				.list();

		iterator = resultSet.iterator();
		while(iterator.hasNext()){
			User temp = (User) iterator.next();
			System.out.println(temp.toString());
			session.delete(temp);
		}
		transaction.commit();
	}
}
