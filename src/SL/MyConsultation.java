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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author NITRO_5
 */
public class MyConsultation extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public MyConsultation() {
        initComponents();
        setTitle("My Consultations");
        tableModel = (DefaultTableModel) jTable1.getModel();
        loadBookings();
        loadRescheduledConsultations();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    String status = (String) tableModel.getValueAt(selectedRow, 6);
                    jButton1.setEnabled(status.equals("Approved") || status.equals("Rejected") || status.equals("Rescheduled"));
                    jButton2.setEnabled(status.equals("Approved") || status.equals("Rejected") || status.equals("Rescheduled"));
                } else {
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(false);
                }
            }
        });
    }

    private void loadBookings() {
        List<String[]> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo - Copy"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookingDetails = line.split(",");
                if (bookingDetails.length > 1) { 
                    bookings.add(bookingDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tableModel.setRowCount(0);
        for (String[] booking : bookings) {
            tableModel.addRow(booking);
        }
    }
    
private void loadRescheduledConsultations() {
    List<String[]> rescheduledBookings = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo - Copy"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] rescheduleDetails = line.split(",");
            if (rescheduleDetails.length == 6) {
                String[] bookingWithStatus = new String[7];
                System.arraycopy(rescheduleDetails, 0, bookingWithStatus, 0, 6);
                bookingWithStatus[6] = "Approved";
                rescheduledBookings.add(bookingWithStatus);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    for (String[] booking : rescheduledBookings) {
        tableModel.addRow(booking);
    }
}

private boolean shouldIncludeConsultation(String[] bookingDetails, String filter) {
    String status = bookingDetails[6].trim();
    String dateOriginal = bookingDetails[3].trim();
    String timeOriginal = bookingDetails[2].trim();

    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // for example 10-12-2024
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a"); // for example 10:00 AM - 11: 00 AM

    LocalTime startTime;

    try {
        String[] times = timeOriginal.split(" - "); //use - to split start time n end time
        String startTimeString = times[0].trim(); // Start time

        if (!startTimeString.endsWith("AM") && !startTimeString.endsWith("PM")) {
            startTimeString += " AM"; // default is AM
        }

        startTime = LocalTime.parse(startTimeString, timeFormatter); //12-hour
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

    LocalDate bookingDate = LocalDate.parse(dateOriginal, dateFormatter);
    LocalDateTime bookingDateTimeWithTime = bookingDate.atTime(startTime);

    switch (filter) {//combobox
        case "Waiting to Processing":
            return status.equals("Rejected");
        case "Past Consultations":
            return status.equals("Completed") || (status.equals("Approved") && bookingDateTimeWithTime.isBefore(LocalDateTime.now()));
        case "Upcoming Consultations":
            return status.equals("Approved") && bookingDateTimeWithTime.isAfter(LocalDateTime.now());
        case "Rescheduled Consultations":
            return status.equals("Rescheduled");
        case "All Consultations":
            return true;
        default:
            return false;
    }
}

    private void updateTableData() {
        String selectedFilter = jComboBox2.getSelectedItem().toString();
        List<String[]> filteredBookings = new ArrayList<>();

        List<String[]> allBookings = loadBookingsFromFile();

        for (String[] booking : allBookings) {
            if (shouldIncludeConsultation(booking, selectedFilter)) {
                filteredBookings.add(booking);
            }
        }

        tableModel.setRowCount(0);
        for (String[] booking : filteredBookings) {
            tableModel.addRow(booking);
        }
    }

    private List<String[]> loadBookingsFromFile() {
        List<String[]> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\TextFile\\SlotInfo - Copy"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookingDetails = line.split(",");
                bookings.add(bookingDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    
        private void cancelBooking(String bookingId) {
        List<String[]> bookings = loadBookingsFromFile();
        List<String[]> updatedBookings = new ArrayList<>();

        for (String[] booking : bookings) {
            if (!booking[1].equals(bookingId)) {
                updatedBookings.add(booking);
            }
        }

        // Write the updated bookings to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo - Copy"))) {
            for (String[] booking : updatedBookings) {
                bw.write(String.join(",", booking));
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Booking update unsuccessful. Please try again.");
        }
    }
    
        //cancel booking
        private void addToAvailableSlots(String[] canceledBooking) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo", true))) {
            bw.write(String.join(",",canceledBooking[0],canceledBooking[1],canceledBooking[2],canceledBooking[3],canceledBooking[4],canceledBooking[5]));
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Booking cancel or adding unsuccessful. Please try again.");
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
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Lecturer Name", "Book ID", "Time", "Date", "Day", "Venue", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Consultations", "Upcoming Consultations", "Past Consultations", "Waiting to Processing", "Rescheduled Consultations" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("CANCEL BOOKING");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESCHEDULE BOOKING");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel1.setText("MY CONSULTATIONS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(360, 360, 360))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(227, 227, 227))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(475, 475, 475))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        updateTableData();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String bookingId = (String) tableModel.getValueAt(selectedRow, 1);
        String status = (String) tableModel.getValueAt(selectedRow, 6);
        String dateOrigin = ((String) tableModel.getValueAt(selectedRow, 3)).trim();
        String timeOrigin = ((String) tableModel.getValueAt(selectedRow, 2)).trim();

        //check is the booking past already or not
        LocalDate bookingDate = LocalDate.parse(dateOrigin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        //starttime - endtime
        String[] times = timeOrigin.split(" - ");
        String startTimeString = times[0].trim();
        String endTimeString = times[1].trim();

        LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("hh:mm a"));
        LocalDateTime bookingStartDateTime = bookingDate.atTime(startTime);

        if (status.equals("Rejected") || (status.equals("Approved") && bookingStartDateTime.isAfter(LocalDateTime.now()))) {// if time havent pass
            cancelBooking(bookingId);
            JOptionPane.showMessageDialog(this, "Booking canceled successful.");
            loadBookings();
        } else {
            JOptionPane.showMessageDialog(this, "Cannot cancel a consultation that has already occurred.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a booking to cancel.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String status = (String) tableModel.getValueAt(selectedRow, 6);
        if (status.equals("Rescheduled")) {
            JOptionPane.showMessageDialog(this, "Unable to reschedule. This consultation has already been rescheduled.");
            return;
        }

        String lecturerName = (String) tableModel.getValueAt(selectedRow, 0);
        String bookingId = (String) tableModel.getValueAt(selectedRow, 1);
        String dateOrigin = ((String) tableModel.getValueAt(selectedRow, 3)).trim();
        String timeOrigin = ((String) tableModel.getValueAt(selectedRow, 2)).trim();
        String day = (String) tableModel.getValueAt(selectedRow, 4);
        String venue = (String) tableModel.getValueAt(selectedRow, 5);

        LocalDate bookingDate = LocalDate.parse(dateOrigin, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String[] times = timeOrigin.split(" - ");
        String startTimeString = times[0].trim();

        LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("hh:mm a"));
        LocalDateTime bookingStartDateTime = bookingDate.atTime(startTime);

        if (status.equals("Rejected") || (status.equals("Approved") && bookingStartDateTime.isAfter(LocalDateTime.now()))) {
            RescheduleSlots rs = new RescheduleSlots(lecturerName,bookingId,timeOrigin,dateOrigin,day,venue);
            rs.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to reschedule. This consultation has already been rescheduled.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a booking to reschedule.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StudentHomePage shp = new StudentHomePage();
        shp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void handleSuccessfulReschedule(String bookingId, String[] newDetails) {
        cancelBooking(bookingId);//remove old booking in SlotInfo - Copy
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\TextFile\\SlotInfo - Copy", true))) {//add new booking in SlotInfo - Copy
            bw.write(String.join(",",newDetails[0],newDetails[1],newDetails[2],newDetails[3],newDetails[4],newDetails[5]));
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unsuccessful save the rescheduled booking");
        }
        String[] canceledBooking = {newDetails[0],bookingId,newDetails[2],newDetails[3],newDetails[4],newDetails[5]}; //add back to canceled booking to SlotInfo
        addToAvailableSlots(canceledBooking);
        loadBookings();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
