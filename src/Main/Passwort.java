package Main;

import java.io.IOException;
import java.security.SecureRandom;

import GUI.passwordJMessageBox;
import GUI.passwortAbfage;

public class Passwort {

	// private static final int length;

	public static String createPassword(int length) {
		final String allowedChars = "0123456789abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOP!§$%&?*+#";
		SecureRandom random = new SecureRandom();
		StringBuilder pass = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
			//System.out.println(pass.toString());

		}
		return pass.toString();}

	public static void main(String[] args) throws Exception {
		//GUI.passwortAbfage passwort = new passwortAbfage();
		//passwort.initialize();
		GUI.passwordJMessageBox output = new passwordJMessageBox();
		output.showPassword();
		System.exit(0);
		
	}

}