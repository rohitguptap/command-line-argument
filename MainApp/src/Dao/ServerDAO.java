package Dao;

import model.TestServer;

public interface ServerDAO {

	public Long saveServer(TestServer server);
	
	public Long countServer();
	
	public String ListServer();
	
	public void DeleteServer(int id);
	
	public void UpdateServer(int id, String serverName);

}
