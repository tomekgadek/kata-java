/** Animacja piłki. */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ball {
    private Image ball;
    private int x;
    private int y;

    Ball() {
        ImageIcon ballIcon = new ImageIcon("../static/ui_file_002.png");
        ball = ballIcon.getImage();
        this.x = -45;
        this.y = -45;
    }

    Image loadImage() {
        return this.ball;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void top(int value) {
        this.y -= value;
    }

    void bottom(int value) {
        this.y += value;
    }

    void left(int value) {
        this.x -= x;
    }

    void right(int value) {
        this.x += value;
    }
}

class BoardPanel extends JPanel implements ActionListener {

    private static final int DELAY = 10;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Ball ball;
    private Timer timer;

    BoardPanel(final Ball ball) {
        this.ball = ball;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDoubleBuffered(true);

        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(ball.loadImage(), ball.getX(), ball.getY(), this);
        Toolkit.getDefaultToolkit().sync();
    }

    public void actionPerformed(ActionEvent e) {
        
        ball.bottom(1);
        ball.right(1);

        if(ball.getY() > HEIGHT) {
            ball = new Ball();
        }

        repaint();
    }
}


class Window extends JFrame {

    Window() {

        add(new BoardPanel(new Ball()));

        setTitle("Ball animation");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
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