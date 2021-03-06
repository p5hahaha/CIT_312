package server.hibernate;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;

import server.hibernate.tableClasses.*;
public class HibernateUtilSingleton

{

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static String username = "application";
	private static String password = "somePassword";

	static{

		try{
			AnnotationConfiguration config = new AnnotationConfiguration();

			config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

			config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");

			//change the next line of code to match your MySQL url

			config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:XE");

			//change the next two lines of code to match your MySQL user name and password.

			config.setProperty("hibernate.connection.username", username);

			config.setProperty("hibernate.connection.password", password);

			//change the pool size to reflect how many users you expect your application to have initially

			config.setProperty("hibernate.connection.pool_size", "1");

					config.setProperty("hibernate.connection.autocommit", "true");

			config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

			/*
			 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
			 */

			//config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

			config.setProperty("hibernate.show_sql", "true");

			config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

			config.setProperty("hibernate.current_session_context_class", "thread");


			System.out.println("Adding Hibernate Table/Classes");
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(UserSession.class);
			config.addAnnotatedClass(Vehicle.class);
			System.out.println("Done adding Hibernate Table/Classes");
			
			sessionFactory = config.buildSessionFactory();

		}

		catch (Throwable ex)

		{

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	public static SessionFactory getSessionFactory()

	{

		return sessionFactory;

	}

	//make a private default constructor so that no other HibernateUtil can be created.

	private HibernateUtilSingleton(){



	}

}
