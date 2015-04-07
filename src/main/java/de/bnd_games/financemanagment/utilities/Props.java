package de.bnd_games.financemanagment.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Props {
	static final Logger logger = LogManager.getLogger(Props.class.getName());

	//Gibt Properties Pfad zurück, mit individuellem APPDATA Pfad
	protected static String getPropertiesPath() {
		logger.info("Starte pfad_properties");
		String result = System.getenv("APPDATA")
				+ "\\Finanzverwaltung\\config.properties";
		logger.debug("Properties Pfad ist: " + result);
		return result;
	}

	public void createPropertiesFile() {
		logger.info("Starte erstelle_properties");
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(getPropertiesPath());
			prop.setProperty("version", "1.0");
			prop.setProperty("erst_konfiguration", "ausstehend");
			prop.setProperty("daten_speicherpfad", System.getenv("APPDATA")
					+ "\\Finanzverwaltung\\Data");
			prop.setProperty("benutzer_speicherpfad", System.getenv("APPDATA")
					+ "\\Finanzverwaltung\\Users");
			prop.setProperty("log_speicherpfad", System.getenv("APPDATA")
					+ "\\Finanzverwaltung\\Logs");

			prop.store(output, null);

		} catch (IOException io) {
			logger.error("Schreiben der Properties Fehlgeschlagen");
			return;

		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.warn("Schreiben der Properties eventuell Fehlgeschlagen");
					return;
				}
			}
			logger.debug("Schreiben der Properties erfolgreich.");
		}
	}

	//TODO Rückgabewert einfügen, hier sollte kein OptionPane gestartet werden
	public void changePropertiesSetting(String settings, String worth) {
		logger.info("Starte aendere_properties");
		Properties props = new Properties();
		try {
			logger.debug("Lese alte Properties ein.");
			FileInputStream in = new FileInputStream(getPropertiesPath());
			props.load(in);
			in.close();
		} catch (Exception ex) {
			logger.error("Einlesen der alten Properties gescheitert.");
			return;
		} finally {
			logger.debug("Einlesen der alten Properties erfolgreich.");
		}
		try {
			logger.debug("Schreiben der neuen Properties.");
			FileOutputStream out = new FileOutputStream(getPropertiesPath());
			props.setProperty(settings, worth);
			props.store(out, null);
			out.close();
		} catch (Exception ex) {
			logger.error("Schreiben der alten Properties gescheitert.");
			return;
		} finally {
			logger.debug("Schreiben der neuen Properties erolgreich.");
			JOptionPane.showMessageDialog(null,
					"Einstellungen erfolgreich gespeichert.");
		}
	}

	public static String readPropertiesSetting(String settings) {
		logger.info("Starte auslesen_properties");
		String result = null;
		Properties props = new Properties();
		try {
			logger.debug("Lese Einstellungen fuer: "  + settings + " ein.");
			FileInputStream in = new FileInputStream(getPropertiesPath());
			props.load(in);
			result = props.getProperty(settings);
		} catch (Exception ex) {
			logger.error("Einlesen der Properties gescheitert.");
			return "fehlgeschlagen";
		}
		logger.debug("Auslesen der Einstellung war efolgreich: " + result);
		return result;
	}
}
