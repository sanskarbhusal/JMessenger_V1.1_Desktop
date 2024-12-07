package client.main;

import client.login.PasswordManager;
import client.swing.ComponentResizer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

   private boolean maximized = false;

   public Main() {
      initComponents();
      init();
   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

      super.paint(g);

      int width = getWidth();
      int height = getHeight();

      // Define gradient start and end points
      Point2D start = new Point2D.Float(0, 0);
      Point2D end = new Point2D.Float(width, height);

      // Define colors for the gradient
      Color color1 = new Color(248, 215, 93); // Start color
      Color color2 = new Color(68, 112, 187); // End color

      // Create a gradient paint for stroke
      GradientPaint gradient = new GradientPaint(start, color1, end, color2);

      // Set the paint to the graphics context of the component
      g2d.setPaint(gradient);

      // Set stroke thickness
      g2d.setStroke(new BasicStroke(2)); // Adjust thickness as needed

      // Draw the rectangle outline with the gradient stroke
      g2d.drawRect(0, 0, width, height); // Adjust coordinates to fit within the component bounds

   }

   @Override
   public Insets getInsets() {
      int borderWidth = 2;  // Example border width
      return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
   }

   private void init() {
      setIconImage(new ImageIcon(getClass().getResource("/client/resources/logo.png")).getImage());
      ComponentResizer com = new ComponentResizer();
      com.registerComponent(this);
      com.setMinimumSize(new Dimension(900, 600));
      com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
      com.setSnapSize(new Dimension(1, 1));

   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      sidePanel = new javax.swing.JPanel();
      jButton3 = new javax.swing.JButton();
      frameTitle = new javax.swing.JPanel();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      home1 = new client.form.Home();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setBackground(new java.awt.Color(255, 255, 255));
      setUndecorated(true);

      sidePanel.setBackground(new java.awt.Color(247, 247, 246));
      sidePanel.setPreferredSize(new java.awt.Dimension(30, 0));

      jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/logout.png"))); // NOI18N
      jButton3.setBorder(null);
      jButton3.setContentAreaFilled(false);
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
      sidePanel.setLayout(sidePanelLayout);
      sidePanelLayout.setHorizontalGroup(
         sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      sidePanelLayout.setVerticalGroup(
         sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
            .addContainerGap(507, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14))
      );

      frameTitle.setBackground(new java.awt.Color(247, 247, 246));
      frameTitle.setPreferredSize(new java.awt.Dimension(1111, 32));
      frameTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
         public void mouseDragged(java.awt.event.MouseEvent evt) {
            frameTitleMouseDragged(evt);
         }
      });
      frameTitle.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            frameTitleMouseClicked(evt);
         }
         public void mousePressed(java.awt.event.MouseEvent evt) {
            frameTitleMousePressed(evt);
         }
      });

      jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/minimize.png"))); // NOI18N
      jButton1.setBorder(null);
      jButton1.setBorderPainted(false);
      jButton1.setContentAreaFilled(false);
      jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton1MouseEntered(evt);
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton1MouseExited(evt);
         }
      });
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/close.png"))); // NOI18N
      jButton2.setBorder(null);
      jButton2.setBorderPainted(false);
      jButton2.setContentAreaFilled(false);
      jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton2MouseEntered(evt);
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton2MouseExited(evt);
         }
      });
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/logo.png"))); // NOI18N

      jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(59, 102, 176));
      jLabel1.setText("Java");

      jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(255, 189, 0));
      jLabel2.setText("Messenger");

      javax.swing.GroupLayout frameTitleLayout = new javax.swing.GroupLayout(frameTitle);
      frameTitle.setLayout(frameTitleLayout);
      frameTitleLayout.setHorizontalGroup(
         frameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(frameTitleLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jLabel3)
            .addGap(8, 8, 8)
            .addComponent(jLabel1)
            .addGap(0, 0, 0)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
      );
      frameTitleLayout.setVerticalGroup(
         frameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameTitleLayout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel3)
            .addGap(2, 2, 2))
         .addGroup(frameTitleLayout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(4, 4, 4))
         .addGroup(frameTitleLayout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(4, 4, 4))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameTitleLayout.createSequentialGroup()
            .addGroup(frameTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(frameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(home1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
               .addComponent(home1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void frameTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameTitleMousePressed
       pX = evt.getX();
       pY = evt.getY();
    }//GEN-LAST:event_frameTitleMousePressed

    private void frameTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameTitleMouseDragged
       setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_frameTitleMouseDragged

    private void frameTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameTitleMouseClicked

       if (evt.getClickCount() == 2) {
          if (maximized) {
             // Restore to normal size
             setExtendedState(NORMAL);

             maximized = false;
          } else {
             // Maximize the frame
             setExtendedState(MAXIMIZED_BOTH);
             maximized = true;
          }
       }

    }//GEN-LAST:event_frameTitleMouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
       jButton2.setOpaque(true);
       jButton2.setBackground(Color.RED);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
       jButton2.setOpaque(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
       jButton1.setOpaque(true);
       jButton1.setBackground(Color.GRAY);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
       jButton1.setOpaque(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
          PasswordManager.removeSavedAccount();
          System.exit(0);
       } else {
          // Handle dialog closing (if needed)
       }

    }//GEN-LAST:event_jButton3ActionPerformed
   private int pX;
   private int pY;

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {

      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Main().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPanel frameTitle;
   private client.form.Home home1;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel sidePanel;
   // End of variables declaration//GEN-END:variables
}
