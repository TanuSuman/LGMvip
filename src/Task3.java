import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Task3 extends JFrame implements ActionListener {
    private JTextField displayField;
    private boolean isNewInput = true;
    private String currentOperator = "";
    private double currentOperand = 0.0;

    public Task3() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.PLAIN, 20));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "+", "C",
                "4", "5", "6", "-", "√",
                "1", "2", "3", "*", "^",
                "0", ".", "=", "/", "log",
                "sin", "cos", "tan", "(", ")"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNewInput) {
            displayField.setText("");
            isNewInput = false;
        }

        if ("0123456789.".contains(command)) {
            displayField.setText(displayField.getText() + command);
        } else if ("+-*/".contains(command)) {
            currentOperator = command;
            currentOperand = Double.parseDouble(displayField.getText());
            isNewInput = true;
        } else if ("√^log".contains(command)) {
            double operand = Double.parseDouble(displayField.getText());
            double result = 0.0;

            switch (command) {
                case "√":
                    result = Math.sqrt(operand);
                    break;
                case "^":
                    result = Math.pow(currentOperand, operand);
                    break;
                case "log":
                    result = Math.log10(operand);
                    break;
            }

            displayField.setText(formatResult(result));
            isNewInput = true;
        } else if ("sin cos tan".contains(command)) {
            double operand = Double.parseDouble(displayField.getText());
            double result = 0.0;

            switch (command) {
                case "sin":
                    result = Math.sin(Math.toRadians(operand));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(operand));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(operand));
                    break;
            }

            displayField.setText(formatResult(result));
            isNewInput = true;
        } else if ("()".contains(command)) {
            displayField.setText(displayField.getText() + command);
        } else if ("C".equals(command)) {
            displayField.setText("");
            currentOperator = "";
            currentOperand = 0.0;
            isNewInput = true;
        } else if ("=".equals(command)) {
            double operand = Double.parseDouble(displayField.getText());
            double result = 0.0;

            switch (currentOperator) {
                case "+":
                    result = currentOperand + operand;
                    break;
                case "-":
                    result = currentOperand - operand;
                    break;
                case "*":
                    result = currentOperand * operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result = currentOperand / operand;
                    } else {
                        displayField.setText("Error");
                        isNewInput = true;
                    }
                    break;
            }

            displayField.setText(formatResult(result));
            isNewInput = true;
        }
    }

    private String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.######");
        return df.format(result);
    }

    public static void main(String[] args) {
        new Task3();
    }
}
