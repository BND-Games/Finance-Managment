package bnd_games.financemanagment.classes;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLCreater {
	public void xml_user_file_create(String file_path, String vorname, String nachname, String kürzel, String organisation, String sec_settings, String account_data_directory_path)
	{	 
		try 
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("User");
			doc.appendChild(rootElement);
	
			// Account details elements
			Element acc_details = doc.createElement("account_details");
			rootElement.appendChild(acc_details);
	
			// firstname elements
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode(vorname));
			acc_details.appendChild(firstname);
	
			// lastname elements
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode(nachname));
			acc_details.appendChild(lastname);
	
			// contraction elements
			Element contraction = doc.createElement("contraction");
			contraction.appendChild(doc.createTextNode(kürzel));
			acc_details.appendChild(contraction);
	
			// organisation elements
			Element orga = doc.createElement("organisation");
			orga.appendChild(doc.createTextNode(organisation));
			acc_details.appendChild(orga);
			
			// security settings elements
			Element security_settings = doc.createElement("security_settings");
			security_settings.appendChild(doc.createTextNode(sec_settings));
			acc_details.appendChild(security_settings);
			
			// account data directory path elements
			Element acc_data_dir_path = doc.createElement("acc_data_dir_path");
			acc_data_dir_path.appendChild(doc.createTextNode(account_data_directory_path));
			acc_details.appendChild(acc_data_dir_path);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));
	
			transformer.transform(source, result);
		} 
		catch (Exception ex) 
		{
			System.err.println("[Fehler] Beim erstellen der XML "+ file_path +" ist ein Fehler aufgetreten!");
			return;
		} 	
		finally
		{
			System.out.println("[Konsole] User XML für "+ file_path +" geschrieben!");

		}
	}
	
	public void xml_user_security_file_create(String file_path, String nickname, String password, String email)
	{	 
		try 
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("security_details");
			doc.appendChild(rootElement);
	
			// Account information elements
			Element acc_infos = doc.createElement("account_informations");
			rootElement.appendChild(acc_infos);
	
			// nickname elements
			Element nick = doc.createElement("nickname");
			nick.appendChild(doc.createTextNode(nickname));
			acc_infos.appendChild(nick);
	
			// password elements
			Element pass = doc.createElement("password");
			pass.appendChild(doc.createTextNode(password));
			acc_infos.appendChild(pass);
	
			// email elements
			Element mail = doc.createElement("email");
			mail.appendChild(doc.createTextNode(email));
			acc_infos.appendChild(mail);
	
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));
	
			transformer.transform(source, result);
		} 
		catch (Exception ex) 
		{
			System.err.println("[Fehler] Beim erstellen der Sicherheits relevanten XML " + file_path + " ist ein Fehler aufgetreten!");
			return;
		} 	
		System.out.println("[Konsole] Die Sicherheits relevante XML "+ file_path +" geschrieben!");
	}
	
	public void xml_user_list_create(String file_path, String firstname, String lastname , String security)
	{	 
		try 
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("user_list");
			doc.appendChild(rootElement);
	
			// Account-List elements
			Element acc_list = doc.createElement(firstname + "." + lastname);
			rootElement.appendChild(acc_list);
	
			// firstname elements
			Element f_name = doc.createElement("firstname");
			f_name.appendChild(doc.createTextNode(firstname));
			acc_list.appendChild(f_name);
	
			// lastname elements
			Element l_name = doc.createElement("lastname");
			l_name.appendChild(doc.createTextNode(lastname));
			acc_list.appendChild(l_name);
	
			// security elements
			Element sec = doc.createElement("security");
			sec.appendChild(doc.createTextNode(security));
			acc_list.appendChild(sec);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));
	
			transformer.transform(source, result);
		} 
		catch (Exception ex) 
		{
			System.err.println("[Fehler] Beim erstellen der Sicherheits relevanten XML " + file_path + " ist ein Fehler aufgetreten!");
			return;
		} 	
		System.out.println("[Konsole] Die Sicherheits relevante XML "+ file_path +" geschrieben!");
	}
	
	public static void read_users_xml(File path)
	{
	    try {	    	 
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(path);
	     
	    	NodeList nList = doc.getElementsByTagName("account_details");	     
    		Node nNode = nList.item(0);
   	     
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {	     
    			Element eElement = (Element) nNode;	     
    			System.err.println("[Debug] " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
    			System.err.println("[Debug] " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
    			System.err.println("[Debug] " + eElement.getElementsByTagName("security_settings").item(0).getTextContent());	     
    		}
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
	}

}
