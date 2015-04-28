package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import model.Creature;

public class GUI extends JFrame{
	JFrame frame = new JFrame("Creature Game");
	JPanel panel = new JPanel();
	JTextPane collection = new JTextPane();
	
	public GUI(){
		collection.setText("");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		panel.setLayout(null);
		panel.add(collection);
		frame.add(panel);
		//frame.add(collection);
		panel.setBounds(0, 0, 500, 500);
		collection.setBounds(10, 10, 200, 200);
		frame.setVisible(true);
		
	}
	
	//updates Collection
	public void updateCollection(Creature[] in){
		String result = "";
		for (int i = 0; i < in.length; i++){
			if (in[i] != null)
				result += in[i].getName() + '\n';
		}
		System.out.println("setting text " + result);
		collection.setText(result);
	}
}
