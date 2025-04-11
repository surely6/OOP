package KH;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Requests extends javax.swing.JFrame {

    File slotInfo = new File("src\\TextFile\\SlotInfo - Copy");
    String slotInfoB = "src\\TextFile\\SlotInfo - Copy";
    LocalDate ld = LocalDate.now();

    ArrayList<String> slotDate = new ArrayList<>();
    ArrayList<String> status = new ArrayList<>();
    ArrayList<String> dd = new ArrayList<>();
    ArrayList<String> mm = new ArrayList<>();
    ArrayList<String> yyyy = new ArrayList<>();
    ArrayList<String> checkBoxes = new ArrayList<>();
    
    ArrayList<String> selectedBox = new ArrayList<>();
    ArrayList<String> selectedStatus = new ArrayList<>();
    
    ArrayList<String> updatedRow = new ArrayList<>();
//    List<List<String>> selectedBox = new ArrayList<>();
//    List<List<String>> checkBoxes = new ArrayList<>();

    public Requests() {
        initComponents();
        getContentPane().setBackground(new Color(0x2a3935));

        Request1.setEnabled(false);
        Request2.setEnabled(false);
        Request3.setEnabled(false);
        Request4.setEnabled(false);
        Request5.setEnabled(false);
        Request6.setEnabled(false);
        Request7.setEnabled(false);
        Request8.setEnabled(false);
        Request9.setEnabled(false);
        Request10.setEnabled(false);
        Request11.setEnabled(false);
        Request12.setEnabled(false);
        Request13.setEnabled(false);
        Request14.setEnabled(false);
        Request15.setEnabled(false);
        Request16.setEnabled(false);
        
        
        int line = -1;
        int rowCount = -1;
        int todayRowCount = -1;
        String conInfo = "";
        String tomorrow = "";
        try {
            if (!slotInfo.exists()) {
                slotInfo.createNewFile();
            } else {
                Scanner slotReader = new Scanner(slotInfo);
                while (slotReader.hasNextLine()) {
                    conInfo = slotReader.nextLine();
                    String rowSlotInfo[] = conInfo.split(",");
                    slotDate.add(rowSlotInfo[3]);
                    status.add(rowSlotInfo[6]);
                }
                for (String i : slotDate) {
                    String dateSplit[] = i.split("-");
                    yyyy.add(dateSplit[2]);
                    mm.add(dateSplit[1]);
                    dd.add(dateSplit[0]);
                }
                for (int j = 0; j < yyyy.size(); j++) {
//                    System.out.println("test size: " + yyyy.size());
                    int year = Integer.valueOf(yyyy.get(j));
                    int month = Integer.valueOf(mm.get(j));
                    String spacedDay = dd.get(j).trim();
                    int day = Integer.valueOf(spacedDay);

                    LocalDate ldCheck = LocalDate.of(year, month, day);

//                    System.out.println(ldCheck);

                    if (!status.get(j).equals("Completed") && (ldCheck.equals(ld) || ldCheck.isAfter(ld))) {
                        line = j;
                        todayRowCount++;
                        Scanner slotReader2 = new Scanner(slotInfo);
                        for (int k = 0; k <= line; k++) {
                            conInfo = slotReader2.nextLine();
                            conInfo = conInfo.replace(",", ", ");

                        }
//                        checkBoxes.add(Arrays.asList(conInfo));
                        checkBoxes.add(conInfo);
//                        System.out.println(checkBoxes);

                    } else if (ldCheck.isAfter(ld)) {
                        line = j;
                        rowCount++;
                        Scanner slotReader2 = new Scanner(slotInfo);
                        for (int k = 0; k <= line; k++) {
                            conInfo = slotReader2.nextLine();
                            conInfo = conInfo.replace(",", ", ");
                        }
//                        upComingModel.setValueAt(conInfo , rowCount, 0);
//                        System.out.println(ld);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("an error occur");
        }

        try {
            // Iterate through the checkBoxes list and dynamically set text
            for (int i = 0; i < checkBoxes.size(); i++) {

//                if ()
                switch (i) {
                    case 0 :
                        Request1.setText(checkBoxes.get(0));
                        Request1.setEnabled(true);
                        break;
                    case 1 :
                        Request2.setText(checkBoxes.get(1));
                        Request2.setEnabled(true);
                        break;
                    case 2 :
                        Request3.setText(checkBoxes.get(2));
                        Request3.setEnabled(true);
                        break;
                    case 3 :
                        Request4.setText(checkBoxes.get(3));
                        Request4.setEnabled(true);
                        break;
                    case 4 :
                        Request5.setText(checkBoxes.get(4));
                        Request5.setEnabled(true);
                        break;
                    case 5 :
                        Request6.setText(checkBoxes.get(5));
                        Request6.setEnabled(true);
                        break;
                    case 6 :
                        Request7.setText(checkBoxes.get(6));
                        Request7.setEnabled(true);
                        break;
                    case 7 :
                        Request8.setText(checkBoxes.get(7));
                        Request8.setEnabled(true);
                        break;
                    case 8 :
                        Request9.setText(checkBoxes.get(8));
                        Request9.setEnabled(true);
                        break;
                    case 9 :
                        Request10.setText(checkBoxes.get(9));
                        Request10.setEnabled(true);
                        break;
                    case 10 :
                        Request11.setText(checkBoxes.get(10));
                        Request11.setEnabled(true);
                        break;
                    case 11 :
                        Request12.setText(checkBoxes.get(11));
                        Request12.setEnabled(true);
                        break;
                    case 12 :
                        Request13.setText(checkBoxes.get(12));
                        Request13.setEnabled(true);
                        break;
                    case 13 :
                        Request14.setText(checkBoxes.get(13));
                        Request14.setEnabled(true);
                        break;
                    case 14 :
                        Request15.setText(checkBoxes.get(14));
                        Request15.setEnabled(true);
                        break;
                    case 15 :
                        Request16.setText(checkBoxes.get(15));
                        Request16.setEnabled(true);
                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access an invalid array index.");
            System.out.println("Exception message: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Request1 = new javax.swing.JCheckBox();
        Request2 = new javax.swing.JCheckBox();
        Request3 = new javax.swing.JCheckBox();
        Request4 = new javax.swing.JCheckBox();
        Request5 = new javax.swing.JCheckBox();
        Request6 = new javax.swing.JCheckBox();
        Request7 = new javax.swing.JCheckBox();
        Request14 = new javax.swing.JCheckBox();
        Request8 = new javax.swing.JCheckBox();
        Request9 = new javax.swing.JCheckBox();
        Request10 = new javax.swing.JCheckBox();
        Request11 = new javax.swing.JCheckBox();
        Request12 = new javax.swing.JCheckBox();
        Request13 = new javax.swing.JCheckBox();
        Request15 = new javax.swing.JCheckBox();
        Request16 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(256, 128));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("Student Requests");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reject");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Approve");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Request1.setForeground(new java.awt.Color(211, 239, 233));
        Request1.setText("Request1");
        Request1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request1ActionPerformed(evt);
            }
        });

        Request2.setForeground(new java.awt.Color(211, 239, 233));
        Request2.setText("Request2");
        Request2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request2ActionPerformed(evt);
            }
        });

        Request3.setForeground(new java.awt.Color(211, 239, 233));
        Request3.setText("Request3");
        Request3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request3ActionPerformed(evt);
            }
        });

        Request4.setForeground(new java.awt.Color(211, 239, 233));
        Request4.setText("Request4");
        Request4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request4ActionPerformed(evt);
            }
        });

        Request5.setForeground(new java.awt.Color(211, 239, 233));
        Request5.setText("Request5");
        Request5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request5ActionPerformed(evt);
            }
        });

        Request6.setForeground(new java.awt.Color(211, 239, 233));
        Request6.setText("Request6");
        Request6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request6ActionPerformed(evt);
            }
        });

        Request7.setForeground(new java.awt.Color(211, 239, 233));
        Request7.setText("Request7");
        Request7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request7ActionPerformed(evt);
            }
        });

        Request14.setForeground(new java.awt.Color(211, 239, 233));
        Request14.setText("Request14");
        Request14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request14ActionPerformed(evt);
            }
        });

        Request8.setForeground(new java.awt.Color(211, 239, 233));
        Request8.setText("Request8");
        Request8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request8ActionPerformed(evt);
            }
        });

        Request9.setForeground(new java.awt.Color(211, 239, 233));
        Request9.setText("Request9");
        Request9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request9ActionPerformed(evt);
            }
        });

        Request10.setForeground(new java.awt.Color(211, 239, 233));
        Request10.setText("Request10");
        Request10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request10ActionPerformed(evt);
            }
        });

        Request11.setForeground(new java.awt.Color(211, 239, 233));
        Request11.setText("Request11");
        Request11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request11ActionPerformed(evt);
            }
        });

        Request12.setForeground(new java.awt.Color(211, 239, 233));
        Request12.setText("Request12");
        Request12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request12ActionPerformed(evt);
            }
        });

        Request13.setForeground(new java.awt.Color(211, 239, 233));
        Request13.setText("Request13");
        Request13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request13ActionPerformed(evt);
            }
        });

        Request15.setForeground(new java.awt.Color(211, 239, 233));
        Request15.setText("Request15");
        Request15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request15ActionPerformed(evt);
            }
        });

        Request16.setForeground(new java.awt.Color(211, 239, 233));
        Request16.setText("Request16");
        Request16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Request16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(621, 621, 621))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Request16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Request1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(155, 155, 155))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Request1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Request16)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lecturer_main_page lecMain = new Lecturer_main_page();
        lecMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

