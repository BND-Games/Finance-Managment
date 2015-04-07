package objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO komplett überarbeitung! Siehe LoginObject...
public class UserObject {
	private String firstname;
	private String lastnanme;
	private String initials;
	private String oranisation;
	private boolean sec_settings;
	static final Logger logger = LogManager.getLogger(UserObject.class
			.getName());

	public String getOranisation() {
		logger.info("Lese Organisation aus: " + this.oranisation);
		return oranisation;
	}

	public void setOranisation(String oranisation) {
		logger.info("Setze Organisation zu: " + oranisation);
		this.oranisation = oranisation;
	}

	public void set_firstname(String new_firstname) {
		logger.info("Setze Vornamen zu: " + new_firstname);
		this.firstname = new_firstname;
	}

	public void set_lastname(String new_lastname) {
		logger.info("Setze Nachnamen zu: " + new_lastname);
		this.lastnanme = new_lastname;
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
		logger.info("Lese Vornamen aus: " + this.firstname);
		return this.firstname;
	}

	public String get_lastname() {
		logger.info("Lese Nachname aus: " + this.lastnanme);
		return this.lastnanme;
	}

	public String get_initials() {
		logger.info("Lese Initialien aus: " + this.initials);
		return this.initials;
	}

	public Boolean get_sec_settings() {
		logger.info("Lese Sicherheitseinstellungen aus: " + this.sec_settings);
		return this.sec_settings;
	}
}
