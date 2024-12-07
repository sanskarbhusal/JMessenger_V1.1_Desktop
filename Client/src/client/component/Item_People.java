package client.component;

import client.event.PublicEvent;
import client.util.Database;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Item_People extends javax.swing.JPanel {

   public Item_People(String name, String recent_message) {
      initComponents();
      item_people_label.setText(name);
      message_peek.setText(recent_message);
      Theme.setTheme(getBackground());
      init();
   }

   @Override
   protected void paintComponent(Graphics g) {
      // Enable antialiasing for text rendering
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

      // Call the superclass method to paint components
   }

   private void init() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent me) {
            setBackground(new Color(58, 103, 176));
            item_people_label.setForeground(new Color(255, 255, 255));
            message_peek.setForeground(new Color(255, 255, 255));
         }

         @Override
         public void mouseExited(MouseEvent me) {
            setBackground(Theme.getTheme());
            item_people_label.setForeground(Color.BLACK);
            message_peek.setForeground(Color.gray);
         }

         @Override
         public void mouseClicked(MouseEvent evt) {
            PublicEvent.getInstance().getEventChat().showChat();
            String id = item_people_label.getText();
            PublicEvent.getInstance().getEventChat().setTitle(id);
            ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> msg_history = new ConcurrentLinkedDeque<>();
            msg_history = Database.getMessages().get(id);
            for (SimpleImmutableEntry<String, String> entry : msg_history) {
               String temp = entry.getKey();
               switch (temp) {
                  case "sent" ->
                     PublicEvent.getInstance().getEventChat().getChatBody().addItemRight(entry.getValue());
                  case "received" ->
                     PublicEvent.getInstance().getEventChat().getChatBody().addItemLeft(entry.getValue());
                  case "new" ->
                     PublicEvent.getInstance().getEventChat().getChatBody().addItemRight(entry.getValue());
                  default ->
                     System.out.println("Error while reading messages database, probably corrupted!");
               }
            }
         }
      });

   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new client.swing.ImageAvatar();
        item_people_label = new javax.swing.JLabel();
        message_peek = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(240, 62));

        imageAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderColor(new java.awt.Color(51, 153, 255));
        imageAvatar1.setBorderSize(1);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/client/resources/profile2.png"))); // NOI18N

        item_people_label.setBackground(new java.awt.Color(255, 255, 255));
        item_people_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        item_people_label.setForeground(new java.awt.Color(0, 0, 0));
        item_people_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        item_people_label.setText("People");

        message_peek.setBackground(new java.awt.Color(255, 255, 255));
        message_peek.setForeground(new java.awt.Color(153, 153, 153));
        message_peek.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_people_label, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(message_peek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(item_people_label, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(message_peek)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private client.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel item_people_label;
    private javax.swing.JLabel message_peek;
    // End of variables declaration//GEN-END:variables
}
