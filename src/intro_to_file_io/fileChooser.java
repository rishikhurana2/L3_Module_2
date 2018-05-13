package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class fileChooser {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			try {
				FileReader fr = new FileReader(fileName);
				int c = fr.read();
				while (c != -1) {
					System.out.println((char) c);
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
