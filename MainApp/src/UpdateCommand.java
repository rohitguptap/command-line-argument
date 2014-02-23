import java.util.Scanner;

import Service.ServerServiceImpl;


public class UpdateCommand  implements Command{

	@Override
	public void execute() {
		System.out.println("Please enter a identifier and the new server name  to be updated");
		Scanner sc =  new Scanner(System.in);
		int id = sc.nextInt();
		String server = sc.nextLine();
		ServerServiceImpl sad = new ServerServiceImpl();
		sad.UpdateServer(id,server);
		
	}
}
