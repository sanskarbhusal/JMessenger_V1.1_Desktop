package client.login;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

   Register r;
   private String userId;
   private String password;

   public Login() {
      setUndecorated(true);
      initComponents();
      init();
   }

   void setInstance(Register r) {
      this.r = r;
   }

   Login getInstance() {
      return this;
   }

   private void init() {
      if (PasswordManager.getId() != null && PasswordManager.getPassword() != null) {
         id.setText(PasswordManager.getId());
         pass.setText(PasswordManager.getPassword());
      }
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      gradientLoginPanel1 = new client.component.GradientLoginPanel();
      jLabel1 = new javax.swing.JLabel();
      jPanel6 = new javax.swing.JPanel();
      idPanel = new javax.swing.JPanel();
      id = new javax.swing.JTextField();
      jLabel3 = new javax.swing.JLabel();
      passPanel1 = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      pass = new javax.swing.JPasswordField();
      jPanel1 = new javax.swing.JPanel();
      signin = new javax.swing.JButton();
      jPanel3 = new javax.swing.JPanel();
      register = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Login");
      setBackground(new java.awt.Color(255, 255, 255));
      setIconImage(getIconImage());
      setIconImages(null);
      setLocation(new java.awt.Point(0, 0));
      setResizable(false);
      setType(java.awt.Window.Type.POPUP);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(241, 199, 79));
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("Log in");

      jPanel6.setOpaque(false);
      jPanel6.setPreferredSize(new java.awt.Dimension(250, 140));

      idPanel.setOpaque(false);
      idPanel.setPreferredSize(new java.awt.Dimension(250, 55));

      id.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
      id.setPreferredSize(new java.awt.Dimension(68, 40));
      id.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            idActionPerformed(evt);
         }
      });

      jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(241, 199, 71));
      jLabel3.setText("Phone/Email");

      javax.swing.GroupLayout idPanelLayout = new javax.swing.GroupLayout(idPanel);
      idPanel.setLayout(idPanelLayout);
      idPanelLayout.setHorizontalGroup(
         idPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      idPanelLayout.setVerticalGroup(
         idPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(idPanelLayout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(3, 3, 3))
      );

      passPanel1.setOpaque(false);
      passPanel1.setPreferredSize(new java.awt.Dimension(250, 55));

      jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(241, 199, 79));
      jLabel2.setText("Password");

      pass.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
      pass.setPreferredSize(new java.awt.Dimension(68, 40));
      pass.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            passActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout passPanel1Layout = new javax.swing.GroupLayout(passPanel1);
      passPanel1.setLayout(passPanel1Layout);
      passPanel1Layout.setHorizontalGroup(
         passPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      passPanel1Layout.setVerticalGroup(
         passPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(passPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(0, 0, 0)
            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      jPanel1.setOpaque(false);

      signin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      signin.setForeground(new java.awt.Color(102, 0, 0));
      signin.setText("Log in");
      signin.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 40, 11, 40));
      signin.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            signinActionPerformed(evt);
         }
      });
      jPanel1.add(signin);

      jPanel3.setOpaque(false);

      register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      register.setForeground(new java.awt.Color(51, 102, 0));
      register.setText("Register");
      register.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 32, 11, 32));
      register.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            registerActionPerformed(evt);
         }
      });
      jPanel3.add(register);

      jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
      jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel4.setText("No account?");

      javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
      jPanel6.setLayout(jPanel6Layout);
      jPanel6Layout.setHorizontalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel6Layout.createSequentialGroup()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(passPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                  .addComponent(idPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE))
         .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      jPanel6Layout.setVerticalGroup(
         jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel6Layout.createSequentialGroup()
            .addComponent(idPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(passPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12))
      );

      jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/register.png"))); // NOI18N

      jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/resources/back_orange.png"))); // NOI18N
      jButton1.setBorder(null);
      jButton1.setContentAreaFilled(false);
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout gradientLoginPanel1Layout = new javax.swing.GroupLayout(gradientLoginPanel1);
      gradientLoginPanel1.setLayout(gradientLoginPanel1Layout);
      gradientLoginPanel1Layout.setHorizontalGroup(
         gradientLoginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
            .addGroup(gradientLoginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
                  .addGap(52, 52, 52)
                  .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel1)
                  .addGap(100, 100, 100)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addComponent(jLabel6))
      );
      gradientLoginPanel1Layout.setVerticalGroup(
         gradientLoginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
            .addGroup(gradientLoginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
               .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(46, 46, 46))
         .addGroup(gradientLoginPanel1Layout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(gradientLoginPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(gradientLoginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, Short.MAX_VALUE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
       userId = id.getText().trim();
       password = new String(pass.getPassword());
       String response = Account.isValid(userId, password);
       switch (response) {
          case "true":
                PasswordManager.remember(userId, password);
             dispose();
             new client.main.Main().setVisible(true);
             break;
          case "WRONG_PASSWORD":
             javax.swing.JOptionPane.showMessageDialog(this, "Wrong Password", "oops!", JOptionPane.ERROR_MESSAGE);
             break;
          case "NO_ACCOUNT":
             javax.swing.JOptionPane.showMessageDialog(this, "Wrong ID", "oops!", JOptionPane.WARNING_MESSAGE);
             break;
          default:
             System.out.println("Server responded with unknown message!");
             break;
       }
    }//GEN-LAST:event_signinActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
       if (r != null) {
          r.setVisible(true);
       } else {
          new Register().setInstance(this);
       }
       setVisible(false);
    }//GEN-LAST:event_registerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
          System.exit(0);
       } else {
          // Handle dialog closing (if needed)
       }
    }//GEN-LAST:event_jButton1ActionPerformed

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
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Login().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private client.component.GradientLoginPanel gradientLoginPanel1;
   private javax.swing.JTextField id;
   private javax.swing.JPanel idPanel;
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel6;
   private javax.swing.JPasswordField pass;
   private javax.swing.JPanel passPanel1;
   private javax.swing.JButton register;
   private javax.swing.JButton signin;
   // End of variables declaration//GEN-END:variables
}
