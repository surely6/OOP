package assignment2;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class LecFeedback extends javax.swing.JFrame {
    File slotInfo = new File("src\\TextFile\\SlotInfo - Copy");
    File feedbackInfo = new File("src\\TextFile\\FeedbackInfo");
    File stuFeedback = new File("src\\TextFile\\FeedbackInfo - Copy");
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> bookId = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> day = new ArrayList<>();
    ArrayList<String> venue = new ArrayList<>();
    ArrayList<String> status = new ArrayList<>();
    ArrayList<String> feedId = new ArrayList<>();
    ArrayList<String> feedContent = new ArrayList<>();
    ArrayList<String> stuFeedId = new ArrayList<>();
    ArrayList<String> stuFeedContent = new ArrayList<>();
    
    String selectedBookId = "";
    
    private String[] Column = {"Student name", "Book ID", "Time", "Date", "Day", "Venue", "Status"};
    private Object[][] Data = {};

    DefaultTableModel model = new DefaultTableModel(Data, Column) {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };

    public LecFeedback() {
        initComponents();
        getContentPane().setBackground(new Color(0x2a3935));
        jLabel1.setForeground(new Color(0xD3EFE9));

        int todayRowCount = 0;
        
        try (Scanner slotReader = new Scanner(slotInfo)){
            while (slotReader.hasNextLine()) {
                String conInfo = slotReader.nextLine();
                String rowSlotInfo[] = conInfo.split(",");
                name.add(rowSlotInfo[0]);
                bookId.add(rowSlotInfo[1]);
                time.add(rowSlotInfo[2]);
                date.add(rowSlotInfo[3]);
                day.add(rowSlotInfo[4]);
                venue.add(rowSlotInfo[5]);
                status.add(rowSlotInfo[6]);
//                System.out.println(status);
            }
            for (int i = 0; i < name.size(); i++) {
                if (status.get(i).equals("Completed")) {
                    model.addRow(new Object[]{""});
                    model.setValueAt(name.get(i) , todayRowCount, 0);
                    model.setValueAt(bookId.get(i) , todayRowCount, 1);
                    model.setValueAt(time.get(i) , todayRowCount, 2);
                    model.setValueAt(date.get(i) , todayRowCount, 3);
                    model.setValueAt(day.get(i) , todayRowCount, 4);
                    model.setValueAt(venue.get(i) , todayRowCount, 5);
                    model.setValueAt(status.get(i) , todayRowCount, 6);
                    todayRowCount++;
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
        //jLable1 showing student feedback
        
        
    }
    
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(256, 128));

        jTable1.setModel(model
        );
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("Feedback");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setBackground(new java.awt.Color(187, 187, 187));
        jLabel1.setText("No feedback from Student");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setText("Sent");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(211, 239, 233));
        jLabel3.setText("Student Feedback");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(237, 237, 237))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(298, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        selectedBookId = bookId.get(row);
        
        try (Scanner feedReader = new Scanner(feedbackInfo)) {
            while (feedReader.hasNextLine()) {
                String data = feedReader.nextLine();
                String inData[] = data.split("`");
                feedId.add(inData[0]);
                feedContent.add(inData[1]);
            }
            for (int i = 0; i < feedId.size(); i++) {
                if (feedId.get(i).equals(selectedBookId)) {
                    jTextArea1.setText(feedContent.get(i));
                    jTextArea1.setEditable(false);
                    break;
                }else{
                    jTextArea1.requestFocusInWindow();
                    jTextArea1.selectAll();
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Found not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
        try (Scanner slotReader = new Scanner(stuFeedback)){
            while (slotReader.hasNextLine()) {
                String conInfo = slotReader.nextLine();
                String rowSlotInfo[] = conInfo.split("`");
                stuFeedId.add(rowSlotInfo[0]);
                stuFeedContent.add(rowSlotInfo[1]);
            }
            for (int i = 0; i < stuFeedId.size(); i++) {
                if (stuFeedId.get(i).equals(selectedBookId)) {
                    jLabel1.setText(stuFeedContent.get(i));
                    break;
                }else{
                    jLabel1.setText("No feedback from Student");
//                    break;
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String feedBack = jTextArea1.getText();
        if (!feedBack.equals("Enter your feedback here")){
            int result = JOptionPane.showConfirmDialog(null, "Sent feedback to student?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                try {
                    if (!feedbackInfo.exists()) {
                        feedbackInfo.createNewFile();
                    } else {
                        try (Scanner feedReader = new Scanner(feedbackInfo)) {
                            while (feedReader.hasNextLine()) {
                                String data = feedReader.nextLine();
                                String inData[] = data.split("`");
                                feedId.add(inData[0]);
                                feedContent.add(inData[1]);
                            }
                            for (int i = 0; i < feedId.size(); i++) {
                                if (feedId.get(i).equals(selectedBookId)) {
                                    jTextArea1.setText(feedContent.get(i));
                                    jTextArea1.enableInputMethods(false);
                                    break;
                                }else {
                                    FileWriter feedWriter = new FileWriter(feedbackInfo, true);
                                    feedWriter.write(selectedBookId+"`"+feedBack+"\n");
                                    feedWriter.close();
                                    System.out.println(feedId.get(i));
                                    break;
                                }
                            }
                            System.out.println(feedId);

                        }
                        
                    }
                }catch(FileNotFoundException e){
                    System.out.println("Found not found");
                }catch (IOException e) {
                    System.out.println("an error occur");
                }
                jTable1.clearSelection();
                jTextArea1.setText("Enter your feedback here");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        java.util.logging.Logger.getLogger(LecFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(LecFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(LecFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(LecFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new LecFeedback().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
