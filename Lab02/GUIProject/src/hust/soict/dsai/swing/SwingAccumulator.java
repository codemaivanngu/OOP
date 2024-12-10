package hust.soict.dsai.swing;

import java.awt.Container;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame{
	
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;

	public SwingAccumulator() {
		// TODO Auto-generated constructor stub
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		cp.add(new JLabel("Enter an Integer: "));
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		cp.add(new JLabel("The Accumulated Sum is: "));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		setTitle("Swing Accumulator");
		setSize(350,120);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAccumulator();
	}
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberInt = Integer.parseInt(tfInput.getText());
			sum += numberInt;
			tfInput.setText("");
			tfOutput.setText(sum+"");
			
		}
	}

}
