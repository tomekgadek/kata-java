/** Pierwsze okienko. */

import javax.swing.JFrame;
import java.awt.EventQueue;

class FirstWindow extends JFrame {

    FirstWindow() {
        super("My first window");
        pack();
        setVisible(true);
        setLocation(100, 100);
        setSize(800, 600);
    }

}

class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstWindow();
            } 
        });
    }
}
