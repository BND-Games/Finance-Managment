package de.bnd_games.financemanagment.utilities;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileCreater {
	static final Logger logger = LogManager.getLogger(FileCreater.class
			.getName());

	// error_message should be given if the directory is important, isn't it it
	// should be get null.

	public boolean verzeichniss_prüfung(String pfad_verzeichniss) {
		logger.info("Prüfung ob Verzeichniss bereits existiert.");
		File verzeichniss_prüfung = new File(pfad_verzeichniss);
		if (verzeichniss_prüfung.exists()) {
			logger.info("Verzeichniss ist bereits existent.");
			logger.info(verzeichniss_prüfung);
			return false;
		} else {
			verzeichniss_erstellen(verzeichniss_prüfung);
			logger.info("Verzeichniss ist noch nicht existent.");
			return true;
		}

	}

	public boolean dir_check(String dir_path) {
		File dir_checksum = new File(dir_path);
		if (dir_checksum.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public void verzeichniss_erstellen(File verzeichniss_prüfung) {
		try {
			logger.info("Schreibe Verzeichnis");
			verzeichniss_prüfung.mkdir();
		} catch (Exception ex) {
			logger.error("Konnte Verzeichniss nicht erstellen.");
			logger.error(verzeichniss_prüfung);
			return;
		} finally {
			logger.error("Verzeichniss erfolgreich erstellt.");
			logger.error(verzeichniss_prüfung);
		}
	}

	public void properties_erstellen() {
		Props props = new Props();
		props.erstelle_properties();
	}
}
