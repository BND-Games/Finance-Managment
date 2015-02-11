package de.bnd_games.financemanagment.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserObject {
	private String firstname;
	private String lastnanme;
	private String password;
	private String initials;
	private boolean sec_settings;
	static final Logger logger = LogManager.getLogger(UserObject.class
			.getName());

	public void set_firstname(String new_firstname) {
		logger.info("Setze Vornamen zu: " + new_firstname);
		this.firstname = new_firstname;
	}

	public void set_lastname(String new_lastname) {
		logger.info("Setze Nachnamen zu: " + new_lastname);
		this.lastnanme = new_lastname;
	}

	public void set_password(String new_password) {
		logger.info("Setze Passwort zu: " + new_password);
		this.password = new_password;
	}

	public void set_initials(String new_initials) {
		logger.info("Setze Initialien zu: " + new_initials);
		this.initials = new_initials;
	}

	public void set_sec_settings(boolean new_sec_settings) {
		logger.info("Setze Sicherheitseinstellungen auf: " + new_sec_settings);
		this.sec_settings = new_sec_settings;
	}

	public String get_firstname() {
		return this.firstname;
	}

	public String get_lastname() {
		return this.lastnanme;
	}

	public String get_password() {
		return this.password;
	}

	public String get_initials() {
		return this.initials;
	}

	public Boolean get_sec_settings() {
		return this.sec_settings;
	}
}
