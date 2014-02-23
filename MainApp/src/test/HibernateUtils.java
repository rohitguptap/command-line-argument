package test;


import model.TestServer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtils {

	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = (SessionFactory) new AnnotationConfiguration()
			.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
			.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
			.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:DBNAME")
			.setProperty("hibernate.connection.password", "")
			.setProperty("hibernate.connection.username", "sa")
			.setProperty("hibernate.show_sql","true")
			.setProperty("hibernate.hbm2ddl.auto","create")
			.setProperty( "hibernate.jdbc.factory_class", "org.hibernate.jdbc.NonBatchingBatcherFactory")
			.setProperty("hibernate.jdbc.batch_size", "1")
			.addPackage("model") //the fully qualified package name
			.addAnnotatedClass(TestServer.class)
			.buildSessionFactory();
		

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
