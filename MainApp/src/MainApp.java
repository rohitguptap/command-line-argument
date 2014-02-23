import java.lang.*;


import java.util.Scanner;

import Exception.ServerException;

public class MainApp
{
    public static void main(String[] args) 
    {
    	try{
    	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter one of the following option a)help b)quit c)read d)count e)list f)delete g)update");
  

	String read = sc.nextLine();

	Commands.getCommand(read).execute();
    
    }
    catch(ServerException e){
    	
    	
    }
   
}
}
