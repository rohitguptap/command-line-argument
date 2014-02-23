package Service;

import model.TestServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import Dao.ServerDAO;
import Dao.ServerDAOImpl;
@Service("serverService")
public class ServerServiceImpl implements ServerService {

	ServerDAOImpl serverDao = new ServerDAOImpl();
	@Override
	public Long saveServer(TestServer server) {
		Long id = serverDao.saveServer(server);
		return id;
	};

	@Override
	public Long countServer() {
		Long Id = serverDao.countServer();
		return Id;
	}
	
	@Override
	public String ListServer() {
		String server= serverDao.ListServer();
		return server;
		
	}
	
	@Override
	public void DeleteServer(int id) {
		 serverDao.DeleteServer(id);
		
		
	}

	public void UpdateServer(int id, String server) {
		 serverDao.UpdateServer(id, server);
		
	}
	

}
