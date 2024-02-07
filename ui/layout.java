/** Sposoby rozmieszczania elementów wewnątrz ramki. */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.GridLayout;

class Window extends JFrame {

    Window() {
        super("Buttons");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocation(100, 100);

        // rozmieszczenie elementów w postaci siatki, 2 wiersze i 6 kolumn
        // vgap i hgap to odstępy pomiędzy komórkami w pionie i poziomie wewnątrz siatki
        setLayout(new GridLayout(2, 6, 10, 10));

        // rozmieszczenie elementów jeden obok drugiego w linii, a gdy brakuje miejsca, przechodzą do kolejnego wiersza
        //setLayout(new FlowLayout(FlowLayout.CENTER, 1, 5));
        setVisible(true);

        for(int i = 0; i < 11; i++) {
            add(new JButton(String.format("Button %d", i+1)));
        }
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
