package KH;

import java.awt.Color;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends javax.swing.JFrame {
    ImageIcon topLogo = new ImageIcon("src/Image/simple apu logo.png");
    File lecInfo = new File("src\\TextFile\\lecturerInfo");
    ArrayList<String> idCheck = new ArrayList<String>();

    
    
    
    private String profession;
    
    
    
    public Register() {
        initComponents();
        
        
        getContentPane().setBackground(new Color(0x2a3935));
        
        jLabel9.setVisible(false);
        
        
//        ButtonModel selectedModel = buttonGroup1.getSelection();
//        System.out.println(selectedModel);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setBackground(new java.awt.Color(23, 23, 23));
        setIconImage(topLogo.getImage());
        setLocation(new java.awt.Point(256, 128));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Start3.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("Register");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(211, 239, 233));
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(211, 239, 233));
        jLabel4.setText("Password: ");

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(211, 239, 233));
        jLabel5.setText("Confirm ");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(211, 239, 233));
        jLabel6.setText("Password: ");

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

        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setText("Confirm password");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField3MouseReleased(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(25, 113, 92));
        jButton2.setForeground(new java.awt.Color(211, 239, 233));
        jButton2.setText("Register");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton1.setText("Student");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton2.setText("Lecturer");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 239, 233));
        jLabel7.setText("Profession:");

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(211, 239, 233));
        jLabel8.setText("Name: ");

        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setText("Enter your name");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField4MouseReleased(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jLabel9.setForeground(java.awt.Color.red);
        jLabel9.setText("Select one");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String id = jTextField1.getText();
        String password = jTextField2.getText();
        String confirmPassword = jTextField3.getText();
        String name = jTextField4.getText();
        
        try {
            if (!lecInfo.exists()) {
                lecInfo.createNewFile();
            }
            Scanner myReader = new Scanner(lecInfo);
            while (myReader.hasNextLine()) {
                String info = myReader.nextLine();
                String idInfo[] = info.split(",");
                idCheck.add(idInfo[0]);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
        
//        System.out.println(profession);
        
        if (id.isEmpty() || id.equals("Enter a email")){
            jTextField1.setForeground(Color.red);
            jTextField1.setText("Enter a email");
        }
        else if (password.isEmpty() || password.equals("Enter a password")){
            jTextField2.setForeground(Color.red);
            jTextField2.setText("Enter a password");
        }
        else if (password.length() < 8){
            jTextField2.setForeground(Color.red);
            jTextField2.setText("At least 8 character");
        }
        else if (confirmPassword.isEmpty() || confirmPassword.equals("Confirm password")){
            jTextField3.setForeground(Color.red);
            jTextField3.setText("Confirm password");
        }
        else if (profession == null || profession.isEmpty()){
            jLabel9.setVisible(true);
        }
        else if (name.isEmpty() || name.equals("Enter your name")){
            jTextField4.setForeground(Color.red);
            jTextField4.setText("Enter your name");
        }
        else if (idCheck.contains(id)){
            jTextField1.setForeground(Color.red);
            jTextField1.setText("ID already exists");
        }
        else if (!password.equals(confirmPassword)){
            jTextField3.setForeground(Color.red);
            jTextField3.setText("Password not match");
        }
        
        else{
            try {
                if ( !lecInfo.exists() ) {
                    lecInfo.createNewFile();
                }
                FileWriter myWriter = new FileWriter(lecInfo, true);
                myWriter.write(id + "," + password + "," + name + "," + profession + "\n");
                myWriter.close();                
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("test fail");
            }
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        buttonGroup1.clearSelection();
        jTextField4.setText("");
        
        Login loginPage = new Login(); 
        loginPage.setVisible(true);
        this.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseReleased
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Enter a email") || 
                jTextField1.getText().equals("ID already exists")){
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField1MouseReleased

    private void jTextField2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseReleased

    private void jTextField3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Enter a email") ){
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        if (jTextField2.getText().equals("Enter a password") ||
                jTextField2.getText().equals("At least 8 character")){
            jTextField2.setText("");
            jTextField2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if (jTextField2.getText().equals("Enter a password") ||
                jTextField2.getText().equals("At least 8 character")){
            jTextField2.setText("");
            jTextField2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if (jTextField3.getText().equals("Confirm password") ||
                jTextField3.getText().equals("Password not match")){
            jTextField3.setText("");
            jTextField3.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
        if (jTextField3.getText().equals("Confirm password") ||
                jTextField3.getText().equals("Password not match")){
            jTextField3.setText("");
            jTextField3.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        if (jTextField1.getText().equals("")){
            jTextField1.setForeground(Color.red);
            jTextField1.setText("Enter a email");
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        if (jTextField2.getText().equals("")){
            jTextField2.setForeground(Color.red);
            jTextField2.setText("Enter a password");
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
        if (jTextField3.getText().equals("")){
            jTextField3.setForeground(Color.red);
            jTextField3.setText("Confirm password");
        }
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        // TODO add your handling code here:
        if (jTextField4.getText().equals("Enter your name") ){
            jTextField4.setText("");
            jTextField4.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        // TODO add your handling code here:
        if (jTextField4.getText().equals("")){
            jTextField4.setForeground(Color.red);
            jTextField4.setText("Enter your name");
        }
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField4MouseReleased

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        profession = jRadioButton1.getText();
        

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        profession = jRadioButton2.getText();
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
