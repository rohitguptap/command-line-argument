package test;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base DbUnit Test case that initialises test database.
 *
 *
 */
public abstract class HibernateDbUnitTestCase extends DBTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateDbUnitTestCase.class);

    private static SessionFactory sessionFactory;
    protected Session session;

    /**
     * system properties initializing constructor.
     */
    public HibernateDbUnitTestCase() {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:hsqldb:mem:DBNAME");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
    }

    /**
     * Start the server.
     * @throws Exception in case of startup failure.
     */
    @Before
    public void setUp() throws Exception {
        HSQLServerUtil.getInstance().start("DBNAME");

        LOG.info("Loading hibernate...");
        if (sessionFactory == null) {
            sessionFactory = HibernateUtils.getSessionFactory();
        }

        session = sessionFactory.openSession();

        super.setUp();
    }

    /**
     * shutdown the server.
     * @throws Exception in case of errors.
     */
    @After
    public void tearDown() throws Exception {
        session.close();
        super.tearDown();
        HSQLServerUtil.getInstance().stop();
    }

    /** {@inheritDoc} */
    protected IDataSet getDataSet() throws Exception {
        throw new Exception("Specify data set for test: " + this.getClass().getSimpleName());
    }

    /** {@inheritDoc} */
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.REFRESH;
    }

    /** {@inheritDoc} */
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
    }


}
