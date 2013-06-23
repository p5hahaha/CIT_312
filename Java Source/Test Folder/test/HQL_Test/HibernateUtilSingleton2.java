package test.HQL_Test;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;

/*
 * This class follows the singleton pattern.
 */

//@SuppressWarnings("deprecation")
@SuppressWarnings("deprecation")
public class HibernateUtilSingleton2

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

			/*
			 *  Add your classes here that you want to match your database tables
			 *  The example has a User and a PhoneNumber class.
			 */

			config.addAnnotatedClass(MyUser.class);

			sessionFactory = config.buildSessionFactory();



			/*System.out.println("Creating the configuration");
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
			 */
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

	private HibernateUtilSingleton2(){



	}

}
