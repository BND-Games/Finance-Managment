package de.bnd_games.financemanagment.classes;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLCreater {
	static final Logger logger = LogManager.getLogger(XMLCreater.class
			.getName());

	public void xml_user_file_create(String file_path, String vorname,
			String nachname, String kürzel, String organisation,
			String sec_settings, String account_data_directory_path) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
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
			acc_data_dir_path.appendChild(doc
					.createTextNode(account_data_directory_path));
			acc_details.appendChild(acc_data_dir_path);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));

			transformer.transform(source, result);
		} catch (Exception ex) {
			logger.error("Beim erstellen der XML " + file_path
					+ " ist ein Fehler aufgetreten!");
			return;
		} finally {
			logger.info("User XML für " + file_path + " geschrieben!");

		}
	}

	public void xml_user_security_file_create(String file_path,
			String nickname, String password, String email) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
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
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));

			transformer.transform(source, result);
		} catch (Exception ex) {
			logger.error("Beim erstellen der Sicherheits relevanten XML "
					+ file_path + " ist ein Fehler aufgetreten!");
			return;
		}
		logger.info("Die Sicherheits relevante XML " + file_path
				+ " geschrieben!");
	}

	public void xml_user_list_create(String file_path, String firstname,
			String lastname, String security) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
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
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file_path));

			transformer.transform(source, result);
		} catch (Exception ex) {
			logger.error("Beim erstellen der Sicherheits relevanten XML "
					+ file_path + " ist ein Fehler aufgetreten!");
			return;
		}
		logger.info("Die Sicherheits relevante XML " + file_path
				+ " geschrieben!");
	}

	public static UserObject read_users_xml(File path) {
		try {
			//deklarierung eines neuen userObjects
			UserObject usObj = new UserObject();
			
			//auslesen von übergebener xml file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(path);

			//hole alle elemente unter account_details
			NodeList nList = doc.getElementsByTagName("account_details");
			Node nNode = nList.item(0);
	
			int i = 0;
			//auslesen der einzelnen elemente und speichern in einem userObject
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				usObj.set_firstname(eElement.getElementsByTagName("firstname")
						.item(0).getTextContent());
				usObj.set_lastname(eElement.getElementsByTagName("lastname")
						.item(0).getTextContent());
				usObj.set_sec_settings(Boolean.parseBoolean(eElement
						.getElementsByTagName("security_settings").item(0)
						.getTextContent()));
				i++;
			}
			return usObj;
		} catch (Exception ex) {
			logger.error("Beim auslesen der XML-Datei " + path
					+ " ist ein Fehler aufgetreten!");
			return null;
		}
	}

}
