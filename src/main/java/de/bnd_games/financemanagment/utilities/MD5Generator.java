package de.bnd_games.financemanagment.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MD5Generator {
	static final Logger logger = LogManager.getLogger(MD5Generator.class
			.getName());

	//TODO Sollte wohl besser nicht main heißen...
	@SuppressWarnings("finally")
	public String main(String message) {
		logger.info("Starte MD5 Generator");
		String md5_value = null;
		try {
			logger.debug("Generiere MD5 Wert von: " + message);
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(message.getBytes(), 0, message.length());
			md5_value = new BigInteger(1, m.digest()).toString();
		} catch (Exception ex) {
			logger.error("Generieren des MD5 Wertes von " + message
					+ " ist Fehlgeschlagen.");
			return "failed";
		} finally {
			logger.debug("MD5 Wert von: " + message + "erfolgreich erstellt: " + md5_value);
			return md5_value;
		}
	}
}
