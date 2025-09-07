import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lockPin {
	
	private JButton one, two, three, four, five, six, seven, eight, nine, zero,
					clear, enter;

	private JLabel display;
	private String input = "";
	private String displayOutput = "";
    private String setCorrectPIN = "";
	private String correctPIN = "";

	
	public lockPin() {
		JFrame f = new JFrame ("Lock PIN");
		JPanel panel = new JPanel(new BorderLayout(5,5));
        JPanel keypad = new JPanel(new GridLayout(4,3));
        JPanel displayArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
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
		
		keypad.add(one);
		keypad.add(two);
		keypad.add(three);
		keypad.add(four);
		keypad.add(five);
		keypad.add(six);
		keypad.add(seven);
		keypad.add(eight);
		keypad.add(nine);
		keypad.add(zero);
		keypad.add(clear);
		keypad.add(enter);
		
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
                if (correctPIN != null && !correctPIN.isEmpty()) {
                    if (input.equals(correctPIN)) {
                	display.setText("OPEN");
                    } else {
                	    display.setText("WRONG PIN");
                    }
                } else {
                    input = correctPIN;
                    display.setText("PIN set!");
                }
                input = "";
                displayOutput = "";
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
