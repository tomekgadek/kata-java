package pl.unittest.thirteenth_lab;

import javax.swing.*;
import java.awt.*;

class NumberView extends JFrame {
    private final JTextField numberField = new JTextField(10);
    private final JButton reverseButton = new JButton("Zapisz wspak");
    private final JButton octalButton = new JButton("Zamień na ósemkowy");
    private final JButton clearButton = new JButton("Wyczyść");
    private final JLabel resultLabel = new JLabel("Wynik operacji:");
    private final JLabel outputLabel = new JLabel("");

    public NumberView() {
        setTitle("Number Processor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Wprowadź liczbę:"));
        topPanel.add(numberField);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(resultLabel);
        centerPanel.add(outputLabel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3, 5, 5));
        bottomPanel.add(reverseButton);
        bottomPanel.add(octalButton);
        bottomPanel.add(clearButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setMinimumSize(new Dimension(500, 150));
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public JButton getReverseButton() {
        return reverseButton;
    }

    public JButton getOctalButton() {
        return octalButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JLabel getOutputText() {
        return outputLabel;
    }
}

