package bnd.FinanceManagment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import classes.FileCreater;;

public class StartScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8760906563233681727L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
					frame.setVisible(true);
					if (properties_check() == true)
					{
					    System.out.println("[Konsole] Erst Konfiguration wird gestartet.");
						StartConfig start_conf = new StartConfig();
						start_conf.main(null);
						frame.setVisible(false);
					}
					else
					{
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartScreen() {
		setTitle("Finanzverwaltung");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFinanzverwaltung = new JLabel("Finanzverwaltung");
		lblFinanzverwaltung.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinanzverwaltung.setFont(new Font("Script MT Bold", Font.PLAIN, 39));
		lblFinanzverwaltung.setBounds(10, 61, 424, 136);
		contentPane.add(lblFinanzverwaltung);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnAbbrechen.setBounds(303, 237, 111, 23);
		contentPane.add(btnAbbrechen);
	}
	
	private static Boolean properties_check()
	{
		String verzeichniss = "\\Finanzverwaltung";
		String datei = "\\Finanzverwaltung\\config.properties";
		
		FileCreater fc = new FileCreater();
		String pfad_verzeichniss = System.getenv("APPDATA") + verzeichniss;
		String pfad_datei = System.getenv("APPDATA") + datei;
		fc.verzeichniss_prüfung(pfad_verzeichniss);
		
		if(fc.dir_check(pfad_datei)== false)
		{
			fc.properties_erstellen();
			return true;
		}
		else
		{
			return false;
		}
	}
}
