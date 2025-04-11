package KH;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;



public class History extends javax.swing.JFrame {
    File slotInfo = new File("src\\TextFile\\History");
    LocalDate ld = LocalDate.now();
    ArrayList<String> slotDate = new ArrayList<>();
    ArrayList<String> slotDay = new ArrayList<>();
    ArrayList<String> slotTime = new ArrayList<>();
    ArrayList<String> slotVenue = new ArrayList<>();
    ArrayList<String> slotNote = new ArrayList<>();
    ArrayList<String> dd = new ArrayList<>();
    ArrayList<String> mm = new ArrayList<>();
    ArrayList<String> yyyy = new ArrayList<>();
    
   
    private String[] columnName = {"Date", "Day", "Time", "Venue", "Notes"};
    private Object[][] data = {
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null},
//        {null, null, null, null, null}
    };
    
    DefaultTableModel model = new DefaultTableModel(data, columnName) {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    
    public History() {
        initComponents();
        getContentPane().setBackground(new Color(0x2a3935));
        
        int rowCount = -1;
        try {
            if (!slotInfo.exists()) {
                slotInfo.createNewFile();
            }
            Scanner slotReader = new Scanner(slotInfo);
            while (slotReader.hasNextLine()) {
                String conInfo = slotReader.nextLine();
                String rowSlotInfo[] = conInfo.split(",");
                slotDate.add(rowSlotInfo[3]);
                slotDay.add(rowSlotInfo[4]);
                slotTime.add(rowSlotInfo[2]);
                slotVenue.add(rowSlotInfo[5]);
            }
            for (String i : slotDate){
                String dateSplit[] =i.split("-");
                yyyy.add(dateSplit[2]);
                mm.add(dateSplit[1]);
                dd.add(dateSplit[0]);
            }
            for (int j = 0; j < yyyy.size(); j++){
//                    int yearIndex = j;
                System.out.println("test size: " +yyyy.size());
                int year = Integer.valueOf(yyyy.get(j));
                int month = Integer.valueOf(mm.get(j));
                int day = Integer.valueOf(dd.get(j));
//                System.out.println(year);
//                System.out.println(month);
//                System.out.println(day);
//                    
                LocalDate ldCheck = LocalDate.of(year, month, day);
                
                if (ldCheck.isBefore(ld)) {
                    rowCount++;
                    model.addRow(new Object[]{"", ""});
                    model.setValueAt(slotDate.get(j), rowCount, 0);
                    model.setValueAt(slotDay.get(j), rowCount, 1);
                    model.setValueAt(slotTime.get(j), rowCount, 2);
                    model.setValueAt(slotVenue.get(j), rowCount, 3);
//                    System.out.println(ldCheck);
                    
                }
                System.out.println("Before today slot filtered");
            }
                
            
            
        }catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
//        System.out.println(yyyy);
//        System.out.println(mm);
//        System.out.println(dd);
//        System.out.println(slotVenue);
//        
        
        
        
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(256, 128));
        setResizable(false);

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("History");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lecturer_main_page lecMain = new Lecturer_main_page();
        lecMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
