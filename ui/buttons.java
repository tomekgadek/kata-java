/** Obsługa przycisków. */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ButtonPanel extends JPanel implements ActionListener {

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;
    private JButton customColorButton;
    private JButton randomColorButton;

    private Random randomColor;

    private Color[] colors;

    ButtonPanel() {
        randomColor = new Random();

        colors = new Color[]{ Color.GREEN, Color.BLUE, Color.RED, this.prepareCustomColor() };

        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");
        customColorButton = new JButton("Custom");
        randomColorButton = new JButton("Random");

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        customColorButton.addActionListener(this);
        randomColorButton.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        add(greenButton);
        add(blueButton);
        add(redButton);
        add(customColorButton);
        add(randomColorButton);
    }
    
    // metoda reaguje na akcję kliknięcia w przycisk (button)
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if(source == greenButton) {
            setBackground(Color.GREEN);
        } else if(source == blueButton) {
            setBackground(Color.BLUE);
        } else if(source == redButton) {
            setBackground(Color.RED);
        } else if(source == customColorButton) {
            setBackground(this.prepareCustomColor());
        } else if(source == randomColorButton) {
            setBackground(colors[randomColor.nextInt(this.colors.length)]);
        }
    }

    private Color prepareCustomColor() {
        // możemy definiować własne kolory dodając składowe RGB
        return new Color(70, 10, 190);
    }
}

class Window extends JFrame {

    Window() {
        super("Test buttons");

        add(new ButtonPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}

class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Window(); // tworzymy okienko
            }
        });
    }
}
