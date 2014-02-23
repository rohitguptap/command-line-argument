import Service.ServerServiceImpl;


public class ListCommand implements Command{
	
	@Override
	public void execute() {
		ServerServiceImpl sad = new ServerServiceImpl();
		sad.ListServer();
	}


}
