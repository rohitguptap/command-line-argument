
public class HelpCommand implements Command{

	@Override
	public void  execute() {
		System.out.println("help to display this message");
		System.out.println("countServers to display the current number of servers present");
		System.out.println("addServer to display the current number of servers present");
		System.out.println("editServer to change the name of a server identified by id (takes 2 additional args - the id and the new name)");
		System.out.println("deleteServer to delete a server (takes one more arg - the id of the server to delete)");
		System.out.println("listServers to display details of all servers servers");	
	}
	

}
