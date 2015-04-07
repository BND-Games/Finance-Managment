package de.bnd_games.financemanagment.utilities;

import javax.swing.JFileChooser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileChooser {
	static final Logger logger = LogManager.getLogger(FileChooser.class
			.getName());

	//FileChooser Fenster
	public static String chooseFile(String name) {
		logger.info("Starte Methode datenwahl");
		String result = null;
		JFileChooser fc_data = new JFileChooser();
		fc_data.setDialogTitle(name);
		fc_data.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc_data.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			result = fc_data.getSelectedFile().getAbsolutePath();
		}
		logger.debug("Rueckgabewert ist: " + result); 
		return result;
	}
}
