package utilities;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import objects.UserObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileChooser {
	static final Logger logger = LogManager.getLogger(FileChooser.class
			.getName());

	public String datenwahl(String name) {
		String rückgabewert = null;
		JFileChooser fc_data = new JFileChooser();
		fc_data.setDialogTitle(name);
		fc_data.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc_data.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			rückgabewert = fc_data.getSelectedFile().getAbsolutePath();
		}
		return rückgabewert;
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
		String user_path = Props.auslesen_properties("benutzer_speicherpfad");

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
			result.add(i, XMLCreater.read_users_xml(file));
			i++;
		}
		// abziehen eines wertes von i, weil 1 zu hoch
		i--;
		//Generierung von String für jedes einzelne Object
		while (i >= 0) {
			result_str.add(j, result.get(i).get_firstname() + " "+ result.get(i).get_lastname() + " " + result.get(i).get_sec_settings());
			i--;
			j++;
		}
		return result_str;
	}
}
