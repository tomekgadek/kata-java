package pl.unittest.fourteenth_lab;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MaterialPointDrawingPanelView extends JPanel {
    private final List<MaterialPoint> points;
    private boolean logScale = false;

    public MaterialPointDrawingPanelView(List<MaterialPoint> points) {
        this.points = points;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 600));
    }

    public void setLogScale(boolean logScale) {
        this.logScale = logScale;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();
        double maxMass = points.stream()
                .mapToDouble(p -> logScale ? Math.log(p.mass()) : p.mass())
                .max().orElse(1.0);

        double minX = points.stream().mapToDouble(MaterialPoint::x).min().orElse(0);
        double maxX = points.stream().mapToDouble(MaterialPoint::x).max().orElse(0);
        double minY = points.stream().mapToDouble(MaterialPoint::y).min().orElse(0);
        double maxY = points.stream().mapToDouble(MaterialPoint::y).max().orElse(0);

        // Calculate max point diameter
        double maxDiameter = maxMass > 0 ? 0.1 * Math.min(w, h) : 2.0;

        double rangeX = maxX - minX;
        double rangeY = maxY - minY;

        // Calculate padding based on range
        double padding = Math.max(rangeX, rangeY) * 0.1;

        // Adjust ranges with padding
        rangeX += 2 * padding;
        rangeY += 2 * padding;

        // Adjust scale to account for point sizes and padding
        double scaleX = (w - maxDiameter) / rangeX;
        double scaleY = (h - maxDiameter) / rangeY;
        double scale = Math.min(scaleX, scaleY);

        // Calculate offsets to center the drawing
        double offsetX = (w - (maxX + minX) * scale) / 2.0;
        double offsetY = (h + (maxY + minY) * scale) / 2.0;

        // Draw lines between points
        g2.setColor(Color.GRAY);
        for (int i = 0; i < points.size() - 1; i++) {
            int x1 = (int) (offsetX + points.get(i).x() * scale);
            int y1 = (int) (offsetY - points.get(i).y() * scale);
            int x2 = (int) (offsetX + points.get(i + 1).x() * scale);
            int y2 = (int) (offsetY - points.get(i + 1).y() * scale);
            g2.drawLine(x1, y1, x2, y2);
        }

        // Draw points
        for (MaterialPoint p : points) {
            double value = logScale ? (p.mass() > 0 ? Math.log(p.mass()) : 0.0) : p.mass();
            double diameter = maxMass > 0 ? (value / maxMass) * maxDiameter : 0;

            // Ensure minimum diameter
            diameter = Math.max(diameter, 2.0);

            int px = (int) (offsetX + p.x() * scale);
            int py = (int) (offsetY - p.y() * scale);
            int d = (int) diameter;

            g2.setColor(Color.RED);
            g2.fillOval(px - d / 2, py - d / 2, d, d);
            g2.setColor(Color.BLACK);
            g2.drawOval(px - d / 2, py - d / 2, d, d);
        }

        // Draw axes
        g2.setColor(Color.BLACK);
        g2.drawLine(0, (int) offsetY, w, (int) offsetY); // x-axis
        g2.drawLine((int) offsetX, 0, (int) offsetX, h); // y-axis
    }
}
