package de.bnd_games.financemanagment.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserObject {
	private String firstname;
	private String lastnanme;
	private String initials;
	private String oranisation;
	private boolean sec_settings;

	static final Logger logger = LogManager.getLogger(UserObject.class
			.getName());

	public String getFirstname() {
		logger.debug("Lese Vorname aus: " + this.firstname);
		return firstname;
	}

	public void setFirstname(String firstname) {
		logger.debug("Setze Vorname zu: " + firstname);
		this.firstname = firstname;
	}

	public String getLastnanme() {
		logger.debug("Lese Nachname aus: " + this.lastnanme);
		return lastnanme;
	}

	public void setLastnanme(String lastnanme) {
		logger.debug("Setze Nachname zu: " + lastnanme);
		this.lastnanme = lastnanme;
	}

	public String getInitials() {
		logger.debug("Lese Kuerzel aus: " + this.initials);
		return initials;
	}

	public void setInitials(String initials) {
		logger.debug("Setze Kuerzel zu: " + initials);
		this.initials = initials;
	}

	public String getOranisation() {
		logger.debug("Lese Organisation aus: " + this.oranisation);
		return oranisation;
	}

	public void setOranisation(String oranisation) {
		logger.debug("Setze Organisation zu: " + oranisation);
		this.oranisation = oranisation;
	}

	public boolean isSec_settings() {
		logger.debug("Lese Sicherheits Einstelllung aus: " + this.sec_settings);
		return sec_settings;
	}

	public void setSec_settings(boolean sec_settings) {
		logger.debug("Setze Sicherheits Einstellungen zu: " + sec_settings);
		this.sec_settings = sec_settings;
	}
}
