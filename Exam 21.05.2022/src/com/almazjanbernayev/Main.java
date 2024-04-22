package com.almazjanbernayev;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Almazjan Bernayev
 */

@SuppressWarnings("serial")
class MyFrame extends JFrame implements WindowListener {

	private JPanel panel1, panel2;
	private JLabel columnLabel, lineLabel, colorLabel, emptyLabel;
	private Choice choiceLetter, choiceDigit, choiceColor;
	private JButton colorButton, saveButton;
	private Font labelFont, buttonFont;
	private TextArea info;

	int x, y;
	long startTime = System.currentTimeMillis();
	String c;
	String[] letter,
	digit,
	color;

	public MyFrame() {

		setTitle("Exam 21.05.2022");
		setLayout(null);
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labelFont = new Font("Arial", Font.PLAIN, 20);
		buttonFont = new Font("Arial", Font.ITALIC, 20);

		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 250, 600);
//		panel1.setBackground(Color.green);

		panel2 = new JPanel() {
			public void paint(Graphics g) {
				Graphics2D graphics = (Graphics2D) g;

				int horizontalLine = 250,
						verticalLine = 250;

				for(int i=0; i<6; i++) {
					graphics.drawLine(0, i*50, horizontalLine, i*50);
				}
				for(int i=0; i<6; i++) {
					graphics.drawLine(i*50, 0, i*50, verticalLine);
				}

				if(c == "R") {
					graphics.setColor(Color.red);
				}else if(c == "G") {
					graphics.setColor(Color.green);
				}else if(c == "B") {
					graphics.setColor(Color.blue);
				}

				graphics.fillRect(x*50, y*50, 50, 50);
			}
		};
		panel2.setLayout(null);
		panel2.setBounds(300, 0, 350, 600);
//		panel2.setBackground(Color.green); // doesn't work


		choiceLetter = new Choice();
		choiceLetter.setBounds(160, 20, 40, 20);
		choiceLetter.add("A");
		choiceLetter.add("B");
		choiceLetter.add("C");
		choiceLetter.add("D");
		choiceLetter.add("E");
		panel1.add(choiceLetter);

		choiceDigit = new Choice();
		choiceDigit.setBounds(160, 50, 40, 20);
		choiceDigit.add("1");
		choiceDigit.add("2");
		choiceDigit.add("3");
		choiceDigit.add("4");
		choiceDigit.add("5");
		panel1.add(choiceDigit);

		choiceColor = new Choice();
		choiceColor.setBounds(160, 80, 40, 20);
		choiceColor.add("R");
		choiceColor.add("G");
		choiceColor.add("B");
		panel1.add(choiceColor);

		columnLabel = new JLabel("Select column:");
		columnLabel.setBounds(20, 20, 140, 20);
		columnLabel.setFont(labelFont);

		lineLabel = new JLabel("Select line:");
		lineLabel.setBounds(20, 50, 140, 20);
		lineLabel.setFont(labelFont);

		colorLabel = new JLabel("Select color:");
		colorLabel.setBounds(20, 80, 140, 20);
		colorLabel.setFont(labelFont);
		
		emptyLabel = new JLabel();
		emptyLabel.setBounds(10, 200, 250, 20);
		emptyLabel.setFont(labelFont);

		info = new TextArea();
		info.setBounds(0, 280, 250, 250);
		info.setFont(labelFont);


		// ==================== BUTTONS ====================
		colorButton = new JButton("COLOUR");
		colorButton.setBounds(50, 120, 120, 30);
		colorButton.setFont(buttonFont);
//		colorButton.setBackground(new Color(185, 180, 120));
		colorButton.setBackground(new Color(140, 225, 200));
		colorButton.setFocusable(false);
		colorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0, y = 0;
				long reactionTime = System.currentTimeMillis() - startTime;
				info.append((String) choiceColor.getSelectedItem() + " - " +
						(String) choiceLetter.getSelectedItem() +
						(String) choiceDigit.getSelectedItem() + " - " +
						reactionTime + " ms" + "\n");
				if(choiceLetter.getSelectedItem() == "A") {
					x = 0;
				}else if(choiceLetter.getSelectedItem() == "B") {
					x = 1;
				}else if(choiceLetter.getSelectedItem() == "C") {
					x = 2;
				}else if(choiceLetter.getSelectedItem() == "D") {
					x = 3;
				}else if(choiceLetter.getSelectedItem() == "E") {
					x = 4;
				}
				y = Integer.parseInt(choiceDigit.getSelectedItem()) - 1;

				setX(x);
				setY(y);
				setColor((String)choiceColor.getSelectedItem());
				repaint();

			}
		});

		saveButton = new JButton("SAVE");
		saveButton.setBounds(50, 160, 120, 30);
		saveButton.setFont(buttonFont);
		saveButton.setBackground(new Color(140, 225, 120));
//		saveButton.setBackground(new Color(140, 225, 200));
		saveButton.setFocusable(false);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					checkNullTextArea(info);
					BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
					writer.write(info.getText());
					writer.close();
					emptyLabel.setForeground(new Color(100, 180, 50));
					emptyLabel.setText("File saved successfully");
					info.setText("");
				} catch (Exception e1) {
					emptyLabel.setForeground(Color.RED);
					emptyLabel.setText("There's no text to be saved");
				}

			}

		});

		panel1.add(columnLabel);
		panel1.add(lineLabel);
		panel1.add(colorLabel);
		panel1.add(emptyLabel);
		panel1.add(colorButton);
		panel1.add(saveButton);

		panel2.add(info);




		add(panel1);
		add(panel2);

		setVisible(true);

	}

	public void setColor(String c) {
		this.c = c;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void checkNullTextArea(TextArea textArea) throws Exception{
		String string = textArea.getText().trim();
		if(string.equals("")) {
			throw new Exception("There's no text to be saved");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new MyFrame());

	} // method main

} // class Main
