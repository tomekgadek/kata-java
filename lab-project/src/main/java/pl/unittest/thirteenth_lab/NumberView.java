package pl.unittest.thirteenth_lab;

import javax.swing.*;
import java.awt.*;

class NumberView extends JFrame {
    private final JButton incrementButton = new JButton("Zwiększ licznik");
    private final JLabel counterLabel = new JLabel("Licznik: 0");

    public NumberView() {
        setTitle("MVC - Swing Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(incrementButton);
        add(counterLabel);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setCounterText(String text) {
        counterLabel.setText(text);
    }

    public JButton getIncrementButton() {
        return incrementButton;
    }
}

