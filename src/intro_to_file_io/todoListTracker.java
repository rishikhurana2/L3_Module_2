package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class todoListTracker implements ActionListener {
	String task;
	String removeTask;
	ArrayList<String> taskHolder = new ArrayList<String>();
	public static void main(String[] args) {
		todoListTracker todo = new todoListTracker();
		todo.createUI();
	}
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	void createUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		frame.setVisible(true);
		frame.setSize(700,100);
		frame.add(panel);
		b1.setText("add task");
		b2.setText("remove task");
		b3.setText("save");
		b4.setText("load");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		taskHolder.add(0, "To-Do List");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			task = JOptionPane.showInputDialog("Please add a task");
			try {
				taskHolder.add(task);
				FileWriter fw = new FileWriter("src/intro_to_file_io/To-Do List", false);
				for (int i = 0; i < taskHolder.size(); i++) {
						fw.write(taskHolder.get(i) + "\n");
				}
				System.out.println(taskHolder);
				fw.close();
			} catch (IOException j) {
				// TODO Auto-generated catch block
				j.printStackTrace();
			}
		}
		if (e.getSource() == b2) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/To-Do List"));
				FileWriter fr = new FileWriter("src/intro_to_file_io/To-Do List");
				br.readLine();
				String i = JOptionPane.showInputDialog("Please enter the task you would like to remove");
				taskHolder.remove(i);
				System.out.println(taskHolder);
				br.close();
				fr.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
