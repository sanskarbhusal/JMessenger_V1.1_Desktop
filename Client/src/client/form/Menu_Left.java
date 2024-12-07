package client.form;

import client.component.Item_People;
import client.component.Theme;
import client.login.Account;
import client.swing.ScrollBar;
import client.util.Database;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.concurrent.ConcurrentLinkedDeque;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

   public Menu_Left() {
      initComponents();
      init();
      menu.setBackground(Theme.getTheme());
      search.setBackground(Theme.getTheme());
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
      sp.setVerticalScrollBar(new ScrollBar(new Color(255, 255, 255)));
      menuList.setLayout(new MigLayout("fillx", "0[fill,100%]0", "0[]0"));
      showChatList();
      search.setForeground(Color.GRAY);
   }

   public void showChatList() {
      menuList.removeAll();
      menuList.revalidate();
      menuList.repaint();
      ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> chatList;
      chatList = Database.getChatList();

      for (SimpleImmutableEntry<String, String> entry : chatList) {
         menuList.add(new Item_People(entry.getKey(), entry.getValue()), "wrap");
      }
      menuList.revalidate();
      menuList.repaint();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      menu = new javax.swing.JLayeredPane();
      jButton2 = new javax.swing.JButton();
      search = new client.swing.TextFieldRounded();
      sp = new javax.swing.JScrollPane();
      menuList = new javax.swing.JLayeredPane();
      Chats = new javax.swing.JLabel();

      setBackground(new java.awt.Color(255, 255, 255));
      setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(235, 235, 235)));

      menu.setBackground(new java.awt.Color(255, 255, 255));

      jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/search_people.png"))); // NOI18N
      jButton2.setBorder(null);
      jButton2.setBorderPainted(false);
      jButton2.setContentAreaFilled(false);
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      search.setForeground(new java.awt.Color(204, 204, 204));
      search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      search.setText("Search");
      search.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            searchMouseClicked(evt);
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {
            searchMouseExited(evt);
         }
      });

      menu.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
      menu.setLayer(search, javax.swing.JLayeredPane.DEFAULT_LAYER);

      javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
      menu.setLayout(menuLayout);
      menuLayout.setHorizontalGroup(
         menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      menuLayout.setVerticalGroup(
         menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(menuLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10))
      );

      sp.setBackground(new java.awt.Color(235, 235, 235));
      sp.setBorder(null);
      sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      menuList.setBackground(new java.awt.Color(255, 255, 255));
      menuList.setOpaque(true);

      javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
      menuList.setLayout(menuListLayout);
      menuListLayout.setHorizontalGroup(
         menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 310, Short.MAX_VALUE)
      );
      menuListLayout.setVerticalGroup(
         menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 504, Short.MAX_VALUE)
      );

      sp.setViewportView(menuList);

      Chats.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
      Chats.setText("Chats");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
         .addComponent(menu)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(Chats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(Chats, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
            .addGap(0, 0, 0))
      );
   }// </editor-fold>//GEN-END:initComponents

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
       if (search.getText().equals("")) {
          search.setForeground(Color.GRAY);
          search.setHorizontalAlignment(JTextField.CENTER);
          search.setText("Search");

       }
    }//GEN-LAST:event_searchMouseExited

   private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
      if (search.getText().equals("Search")) {
         search.setEditable(true);
         // search.setFont(new Font("Segoe UI", Font.PLAIN, 17)); //I put here just in case I need it later
         search.setText(""); // Clear the placeholder text when focused
         search.setHorizontalAlignment(JTextField.LEFT);
         search.setForeground(Color.BLACK); // Set text color to black when typing
      }
   }//GEN-LAST:event_searchMouseClicked

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String searched_id = search.getText().trim();
      String isNewChat = "true";
      String accountAvailable = Account.findAccount(searched_id);
      ConcurrentLinkedDeque<SimpleImmutableEntry<String, String>> chatList;
      chatList = Database.getChatList();
      if (accountAvailable.equalsIgnoreCase("true")) {
         for (SimpleImmutableEntry<String, String> entry : chatList) {
            if (entry.getKey().equals(searched_id)) {
               isNewChat = "false";
               break;
            }
         }
         if (isNewChat.equals("true")) {
            Database.addToChatList(searched_id, "new");
            Database.addToMessages(searched_id, "new", "sent");
            Database.addToMessages(searched_id, "new", "received");
            showChatList();
         }

      }
   }//GEN-LAST:event_jButton2ActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel Chats;
   private javax.swing.JButton jButton2;
   private javax.swing.JLayeredPane menu;
   private javax.swing.JLayeredPane menuList;
   private client.swing.TextFieldRounded search;
   private javax.swing.JScrollPane sp;
   // End of variables declaration//GEN-END:variables
}
