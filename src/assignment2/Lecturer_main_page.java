package assignment2;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class Lecturer_main_page extends javax.swing.JFrame {
    File slotInfo = new File("src\\TextFile\\SlotInfo");
    LocalDate ld = LocalDate.now();
    
    ArrayList<String> todaySlot = new ArrayList<>();
    ArrayList<String> tomorrowSlot = new ArrayList<>();
    ArrayList<String> slotDate = new ArrayList<>();
    ArrayList<String> dd = new ArrayList<>();
    ArrayList<String> mm = new ArrayList<>();
    ArrayList<String> yyyy = new ArrayList<>();
    
    private String[] columnName = {"Today"};
    private Object[][] data = {
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
    };
    
    
    
        
    DefaultTableModel model = new DefaultTableModel(data, columnName) {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    private String[] upColumn = {"Up Coming"};
    private Object[][] upData = {
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
//        {null},
        
    };
    
    DefaultTableModel upComingModel = new DefaultTableModel(upData, upColumn) {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };

    public Lecturer_main_page() {
        initComponents();
        getContentPane().setBackground(new Color(0x2a3935));
        
//        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//        model.addRow(new Object[]{"data", "columnName"});
//        
//        DefaultTableModel upComingModel = (DefaultTableModel) jTable1.getModel();
//        model.addRow(new Object[]{"data", "columnName"});
        
        int line = -1;
        int rowCount = -1;
        int todayRowCount = -1;
        String conInfo = "";
        String tomorrow = "";
        try {
            if (!slotInfo.exists()) {
                slotInfo.createNewFile();
            }else {
                Scanner slotReader = new Scanner(slotInfo);
                while (slotReader.hasNextLine()) {
                    conInfo = slotReader.nextLine();
                    String rowSlotInfo[] = conInfo.split(",");
                    slotDate.add(rowSlotInfo[3]);
                }
                for (String i : slotDate){
                    String dateSplit[] =i.split("-");
                    yyyy.add(dateSplit[2]);
                    mm.add(dateSplit[1]);
                    dd.add(dateSplit[0]);
                }
                for (int j = 0; j < yyyy.size(); j++){
                    System.out.println("test size: " +yyyy.size());
                    int year = Integer.valueOf(yyyy.get(j));
                    int month = Integer.valueOf(mm.get(j));
                    int day = Integer.valueOf(dd.get(j));
                    
                    LocalDate ldCheck = LocalDate.of(year, month, day);
                    
                    System.out.println(ldCheck);
                    
                    if (ldCheck.equals(ld)) {
                        line = j;
                        todayRowCount++;
                        Scanner slotReader2 = new Scanner(slotInfo);
                        for (int k = 0; k <= line; k++){
                            conInfo = slotReader2.nextLine();
                            conInfo = conInfo.replace(",", ", ");
                        }
                        model.addRow(new Object[]{""});
                        model.setValueAt(conInfo , todayRowCount, 0);
                    }
                    else if (ldCheck.isAfter(ld)) {
                        line = j;
                        rowCount++;
                        Scanner slotReader2 = new Scanner(slotInfo);
                        for (int k = 0; k <= line; k++){
                            conInfo = slotReader2.nextLine();
                            conInfo = conInfo.replace(",", ", ");
                        }
                        upComingModel.addRow(new Object[]{""});
                        upComingModel.setValueAt(conInfo , rowCount, 0);
                        System.out.println(ld);
                    }
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(256, 128));
        setResizable(false);

        jLabel1.setText("Lecturer Name: ");

        jLabel2.setText("Lecturer ID:");

        jButton1.setText("History");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 25));
        jButton1.setName(""); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(75, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Consultation Slot");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(upComingModel);
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jScrollPane2.setViewportView(jTable1);

        jButton3.setText("Request");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Student Feedback");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/profilePic (2).png"))); // NOI18N

        jTable3.setModel(model);
        jTable3.setEditingColumn(0);
        jTable3.setEditingRow(0);
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(540, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(291, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ConsultationSlot ConSlotPage = new ConsultationSlot();
        ConSlotPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        History historyPage = new History();
        historyPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Requests requestPage = new Requests();
        requestPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Lecturer_main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecturer_main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecturer_main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecturer_main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lecturer_main_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
