package classes;
import java.io.File;

public class FileCreater {
	
	//error_message should be given if the directory is important, isn't it it should be get null.
	
	public boolean verzeichniss_prüfung(String pfad_verzeichniss)
	{
	    System.out.println("[Konsole] Prüfung ob Verzeichniss bereits existiert.");
	    File verzeichniss_prüfung = new File(pfad_verzeichniss);
	    if (verzeichniss_prüfung.exists()) {
		    System.out.println("[Konsole] Verzeichniss ist bereits existent.");
		    System.out.println("[Konsole] " + verzeichniss_prüfung);
		    return false;
	    }
	    else
	    {
	    	System.out.println("[Konsole] Verzeichniss ist noch nicht existent.");
	    	verzeichniss_erstellen(verzeichniss_prüfung);
	    	return true;
	    }
		
	}
	
	public boolean dir_check(String dir_path)
	{
	    File dir_checksum = new File(dir_path); 
		if(dir_checksum.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void verzeichniss_erstellen(File verzeichniss_prüfung)
	{
		try{
	        System.out.println("[Konsole] Schreibe Verzeichniss");
	        verzeichniss_prüfung.mkdir();
		}catch(Exception ex){
	        System.err.println("[Fehler] Konnte Verzeichniss nicht erstellen.");
	        System.err.println("[Konsole] " + verzeichniss_prüfung);	
	        return;
		}finally{
	        System.out.println("[Konsole] Verzeichniss erfolgreich erstellt.");
	        System.out.println("[Konsole] " + verzeichniss_prüfung);	
		}
	}
	
	public void properties_erstellen()
	{
		Props props = new Props();
		props.erstelle_properties();
	}
}
