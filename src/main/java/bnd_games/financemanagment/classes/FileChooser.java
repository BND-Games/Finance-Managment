package bnd_games.financemanagment.classes;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class FileChooser {
	public String datenwahl(String name)
	{
		String rückgabewert = null;
		JFileChooser fc_data = new JFileChooser();
		fc_data.setDialogTitle(name);
		fc_data.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fc_data.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			rückgabewert = fc_data.getSelectedFile().getAbsolutePath();
		}	
		return rückgabewert;		
	}
	
	public static void readUserData()
	{
		String user_path = Props.auslesen_properties("benutzer_speicherpfad");
		
		File f = new File(user_path);
		File[] fileArray = f.listFiles();
		
		ArrayList<String> usernames = new ArrayList<String>();
		
		int i = 0;
		for (File file : fileArray) {
			String filestr = file.toString();
			usernames.add(filestr.substring(filestr.lastIndexOf("\\") +1));
			System.out.println(usernames.get(i)); // Debug Zwecke
			i++;
		}	
	}
}
