package test.HQL_Test;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/*
 * This class follows the singleton pattern.
 */

//@SuppressWarnings("deprecation")
public class HibernateUtilSingleton

{

	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	private static String username = "application";
	private static String password = "somePassword";

	static{

		try{
			System.out.println("Creating the configuration");
			Configuration config = new Configuration()
			.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect")
			.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
			.setProperty("hibernate.connection.username", username)
			.setProperty("hibernate.connection.password", password)
			.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:XE");
			
			System.out.println("Configuring the connection properties");
			
			config.setProperty("hibernate.connection.pool_size", "1");
			config.setProperty("hibernate.connection.autocommit", "true");
			config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
			config.setProperty("hibernate.show_sql", "true");
			config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
			config.setProperty("current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");
			
			System.out.println("Adding classes");
			config.addAnnotatedClass(MyUser.class);

			//config.addAnnotatedClass(PhoneNumber.class);
			
			System.out.println("Building a session");
			
			//config.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			
			sessionFactory = config.buildSessionFactory(serviceRegistry);

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
