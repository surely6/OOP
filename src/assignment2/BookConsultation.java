/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BookConsultation extends JFrame {
    private final String lecturerName;
    private final String bookingId;
    private final String time;
    private final String date;
    private final String day;
    private final String venue;
    private final JButton confirmBookingButton;

    // Constructor to initialize the booking details
    public BookConsultation(String lecturerName,String bookingId,String time,String date,String day,String venue) {
        this.lecturerName = lecturerName;
        this.bookingId = bookingId;
        this.time = time;
        this.date = date;
        this.day = day;
        this.venue = venue;

        setTitle("Book Consultation with " + lecturerName);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        confirmBookingButton = new JButton("Confirm Booking");
        add(confirmBookingButton, BorderLayout.CENTER);

        // Add action listener for confirm booking button
    confirmBookingButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create booking information string in the desired format
            String bookingInfo = String.join(",",lecturerName,bookingId,time,date,day,venue,"Approved");
            
            // Save the booking to the file
            saveBookingToFile(bookingInfo);
            
            // Show confirmation message
            JOptionPane.showMessageDialog(null, "Booking confirmed for " + lecturerName + " at " + time);
            ViewLecturers vc = new ViewLecturers();
            vc.setVisible(true);
            dispose(); // Close the booking window after confirmation
        }
    });
    }

    private BookConsultation() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    // Method to save the booking information to the file
    private boolean saveBookingToFile(String bookingInfo) {
        try (FileWriter writer = new FileWriter("src\\TextFile\\SlotInfo - Copy", true)) {
            writer.write(bookingInfo + "\n");
            return true; // if successful save then return
        } catch (IOException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BookConsultation().setVisible(true);
        });
    }
}