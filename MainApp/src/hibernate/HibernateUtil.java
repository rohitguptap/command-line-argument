package hibernate;


import model.TestServer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = (SessionFactory) new AnnotationConfiguration()
			.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
			.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
			.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/bankdb")
			.setProperty("hibernate.connection.password", "123456")
			.setProperty("hibernate.connection.username", "rohit")
			.setProperty("hibernate.show_sql","true")
			.setProperty("hibernate.hbm2ddl.auto","update")
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
