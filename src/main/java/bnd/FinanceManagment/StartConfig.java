package bnd.FinanceManagment;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

import classes.FileCreater;
import classes.MD5Generator;
import classes.Props;
import classes.XMLCreater;

@SuppressWarnings("serial")
public class StartConfig extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_dp;
	private static JTextField textField_up;
	private static JTextField textField_lp;
	private JTextField textField_vorname;
	private JTextField textField_nachname;
	private JTextField textField_kürzel;
	private JTextField textField_orga;
	private JTextField textField_nick;
	private JTextField textField_email;
	private JPasswordField passwordField;
	private JPasswordField passwordField_wdh;
	private JTextPane txtpn_zf;
	private JCheckBox checkbox_sicher;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartConfig frame = new StartConfig();
					frame.setVisible(true);
					datenfelder_auslesen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartConfig() {
		setResizable(false);
		setTitle("Konfiguration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(10, 72, 538, 374);
		contentPane.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Allgemeines", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton button_10 = new JButton("Weiter");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
			}
		});
		button_10.setBounds(276, 312, 104, 23);
		panel_4.add(button_10);
		
		JButton button_11 = new JButton("Abbrechen");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_11.setBounds(162, 312, 104, 23);
		panel_4.add(button_11);
		tabbedPane.setEnabledAt(0, false);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pfade", null, panel, null);
		tabbedPane.setEnabledAt(1, false);
		panel.setLayout(null);
		
		textField_dp = new JTextField();
		textField_dp.setEditable(false);
		textField_dp.setBounds(113, 75, 320, 20);
		textField_dp.setColumns(10);
		panel.add(textField_dp);
		
		textField_up = new JTextField();
		textField_up.setEditable(false);
		textField_up.setBounds(113, 105, 320, 20);
		textField_up.setColumns(10);
		panel.add(textField_up);
		
		Button button = new Button("Pfad w\u00E4hlen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes.FileChooser fc = new classes.FileChooser();
				String ergebnis = fc.datenwahl("Daten Pfad");
				if (ergebnis != null)
				{
					textField_dp.setText(ergebnis);
				}
			}
		});
		button.setBounds(439, 75, 75, 22);
		panel.add(button);
		
		Button button_1 = new Button("Pfad w\u00E4hlen");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes.FileChooser fc = new classes.FileChooser();
				String ergebnis = fc.datenwahl("User Pfad");
				if (ergebnis != null)
				{
					textField_up.setText(ergebnis);
				}
			}
		});
		button_1.setBounds(439, 103, 75, 22);
		panel.add(button_1);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnWeiter.setBounds(329, 312, 104, 23);
		panel.add(btnWeiter);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAbbrechen.setBounds(101, 312, 104, 23);
		panel.add(btnAbbrechen);
		
		textField_lp = new JTextField();
		textField_lp.setEditable(false);
		textField_lp.setColumns(10);
		textField_lp.setBounds(113, 133, 320, 20);
		panel.add(textField_lp);
		
		Button button_2 = new Button("Pfad w\u00E4hlen");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classes.FileChooser fc = new classes.FileChooser();
				String ergebnis = fc.datenwahl("Log Pfad");
				if (ergebnis != null)
				{
					textField_lp.setText(ergebnis);
				}
			}
		});
		button_2.setBounds(439, 131, 75, 22);
		panel.add(button_2);
		
		JLabel lblDatenPfad = new JLabel("Daten Pfad:");
		lblDatenPfad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatenPfad.setBounds(10, 78, 93, 14);
		panel.add(lblDatenPfad);
		
		JLabel lblUserPfad = new JLabel("User Pfad:");
		lblUserPfad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPfad.setBounds(10, 108, 93, 14);
		panel.add(lblUserPfad);
		
		JLabel lblLogPfad = new JLabel("Log Pfad:");
		lblLogPfad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogPfad.setBounds(10, 136, 93, 14);
		panel.add(lblLogPfad);
		
		JTextPane txtpnWhlen = new JTextPane();
		txtpnWhlen.setText("W\u00E4hlen Sie bitte die Datenablage Pfade die zum Nutzen des Programmes notwendig sind. Diese k\u00F6nnen im nachhinein in den Einstellungen auch noch ge\u00E4ndert werden.");
		txtpnWhlen.setEditable(false);
		txtpnWhlen.setBackground(SystemColor.menu);
		txtpnWhlen.setBounds(10, 11, 513, 45);
		panel.add(txtpnWhlen);
		
		JTextPane txtpnBitteSeienSie = new JTextPane();
		txtpnBitteSeienSie.setBackground(SystemColor.control);
		txtpnBitteSeienSie.setText("Bitte seien Sie sich dar\u00FCber im klaren das es bei einer \u00C4nderung der Standardpfade zu Problemen kommen kann welche die Stabilit\u00E4t der Software stark beeinflussen k\u00F6nnen. Es wird deshalb empfohlen die Standardpfade beizubehalten. Falls diese nicht gew\u00FCnscht sind sollte das Programm per rechts Klick als Administrator ausgef\u00FChrt werden.");
		txtpnBitteSeienSie.setBounds(10, 184, 504, 70);
		panel.add(txtpnBitteSeienSie);
		
		JButton button_12 = new JButton("Zurück");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(0, true);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		button_12.setBounds(215, 312, 104, 23);
		panel.add(button_12);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("User", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane txtpnLegeSieBitte = new JTextPane();
		txtpnLegeSieBitte.setBackground(SystemColor.control);
		txtpnLegeSieBitte.setEditable(false);
		txtpnLegeSieBitte.setText("Lege Sie bitte ein Standard Nutzer Konto an. Von diesem aus k\u00F6nnen Sie bei mehreren erforderlichen Nutzern diese dann \u00FCber die Einstellungen anlegen.");
		txtpnLegeSieBitte.setBounds(10, 11, 513, 45);
		panel_1.add(txtpnLegeSieBitte);
		
		textField_vorname = new JTextField();
		textField_vorname.setBounds(179, 67, 228, 20);
		panel_1.add(textField_vorname);
		textField_vorname.setColumns(10);
		
		textField_nachname = new JTextField();
		textField_nachname.setColumns(10);
		textField_nachname.setBounds(179, 95, 228, 20);
		panel_1.add(textField_nachname);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setBounds(55, 67, 104, 14);
		panel_1.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setBounds(55, 98, 104, 14);
		panel_1.add(lblNachname);
		
		textField_kürzel = new JTextField();
		textField_kürzel.setBounds(179, 126, 228, 20);
		panel_1.add(textField_kürzel);
		textField_kürzel.setColumns(10);
		
		JLabel lblOrganisation = new JLabel("K\u00FCrzel:");
		lblOrganisation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrganisation.setBounds(55, 129, 104, 14);
		panel_1.add(lblOrganisation);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Sie haben die Möglichkeit Ihren Account zu sichern. Wenn Sie dies wählen muss im nächsten Schritt ein lokaler Account mit Passwort angelegt werden. Ohne dieses Passwort haben Sie dann keinen Zugriff auf den Account und dessen Daten.");
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(10, 188, 513, 56);
		panel_1.add(textPane);
		
		checkbox_sicher = new JCheckBox("Sicheren Account anlegen (Optional)");
		checkbox_sicher.setBounds(144, 261, 263, 23);
		panel_1.add(checkbox_sicher);
		
		JButton button_3 = new JButton("Weiter");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkbox_sicher.isSelected())
				{
					if (textField_vorname.getText().isEmpty() || textField_nachname.getText().isEmpty() || textField_orga.getText().isEmpty() || textField_kürzel.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(contentPane, "Bitte füllen Sie zunächst alle Felder aus!");
					}
					else
					{
						tabbedPane.setEnabledAt(2, false);
						tabbedPane.setEnabledAt(3, true);
						tabbedPane.setSelectedIndex(3);
					}
				}
				else
				{
					if (textField_vorname.getText().isEmpty() || textField_nachname.getText().isEmpty() || textField_orga.getText().isEmpty() || textField_kürzel.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(contentPane, "Bitte füllen Sie zunächst alle Felder aus!");
					}
					else
					{
						zf_erstellen();
						tabbedPane.setEnabledAt(2, false);
						tabbedPane.setEnabledAt(4, true);
						tabbedPane.setSelectedIndex(4);
					}
				}
			}
			}
	    );
		button_3.setBounds(329, 312, 104, 23);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Abbrechen");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_4.setBounds(101, 312, 104, 23);
		panel_1.add(button_4);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setEnabledAt(2, false);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnZurck.setBounds(215, 312, 104, 23);
		panel_1.add(btnZurck);
		
		textField_orga = new JTextField();
		textField_orga.setColumns(10);
		textField_orga.setBounds(179, 157, 228, 20);
		panel_1.add(textField_orga);
		
		JLabel label_3 = new JLabel("Organisation:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(55, 160, 104, 14);
		panel_1.add(label_3);
		tabbedPane.setEnabledAt(2, false);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Sicherheit (Optional)", null, panel_2, null);
		tabbedPane.setEnabledAt(3, false);
		panel_2.setLayout(null);
		
		JTextPane txtpnSieHabenDie = new JTextPane();
		txtpnSieHabenDie.setText("Sie haben die Sicherheitseinstellungen gew\u00E4hlt. Deshalb wird nun bei der Auswahl Ihres Kontos die Eingabe eines Nicknames sowie eines Passwortes erforderlich. Legen Sie diese hier an. Im Programm sp\u00E4ter k\u00F6nnen Sie nach der Anmeldung das Passwort auch noch \u00E4ndern.");
		txtpnSieHabenDie.setEditable(false);
		txtpnSieHabenDie.setBackground(SystemColor.menu);
		txtpnSieHabenDie.setBounds(10, 11, 513, 68);
		panel_2.add(txtpnSieHabenDie);
		
		textField_nick = new JTextField();
		textField_nick.setColumns(10);
		textField_nick.setBounds(221, 114, 228, 20);
		panel_2.add(textField_nick);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNickname.setBounds(97, 114, 104, 14);
		panel_2.add(lblNickname);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswort.setBounds(97, 145, 104, 14);
		panel_2.add(lblPasswort);
		
		JLabel lblPasswortwiederholung = new JLabel("Passwort (wiederholung):\r\n");
		lblPasswortwiederholung.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswortwiederholung.setBounds(52, 176, 149, 14);
		panel_2.add(lblPasswortwiederholung);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(221, 204, 228, 20);
		panel_2.add(textField_email);
		
		JLabel lblEmail = new JLabel("EMail - Adresse: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(97, 207, 104, 14);
		panel_2.add(lblEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(221, 145, 228, 20);
		panel_2.add(passwordField);
		
		passwordField_wdh = new JPasswordField();
		passwordField_wdh.setBounds(221, 173, 228, 20);
		panel_2.add(passwordField_wdh);
		
		JButton button_5 = new JButton("Weiter");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_nick.getText().isEmpty() || passwordField.getPassword() == null || passwordField_wdh.getPassword() == null || textField_email.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(contentPane, "Bitte füllen Sie zunächst alle Felder aus!");
				}
				else
				{
					char[] pw = passwordField.getPassword();
					String pw_s = new String(pw);
					char[] pw_wdh = passwordField_wdh.getPassword();
					String pw_wdh_s = new String (pw_wdh);
					if(pw_s.equals(pw_wdh_s))
					{
						zf_erstellen();
						tabbedPane.setEnabledAt(4, true);
						tabbedPane.setEnabledAt(3, false);
						tabbedPane.setSelectedIndex(4);
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Die Passwörter stimmen nicht überein!");						
					}				
				}				
			}
		});
		button_5.setBounds(329, 312, 104, 23);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("Zur\u00FCck");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setEnabledAt(3, false);
				tabbedPane.setSelectedIndex(2);
			}
		});
		button_6.setBounds(215, 312, 104, 23);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("Abbrechen");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_7.setBounds(101, 312, 104, 23);
		panel_2.add(button_7);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Zusammenfassung", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton button_8 = new JButton("Abbrechen");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_8.setBounds(91, 312, 104, 23);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("Zur\u00FCck");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkbox_sicher.isSelected())
				{
					tabbedPane.setEnabledAt(3, true);
					tabbedPane.setEnabledAt(4, false);
					tabbedPane.setSelectedIndex(3);
				}
				else
				{
					tabbedPane.setEnabledAt(2, true);
					tabbedPane.setEnabledAt(3, false);
					tabbedPane.setSelectedIndex(2);					
				};
			}
		});
		button_9.setBounds(205, 312, 104, 23);
		panel_3.add(button_9);
		
		JButton btnAbschlieen = new JButton("Best\u00E4tigen");
		btnAbschlieen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sec_settings;
				String acc_dir_path = System.getenv("APPDATA") + "\\Finanzverwaltung\\Users\\" + textField_nachname.getText() + "." + textField_vorname.getText();
				String acc_list_path = System.getenv("APPDATA") + "\\Finanzverwaltung\\Users\\user_list.xml";
				String acc_dir_sec_path = acc_dir_path + "\\account";
				String acc_data_dir_path = System.getenv("APPDATA") + "\\Finanzverwaltung\\Data\\" + textField_nachname.getText() + "." + textField_vorname.getText();
				String acc_dir_file = acc_dir_path + "\\"+ textField_nachname.getText() + "." + textField_vorname.getText() +".xml";
				
				if(checkbox_sicher.isSelected())
				{
					sec_settings = "true";
				}
				else
				{
					sec_settings = "false";
				}
				
				
				FileCreater fc = new FileCreater();
		        XMLCreater xml_create = new XMLCreater();
				fc.verzeichniss_prüfung(textField_dp.getText());
				fc.verzeichniss_prüfung(textField_up.getText());
				fc.verzeichniss_prüfung(textField_lp.getText());
				
				//generating user path
				if (fc.verzeichniss_prüfung(acc_dir_path) == false)
				{
				    System.out.println("[Warnung] Konfiguration wurde beendet da die Kombination aus Vor und Nachnamen bereits existiert.");
					JOptionPane.showMessageDialog(null, "Die Kombination aus Vor und Nachnamen existiert bereits.");
					return;
				}
				
				fc.verzeichniss_prüfung(acc_data_dir_path);
				
				if(fc.dir_check(acc_dir_file) == false)
				{
					xml_create.xml_user_file_create(acc_dir_file, textField_vorname.getText(), textField_nachname.getText(), textField_kürzel.getText(), textField_orga.getText(), sec_settings, acc_data_dir_path);
				}

				if(checkbox_sicher.isSelected())
				{
					if(fc.verzeichniss_prüfung(acc_dir_sec_path)==true)
					{
						acc_dir_sec_path = acc_dir_sec_path + "\\login.xml";
						String password_md5 = String.valueOf(passwordField.getPassword());
						MD5Generator md5g = new MD5Generator();
						password_md5 = md5g.main(password_md5);
						xml_create.xml_user_security_file_create(acc_dir_sec_path, textField_nick.getText(), password_md5, textField_email.getText());
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ihre Sicherheitseinstellungen konnten nicht übernommen werden!");
					    System.err.println("[Fehler] Sicherheitseinstellungen konnten nicht übernommen werden.");
					}
					xml_create.xml_user_list_create(acc_list_path, textField_vorname.getText(), textField_nachname.getText(), "true");
				}
				else
				{
					xml_create.xml_user_list_create(acc_list_path, textField_vorname.getText(), textField_nachname.getText(), "false");					
				}
				
				Props properties = new Props();
				properties.ändere_properties("erst_konfiguration", "abgeschlossen");				
				StartScreen startscreen = new StartScreen();
				startscreen.main(null);
			}
		});
		btnAbschlieen.setBounds(319, 312, 104, 23);
		panel_3.add(btnAbschlieen);
				
		txtpn_zf = new JTextPane();
		txtpn_zf.setBackground(SystemColor.control);;
		txtpn_zf.setEditable(false);
		txtpn_zf.setBounds(10, 11, 513, 290);

		tabbedPane.setEnabledAt(4, false);
		
		JScrollPane jsp_zf = new JScrollPane(txtpn_zf);
		jsp_zf.setEnabled(false);
		jsp_zf.setBackground(SystemColor.control);
		panel_3.add(jsp_zf);
		jsp_zf.setBounds(10, 11, 513, 290);
		
		JLabel lblNewLabel = new JLabel("Konfiguration Finanzverwaltung");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 538, 60);
		contentPane.add(lblNewLabel);
		}

	private static void datenfelder_auslesen()
	{
		textField_dp.setText(classes.Props.auslesen_properties("daten_speicherpfad"));
		textField_up.setText(classes.Props.auslesen_properties("benutzer_speicherpfad"));
		textField_lp.setText(classes.Props.auslesen_properties("log_speicherpfad"));
	}
	
	private void zf_erstellen()
	{
		txtpn_zf.setContentType("text/html");
		if(checkbox_sicher.isSelected())
		{
			txtpn_zf.setText("<center><b>Zusammenfassung Ihrer Konfiguration:</b></center><hr><center><b>Ihre Pfade: </b></center>"+
							"<b>Daten: </b>"+ textField_dp.getText()+"<br>"+
							"<b>User: </b>"+ textField_up.getText()+"<br>"+
							"<b>Log: </b>"+ textField_lp.getText()+"<br><hr>"+
							"<center><b>Ihre User Einstellungen: </b></center>"+
							"<b>Vorname: </b>"+ textField_vorname.getText()+"<br>"+
							"<b>Nachname: </b>"+ textField_nachname.getText()+"<br>"+
							"<b>Kürzel: </b>"+ textField_kürzel.getText()+"<br>"+
							"<b>Organisation: </b>"+ textField_orga.getText()+"<br>"+
							"<b>Sicherer Account: </b> Gesetzt!<br><hr>"+
							"<center><b>Sicherheit:</b></center>"+
							"<b>Nickname: </b>"+ textField_nick.getText()+"<br>"+
							"<b>Passwort: </b> Nur Sie wissen es! <br>"+
							"<b>E-Mail:  </b>"+ textField_email.getText()+"<br><hr>"+
							"<center><b>Dies sind Ihre Einstellungen. Wenn Sie etwas ändern möchten tun Sie dies jetzt. Mit einem Klick auf Bestätigen werden diese Einstellungen umgesetzt.</b></center>");
		}
		else
		{
			txtpn_zf.setText("<center><b>Zusammenfassung Ihrer Konfiguration:</b></center><hr><center><b>Ihre Pfade: </b></center>"+
							"<b>Daten: </b>"+ textField_dp.getText()+"<br>"+
							"<b>User: </b>"+ textField_up.getText()+"<br>"+
							"<b>Log: </b>"+ textField_lp.getText()+"<br><hr>"+
							"<center><b>Ihre User Einstellungen: </b></center>"+
							"<b>Vorname: </b>"+ textField_vorname.getText()+"<br>"+
							"<b>Nachname: </b>"+ textField_nachname.getText()+"<br>"+
							"<b>Kürzel: </b>"+ textField_kürzel.getText()+"<br>"+
							"<b>Organisation: </b>"+ textField_orga.getText()+"<br>"+
							"<b>Sicherer Account: </b> Nicht gesetzt!<br><hr>"+
							"<center><b>Dies sind Ihre Einstellungen. Wenn Sie etwas ändern möchten tun Sie dies jetzt. Mit einem Klick auf Bestätigen werden diese Einstellungen umgesetzt.</b></center>");
		}
	}
}