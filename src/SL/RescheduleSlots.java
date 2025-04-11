/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NITRO_5
 */
public class RescheduleSlots extends javax.swing.JFrame {
    private String lecturerName;
    private String bookingId;
    private String originalTime;
    private String originalDate;
    private String day;
    private String venue;
    private DefaultTableModel tableModel;
    /**
     * Creates new form RescheduleSlots
     */

    public RescheduleSlots(String lecturerName,String bookingId,String originalTime,String originalDate,String day,String venue) {
        this.lecturerName = lecturerName;
        this.bookingId = bookingId;
        this.originalTime = originalTime;
        this.originalDate = originalDate;
        this.day = day;
        this.venue = venue;
        initComponents();

        tableModel = new DefaultTableModel(new String[]{"Lecturer Name","Booking ID","Time","Date","Day","Venue"}, 0);
        jTable1.setModel(tableModel);
        loadAvailableSlots();
    }
    
    private void loadAvailableSlots() {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(lecturerName)) {
                    String bookingId = data[1].trim();
                    String time = data[2].trim();
                    String date = data[3].trim();
                    String day = data[4].trim();
                    String venue = data[5].trim();

                    if (!time.equals(originalTime) || !date.equals(originalDate)) {
                        tableModel.addRow(new Object[]{lecturerName,bookingId,time,date,day,venue});
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading available slots: " + e.getMessage());
        }
    }

private void updateBooking(String bookingId,String newBookingId,String newTime,String newDate,String newDay,String newVenue) {
    try {
        List<String[]> bookings = new ArrayList<>();
        boolean bookingFound = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo - Copy"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookingDetails = line.split(",");
                String currentBookingId = bookingDetails[1].trim();
                if (currentBookingId.equals(bookingId)) {
                    bookingDetails[1] = newBookingId;
                    bookingDetails[2] = newTime;
                    bookingDetails[3] = newDate;
                    bookingDetails[4] = newDay;
                    bookingDetails[5] = newVenue;
                    bookingDetails[6] = "Rescheduled";
                    bookingFound = true;
                }
                bookings.add(bookingDetails);
            }
        }

        if (bookingFound) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo - Copy"))) {
                for (String[] booking : bookings) {
                    writer.write(String.join(",", booking));
                    writer.newLine();
                }
            }

            JOptionPane.showMessageDialog(this, "Booking rescheduled successful");
        } else {
            JOptionPane.showMessageDialog(this, "Booking ID not found.");
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Unsuccessful update booking. Please try again.");
    }
}
    
    private void addToAvailableSlots(String time, String date, String day, String venue) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo", true))) {
            bw.write(String.format("%s,%s,%s,%s,%s,%s%n",lecturerName,bookingId,time,date,day,venue));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error adding to available slots: " + e.getMessage());
        }
    }

    private void removeSlotFromAvailableSlots(String newBookingId,String newTime,String newDate,String newDay,String newVenue) {
        List<String[]> availableSlots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] slotDetails = line.split(",");
                if (slotDetails.length == 6) {
                    if (!(slotDetails[0].trim().equals(lecturerName) && //check the slot match the new bookingor not
                          slotDetails[1].trim().equals(newBookingId) && 
                          slotDetails[2].trim().equals(newTime) && 
                          slotDetails[3].trim().equals(newDate) && 
                          slotDetails[4].trim().equals(newDay) && 
                          slotDetails[5].trim().equals(newVenue))) {
                        availableSlots.add(slotDetails); //if don match then just keep the slot
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading available slots: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo"))) {//write back the slot to SlotInfo
            for (String[] slot : availableSlots) {
                bw.write(String.join(",", slot));
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating available slots: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Lecturer Name", "Booking ID", "Time", "Date", "Day", "Venue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BOOK NEW SLOT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel1.setText("RESCHEDULE SLOTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(245, 245, 245)
                        .addComponent(jButton2)
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(338, 338, 338))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MyConsultation mc = new MyConsultation();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String newBookingId = tableModel.getValueAt(selectedRow, 1).toString();
        String newTime = tableModel.getValueAt(selectedRow, 2).toString();
        String newDate = tableModel.getValueAt(selectedRow, 3).toString();
        String newDay = tableModel.getValueAt(selectedRow, 4).toString();
        String newVenue = tableModel.getValueAt(selectedRow, 5).toString();

        moveSlotToBooking(newBookingId,newTime,newDate,newDay,newVenue);//move the slot to SlotInfo - Copy from SlotInfo
    } else {
        JOptionPane.showMessageDialog(this, "Please select a slot to book.");
    }
    MyConsultation mc = new MyConsultation();
    mc.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

private void moveSlotToBooking(String newBookingId,String newTime,String newDate,String newDay,String newVenue) {
    try {
        List<String[]> availableSlots = new ArrayList<>();
        boolean slotFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] slotDetails = line.split(",");
                if (slotDetails.length == 6) {
                    if (slotDetails[1].trim().equals(newBookingId) && //check is it the slot they want to book
                        slotDetails[2].trim().equals(newTime) && 
                        slotDetails[3].trim().equals(newDate) && 
                        slotDetails[4].trim().equals(newDay) && 
                        slotDetails[5].trim().equals(newVenue)) {
                        slotFound = true;
                    } else {
                        availableSlots.add(slotDetails);//if don match then just keep the slot
                    }
                }
            }
        }

        if (slotFound) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo - Copy", true))) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,Rescheduled%n",lecturerName,newBookingId,newTime,newDate,newDay,newVenue));
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo"))) {
                for (String[] slot : availableSlots) {
                    bw.write(String.join(",", slot));
                    bw.newLine();
                }
            }

            JOptionPane.showMessageDialog(this, "Slot booked successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Selected slot not found. Please try again.");
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Unsuccessful move the slot.Please try again.");
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RescheduleSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RescheduleSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RescheduleSlots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RescheduleSlots("Lecturer Name","Booking ID","Original Time","Original Date","Day","Venue").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
