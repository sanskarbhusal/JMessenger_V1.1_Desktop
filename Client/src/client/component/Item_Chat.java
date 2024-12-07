package client.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Item_Chat extends javax.swing.JLayeredPane {

    Color BUBBLE_COLOR;
    Color BUBBLE_BORDER_COLOR;

    public Item_Chat() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);

    }

    public void setText(String text, Color c) {
        txt.setText(text);
        txt.setForeground(c);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(BUBBLE_COLOR);
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        g2.setColor(BUBBLE_BORDER_COLOR);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new client.swing.JIMSendTextPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private client.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
