package de.bnd_games.financemanagment.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTree;

import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainScreen {

	private JFrame frmFinanzverwaltung;
	static final Logger logger = LogManager.getLogger(MainScreen.class
			.getName());
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmFinanzverwaltung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinanzverwaltung = new JFrame();
		frmFinanzverwaltung.setResizable(false);
		frmFinanzverwaltung.setTitle("Finanzverwaltung Alpha 1 ");
		frmFinanzverwaltung.setBounds(100, 100, 1280, 720);
		frmFinanzverwaltung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmFinanzverwaltung.setJMenuBar(menuBar);

		JMenu mnAllgemeines = new JMenu("Datei");
		menuBar.add(mnAllgemeines);

		JMenu mnNeuerPlan = new JMenu("Neuer Plan");
		mnAllgemeines.add(mnNeuerPlan);

		JMenu mnSpeichern = new JMenu("Plan Speichern");
		mnAllgemeines.add(mnSpeichern);

		JMenu mnPlanLaden = new JMenu("Plan Laden");
		mnAllgemeines.add(mnPlanLaden);

		JMenu mnEinstellungen = new JMenu("Einstellungen");
		mnEinstellungen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainSettings main_einstellungen = new MainSettings();
				main_einstellungen.setVisible(true);
				logger.info("Oeffne Einstellungen");
			}
		});
		menuBar.add(mnEinstellungen);

		JMenu mnCredits = new JMenu("Credits");
		menuBar.add(mnCredits);
		frmFinanzverwaltung.getContentPane().setLayout(null);

		JTree tree = new JTree();
		tree.setBounds(0, 0, 179, 631);
		frmFinanzverwaltung.getContentPane().add(tree);

		Label label = new Label(
				"Finanzverwaltung Alpha 1 © Björn Bochmann");
		label.setAlignment(Label.CENTER);
		label.setBounds(537, 638, 275, 22);
		frmFinanzverwaltung.getContentPane().add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(189, 0, 1085, 631);
		frmFinanzverwaltung.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Planung", null, panel, null);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Aktuell", null, panel_1, null);
	}
}
