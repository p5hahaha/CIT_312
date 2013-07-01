package test.HQL_Test.HibernateModels;

import org.hibernate.Session;
import org.hibernate.Transaction;

abstract public class GenericHibernateModel {
	protected Session session;
	protected Transaction transaction;
	
	abstract public boolean hibernateCommand();
}