//        System.out.println(selectedBox);
        
        // Step 1: Read the file into a list
        List<String> lines = new ArrayList<>();
        String line;
        int listCount = 0;
        
        if (selectedBox.size()>0){
            int result = JOptionPane.showConfirmDialog(null, "Reject Selected Consultation?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(slotInfo))) {
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                for (int j = 0; j < selectedBox.size() ; j++) {
                    Scanner requestReader = new Scanner(slotInfo);
                    String sublist = requestReader.nextLine();
    //                String joinedSublist = String.join(",", sublist);
                    String splitSelected[] = sublist.split(", ");
                    String splitDetail[] = splitSelected[0].split(",");
    //                System.out.println("Found1: " + splitDetail[0]);
                    selectedStatus.add(splitDetail[6]);

                    String selectedBoxList = selectedBox.get(j).replace(", ", ",");
    //                String selectedList[] = joinedSublist.indexOf(6);
                    System.out.println("Found2: " + selectedBoxList);
                    int txtRow = 0;
    //                System.out.println("Found3: " + selectedStatus);
    //                System.out.println("Found4: " + selectedBox);
                    for (int i = 0; i < lines.size(); i++) {
                        if (lines.get(i).equals(selectedBoxList)) {
                            String Selrow = selectedBoxList;
                            String[] edit = Selrow.split(",");
                            edit[edit.length-1] = "Rejected";
                            String rejected = String.join(",", edit);
                            lines.set(i, rejected);
    //                    System.out.println("j: " + rejected);
    //                    System.out.println("i: " + lines);
                        }
                    }
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(slotInfoB))) {
                    for (String update : lines) {
                        writer.write(update);
                        writer.newLine();
                        
                    }
                    writer.close();
                }catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                }
            } catch (FileNotFoundException e) {
                System.out.println("An file error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        int todayRowCount = 0;
        String conInfo = "";
        slotDate.clear();
        status.clear();
        yyyy.clear();
        mm.clear();
        dd.clear();
        checkBoxes.clear();

        try (Scanner slotReader = new Scanner(slotInfo)) {
            while (slotReader.hasNextLine()) {
                conInfo = slotReader.nextLine();
                String[] rowSlotInfo = conInfo.split(",");
                updatedRow.add(conInfo);
                slotDate.add(rowSlotInfo[3]); // Date
                status.add(rowSlotInfo[6]);  // Status
            }
        //    System.out.println("while: " + updatedRow.size());
        //    System.out.println("slotDate2: " + slotDate.size());
        //    System.out.println("status3: " + status.size());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

                // Step 2: Split dates and filter rows based on conditions

                for (String i : slotDate) {
                    String[] dateSplit = i.split("-");
                    yyyy.add(dateSplit[2]);
                    mm.add(dateSplit[1]);
                    dd.add(dateSplit[0]);
                }
        //    System.out.println("for: " + yyyy.size());
        //    System.out.println("mm: " + mm.size());
        //    System.out.println("dd: " + dd.size());
                for (int j = 0; j < yyyy.size(); j++) {
                    int year = Integer.parseInt(yyyy.get(j));
                    int month = Integer.parseInt(mm.get(j));
                    int day = Integer.parseInt(dd.get(j).trim());

                    LocalDate ldCheck = LocalDate.of(year, month, day);

                    // Filter rows: not "Completed" and today or future date
                    if (!status.get(j).equals("Completed") && (ldCheck.equals(ld) || ldCheck.isAfter(ld))) {
        //                todayRowCount++;
                        String spacing = updatedRow.get(j).replace(",", ", ");
        //                String spacing = String.join(", ", slotDate.get(j), status.get(j)); // Simplified logic
                        checkBoxes.add(spacing);
                    }
                }
                System.out.println("checkBoxes: " + checkBoxes);
                System.out.println("checkBoxes count: " + checkBoxes.size());

                // Step 3: Set text for the checkBoxes
                try {
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        switch (i) {
                            case 0 :
                                Request1.setText(checkBoxes.get(0));
                                Request1.setEnabled(true);
                                break;
                            case 1 :
                                Request2.setText(checkBoxes.get(1));
                                Request2.setEnabled(true);
                                break;
                            case 2 :
                                Request3.setText(checkBoxes.get(2));
                                Request3.setEnabled(true);
                                break;
                            case 3 :
                                Request4.setText(checkBoxes.get(3));
                                Request4.setEnabled(true);
                                break;
                            case 4 :
                                Request5.setText(checkBoxes.get(4));
                                Request5.setEnabled(true);
                                break;
                            case 5 :
                                Request6.setText(checkBoxes.get(5));
                                Request6.setEnabled(true);
                                break;
                            case 6 :
                                Request7.setText(checkBoxes.get(6));
                                Request7.setEnabled(true);
                                break;
                            case 7 :
                                Request8.setText(checkBoxes.get(7));
                                Request8.setEnabled(true);
                                break;
                            case 8 :
                                Request9.setText(checkBoxes.get(8));
                                Request9.setEnabled(true);
                                break;
                            case 9 :
                                Request10.setText(checkBoxes.get(9));
                                Request10.setEnabled(true);
                                break;
                            case 10 :
                                Request11.setText(checkBoxes.get(10));
                                Request11.setEnabled(true);
                                break;
                            case 11 :
                                Request12.setText(checkBoxes.get(11));
                                Request12.setEnabled(true);
                                break;
                            case 12 :
                                Request13.setText(checkBoxes.get(12));
                                Request13.setEnabled(true);
                                break;
                            case 13 :
                                Request14.setText(checkBoxes.get(13));
                                Request14.setEnabled(true);
                                break;
                            case 14 :
                                Request15.setText(checkBoxes.get(14));
                                Request15.setEnabled(true);
                                break;
                            case 15 :
                                Request16.setText(checkBoxes.get(15));
                                Request16.setEnabled(true);
                                break;
                        }
                    }
                    Request1.setSelected(false);
                    Request2.setSelected(false);
                    Request3.setSelected(false);
                    Request4.setSelected(false);
                    Request5.setSelected(false);
                    Request6.setSelected(false);
                    Request7.setSelected(false);
                    Request8.setSelected(false);
                    Request9.setSelected(false);
                    Request10.setSelected(false);
                    Request11.setSelected(false);
                    Request12.setSelected(false);
                    Request13.setSelected(false);
                    Request14.setSelected(false);
                    Request15.setSelected(false);
                    Request16.setSelected(false);
                    selectedBox.clear();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Tried to access an invalid array index.");
                    System.out.println("Exception message: " + e.getMessage());
                }
                
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        List<String> lines = new ArrayList<>();
        String line;
        int listCount = 0;
        
        if (selectedBox.size()>0){
            int result = JOptionPane.showConfirmDialog(null, "Approve Selected Consultation?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(slotInfo))) {
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                for (int j = 0; j < selectedBox.size() ; j++) {
                    Scanner requestReader = new Scanner(slotInfo);
                    String sublist = requestReader.nextLine();
                    String splitSelected[] = sublist.split(", ");
                    String splitDetail[] = splitSelected[0].split(",");
    //                System.out.println("Found1: " + splitDetail[0]);
                    selectedStatus.add(splitDetail[6]);
                    String selectedBoxList = selectedBox.get(j).replace(", ", ",");
                    System.out.println("selectedBoxList: " + selectedBoxList);
                    int txtRow = 0;
    //                System.out.println("Found3: " + selectedStatus);
    //                System.out.println("Found4: " + selectedBox);
                    for (int i = 0; i < lines.size(); i++) {
                        if (lines.get(i).equals(selectedBoxList)) {
                            String Selrow = selectedBoxList;
                            String[] edit = Selrow.split(",");
                            edit[edit.length-1] = "Approved";
                            String approved = String.join(",", edit);
                            lines.set(i, approved);
    //                    System.out.println("j: " + rejected);
    //                    System.out.println("i: " + lines);
                        }
                    }
                }
                try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(slotInfo))) {
                    for (String update : lines) {
                        writer2.write(update);
                        writer2.newLine();
                        
                    }
                    writer2.close();
                }catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                }
            } catch (FileNotFoundException e) {
                System.out.println("An file error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        int todayRowCount = 0;
        String conInfo = "";
        slotDate.clear();
        status.clear();
        yyyy.clear();
        mm.clear();
        dd.clear();
        checkBoxes.clear();

        try (Scanner slotReader = new Scanner(slotInfo)) {
            while (slotReader.hasNextLine()) {
                conInfo = slotReader.nextLine();
                String[] rowSlotInfo = conInfo.split(",");
                updatedRow.add(conInfo);
                slotDate.add(rowSlotInfo[3]); // Date
                status.add(rowSlotInfo[6]);  // Status
            }
        //    System.out.println("while: " + updatedRow.size());
        //    System.out.println("slotDate2: " + slotDate.size());
        //    System.out.println("status3: " + status.size());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

                // Step 2: Split dates and filter rows based on conditions

                for (String i : slotDate) {
                    String[] dateSplit = i.split("-");
                    yyyy.add(dateSplit[2]);
                    mm.add(dateSplit[1]);
                    dd.add(dateSplit[0]);
                }
        //    System.out.println("for: " + yyyy.size());
        //    System.out.println("mm: " + mm.size());
        //    System.out.println("dd: " + dd.size());
                for (int j = 0; j < yyyy.size(); j++) {
                    int year = Integer.parseInt(yyyy.get(j));
                    int month = Integer.parseInt(mm.get(j));
                    int day = Integer.parseInt(dd.get(j).trim());

                    LocalDate ldCheck = LocalDate.of(year, month, day);

                    // Filter rows: not "Completed" and today or future date
                    if (!status.get(j).equals("Completed") && (ldCheck.equals(ld) || ldCheck.isAfter(ld))) {
        //                todayRowCount++;
                        String spacing = updatedRow.get(j).replace(",", ", ");
        //                String spacing = String.join(", ", slotDate.get(j), status.get(j)); // Simplified logic
                        checkBoxes.add(spacing);
                    }
                }
                System.out.println("checkBoxes: " + checkBoxes);
                System.out.println("checkBoxes count: " + checkBoxes.size());

                // Step 3: Set text for the checkBoxes
                try {
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        switch (i) {
                            case 0 :
                                Request1.setText(checkBoxes.get(0));
                                Request1.setEnabled(true);
                                break;
                            case 1 :
                                Request2.setText(checkBoxes.get(1));
                                Request2.setEnabled(true);
                                break;
                            case 2 :
                                Request3.setText(checkBoxes.get(2));
                                Request3.setEnabled(true);
                                break;
                            case 3 :
                                Request4.setText(checkBoxes.get(3));
                                Request4.setEnabled(true);
                                break;
                            case 4 :
                                Request5.setText(checkBoxes.get(4));
                                Request5.setEnabled(true);
                                break;
                            case 5 :
                                Request6.setText(checkBoxes.get(5));
                                Request6.setEnabled(true);
                                break;
                            case 6 :
                                Request7.setText(checkBoxes.get(6));
                                Request7.setEnabled(true);
                                break;
                            case 7 :
                                Request8.setText(checkBoxes.get(7));
                                Request8.setEnabled(true);
                                break;
                            case 8 :
                                Request9.setText(checkBoxes.get(8));
                                Request9.setEnabled(true);
                                break;
                            case 9 :
                                Request10.setText(checkBoxes.get(9));
                                Request10.setEnabled(true);
                                break;
                            case 10 :
                                Request11.setText(checkBoxes.get(10));
                                Request11.setEnabled(true);
                                break;
                            case 11 :
                                Request12.setText(checkBoxes.get(11));
                                Request12.setEnabled(true);
                                break;
                            case 12 :
                                Request13.setText(checkBoxes.get(12));
                                Request13.setEnabled(true);
                                break;
                            case 13 :
                                Request14.setText(checkBoxes.get(13));
                                Request14.setEnabled(true);
                                break;
                            case 14 :
                                Request15.setText(checkBoxes.get(14));
                                Request15.setEnabled(true);
                                break;
                            case 15 :
                                Request16.setText(checkBoxes.get(15));
                                Request16.setEnabled(true);
                                break;
                        }
                    }
                    Request1.setSelected(false);
                    Request2.setSelected(false);
                    Request3.setSelected(false);
                    Request4.setSelected(false);
                    Request5.setSelected(false);
                    Request6.setSelected(false);
                    Request7.setSelected(false);
                    Request8.setSelected(false);
                    Request9.setSelected(false);
                    Request10.setSelected(false);
                    Request11.setSelected(false);
                    Request12.setSelected(false);
                    Request13.setSelected(false);
                    Request14.setSelected(false);
                    Request15.setSelected(false);
                    Request16.setSelected(false);
                    selectedBox.clear();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Tried to access an invalid array index.");
                    System.out.println("Exception message: " + e.getMessage());
                }
                
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Request15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request15ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request15.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request15.isSelected() && !finalStatus.equals("Rejected") || !finalStatus.equals("Approved")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request15.getText());
        }else if (!Request15.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request15.getText());
        }
    }//GEN-LAST:event_Request15ActionPerformed

    private void Request9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request9ActionPerformed
        // TODO add your handling code here:
        if (Request9.isSelected()) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request9.getText());
        }else if (!Request9.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request9.getText());
        }
    }//GEN-LAST:event_Request9ActionPerformed

    private void Request1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request1ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request1.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        
        if (finalStatus.equals("Rejected")){
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
        }else if (finalStatus.equals("Approved")) {
            jButton4.setEnabled(false);
            jButton3.setEnabled(true);
        }else {
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        }
        
        if (Request1.isSelected()) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request1.getText());
        }else if (!Request1.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request1.getText());
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
        }
        System.out.println("selectedBox = " +selectedBox);
    }//GEN-LAST:event_Request1ActionPerformed

    private void Request2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request2ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request2.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request2.isSelected() && !finalStatus.equals("Rejected")) {
            selectedBox.add(Request2.getText());
        }else if (!Request2.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request2.getText());
        }
    }//GEN-LAST:event_Request2ActionPerformed

    private void Request3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request3ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request3.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request3.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request3.getText());
        }else if (!Request3.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request3.getText());
        }
    }//GEN-LAST:event_Request3ActionPerformed

    private void Request4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request4ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request4.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request4.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request4.getText());
        }else if (!Request4.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request4.getText());
        }
    }//GEN-LAST:event_Request4ActionPerformed

    private void Request5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request5ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request5.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request5.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request5.getText());
        }else if (!Request5.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request5.getText());
        }
    }//GEN-LAST:event_Request5ActionPerformed

    private void Request6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request6ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request6.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request6.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request6.getText());
        }else if (!Request6.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request6.getText());
        }
    }//GEN-LAST:event_Request6ActionPerformed

    private void Request7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request7ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request7.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request7.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request7.getText());
        }else if (!Request7.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request7.getText());
        }
    }//GEN-LAST:event_Request7ActionPerformed

    private void Request8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request8ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request8.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request8.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request8.getText());
        }else if (!Request8.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request8.getText());
        }
    }//GEN-LAST:event_Request8ActionPerformed

    private void Request10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request10ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request10.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request10.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request10.getText());
        }else if (!Request10.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request10.getText());
        }
    }//GEN-LAST:event_Request10ActionPerformed

    private void Request11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request11ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request11.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request11.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request11.getText());
        }else if (!Request11.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request11.getText());
        }
    }//GEN-LAST:event_Request11ActionPerformed

    private void Request12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request12ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request12.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request12.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request12.getText());
        }else if (!Request12.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request12.getText());
        }
    }//GEN-LAST:event_Request12ActionPerformed

    private void Request13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request13ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request13.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request13.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request13.getText());
        }else if (!Request13.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request13.getText());
        }
    }//GEN-LAST:event_Request13ActionPerformed

    private void Request14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request14ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request14.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request14.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request14.getText());
        }else if (!Request14.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request14.getText());
        }
    }//GEN-LAST:event_Request14ActionPerformed

    private void Request16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Request16ActionPerformed
        // TODO add your handling code here:
        String getStatus = Request16.getText();
        String splitStatus[] = getStatus.split(", ");
        String finalStatus = splitStatus[6];
        if (Request16.isSelected() && !finalStatus.equals("Rejected")) {
//            selectedBox.add(Arrays.asList(Request1.getText()));
            selectedBox.add(Request16.getText());
        }else if (!Request16.isSelected()) {
//            selectedBox.remove(Arrays.asList(Request1.getText()));
            selectedBox.remove(Request16.getText());
        }
    }//GEN-LAST:event_Request16ActionPerformed

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
            java.util.logging.Logger.getLogger(Requests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Request1;
    private javax.swing.JCheckBox Request10;
    private javax.swing.JCheckBox Request11;
    private javax.swing.JCheckBox Request12;
    private javax.swing.JCheckBox Request13;
    private javax.swing.JCheckBox Request14;
    private javax.swing.JCheckBox Request15;
    private javax.swing.JCheckBox Request16;
    private javax.swing.JCheckBox Request2;
    private javax.swing.JCheckBox Request3;
    private javax.swing.JCheckBox Request4;
    private javax.swing.JCheckBox Request5;
    private javax.swing.JCheckBox Request6;
    private javax.swing.JCheckBox Request7;
    private javax.swing.JCheckBox Request8;
    private javax.swing.JCheckBox Request9;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
