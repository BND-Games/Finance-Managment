package de.bnd_games.financemanagment.start;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.bnd_games.financemanagment.classes.FileChooser;

public class StartLogin {

	private JFrame frmFinanzverwaltungLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	static final Logger logger = LogManager.getLogger(StartLogin.class
			.getName());
	
	//Deklariere ListModel in welches Daten kommen.
	DefaultListModel<String> dfm = new DefaultListModel<String>();
	//Jlist -> wird mit ListModel gefüttert
	JList<String> list = new JList<String>(dfm);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartLogin window = new StartLogin();
					window.frmFinanzverwaltungLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartLogin() {
		initialize();
		initalize_list();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinanzverwaltungLogin = new JFrame();
		frmFinanzverwaltungLogin.setResizable(false);
		frmFinanzverwaltungLogin.setTitle("Finanzverwaltung Login");
		frmFinanzverwaltungLogin.setBounds(100, 100, 450, 300);
		frmFinanzverwaltungLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nickname:");

		passwordField = new JPasswordField();

		JLabel lblPasswort = new JLabel("Passwort:");

		JButton btnLogin = new JButton("Login");

		JButton btnPasswortVergessen = new JButton("Passwort vergessen?");

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Script MT Bold", Font.PLAIN, 39));
		GroupLayout groupLayout = new GroupLayout(
				frmFinanzverwaltungLogin.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(11)
										.addComponent(list,
												GroupLayout.PREFERRED_SIZE,
												201, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblPasswort,
																								GroupLayout.DEFAULT_SIZE,
																								71,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblNewLabel,
																								GroupLayout.DEFAULT_SIZE,
																								71,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								passwordField)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								131,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																lblLogin,
																GroupLayout.PREFERRED_SIZE,
																178,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnPasswortVergessen,
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																206,
																Short.MAX_VALUE)
														.addComponent(
																btnLogin,
																GroupLayout.DEFAULT_SIZE,
																206,
																Short.MAX_VALUE))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				list,
																				GroupLayout.DEFAULT_SIZE,
																				239,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				lblLogin,
																				GroupLayout.PREFERRED_SIZE,
																				57,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				27,
																				Short.MAX_VALUE)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								passwordField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblPasswort))
																		.addGap(31)
																		.addComponent(
																				btnLogin)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnPasswortVergessen)
																		.addGap(13)))
										.addContainerGap()));
		frmFinanzverwaltungLogin.getContentPane().setLayout(groupLayout);
	}

	private void initalize_list() {
		logger.info("Erstellen der Userliste");
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(0, FileChooser.readUserData());

		int i = result.size() - 1;
		while (i >= 0) {
			logger.info("Füge Userlist: " + result.get(i) + " hinzu.");
			dfm.addElement(result.get(i));
			i--;
		}
	}
}
