package client.event;

import client.component.Chat_Body;


public interface EventChat {

   public void sendMessage(String dest_id,String message);

   public void receiveMessage(String sender_id,String message);

   public void setTitle(String text);

   public void showChat();
   public Chat_Body getChatBody();

}
