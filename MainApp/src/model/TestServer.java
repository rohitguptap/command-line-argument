package model; 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "server", namespace="http://www.opsource.net/simpleapp")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class TestServer
{
	@XmlElement(name = "id", required = true, namespace = "http://www.opsource.net/simpleapp")
	@Id
	public int id;
	@XmlElement(name = "name", required = true, namespace = "http://www.opsource.net/simpleapp")
	public String name;
	public TestServer(){}
	
	public TestServer( String name,int id ){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	

}