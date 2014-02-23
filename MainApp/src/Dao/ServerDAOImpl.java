package Dao;

import java.util.List;

import org.hibernate.Query;

import hibernate.HibernateUtil;
import model.TestServer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("serverdao") 
public class ServerDAOImpl implements ServerDAO {
	
	@Transactional
	public Long saveServer(TestServer server)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long Id = null;
		try {
			transaction = session.beginTransaction();
			TestServer ser = new TestServer();
			
			ser.setName(server.getName());
			ser.setId(server.getId());
		
			session.save(ser);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Id;
	}
	
	public Long countServer()
	{
			Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long Id = null;
		try {
			transaction = session.beginTransaction();
		String hql = "SELECT count( T.name) FROM TestServer T";
				Query query = (Query) session.createQuery(hql);
			List results =  query.list();
			System.out.println(results);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Id;
	}
	
	
	public String ListServer()
	{
			Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		String s2= null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from TestServer");
			List<TestServer> results = query.list();
			for(TestServer res: results){
				
				res.getName();
				System.out.println(res.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return s2;
	}
	
	@Transactional
	public void DeleteServer(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			TestServer server = (TestServer) session.get(TestServer.class, id);
			session.delete(server);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	@Transactional
	@Override
	public void UpdateServer(int id, String serverName) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			TestServer server = (TestServer) session.get(TestServer.class, id);
			server.setName(serverName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


}
