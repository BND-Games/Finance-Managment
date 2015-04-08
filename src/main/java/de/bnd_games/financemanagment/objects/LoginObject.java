package de.bnd_games.financemanagment.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginObject {
	private String nickname;
	private String password;
	private String email;
	
	static final Logger logger = LogManager.getLogger(LoginObject.class
			.getName());

	public String getNickname() {
		logger.debug("Lese Nickname aus: " + this.nickname); 
		return nickname;
	}

	public void setNickname(String nickname) {
		logger.debug("Setze Nickname zu: " + nickname);
		this.nickname = nickname;
	}

	public String getPassword() {
		logger.debug("Lese Passwort aus: " + this.password); 
		return password;
	}

	public void setPassword(String password) {
		logger.debug("Setze Passwort zu: " + password);
		this.password = password;
	}

	public String getEmail() {
		logger.debug("Lese E-Mail aus: " + this.email); 
		return email;
	}

	public void setEmail(String email) {
		logger.debug("Setze EMail zu: " + email);
		this.email = email;
	}
}
