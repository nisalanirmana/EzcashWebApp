package lk.dialoglab.ezcash.util;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
 
public class getDBCredintials  {
 
	private static final Logger logger = Logger.getLogger(getDBCredintials.class);
	private String server = "";
	private String port = "3306";
	private String dbName = "";
	private String username = "";
	private String password = "";
	
	
	
//  public static void main(String argv[]) {
	
	public getDBCredintials(){
    try {


    logger.info("Get Databse Credintials. Read xml files");	
	File fXmlFile = new File("ezcashdb.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("dbAccess");
 
	
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
				this.setServer(eElement.getElementsByTagName("server").item(0).getTextContent());
				this.setUsername(eElement.getElementsByTagName("username").item(0).getTextContent());
				this.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
				this.setDbName(eElement.getElementsByTagName("dbName").item(0).getTextContent());
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
	logger.info("Get DB credintials failed"+e.toString());
    }
  }



	public String getServer() {
		return server;
	}



	public void setServer(String server) {
		this.server = server;
	}



	public String getPort() {
		return port;
	}



	public void setPort(String port) {
		this.port = port;
	}



	public String getDbName() {
		return dbName;
	}



	public void setDbName(String dbName) {
		this.dbName = dbName;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
 
}