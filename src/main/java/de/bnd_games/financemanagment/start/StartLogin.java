package de.bnd_games.financemanagment.start;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
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

import de.bnd_games.financemanagment.objects.LoginObject;
import de.bnd_games.financemanagment.objects.UserObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.bnd_games.financemanagment.utilities.MD5Generator;
import de.bnd_games.financemanagment.utilities.Props;
import de.bnd_games.financemanagment.utilities.XMLCreater;
import de.bnd_games.financemanagment.guis.MainScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartLogin {
	private static StartLogin window;
	private JFrame frmFinanzverwaltungLogin;
	private JTextField nicknameField;
	private JPasswordField passwordField;
	private LoginObject loginObj;
	static final Logger logger = LogManager.getLogger(StartLogin.class
			.getName());

	// Deklariere ListModel in welches Daten kommen.
	DefaultListModel<String> dfm = new DefaultListModel<String>();
	// Jlist -> wird mit ListModel gefüttert
	JList<String> list = new JList<String>(dfm);

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new StartLogin();
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
		initalizeList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinanzverwaltungLogin = new JFrame();
		frmFinanzverwaltungLogin.setResizable(false);
		frmFinanzverwaltungLogin.setTitle("Finanzverwaltung Login");
		frmFinanzverwaltungLogin.setBounds(100, 100, 481, 300);
		frmFinanzverwaltungLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		nicknameField = new JTextField();
		nicknameField.setEditable(false);
		nicknameField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Benutzername:");

		passwordField = new JPasswordField();

		JLabel lblPasswort = new JLabel("Passwort:");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] password_char = passwordField.getPassword();
				String password = new String(password_char);
				
				if (password.isEmpty() || password == null){
					logger.warn("Passwort war leer oder NULL");
					JOptionPane.showMessageDialog(null, "Ihr Passwort war leer. Bitte geben Sie es erneut ein!");
					passwordField.setText(null);
					return;
				}
				
				String password_MD5 = new MD5Generator().main(password);
				
				if(loginObj.getPassword().equals(password_MD5)){
					logger.info("Passwoerter stimmen ueberein!");
					MainScreen.main();
					frmFinanzverwaltungLogin.dispose();
				} else {
					logger.info("Passwoerter stimmen nicht ueberein!");
					JOptionPane.showMessageDialog(null, "Ihre Passwoerter stimmen nicht ueberein. Bitte geben Sie es erneut ein!");
					passwordField.setText(null);
					return;
				}
			}
		});

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
												185, GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblLogin,
																GroupLayout.DEFAULT_SIZE,
																204,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblPasswort,
																								GroupLayout.DEFAULT_SIZE,
																								69,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblNewLabel,
																								GroupLayout.DEFAULT_SIZE,
																								69,
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
																								nicknameField,
																								GroupLayout.PREFERRED_SIZE,
																								131,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																btnPasswortVergessen,
																GroupLayout.DEFAULT_SIZE,
																204,
																Short.MAX_VALUE)
														.addComponent(
																btnLogin,
																GroupLayout.DEFAULT_SIZE,
																204,
																Short.MAX_VALUE))
										.addContainerGap()));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = 0;
				String value = list.getSelectedValue();
				String[] value_split = value.split(" ");
				String value_user = Props.readPropertiesSetting("benutzer_speicherpfad") + "//"
						+ value_split[1] + "." + value_split[0] + "//";
				value = value_user + value_split[1] + "." + value_split[0]
						+ ".xml";

				UserObject usobj = XMLCreater.readXMLUser(new File(value));

				if (usobj.isSec_settings() == true) {
					value_user += "account//login.xml";
					loginObj = XMLCreater.readXMLLogin(new File(value_user));

					nicknameField.setText(loginObj.getNickname());
				} else {
					if (i == 0){
						++i;
						MainScreen.main();
						frmFinanzverwaltungLogin.dispose();
					}
				}

				logger.debug(value);
			}
		});
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
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
																				236,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(19)
																		.addComponent(
																				lblLogin,
																				GroupLayout.DEFAULT_SIZE,
																				76,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								nicknameField,
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
																				btnPasswortVergessen)))
										.addGap(24)));
		frmFinanzverwaltungLogin.getContentPane().setLayout(groupLayout);
	}

	private void initalizeList() {
		logger.info("Starte initalizeList");
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(0, XMLCreater.readUserData());

		int i = result.size() - 1;
		while (i >= 0) {
			String[] result_arr = result.get(i).split(" ");
			logger.debug("Fuege Userlist: " + result_arr[0] + " " + result_arr[1]
					+ " hinzu.");
			dfm.addElement(result_arr[0] + " " + result_arr[1]);
			i--;
		}
		logger.debug("initalizeList abgeschlossen mit: " + result.size() + " Usern");
	}
}
