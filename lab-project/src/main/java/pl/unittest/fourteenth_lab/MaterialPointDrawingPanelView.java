package pl.unittest.fourteenth_lab;

import javax.swing.*;
import java.awt.*;

public class MaterialPointDrawingPanelView extends JPanel {

    // TODO: Zamienic na enum
    public static final int SCALE_LINEAR = 1;
    public static final int SCALE_LOG = 2;

    private int scaleMode = SCALE_LINEAR;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.BLACK);
        g2d.drawLine(width / 2, 0, width / 2, height);
        g2d.drawLine(0, height / 2, width, height / 2);
    }

    public void setScaleMode(int scaleMode) {
        this.scaleMode = scaleMode;
    }
}
