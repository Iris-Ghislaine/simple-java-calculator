package com.mycompany.thursday;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculations {
 


    private static double number1 = 0;
    private static double number2 = 0;
    private static String operator = "";

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());

        JPanel pannel = new JPanel(new GridLayout(7, 3));
        JLabel simple=new JLabel("SIMPLE");
        simple.setFont(simple.getFont().deriveFont(Font.BOLD, 16f));
        pannel.add(simple);
        JLabel calculator=new JLabel("CALCULATOR");
        calculator.setFont(simple.getFont().deriveFont(Font.BOLD, 16f));
        pannel.add(calculator);
        JLabel system=new JLabel("SYSTEM");
        system.setFont(simple.getFont().deriveFont(Font.BOLD, 16f));
        pannel.add(system);
        JLabel num1 = new JLabel("Number1:");
        pannel.add(num1);
        JLabel num2 = new JLabel("Number2:");
        pannel.add(num2);
        JLabel answers = new JLabel("ANSWERS:");
        pannel.add(answers);
        JTextField numtf1 = new JTextField();
        pannel.add(numtf1);
        JTextField numtf2 = new JTextField();
        pannel.add(numtf2);
        JTextField anstf3 = new JTextField();
        pannel.add(anstf3);
        anstf3.setEditable(false);  // Answer field should not be editable

        // Number buttons
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");

        // Operation buttons
        JButton multiplyBtn = new JButton("x");
        JButton divideBtn = new JButton("/");
        JButton subtractBtn = new JButton("-");
        JButton modBtn = new JButton("%");

        pannel.add(one);
        pannel.add(two);
        pannel.add(multiplyBtn);
        pannel.add(three);
        pannel.add(four);
        pannel.add(divideBtn);
        pannel.add(five);
        pannel.add(six);
        pannel.add(subtractBtn);
        pannel.add(seven);
        pannel.add(eight);
        pannel.add(modBtn);

        f.add(pannel, BorderLayout.CENTER);
        f.setSize(370, 350);
        f.setVisible(true);

        // Adding listeners for number buttons
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                if (operator.isEmpty()) {
                    numtf1.setText(numtf1.getText() + source.getText());  // Set first number
                } else {
                    numtf2.setText(numtf2.getText() + source.getText());  // Set second number
                    number2 = Double.parseDouble(numtf2.getText());
                    performOperation(anstf3);  // Perform the operation after setting number2
                }
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

        // Adding listeners for operator buttons
        ActionListener operatorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                operator = source.getText();
                number1 = Double.parseDouble(numtf1.getText());  // Store first number
                numtf2.setText("");  // Clear the second number field
            }
        };

        multiplyBtn.addActionListener(operatorListener);
        divideBtn.addActionListener(operatorListener);
        subtractBtn.addActionListener(operatorListener);
        modBtn.addActionListener(operatorListener);
    }

    // Method to perform the calculation
    private static void performOperation(JTextField tf3) {
        double result = 0;
        switch (operator) {
            case "x":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "%":
                result = number1 % number2;
                break;
        }
        tf3.setText(String.valueOf(result));  // Display result in the answers field
    }
}
    

