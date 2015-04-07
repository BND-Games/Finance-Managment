package de.bnd_games.financemanagment.utilities;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import de.bnd_games.financemanagment.objects.LoginObject;
import de.bnd_games.financemanagment.objects.UserObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLCreater {
	static final Logger logger = LogManager.getLogger(XMLCreater.class
			.getName());

	public static void createUserXML(String file_path, String vorname,
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

	public static void createSecurityXML(String file_path,
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

	@SuppressWarnings("finally")
	public static UserObject readXMLUser(File path) {
		// deklarierung eines neuen userObjects
		UserObject usObj = new UserObject();

		try {
			// auslesen von übergebener xml file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(path);

			// hole alle elemente unter account_details
			NodeList nList = doc.getElementsByTagName("account_details");
			Node nNode = nList.item(0);

			// auslesen der einzelnen elemente und speichern in einem userObject
			// TODO restliche Felder müssen noch eingebaut werden
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				usObj.set_firstname(eElement.getElementsByTagName("firstname")
						.item(0).getTextContent());
				usObj.set_lastname(eElement.getElementsByTagName("lastname")
						.item(0).getTextContent());
				usObj.set_sec_settings(Boolean.parseBoolean(eElement
						.getElementsByTagName("security_settings").item(0)
						.getTextContent()));
			}
		} catch (Exception ex) {
			logger.error("Beim auslesen der XML-Datei " + path
					+ " ist ein Fehler aufgetreten!");
			logger.trace(ex);
		} finally{
			logger.debug("Gebe UserObject vom auslesen zurueck!");
			return usObj;
		}
	}

	@SuppressWarnings("finally")
	public static LoginObject readXMLLogin(File path) {
		// deklarierung eines neuen LoginObject
		LoginObject loginObj = new LoginObject();
		try {

			// auslesen von übergebener xml file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(path);

			// hole alle elemente unter account_details
			NodeList nList = doc.getElementsByTagName("account_informations");
			Node nNode = nList.item(0);

			// auslesen der einzelnen elemente und speichern in einem userObject
			// TODO restliche Felder müssen noch eingebaut werden
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				loginObj.setNickname(eElement.getElementsByTagName("nickname")
						.item(0).getTextContent());
				loginObj.setPassword(eElement.getElementsByTagName("password")
						.item(0).getTextContent());
				loginObj.setEmail(eElement.getElementsByTagName("email")
						.item(0).getTextContent());
			}

		} catch (Exception ex) {
			logger.error("Beim auslesen der XML-Datei " + path
					+ " ist ein Fehler aufgetreten!");
			logger.trace(ex);
		} finally {
			logger.debug("Gebe LoginObject vom auslesen zurueck!");
			return loginObj;
		}
	}
	
	public static ArrayList<String> readUserData() {
		// Deklarierung von UserObject Array zur Speicherung der generierten
		// User Objects
		ArrayList<UserObject> result = new ArrayList<UserObject>();
		// Deklarierung von result_str, hier wird vorname_nachame gespeichert
		// welcher aus den UserObjects generiert wird.
		ArrayList<String> result_str = new ArrayList<String>();
		// Generierung Zählvariablen
		int i = 0;
		int j = 0;
		String user_path = Props.readPropertiesSetting("benutzer_speicherpfad");

		File f = new File(user_path);
		File[] fileArray = f.listFiles();

		// für jede gefundene Datei wird ein Userobj erzeugt
		for (File file : fileArray) {
			String filestr = file.toString().substring(
					file.toString().lastIndexOf("\\") + 1);
			String file_path = file.toString() + "\\" + filestr + ".xml";
			file = new File(file_path);
			logger.debug(file);
			logger.debug(filestr);
			// bekomme userobj -> speichere in result
			result.add(i, XMLCreater.readXMLUser(file));
			i++;
		}
		// abziehen eines wertes von i, weil 1 zu hoch
		i--;
		// Generierung von String für jedes einzelne Object
		while (i >= 0) {
			result_str.add(j,
					result.get(i).get_firstname() + " "
							+ result.get(i).get_lastname() + " "
							+ result.get(i).get_sec_settings());
			i--;
			j++;
		}
		return result_str;
	}

}
