package client.component;

import client.swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.geom.Point2D;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;

public class Chat_Body extends javax.swing.JPanel {

   @Override
   protected void paintComponent(Graphics g) {

      Graphics2D g2d = (Graphics2D) g;
      int width = getWidth();
      int height = getHeight();

      // Define start and end points for the gradient
      Point2D start = new Point2D.Float(0, 0);
      Point2D end = new Point2D.Float(width, height);
      Color color1 = new Color(254, 248, 244);
      Color color2 = new Color(247, 247, 246);
      // Create a linear gradient paint
      LinearGradientPaint gradient = new LinearGradientPaint(start, end,
              new float[]{0.0f, 1.0f},
              new Color[]{color1, color2});

      // Set the paint to use for this Graphics2D context
      g2d.setPaint(gradient);

      // Fill the entire area of the frame with the gradient
      g2d.fillRect(0, 0, width, height);
   }

   public Chat_Body() {
      initComponents();
      init();
   }

   public void clean() {
      body.removeAll();
      revalidate();
      repaint();
   }

   private void init() {
      body.setLayout(new MigLayout("fillx", "25[]25", "10[]10"));
      sp.setVerticalScrollBar(new ScrollBar(body.getBackground()));
   }

   public void addItemLeft(String text) {
      Chat_Bubble left = new Chat_Bubble();
      left.setBubbleColor(new Color(255, 255, 255), new Color(230, 230, 230));
      left.setText(text, new Color(0, 0, 0));
      body.add(left, "wrap,w ::40%");
      body.repaint();//decomment later if needed
      body.revalidate(); //decomment later if needed
      scrollToBottom();

   }

   public void addItemRight(String text) {
      Chat_Bubble right = new Chat_Bubble();
      right.setBubbleColor(new Color(217, 252, 210), new Color(182, 217, 175));
      right.setText(text, new Color(0, 0, 0));
      body.add(right, "wrap,al right,w ::40%");
      body.repaint();//decomment later if needed
      body.revalidate(); //decomment later if needed
      scrollToBottom();
   }

   private void scrollToBottom() {
      JScrollBar verticalBar = sp.getVerticalScrollBar();
      AdjustmentListener downScroller = new AdjustmentListener() {
         @Override
         public void adjustmentValueChanged(AdjustmentEvent e) {
            Adjustable adjustable = e.getAdjustable();
            adjustable.setValue(adjustable.getMaximum());
            verticalBar.removeAdjustmentListener(this);
         }
      };
      verticalBar.addAdjustmentListener(downScroller);
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);

        body.setBackground(new java.awt.Color(247, 247, 246));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
