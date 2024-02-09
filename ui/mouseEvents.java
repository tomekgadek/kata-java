/** Zdarzenia myszy. */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MouseTestPanel extends JPanel implements MouseListener, MouseMotionListener {

    MouseTestPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);

        setPreferredSize(new Dimension(800, 600));
    }

    // kliknięcie myszką
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
    }

    // wciśnięcie myszki
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    // zwolnienie wciśniętej myszki
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
    }

    // pojawienie się wskaźniki myszki w obszarze panelu
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    // opuszczenie wskaźnika myszki z obszaru panelu
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
    }

    // wciśnięcie i przesunięcie wskaźnika myszki
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");
    }

    // ruch myszki w obszarze panelu
    public void mouseMoved(MouseEvent e) {
        System.out.println("Moved");
    }
}

class Window extends JFrame {

    Window() {
        super("Test mouse");

        add(new MouseTestPanel());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}

class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window();
            } 
        });
    }
}
