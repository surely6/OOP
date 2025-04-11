package KH;

import SL.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Login extends javax.swing.JFrame {
    

    public Login() {
        initComponents();
        getContentPane().setBackground(new Color(0x2a3935));    
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(256, 128));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Start3.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(211, 239, 233));
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(211, 239, 233));
        jLabel4.setText("Password: ");

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("Enter a password");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField2MouseReleased(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Enter a email");
        jTextField1.setToolTipText("");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField1MouseReleased(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(25, 113, 92));
        jButton1.setForeground(new java.awt.Color(211, 239, 233));
        jButton1.setText("Login");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        if (jTextField2.getText().equals("Enter a password") ||
            jTextField2.getText().equals("At least 8 character") ||
            jTextField2.getText().equals("Incorrect password")){
            jTextField2.setText("");
            jTextField2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        if (jTextField2.getText().equals("")){
            jTextField2.setForeground(Color.red);
            jTextField2.setText("Enter a password");
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
//        if (jTextField2.getText().equals("Enter a password") ||
//            jTextField2.getText().equals("At least 8 character") ||
//            jTextField2.getText().equals("Incorrect password")){
//            jTextField2.setText("");
//            jTextField2.setForeground(Color.BLACK);
//        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        if (jTextField2.getText().equals("Enter a password") ||
            jTextField2.getText().equals("At least 8 character") ||
            jTextField2.getText().equals("Incorrect password")){
            jTextField2.setText("");
            jTextField2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        if (jTextField1.getText().equals("")){
            jTextField1.setForeground(Color.red);
            jTextField1.setText("Enter a email");
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseReleased
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Enter a email") ||
            jTextField1.getText().equals("ID already exists") ||
            jTextField1.getText().equals("Not register")){
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField1MouseReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Enter a email") ){
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText();
        String password = jTextField2.getText();
        
        File lecInfo = new File("src\\TextFile\\lecturerInfo");
        ArrayList<String> idCheck = new ArrayList<String>();
        ArrayList<String> passCheck = new ArrayList<String>();
        ArrayList<String> nameShare = new ArrayList<String>();
        ArrayList<String> profCheck = new ArrayList<String>();
        
        
        try {
            if (!lecInfo.exists()){
                lecInfo.createNewFile();
            }
            Scanner myReader = new Scanner(lecInfo);
            while (myReader.hasNextLine()) {
                String info = myReader.nextLine();
                String idInfo[] = info.split(",");
                idCheck.add(idInfo[0]);
                passCheck.add(idInfo[1]);
                nameShare.add(idInfo[2]);
                profCheck.add(idInfo[3]);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        

        
        if (id.isEmpty() || id.equals("Enter a email")){
            jTextField1.setForeground(Color.red);
            jTextField1.setText("Enter a email");
        }
        else if (password.isEmpty() || password.equals("Enter a password")){
            jTextField2.setForeground(Color.red);
            jTextField2.setText("Enter a password");
        }
        else if (!idCheck.contains(id)) {
            jTextField1.setForeground(Color.red);
            jTextField1.setText("Not register");
        }
        else if (idCheck.contains(id)) {
            int idIndex = idCheck.indexOf(id);
            System.out.println(idIndex);
//            String idName = nameShare.indexOf(id);
            LoginSession.loginName = nameShare.get(idIndex);
            System.out.println(LoginSession.loginName);
            if ( password.equals(passCheck.get(idIndex)) ){
//                System.out.println(passCheck.get(idIndex));
                String profession = profCheck.get(idIndex);
                System.out.println(profession);
                if (profession.equals("Lecturer")) {
                    Lecturer_main_page lecMain = new Lecturer_main_page(); 
                    lecMain.setVisible(true);
                    this.dispose();
                }
                else if (profession.equals("Student")) {
                    StudentHomePage stuMain = new StudentHomePage();
                    stuMain.setVisible(true);
                    this.dispose();
                }
            }
            else{
                jTextField2.setForeground(Color.red);
                jTextField2.setText("Incorrect password");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
