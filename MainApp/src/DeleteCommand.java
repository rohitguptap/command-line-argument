import java.util.Scanner;

import Service.ServerServiceImpl;


public class DeleteCommand implements Command{

	@Override
	public void execute() {
		System.out.println("Please enter a identifier to be deleted from DB");
		Scanner sc =  new Scanner(System.in);
		int id = sc.nextInt();
		ServerServiceImpl sad = new ServerServiceImpl();
		sad.DeleteServer(id);
		
	}

}
