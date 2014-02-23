
public class ServerFactory {
	
	  public static Command executeCommand(String command) {
		  System.out.println(command);
	        if (command.equals("help")) {
	            return new HelpCommand();
	        }else if (command.equalsIgnoreCase("quit")) {
	            return new QuitCommand();
	        }
	        else if (command.equalsIgnoreCase("read")) {
	            return new ReadCommand();
	        }
	        else if (command.equalsIgnoreCase("count")) {
	            return new CountCommand();
	        }
	        throw new IllegalArgumentException("Command doesnot exist");
	    }
	

}
