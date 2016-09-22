package GUI;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class passwortAbfage {
	public void initialize() throws IOException {
		Icon icon = new ImageIcon(GUI.lengthJInputdialog.class.getResource("Apps-password-icon.png"));
		LayoutManager lm = new BorderLayout();
		//Image imc = (Image) icon;
		JFrame f = new JFrame("Passwort");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setIconImage(imc);
		f.setAlwaysOnTop(true);
		f.setAutoRequestFocus(true);
		f.setSize(300, 200);
		f.setLayout(lm);
	JPasswordField pwf = new JPasswordField();
		pwf.setEditable(true);
		pwf.setVisible(true);
		JLabel label = new JLabel();
		label.setText("Gib dein Passwort ein");
		File trys = new File("text.txt");
		
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(trys));
		fileWriter.write("0");
		if(!trys.exists()){
			fileWriter.write("0");
		}
		label.setVisible(true);
		FileReader fr = new FileReader(trys);
		BufferedReader br = new BufferedReader(fr);
		String passwortVersuche = br.readLine();
		if(Integer.parseInt(passwortVersuche) > 4){
			JOptionPane.showMessageDialog(f, "Kontaktiere Tobin um dein Passwort Zurückzusetzen");
			System.exit(0);
		}
		String text = "Das Passwort ist";
		String eingabe = "";
		File passwort = new File("passwort.txt");
		int i = 1;
		while(!passwort.exists()&&(i==1 )){
			f.add(pwf,"Center");
			label.setText("Gib ein neues passwort ein:");
			f.add(label,"North");
			String passwort1 = String.valueOf(pwf.getPassword());
			label.setText("Nochmal");
			String passwort2 = String.valueOf(pwf.getPassword());
			if(passwort1 ==passwort2){
				BufferedWriter fileWriterpassword = new BufferedWriter(new FileWriter("passwort.txt"));
				if(!trys.exists()){
					fileWriter.write(passwort1);
				}
				i = 0;
				f.remove(label);
				f.remove(pwf);
				label.setText("");
			}
		}
		f.add(pwf, "Center");
		label.setText("Gib dein Passwort ein du hast noch "+(3- Integer.parseInt(passwortVersuche)+" Versuche"));
		f.add(label, "North");
		try{
			eingabe = String.valueOf(pwf.getPassword());
		}catch(Exception x){
			x.printStackTrace();
		}FileReader frp = new FileReader("passwort.txt");
		BufferedReader brp = new BufferedReader(fr);
		String passwortfile = br.readLine();
		if(!eingabe.equals(passwortfile)){
			
			int paswortInt = Integer.parseInt(passwortVersuche) +1;
			fileWriter.write(paswortInt);
			System.exit(0);
		}
		
	}

}
