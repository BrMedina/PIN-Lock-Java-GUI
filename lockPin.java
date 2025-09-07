import javax.swing.*;
import java.awt.*;

public class lockPin {

    private JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, enter, resetPin;
    private JLabel display;
    private String input = "";
    private String dispOutput = "";
    private String correctPIN;

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

    }

    public static void main(String[] args) {
        new lockPin();
    }
    
}
