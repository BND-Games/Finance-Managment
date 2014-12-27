package bnd_games.financemanagment.classes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Props {
	private static String pfad_properties()
	{
		String pfad_verzeichniss = System.getenv("APPDATA") + "\\Finanzverwaltung\\config.properties";
		return pfad_verzeichniss;
	}
	
	public void erstelle_properties()
	{
		System.out.println("[Konsole] Schreibe Properties");
		Properties prop = new Properties();
		OutputStream output = null;
	 
		try {	 
			output = new FileOutputStream(pfad_properties());
			prop.setProperty("version", "1.0");
			prop.setProperty("erst_konfiguration", "ausstehend");
			prop.setProperty("daten_speicherpfad", System.getenv("APPDATA") + "\\Finanzverwaltung\\Data");
			prop.setProperty("benutzer_speicherpfad", System.getenv("APPDATA") +"\\Finanzverwaltung\\Users");
			prop.setProperty("user_list", System.getenv("APPDATA") +"\\Finanzverwaltung\\Users\\user_list.xml");
			prop.setProperty("log_speicherpfad", System.getenv("APPDATA") +"\\Finanzverwaltung\\Logs");

			prop.store(output, null);
	 
		} catch (IOException io) {
			System.err.println("[Fehler] Schreiben der Properties Fehlgeschlagen");
			return;
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					System.err.println("[Fehler] Schreiben der Properties Fehlgeschlagen");
					return;
				}
			}
			System.out.println("[Konsole] Schreiben der Properties erfolgreich.");		 
		}
	}
	
	public void ändere_properties(String einstellung,String neuer_wert)
	{	
		Properties props = new Properties();
		try
		{
			System.out.println("[Konsole] Lese alte Properties ein.");
			FileInputStream in = new FileInputStream(pfad_properties());
			props.load(in);
			in.close();
		}catch(Exception ex){
			System.err.println("[Fehler] Einlesen der alten Properties gescheitert.");
			return;
		}finally{
			System.out.println("[Konsole] Einlesen der alten Properties erfolgreich.");			
		}
		try{
			System.out.println("[Konsole] Schreiben der neuen Properties.");
			FileOutputStream out = new FileOutputStream(pfad_properties());
			props.setProperty(einstellung, neuer_wert);
			props.store(out, null);
			out.close();
		}catch(Exception ex){
			System.err.println("[Fehler] Schreiben der alten Properties gescheitert.");
			return;
		}finally{
			System.out.println("[Konsole] Schreiben der neuen Properties erolgreich.");
			JOptionPane.showMessageDialog(null, "Einstellungen erfolgreich gespeichert.");
		}		
	}
	
	@SuppressWarnings("finally")
	public static String auslesen_properties(String einstellung)
	{
		String einstellung_prop = null;
		Properties props = new Properties();
		try{
			System.out.println("[Konsole] Lese Properties ein.");
			FileInputStream in = new FileInputStream(pfad_properties());
			props.load(in);
			einstellung_prop = props.getProperty(einstellung);
		}catch(Exception ex){
			System.err.println("[Fehler] Einlesen der Properties gescheitert.");
			return "fehlgeschlagen";			
		}finally{
			System.out.println("[Konsole] Einlesen der Properties erfolgreich.");
			return einstellung_prop;
		}
	}
}
