package de.bnd_games.financemanagment.classes;

import java.io.File;

import javax.swing.JFileChooser;

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

	public static void readUserData() {
		String user_path = Props.auslesen_properties("benutzer_speicherpfad");

		File f = new File(user_path);
		File[] fileArray = f.listFiles();

		for (File file : fileArray) {
			String filestr = file.toString().substring(
					file.toString().lastIndexOf("\\") + 1);
			String file_path = file.toString() + "\\" + filestr + ".xml";
			file = new File(file_path);
			logger.debug(file);
			;
			logger.debug(filestr);
			;
			XMLCreater.read_users_xml(file);
		}
	}
}
