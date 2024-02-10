/** Wykorzystanie myszki w grafice 2D. */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MousePanel extends JPanel implements MouseListener {

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    private int x;
    private int y;
    private List<Point> points;

    MousePanel() {
        addMouseListener(this);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        points = new ArrayList<>();
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        points.add(new Point(x, y));
        repaint(); // odświeżenie obszaru, na którym renderowana jest grafika
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    // po odświeżenieu wywoływana jest metoda, która nanosi ponownie elementy graficzne
    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(1, 1, this.getWidth(), this.getHeight()-1);
        graphics.setColor(Color.BLACK);
        drawRectangles(graphics2d);
    }

    private void drawRectangles(Graphics2D graphics2d) {

        for(Point point: points) {
            graphics2d.fillRect((int) point.getX()-5, (int) point.getY()-5, 10, 10);
        }
    }
}

class Window extends JFrame {

    Window() {
        super("Mouse dots");

        add(new MousePanel());
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
