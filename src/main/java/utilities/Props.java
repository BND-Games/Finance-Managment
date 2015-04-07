package utilities;

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

	private static String pfad_properties() {
		String pfad_verzeichniss = System.getenv("APPDATA")
				+ "\\Finanzverwaltung\\config.properties";
		return pfad_verzeichniss;
	}

	public void erstelle_properties() {
		logger.info("Schreibe Properties");
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(pfad_properties());
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
					logger.error("Schreiben der Properties Fehlgeschlagen");
					return;
				}
			}
			logger.info("Schreiben der Properties erfolgreich.");
		}
	}

	public void ändere_properties(String einstellung, String neuer_wert) {
		Properties props = new Properties();
		try {
			logger.info("Lese alte Properties ein.");
			FileInputStream in = new FileInputStream(pfad_properties());
			props.load(in);
			in.close();
		} catch (Exception ex) {
			logger.error("Einlesen der alten Properties gescheitert.");
			return;
		} finally {
			logger.info("Einlesen der alten Properties erfolgreich.");
		}
		try {
			logger.info("Schreiben der neuen Properties.");
			FileOutputStream out = new FileOutputStream(pfad_properties());
			props.setProperty(einstellung, neuer_wert);
			props.store(out, null);
			out.close();
		} catch (Exception ex) {
			logger.error("Schreiben der alten Properties gescheitert.");
			return;
		} finally {
			logger.info("Schreiben der neuen Properties erolgreich.");
			JOptionPane.showMessageDialog(null,
					"Einstellungen erfolgreich gespeichert.");
		}
	}

	public static String auslesen_properties(String einstellung) {
		String einstellung_prop = null;
		Properties props = new Properties();
		try {
			logger.info("Lese Properties ein.");
			FileInputStream in = new FileInputStream(pfad_properties());
			props.load(in);
			einstellung_prop = props.getProperty(einstellung);
		} catch (Exception ex) {
			logger.error("Einlesen der Properties gescheitert.");
			return "fehlgeschlagen";
		}
		logger.info("Einlesen der Properties erfolgreich.");
		return einstellung_prop;
	}
}
