import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lockPin {

    private JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, enter, resetPin;
    private JLabel display;
    private String input = "";
    private String dispOutput = "";
    private String setCorrectPin;
    private String correctPin;

    public lockPin() {
        JFrame f = new JFrame("Lock PIN");
        JPanel panel = new JPanel(new BorderLayout(5,5));
		JPanel displayArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel keypad = new JPanel(new GridLayout(4,3));

		display = new JLabel("CLOSE", SwingConstants.CENTER);
		display.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 32));
		display.setPreferredSize(new Dimension(600, 100));
		panel.add(display, BorderLayout.NORTH);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] buttons = new JButton[10];
        for (int i = 0; i <= 9; i++){
            buttons[i] = new JButton(String.valueOf(i));
        }
        clear = new JButton("CLEAR");
		enter = new JButton("Enter");

        for (int i = 1; i <= 9; i++) {
            keypad.add(buttons[i]);
        }
        keypad.add(buttons[0]);
        keypad.add(clear);
        keypad.add(enter);

        panel.add(keypad, BorderLayout.CENTER);

        f.add(panel);
        f.pack();
		f.setVisible(true);
		f.setSize(600,400);
		f.setLocationRelativeTo(null);
        
        ActionListener numbListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton)e.getSource();
                String digits = source.getText();
                digits = correctPin;
                input += digits;
                dispOutput = "*";
                display.setText(dispOutput);
            }           
        };

        for (int i = 0; i <= 9; i++) {
        buttons[i].addActionListener(numbListener);
         }

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	input = "";
            	dispOutput = "";
                if (correctPin != null && !correctPin.isEmpty()) {
                    display.setText("Enter PIN.");
                } else {
                    display.setText("Set a new PIN.");
                }
            }
        });
        
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input.equals(correctPin)) {
                	display.setText("OPEN");
                } else {
                	display.setText("WRONG PIN");
                }
                
                input = "";
                dispOutput = "";
            }
        });

        resetPin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (correctPin != null && !correctPin.isEmpty()) {
                    correctPin = "";
                    display.setText("PIN reset successfully.");
                } else {
                    display.setText("You haven't set a PIN yet.");
                }
            }
        });


    }

    

    public static void main(String[] args) {
        new lockPin();
    }
    
}
