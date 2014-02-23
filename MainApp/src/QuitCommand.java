
public class QuitCommand implements Command {

	@Override
	public void  execute() {
		System.out.println("You have exited from the application");
		return; 	
	}

}
