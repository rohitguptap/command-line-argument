import Dao.ServerDAOImpl;
import Service.ServerService;
import Service.ServerServiceImpl;


public class CountCommand implements Command{
	

	@Override
	public void execute() {
		ServerServiceImpl sad = new ServerServiceImpl();
		sad.countServer();
	}

}
