/**
 * @author Almazjan Bernayev
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener, MouseListener{
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JTextField textFieldMain, textFieldSecondary;
	JButton zero, one, two, three, four, five, six, seven, eight, nine, sign, dot, equals, plus, minus, multiply, devide, root, power, oneDevidedBy, percent, clear, delete;
	ImageIcon image;
	Font labelFont, textFieldMainFont, textFieldSecondaryFont, buttonFont;
	StringBuilder inputBuffer, stringBuilder;
	
//	private int intNumber1, intNumber2;
	private double number1, number2, result;
	private String operation, backSpace;
	
	public Calculator(){
		
		setTitle("Calculator");
		setSize(420, 630);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 410, 595);
		panel.setBackground(new Color(33, 33, 33));
		
		//fonts
		buttonFont = new Font("Arial", Font.PLAIN, 20);
		textFieldMainFont = new Font("Arial", Font.PLAIN, 50);
		textFieldSecondaryFont = new Font("Arial", Font.PLAIN, 30);
		
		// icon
		image = new ImageIcon("calculator.png");
		setIconImage(image.getImage());
		
		// buttons
		sign = new JButton("+/-");
		sign.setBounds(1, 530, 100, 60);
		sign.setFocusable(false);
		sign.setBackground(Color.DARK_GRAY);
		sign.setForeground(Color.white);
		sign.setFont(buttonFont);
		sign.setBorder(null);
		sign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double number = Double.parseDouble(textFieldMain.getText());
				number *= -1;
				inputBuffer.delete(0, inputBuffer.length());
				inputBuffer.append(number);
				textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		sign.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sign.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sign.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		zero = new JButton("0");
		zero.setBounds(102, 530, 100, 60);
		zero.setFocusable(false);
		zero.setBackground(Color.DARK_GRAY);
		zero.setForeground(Color.white);
		zero.setFont(buttonFont);
		zero.setBorder(null);
		zero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		zero.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				zero.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				zero.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		dot = new JButton(".");
		dot.setBounds(203, 530, 100, 60);
		dot.setFocusable(false);
		dot.setBackground(Color.DARK_GRAY);
		dot.setForeground(Color.white);
		dot.setFont(buttonFont);
		dot.setBorder(null);
		dot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldMain.getText().equals("0") || textFieldMain.getText().isEmpty()) {
					inputBuffer.append("0" + dot.getText());
					textFieldMain.setText(inputBuffer.toString());
					dot.setEnabled(false);
				}
				else if(!textFieldMain.getText().contains(".")) {
					inputBuffer.append(dot.getText());
					textFieldMain.setText(inputBuffer.toString());
					dot.setEnabled(false);
				}
				
			}
			
		});
		dot.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				dot.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dot.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		equals = new JButton("=");
		equals.setBounds(304, 468, 100, 122);
		equals.setFocusable(false);
		equals.setBackground(new Color(135, 75, 55));
		equals.setForeground(Color.black);
		equals.setFont(buttonFont);
		equals.setBorder(null);
		equals.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				number2 = Double.parseDouble(textFieldMain.getText());
				stringBuilder.delete(0, stringBuilder.length());
				stringBuilder.append(textFieldSecondary.getText() + number2 + " = ");
				textFieldSecondary.setText(stringBuilder.toString());
				if(operation.equals("+")) {
					result = number1 + number2;
					textFieldMain.setText(String.valueOf(result));
				}
				else if(operation.equals("-")) {
					result = number1 - number2;
					textFieldMain.setText(String.valueOf(result));
				}
				else if(operation.equals("x")) {
					result = number1 * number2;
					textFieldMain.setText(String.valueOf(result));
				}
				else if(operation.equals("÷")) {
					result = number1 / number2;
					textFieldMain.setText(String.valueOf(result));
				}
				
			}
			
		});
		equals.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				equals.setBackground(new Color(125,65, 45));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				equals.setBackground(new Color(135, 75, 55));
			}
			
		});
		
		one = new JButton("1");
		one.setBounds(1, 468, 100, 60);
		one.setFocusable(false);
		one.setBackground(Color.DARK_GRAY);
		one.setForeground(Color.white);
		one.setFont(buttonFont);
		one.setBorder(null);
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		one.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				one.setBackground(new Color(55, 55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				one.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		two = new JButton("2");
		two.setBounds(102, 468, 100, 60);
		two.setFocusable(false);
		two.setBackground(Color.DARK_GRAY);
		two.setForeground(Color.white);
		two.setFont(buttonFont);
		two.setBorder(null);
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		two.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				two.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				two.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		three = new JButton("3");
		three.setBounds(203, 468, 100, 60);
		three.setFocusable(false);
		three.setBackground(Color.DARK_GRAY);
		three.setForeground(Color.white);
		three.setFont(buttonFont);
		three.setBorder(null);
		three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		three.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				three.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				three.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		four = new JButton("4");
		four.setBounds(1, 406, 100, 60);
		four.setFocusable(false);
		four.setBackground(Color.DARK_GRAY);
		four.setForeground(Color.white);
		four.setFont(buttonFont);
		four.setBorder(null);
		four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		four.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				four.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				four.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		five = new JButton("5");
		five.setBounds(102, 406, 100, 60);
		five.setFocusable(false);
		five.setBackground(Color.DARK_GRAY);
		five.setForeground(Color.white);
		five.setFont(buttonFont);
		five.setBorder(null);
		five.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		five.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				five.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				five.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		six = new JButton("6");
		six.setBounds(203, 406, 100, 60);
		six.setFocusable(false);
		six.setBackground(Color.DARK_GRAY);
		six.setForeground(Color.white);
		six.setFont(buttonFont);
		six.setBorder(null);
		six.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		six.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				six.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				six.setBackground(Color.DARK_GRAY);
			}
			
		});

		plus = new JButton("+");
		plus.setBounds(304, 406, 100, 60);
		plus.setFocusable(false);
		plus.setBackground(new Color(55, 55, 55));
		plus.setForeground(Color.white);
		plus.setFont(buttonFont);
		plus.setBorder(null);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dot.setEnabled(true);
				number1 = Double.parseDouble(textFieldMain.getText());
				operation = "+";
				stringBuilder.append(textFieldMain.getText() + " + ");
				textFieldSecondary.setText(stringBuilder.toString());
				inputBuffer.delete(0, inputBuffer.length());
				
			}
			
		});
		plus.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				plus.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				plus.setBackground(new Color(55,55, 55));
			}
			
		});
		
		seven = new JButton("7");
		seven.setBounds(1, 344, 100, 60);
		seven.setFocusable(false);
		seven.setBackground(Color.DARK_GRAY);
		seven.setForeground(Color.white);
		seven.setFont(buttonFont);
		seven.setBorder(null);
		seven.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		seven.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				seven.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				seven.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		eight = new JButton("8");
		eight.setBounds(102, 344, 100, 60);
		eight.setFocusable(false);
		eight.setBackground(Color.DARK_GRAY);
		eight.setForeground(Color.white);
		eight.setFont(buttonFont);
		eight.setBorder(null);
		eight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		eight.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				eight.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				eight.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		nine = new JButton("9");
		nine.setBounds(203, 344, 100, 60);
		nine.setFocusable(false);
		nine.setBackground(Color.DARK_GRAY);
		nine.setForeground(Color.white);
		nine.setFont(buttonFont);
		nine.setBorder(null);
		nine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton button = (JButton)e.getSource();
                inputBuffer.append(button.getText());
                textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		nine.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				nine.setBackground(new Color(55,55, 55));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nine.setBackground(Color.DARK_GRAY);
			}
			
		});
		
		minus = new JButton("-");
		minus.setBounds(304, 344, 100, 60);
		minus.setFocusable(false);
		minus.setBackground(new Color(55, 55, 55));
		minus.setForeground(Color.white);
		minus.setFont(buttonFont);
		minus.setBorder(null);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dot.setEnabled(true);
				number1 = Double.parseDouble(textFieldMain.getText());
				operation = "-";
				stringBuilder.append(textFieldMain.getText() + " - ");
				textFieldSecondary.setText(stringBuilder.toString());
				inputBuffer.delete(0, inputBuffer.length());
				
			}
			
		});
		minus.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				minus.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minus.setBackground(new Color(55,55, 55));
			}
			
		});
		
		oneDevidedBy = new JButton("1/x");
		oneDevidedBy.setBounds(1, 282, 100, 60);
		oneDevidedBy.setFocusable(false);
		oneDevidedBy.setBackground(new Color(55, 55, 55));
		oneDevidedBy.setForeground(Color.white);
		oneDevidedBy.setFont(buttonFont);
		oneDevidedBy.setBorder(null);
		oneDevidedBy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				number1 = Double.parseDouble(textFieldMain.getText());
				stringBuilder.append("1/(" + number1 + ")");
				textFieldSecondary.setText(stringBuilder.toString());
				
				if(number1 == 0) {
					textFieldMain.setText("Cannot divide by zero");
				}
				
				inputBuffer.delete(0, inputBuffer.length());
				inputBuffer.append(1 / number1);
				textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		oneDevidedBy.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				oneDevidedBy.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				oneDevidedBy.setBackground(new Color(55,55, 55));
			}
			
		});
		
		power = new JButton("x^2");
		power.setBounds(102, 282, 100, 60);
		power.setFocusable(false);
		power.setBackground(new Color(55, 55, 55));
		power.setForeground(Color.white);
		power.setFont(buttonFont);
		power.setBorder(null);
		power.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				number1 = Double.parseDouble(textFieldMain.getText());
				stringBuilder.append("sqr(" + textFieldMain.getText() + ")");
				textFieldSecondary.setText(stringBuilder.toString());
				inputBuffer.delete(0, inputBuffer.length());
				inputBuffer.append(Math.pow(number1, 2));
				textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		power.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				power.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				power.setBackground(new Color(55,55, 55));
			}
			
		});

		root = new JButton("√x");
		root.setBounds(203, 282, 100, 60);
		root.setFocusable(false);
		root.setBackground(new Color(55, 55, 55));
		root.setForeground(Color.white);
		root.setFont(buttonFont);
		root.setBorder(null);
		root.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				number1 = Double.parseDouble(textFieldMain.getText());
				stringBuilder.append("√(" + number1 +  ")");
				textFieldSecondary.setText(stringBuilder.toString());
				inputBuffer.delete(0, inputBuffer.length());
				inputBuffer.append(Math.sqrt(number1));
				textFieldMain.setText(inputBuffer.toString());
				
			}
			
		});
		root.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				root.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				root.setBackground(new Color(55,55, 55));
			}
			
		});
		
		multiply = new JButton("x");
		multiply.setBounds(304, 282, 100, 60);
		multiply.setFocusable(false);
		multiply.setBackground(new Color(55, 55, 55));
		multiply.setForeground(Color.white);
		multiply.setFont(buttonFont);
		multiply.setBorder(null);
		multiply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dot.setEnabled(true);
				inputBuffer.delete(0, inputBuffer.length());
				number1 = Double.parseDouble(textFieldMain.getText());
				operation = "x";
				stringBuilder.append(number1 + " x ");
				textFieldSecondary.setText(stringBuilder.toString());
				
			}
			
		});
		multiply.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				multiply.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				multiply.setBackground(new Color(55,55, 55));
			}
			
		});
		
		clear = new JButton("C");
		clear.setBounds(1, 220, 100, 60);
		clear.setFocusable(false);
		clear.setBackground(new Color(55, 55, 55));
		clear.setForeground(Color.white);
		clear.setFont(buttonFont);
		clear.setBorder(null);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dot.setEnabled(true);
				inputBuffer.delete(0, inputBuffer.length());
				stringBuilder.delete(0, stringBuilder.length());
				textFieldMain.setText("0");
				textFieldSecondary.setText("");
				
			}
			
		});
		clear.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				clear.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				clear.setBackground(new Color(55,55, 55));
			}
			
		});
		
		percent = new JButton("%");
		percent.setBounds(102, 220, 100, 60);
		percent.setFocusable(false);
		percent.setBackground(new Color(55, 55, 55));
		percent.setForeground(Color.white);
		percent.setFont(buttonFont);
		percent.setBorder(null);
		percent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		percent.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				percent.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				percent.setBackground(new Color(55,55, 55));
			}
			
		});
		
		delete = new JButton("del");
		delete.setBounds(203, 220, 100, 60);
		delete.setFocusable(false);
		delete.setBackground(new Color(55, 55, 55));
		delete.setForeground(Color.white);
		delete.setFont(buttonFont);
		delete.setBorder(null);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				backSpace = null;
				if(textFieldMain.getText().length() > 0) {
					inputBuffer.deleteCharAt(textFieldMain.getText().length() - 1);
					backSpace = inputBuffer.toString(); // shu liniyany ayyryvam barlap gormaly
					textFieldMain.setText(backSpace);
					if(!textFieldMain.getText().contains(".")) {
						dot.setEnabled(true);
					}
				}
				
			}
			
		});
		delete.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				delete.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete.setBackground(new Color(55,55, 55));
			}
			
		});
		
		devide = new JButton("÷");
		devide.setBounds(304, 220, 100, 60);
		devide.setFocusable(false);
		devide.setBackground(new Color(55, 55, 55));
		devide.setForeground(Color.white);
		devide.setFont(new Font("Arial", Font.PLAIN, 25));
		devide.setBorder(null);
		devide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dot.setEnabled(true);
				inputBuffer.delete(0, inputBuffer.length());
				number1 = Double.parseDouble(textFieldMain.getText());
				operation = "÷";
				stringBuilder.append(number1 + " ÷ ");
				textFieldSecondary.setText(stringBuilder.toString());
				
			}
			
		});
		devide.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				devide.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				devide.setBackground(new Color(55,55, 55));
			}
			
		});
		
		// text fields
		textFieldMain = new JTextField(12);
		textFieldMain.setText("0");
		textFieldMain.setBounds(1, 138, 403, 80);
		textFieldMain.setBackground(new Color(33, 33, 33));
		textFieldMain.setForeground(Color.white);
		textFieldMain.setHorizontalAlignment(JTextField.RIGHT);
		textFieldMain.setFont(textFieldMainFont);
		
		textFieldSecondary = new JTextField();
		textFieldSecondary.setBounds(1, 108, 403, 30);
		textFieldSecondary.setBackground(new Color(33, 33, 33));
		textFieldSecondary.setForeground(Color.gray);
		textFieldSecondary.setHorizontalAlignment(JTextField.RIGHT);
		textFieldSecondary.setBorder(null);
		textFieldSecondary.setFont(textFieldSecondaryFont);
		
		// input buffer
		inputBuffer = new StringBuilder();
		stringBuilder = new StringBuilder();
		
		// adding objects to panel
		panel.add(sign);
		panel.add(zero);
		panel.add(dot);
		panel.add(equals);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(plus);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(minus);
		panel.add(seven);
		panel.add(eight);
		panel.add(nine);
		panel.add(multiply);
		panel.add(oneDevidedBy);
		panel.add(power);
		panel.add(root);
		panel.add(devide);
		panel.add(clear);
		panel.add(percent);
		panel.add(delete);
		panel.add(textFieldMain);
		panel.add(textFieldSecondary);
		
		add(panel);
		
		setLayout(null);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
