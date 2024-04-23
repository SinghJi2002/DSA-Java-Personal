import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator1 extends JFrame implements ActionListener {
    JTextField num1TextField, num2TextField, resultTextField;
    JButton sum1, sub1, multi1, closeButton, nextButton, previousButton;
    int num1, num2, result;
    int currentPage = 1;
    public Calculator1() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        resultTextField = new JTextField(10);
        resultTextField.setEditable(false);
        sum1 = new JButton("Sum");
        sub1 = new JButton("Subtract");
        multi1 = new JButton("Multiply");
        closeButton = new JButton("Close");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        sum1.addActionListener(this);
        sub1.addActionListener(this);
        multi1.addActionListener(this);
        closeButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        add(new JLabel("First Number: "));
        add(num1TextField);
        add(new JLabel("Second Number: "));
        add(num2TextField);
        add(new JLabel("Result: "));
        add(resultTextField);
        add(sum1);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (currentPage == 1) {
            if (ae.getSource() == sum1) {
                num1 = Integer.parseInt(num1TextField.getText());
                num2 = Integer.parseInt(num2TextField.getText());
                result = num1 + num2;
                resultTextField.setText(String.valueOf(result));
                add(new JLabel("Name: SAGAR KUMAR"));
                add(nextButton);
                currentPage++;
                validate();
            }
        } else if (currentPage == 2) {
            if (ae.getSource() == nextButton) {
                remove(sum1);
                remove(nextButton);
                add(new JLabel("Roll: 22053012"));
                add(sub1);
                add(previousButton);
                add(nextButton);
                currentPage++;
                validate();
            }
            if (ae.getSource() == previousButton) {
                remove(new JLabel("Roll: 22053012"));
                remove(sub1);
                remove(previousButton);
                add(sum1);
                add(nextButton);
                currentPage--;
                validate();
            }
        } else if (currentPage == 3) {
            if (ae.getSource() == nextButton) {
                remove(sub1);
                remove(previousButton);
                add(new JLabel("Section: CSE12"));
                add(multi1);
                add(previousButton);
                add(closeButton);
                currentPage++;
                validate();
            }
            if (ae.getSource() == previousButton) {
                remove(new JLabel("Section: CSE12"));
                remove(multi1);
                remove(previousButton);
                add(sub1);
                add(previousButton);
                currentPage--;
                validate();
            }
        }
        if (ae.getSource() == sub1) {
            num1 = Integer.parseInt(num1TextField.getText());
            num2 = Integer.parseInt(num2TextField.getText());
            result = num1 - num2;
            resultTextField.setText(String.valueOf(result));
        } else if (ae.getSource() == multi1) {
            num1 = Integer.parseInt(num1TextField.getText());
            num2 = Integer.parseInt(num2TextField.getText());
            result = num1 * num2;
            resultTextField.setText(String.valueOf(result));
        } else if (ae.getSource() == closeButton) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Calculator1();
    }
}
/*
<html>
<applet code="Calculator1.class" width="400" height="300">
</applet>
</html>
*/