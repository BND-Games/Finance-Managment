package de.bnd_games.financemanagment.utilities;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileCreater {
	static final Logger logger = LogManager.getLogger(FileCreater.class
			.getName());

	//TODO Eventuell eigene Exception?
	//Prüfung ob es existiert, wenn nein wird es erstellt
	public static boolean checkDirectoryAndCreate(String pfad_verzeichniss) {
		logger.info("Starte verzeichniss_pruefung");
		File verzeichniss_prüfung = new File(pfad_verzeichniss);
		if (verzeichniss_prüfung.exists()) {
			logger.debug("Verzeichnis ist bereits existent: " + verzeichniss_prüfung);
			return false;
		} else {
			createDirectory(verzeichniss_prüfung);
			logger.debug("Verzeichniss ist noch nicht existent und wird nun erstellt: " + verzeichniss_prüfung);
			return true;
		}

	}

	//Prüfung ob es existiert, keine weiteren folgen
	public static boolean checkDirectory(String dir_path) {
		logger.info("Starte dir_check");
		File dir_checksum = new File(dir_path);
		if (dir_checksum.exists()) {
			logger.debug("Verzeichnis ist existent");
			return true;
		} else {
			logger.debug("Verzeichnis ist noch nicht existent");
			return false;
		}
	}

	public static void createDirectory(File verzeichniss_prüfung) {
		logger.info("Starte verzeichnis_erstellen");
		try {
			logger.info("Schreibe Verzeichnis");
			verzeichniss_prüfung.mkdir();
		} catch (Exception ex) {
			logger.error("Konnte Verzeichniss nicht erstellen: " + verzeichniss_prüfung);
			return;
		} finally {
			logger.debug("Verzeichniss erfolgreich erstellt: " + verzeichniss_prüfung);
		}
	}

	public static void createPropertiesFile() {
		logger.info("Starte properties_erstellen");
		Props.getPropertiesPath();
	}
}
