package client.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;

/**
 *
 * @author Sanskar
 */
public class GradientLoginPanel extends javax.swing.JPanel {

    public GradientLoginPanel() {

        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Define start and end points for the gradient
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(width, height);
        Color color1 = new Color(68, 112, 187);
        Color color2 = new Color(248, 215, 93);
        // Create a linear gradient paint
        LinearGradientPaint gradient = new LinearGradientPaint(start, end,
                new float[]{0.0f, 1.0f},
                new Color[]{color1, color2});

        // Set the paint to use for this Graphics2D context
        g2d.setPaint(gradient);

        // Fill the entire area of the frame with the gradient
        g2d.fillRect(0, 0, width, height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
