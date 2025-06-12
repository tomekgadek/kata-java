package pl.unittest.fourteenth_lab;

import javax.swing.*;
import java.awt.*;

public class MassView extends JFrame {

    public MassView() {
        setTitle("Wykres punktów materialnych");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(500, 150));
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
