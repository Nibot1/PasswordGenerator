package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class passwordJMessageBox {
	final JFileChooser fc = new JFileChooser();
	Icon icon = new ImageIcon(GUI.lengthJInputdialog.class.getResource("Apps-password-icon.png"));
	int dialogButton = JOptionPane.YES_NO_OPTION;
	public String setPassword() throws ParseException{
		GUI.lengthJInputdialog input = new lengthJInputdialog();
		input.setLength();
		final int length = input.getLenght();
		//System.out.println(length);
		final String pass = Main.Passwort.createPassword(length);
		//System.out.println(pass);
		return pass;}
	public void showPassword() throws Exception{
		final String password = setPassword();
		JOptionPane.showMessageDialog(null, "Dein Passwort ist : \n"+ password, "Passwort",
				JOptionPane.YES_NO_OPTION, icon);
		int dialogResult = JOptionPane.showConfirmDialog (null, "Willst du das Passwort Speichern ?","Speichern ?",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			
				JFrame frame = new JFrame("Datei Öffnen");
				frame .setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JFileChooser saveFile = new JFileChooser();
                int saveOption = saveFile.showSaveDialog(frame);
                if(saveOption == JFileChooser.APPROVE_OPTION){
                	String konto = (String) JOptionPane.showInputDialog(null, "Zu welchem Konto gehört das Passwort ?",
            				"Passwort", JOptionPane.QUESTION_MESSAGE, icon, null, null);

                    try{
                        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(saveFile.getSelectedFile().getPath(),/*append*/ true));
                        fileWriter.append(konto+": " + password+"\n");
                        fileWriter.close();
                    }catch(Exception ex){

                    }

}}}}
