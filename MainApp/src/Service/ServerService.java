package Service;

import model.TestServer;

public interface ServerService {


	public Long saveServer(TestServer server);
	
	public Long countServer();
	
	public String ListServer();

	void DeleteServer(int id);
	
}
