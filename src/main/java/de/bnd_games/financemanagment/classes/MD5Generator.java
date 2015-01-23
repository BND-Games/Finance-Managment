package de.bnd_games.financemanagment.classes;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Generator {
	@SuppressWarnings("finally")
	public String main(String message) {
		String md5_value = null;
		try {
			System.out.println("[Konsole] Generiere MD5 Wert von: " + message);
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(message.getBytes(), 0, message.length());
			md5_value = new BigInteger(1, m.digest()).toString();
		} catch (Exception ex) {
			System.err.println("[Fehler] Generieren des MD5 Wertes von "
					+ message + " ist Fehlgeschlagen.");
			return "failed";
		} finally {
			System.out.println("[Konsole] MD5 Wert von: " + message
					+ "erfolgreich erstellt.");
			System.out.println("[Konsole] " + md5_value);
			return md5_value;
		}
	}
}
