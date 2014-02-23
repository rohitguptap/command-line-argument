package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import model.TestServer;

import org.springframework.util.Assert;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.junit.Test;

import Dao.ServerDAOImpl;

/**
 * .
 */
public class CommandTest extends HibernateDbUnitTestCase {
	private static ServerDAOImpl serverDAOImpl = new ServerDAOImpl();

	@SuppressWarnings("deprecation")
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSet(this.getClass().getResourceAsStream(
				"/test/test.xml"));
	}

	@Test
	public void testCountServer() {
		Transaction trans = session.beginTransaction();
		assertEquals(4, session.createCriteria(TestServer.class).list().size());
		trans.commit();
	}

	//

	@Test
	public void testSelectServer() {
		Transaction trans = session.beginTransaction();
		List<TestServer> contactList = session.createQuery("from TestServer")
				.list();
		java.util.HashSet<String> serverName = new java.util.HashSet<String>();

		String[] arr = { "server1", "server2", "server4", "server3" };

		for (TestServer server : contactList)
			serverName.add(server.getName());
		assertEquals("server name",
				new java.util.HashSet(java.util.Arrays.asList(arr)), serverName);

		trans.commit();
	}

	@Test
	public void testInsertServer() {
		Transaction trans = session.beginTransaction();
		TestServer serverName1 = new TestServer("server88", 88);
		session.save(serverName1);
		List<TestServer> contactList = session.createQuery("from TestServer")
				.list();

		Assert.isTrue(contactList.size() > 1);
	}

	@Test
	public void testDeleteServer() {

		int id = 88;
		Transaction trans = session.beginTransaction();
		TestServer server = (TestServer) session.get(TestServer.class, id);
		session.delete(server);
		List<TestServer> contactList = session.createQuery("from TestServer")
				.list();
		for (TestServer test : contactList)

			Assert.isTrue(test.getId() != 88);

		trans.commit();
	}

	
    @Test
    public void testUpdateServer() {
    	String serverName = "serverUpdated";
    	int id =3;
    	Transaction	transaction = session.beginTransaction();
		TestServer server = (TestServer) session.get(TestServer.class, id);
		server.setName(serverName);
		Query query = session.createQuery("from TestServer where id =3 ");
			List list = query.list();
		TestServer server2 = (TestServer)list.get(0);
	     assertEquals(serverName, server2.getName()
                );
    }
}
