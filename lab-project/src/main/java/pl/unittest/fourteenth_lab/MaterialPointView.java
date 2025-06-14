package pl.unittest.fourteenth_lab;

import javax.swing.*;
import java.awt.*;

public class MaterialPointView extends JFrame {

    private final MaterialPointDrawingPanelView drawingPanelView;
    private final JButton linearScaleButton;
    private final JButton logScaleButton;

    public MaterialPointView(MaterialPointDrawingPanelView drawingPanelView) {
        this.drawingPanelView = drawingPanelView;

        setTitle("MATERIAL POINTS POSITION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        linearScaleButton = new JButton("skala liniowa");
        logScaleButton = new JButton("skala logarytmiczna");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(linearScaleButton);
        buttonPanel.add(logScaleButton);

        add(drawingPanelView, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getLinearScaleButton() {
        return this.linearScaleButton;
    }

    public JButton getLogScaleButton() {
        return this.logScaleButton;
    }

    public void setLogScale(boolean logScale) {
        this.drawingPanelView.setLogScale(logScale);
    }
}
