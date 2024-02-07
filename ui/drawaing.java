/** Rysowanie figur geometrycznych. */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class FiguresPanel extends JPanel {
    
    FiguresPanel() {
        setPreferredSize(new Dimension(400, 400)); // ustalamy rozmiar panelu
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2d = (Graphics2D) graphics;

        Rectangle2D square = new Rectangle2D.Double(10, 10, 380, 380); // tworzymy kwadrat, pozycja (10, 10), wymiary (380, 380)
        Ellipse2D circle = new Ellipse2D.Double(10, 10, 380, 380); // tworzymy koło, pozycja (10, 10), wymiary (380, 380)

        graphics2d.setStroke(new BasicStroke(2.0F)); // ustalamy szerokość "flamastra"

        graphics2d.setPaint(Color.GRAY); // ustalamy kolor "flamastra"
        graphics2d.fill(square); // wypełniamy tło zadeklarowanym kolorem - GRAY
        
        graphics2d.setPaint(Color.DARK_GRAY); // ustalamy nowy kolor "flamastra" na DARK_GRAY
        graphics2d.draw(circle); // rysujemy koło
        graphics2d.draw(square); // rysujemy kwadrat
    }
}

class Window extends JFrame {

    Window() {
        super("Drawing figures");

        JPanel figuresPanel = new FiguresPanel();

        add(figuresPanel); // umieszczamy panel z figurami heometrycznymi w ramce

        pack(); // jeżeli ramka zawiera w sobie elementy to powinna dostosować rozmiar do zawartości
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
