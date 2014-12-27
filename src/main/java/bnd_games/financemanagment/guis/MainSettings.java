package bnd_games.financemanagment.guis;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import bnd_games.financemanagment.classes.FileChooser;
import bnd_games.financemanagment.classes.Props;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class MainSettings extends JFrame {

	private JPanel contentPane;
	private JTextField tf_einstellungen_daten;
	private String auswahl_daten;
	private String auswahl_user;
	private JTextField tf_einstellungen_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSettings frame = new MainSettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainSettings() {
		setTitle("Einstellungen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 444, 276);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Allgemein", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Speicherpfade", null, panel_1, null);
		panel_1.setLayout(null);
		
		Label label = new Label("Datenablage:");
		label.setBounds(10, 10, 80, 22);
		panel_1.add(label);
		
		tf_einstellungen_daten = new JTextField();
		tf_einstellungen_daten.setBounds(96, 10, 245, 20);
		tf_einstellungen_daten.setColumns(10);
		panel_1.add(tf_einstellungen_daten);
		
		Button datenpfad_wählen = new Button("Pfad w\u00E4hlen");
		datenpfad_wählen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileChooser fc = new FileChooser();
				auswahl_daten = (fc.datenwahl("Wählen Sie den Ablagepfad!"));
				tf_einstellungen_daten.setText(auswahl_daten);
			}
		});
		datenpfad_wählen.setBounds(347, 10, 70, 22);
		panel_1.add(datenpfad_wählen);
		
		JButton btnSpeichern_pfad = new JButton("Speichern");
		btnSpeichern_pfad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Props props = new Props();
				props.ändere_properties("daten_speicherpfad" ,auswahl_daten);
				props.ändere_properties("benutzer_speicherpfad" ,auswahl_user);
			}
		});
		btnSpeichern_pfad.setBounds(165, 214, 96, 23);
		panel_1.add(btnSpeichern_pfad);
		btnSpeichern_pfad.setSelectedIcon(null);
		
		Button userpfad_wählen = new Button("Pfad w\u00E4hlen");
		userpfad_wählen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 FileChooser fc = new FileChooser();
				auswahl_user = (fc.datenwahl("Wählen Sie den Ablagepfad!"));
				tf_einstellungen_user.setText(auswahl_user);
			}
		});
		userpfad_wählen.setBounds(347, 38, 70, 22);
		panel_1.add(userpfad_wählen);
		
		tf_einstellungen_user = new JTextField();
		tf_einstellungen_user.setColumns(10);
		tf_einstellungen_user.setBounds(96, 38, 245, 20);
		panel_1.add(tf_einstellungen_user);
		
		Label label_1 = new Label("Userablage:");
		label_1.setBounds(10, 38, 80, 22);
		panel_1.add(label_1);
	}
}
