package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class messageTaker {
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Please write a message");
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/messageTaker", true);
			fw.write(message + " ");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
