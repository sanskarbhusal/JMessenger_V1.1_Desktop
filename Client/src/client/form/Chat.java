package client.form;

import client.component.*;
import client.event.EventChat;
import client.event.PublicEvent;
import client.util.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {

   public Chat() {
      initComponents();
      init();
   }

   public void init() {
      setLayout(new MigLayout("fillx", "0[fill]0", "0[65!]0[fill,100%]0[shrink 0]0"));
      Chat_Title chatTitle = new Chat_Title();
      Chat_Body chatBody = new Chat_Body();
      Chat_Bottom chatBottom = new Chat_Bottom();
      PublicEvent.getInstance().addEventChat(new EventChat() {
         public void showChat() {
            chatBody.clean();
            add(chatTitle, "wrap,growy");
            add(chatBody, "wrap,growy");
            add(chatBottom, "h ::40%");
         }

         @Override
         public void sendMessage(String dest_id, String message) {
            try {
               Home.out.write(dest_id);
               Home.out.newLine();
               Home.out.write(message);
               Home.out.newLine();
               Home.out.flush(); 
               Database.addToMessages(dest_id, message, "sent");
               Database.addToChatList(dest_id, message);
               Home.menuLeft.showChatList();
               chatBody.addItemRight(message);
            } catch (IOException e) {
               System.err.println("Chat Relay Server went offline! Retrying to connect.");
               Home.connectToChatRelayServer();
            }

         }

         public void receiveMessage(String sender_id, String message) {
            try {
               Thread.sleep(100);
            } catch (InterruptedException ex) {
               Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
            Database.addToChatList(sender_id, message);
            Database.addToMessages(sender_id, message, "received");
            Home.menuLeft.showChatList();
            chatBody.addItemLeft(message);

         }

         public void setTitle(String text) {
            chatTitle.setText(text);
         }

         public Chat_Body getChatBody() {
            return chatBody;
         }
      });
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
