import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lockPin {
	
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, enter, resetPIN, backSpace;
	private JLabel display;
	private String input = "";
	private String displayOutput = "";
	private String correctPIN = "";


	public lockPin() {
		JFrame f = new JFrame ("Lock PIN");
		JPanel panel = new JPanel(new BorderLayout(5,5));
        JPanel keypad = new JPanel(new BorderLayout(5,5));
        JPanel numberGrid = new JPanel(new GridLayout(3,3,5,5));
        JPanel bottomRow = new JPanel(new GridLayout(1,3,5,5));
        JPanel bottomRow2 = new JPanel(new GridLayout(1,2,5,5));
        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
		
        if (correctPIN != null && !correctPIN.isEmpty()) {
            display = new JLabel("Enter PIN", SwingConstants.CENTER);
        } else {
            display = new JLabel("Enter a new PIN", SwingConstants.CENTER);
        }

		display.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));
		display.setPreferredSize(new Dimension(600, 100));
		panel.add(display, BorderLayout.NORTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		clear = new JButton("CLEAR");
		enter = new JButton("Enter");
        resetPIN = new JButton("Reset PIN");
        backSpace = new JButton("Backspace");
		
		numberGrid.add(one);
		numberGrid.add(two);
		numberGrid.add(three);
		numberGrid.add(four);
		numberGrid.add(five);
		numberGrid.add(six);
		numberGrid.add(seven);
		numberGrid.add(eight);
		numberGrid.add(nine);

		bottomRow.add(zero);
		bottomRow.add(clear);
		bottomRow.add(enter);
        bottomRow2.add(resetPIN);
        bottomRow2.add(backSpace);

        bottomPanel.add(bottomRow, BorderLayout.NORTH);
        bottomPanel.add(bottomRow2, BorderLayout.SOUTH);

        keypad.add(numberGrid, BorderLayout.CENTER);
        keypad.add(bottomPanel, BorderLayout.SOUTH);

		panel.add(keypad, BorderLayout.CENTER);
		
		ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton)e.getSource();
                String digits = source.getText();
                input += digits;
                displayOutput += "*";
                display.setText(displayOutput);
            }
        };
        
        one.addActionListener(numberListener);
        two.addActionListener(numberListener);
        three.addActionListener(numberListener);
        four.addActionListener(numberListener);
        five.addActionListener(numberListener);
        six.addActionListener(numberListener);
        seven.addActionListener(numberListener);
        eight.addActionListener(numberListener);
        nine.addActionListener(numberListener);
        zero.addActionListener(numberListener);
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	input = "";
            	displayOutput = "";
                display.setText("");
            }
        });
        
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input == null || input.isEmpty()) {
                    display.setText("You have not inputted a PIN!");
                } else if (correctPIN == null || correctPIN.isEmpty()) {
                    correctPIN = input;
                    display.setText("PIN set! Your PIN: " + correctPIN);
                } else {
                    if (input.equals(correctPIN)) {
                        display.setText("Open!");
                    } else {
                    display.setText("Wrong PIN!");
                }
            }
                input = "";
                displayOutput = "";
            }
        });

        resetPIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (correctPIN == null || correctPIN.isEmpty()) {
                    display.setText("You have not yet set a PIN!");
                } else {
                    correctPIN = "";
                    input = "";
                    display.setText("PIN reset success!");
                }
            }
        });

        backSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.isEmpty() && !displayOutput.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    displayOutput = displayOutput.substring(0, displayOutput.length() - 1);
                    display.setText(displayOutput);
                }
            }
        });
		
		f.add(panel);
		f.setVisible(true);
		f.setSize(600,400);
		f.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new lockPin();
	}
}