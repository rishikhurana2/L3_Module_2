package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CopyrightAdder {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String file = jfc.getSelectedFile().getAbsolutePath();
			try {
				FileWriter fw = new FileWriter(file);
				fw.write("Copyright © 2017 by Rishi");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
