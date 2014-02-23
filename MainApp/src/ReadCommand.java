import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import Dao.ServerDAOImpl;
import model.TestServer;


public class ReadCommand implements Command {

	@Override
	public void  execute() {
		// TODO Auto-generated method stub
		 try{
			 File file = new File("C:\\file.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(TestServer.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				TestServer server = (TestServer) jaxbUnmarshaller.unmarshal(file);
				ServerDAOImpl sad = new ServerDAOImpl();
				sad.saveServer(server);
				System.out.println(server.getId());
		    } catch (JAXBException e) {
				e.printStackTrace();
			  }
		
	}

}
