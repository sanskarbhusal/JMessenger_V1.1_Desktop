package client.component;

import client.event.PublicEvent;
import client.swing.JIMSendTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;

public class Chat_Bottom extends javax.swing.JPanel {

   public static String message;

   public Chat_Bottom() {
      initComponents();
      init();
   }

   private void init() {
      setLayout(new MigLayout("fillx, filly", "0[fill]0[]0[]0", "2[fill]2"));
      setBackground(Color.WHITE);
      JScrollPane scroll = new JScrollPane();
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
      scroll.setBorder(null);
      JIMSendTextPane txt = new JIMSendTextPane();
      txt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
      txt.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent ke) {
            refresh();
         }
      });
      txt.setHintText("Type a message");
      scroll.setViewportView(txt);
      JPanel send_button_panel = new JPanel();
      send_button_panel.setLayout(new MigLayout("filly", "0[]0", "0[bottom]0"));
      send_button_panel.setBackground(Color.WHITE);
      JButton send_button = new JButton();
      send_button.setContentAreaFilled(false);
      send_button.setBorder(null);
      send_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
      send_button.setIcon(new ImageIcon(getClass().getResource("/client/resources/send.png")));
      send_button.setPreferredSize(new Dimension(90, 45));
      txt.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               message = txt.getText().trim();
               if (!message.equals("")) {
                  //add chat item
                  PublicEvent.getInstance().getEventChat().sendMessage(Chat_Title.id, message);
                  txt.setText("");
                  txt.grabFocus();
                  refresh();
               } else {
                  txt.grabFocus();
               }
            }
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }
      });
      send_button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            message = txt.getText().trim();
            if (!message.equals("")) {
               //add chat item
               PublicEvent.getInstance().getEventChat().sendMessage(Chat_Title.id, message);
               txt.setText("");
               txt.grabFocus();
               refresh();
            } else {
               txt.grabFocus();
            }
         }
      });
      send_button_panel.add(send_button);
      add(scroll, "w 100%");
      add(send_button_panel);

   }

   private void refresh() {
      repaint();
      revalidate();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(237, 237, 237)));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 404, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 49, Short.MAX_VALUE)
      );
   }// </editor-fold>//GEN-END:initComponents


   // Variables declaration - do not modify//GEN-BEGIN:variables
   // End of variables declaration//GEN-END:variables
}
