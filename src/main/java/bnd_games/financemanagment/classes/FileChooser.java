package bnd_games.financemanagment.classes;
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
}
