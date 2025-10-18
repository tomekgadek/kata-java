import java.awt.Dimension;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;
 
class Frame extends JFrame {
    public Frame() {
        super("Przyklad logowania");
 
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}


class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
