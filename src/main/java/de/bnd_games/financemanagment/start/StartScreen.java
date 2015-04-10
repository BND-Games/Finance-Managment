package de.bnd_games.financemanagment.start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.bnd_games.financemanagment.utilities.FileCreater;
import de.bnd_games.financemanagment.utilities.Props;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartScreen extends JFrame {
	static Logger logger = LogManager.getLogger(StartScreen.class.getName());
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("user.home", "APPDATA");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				logger.info("Starte Finance Managment");
				try {
					StartScreen frame = new StartScreen();
					frame.setVisible(true);
					if (checkProperties() == true) {
						logger.info("Erst Konfiguration wird gestartet.");
						StartConfig.main();
						frame.dispose();
					} else {
						logger.info("Starten der Login Maske");
						StartLogin.main();
						frame.dispose();
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
				logger.info("Programm beendet.");
				System.exit(0);
			}
		});
		btnAbbrechen.setBounds(303, 237, 111, 23);
		contentPane.add(btnAbbrechen);
	}

	private static Boolean checkProperties() {
		logger.info("Starte checkProperties");
		String verzeichniss = "\\Finanzverwaltung";
		String datei = "\\Finanzverwaltung\\config.properties";

		String pfad_verzeichniss = System.getenv("APPDATA") + verzeichniss;
		String pfad_datei = System.getenv("APPDATA") + datei;
		FileCreater.checkDirectoryAndCreate(pfad_verzeichniss);

		if (FileCreater.checkDirectory(pfad_datei) == false) {
			logger.debug("Keine Properties Datei gefunden");
			FileCreater.createPropertiesFile();
			return true;
		} else {
			logger.debug("Properties Datei gefunden");
			if (Props.readPropertiesSetting("erst_konfiguration").equals(
					"abgeschlossen")) {
				logger.debug("Erst Konfiguration ist bereits abgeschlossen");
				return false;
			} else {
				logger.warn("Erst Konfiguration wurde noch nicht abgeschlossen");
				return true;
			}
		}
	}
}
