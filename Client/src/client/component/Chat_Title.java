package client.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Chat_Title extends javax.swing.JPanel {
public static String id;
    public Chat_Title() {
        initComponents();
        setBackground(Theme.getTheme());

    }

    @Override
    protected void paintComponent(Graphics g) {
        // Enable antialiasing for text rendering
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    }
public void setText(String text){
   id=text;
   chat_title_id.setText(text);
    
    
}
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      imageAvatar1 = new client.swing.ImageAvatar();
      chat_title_id = new javax.swing.JLabel();

      setBackground(new java.awt.Color(255, 255, 255));
      setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(237, 237, 237)));
      setPreferredSize(new java.awt.Dimension(399, 58));
      addAncestorListener(new javax.swing.event.AncestorListener() {
         public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            formAncestorAdded(evt);
         }
         public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
         }
         public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
         }
      });

      imageAvatar1.setBorderColor(new java.awt.Color(36, 198, 249));
      imageAvatar1.setBorderSize(1);
      imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/client/resources/profile2.png"))); // NOI18N
      imageAvatar1.setPreferredSize(new java.awt.Dimension(399, 58));

      chat_title_id.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(chat_title_id, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(224, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(8, 8, 8)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(chat_title_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel chat_title_id;
   private client.swing.ImageAvatar imageAvatar1;
   // End of variables declaration//GEN-END:variables
}
