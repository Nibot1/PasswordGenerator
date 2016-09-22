package GUI;

import java.text.ParseException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class lengthJInputdialog {
	private static int lenght;
	private static String lenghtString;
	private static final int maxSize = 59;
	Icon icon = new ImageIcon(GUI.lengthJInputdialog.class.getResource("Apps-password-icon.png"));

	public int setLength() throws ParseException {
		lenghtString = (String) JOptionPane.showInputDialog(null,
				"Wie viele Zeichen soll dein Passwort haben ? (max. 58) ", "Passwort", JOptionPane.QUESTION_MESSAGE,
				icon, null, null);
		if (lenghtString == null) {
			System.exit(0);
		} else {
			try {
				lenght = Integer.parseInt(lenghtString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, lenghtString +" ist keine Zahl", "Error!!!",
						JOptionPane.WARNING_MESSAGE, null);
				System.exit(0);
			}
			if (lenght >= maxSize) {
				JOptionPane.showMessageDialog(null, "Diese Zahl ist zu hoch!!!", "Error!!!",
						JOptionPane.WARNING_MESSAGE, null);
				System.exit(0);
			}
		}
		return lenght;

	}

	public int getLenght() {
		return lenght;
	}
}
