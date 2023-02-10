
package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
  private JTextField display = new JTextField();
  private JButton[] buttons = new JButton[19];
  private String[] labels = { "Backspace", "CE", "C", "+/-", "Sqrt", "7", "8", "9",
      "/", "Percent", "4", "5", "6", "*", "1/x", "1", "2", "3", "-", "=", "0", "+", "." };
  private double result = 0;
  private String operator = "=";
  private boolean startOfNumber = true;

  public Calculator() {
    setLayout(new BorderLayout());
    display.setPreferredSize(new Dimension(200, 50));
    display.setFont(new Font("Arial", Font.BOLD, 24));
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);
    add(display, BorderLayout.NORTH);
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(0, 5, 3, 3));
    for (int i = 0; i < labels.length; i++) {
      buttons[i] = new JButton(labels[i]);
      buttons[i].setFont(new Font("Arial", Font.BOLD, 14));
      p.add(buttons[i]);
      buttons[i].addActionListener(this);
    }
    add(p, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent evt) {
    String command = evt.getActionCommand();
    if (command.charAt(0) == 'C') {
      startOfNumber = true;
      result = 0;
      operator = "=";
      display.setText("");
    } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
      if (startOfNumber == true)
        display.setText(command);
      else
        display.setText(display.getText() + command);
      startOfNumber = false;
    } else {
      if (startOfNumber) {
        if (command.equals("=")) {
          display.setText(command);
          startOfNumber = true;
        } else
          operator = command;
      } else {
        double x = Double.parseDouble(display.getText());
        calculate(x);
        operator = command;
        startOfNumber = true;
      }
    }
  }

  private void calculate(double n) {
      switch (operator) {
          case "+":
              result += n;
              break;
          case "-":
              result -= n;
              break;
          case "*":
              result *= n;
              break;
          case "/":
              result /= n;
              break;
          case "=":
              result = n;
              break;
          default:
              break;
      }
display.setText("" + result);
}

public static void main(String[] args) {
JFrame frame = new Calculator();
frame.setTitle("Calculator");
frame.setSize(250, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}


