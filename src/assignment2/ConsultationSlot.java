package assignment2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.table.*;

public class ConsultationSlot extends javax.swing.JFrame {
    File slotInfo = new File("src\\TextFile\\SlotInfo");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //format the date to 23-05-2004
    ImageIcon topLogo = new ImageIcon("src/Image/simple apu logo.png"); //logo on top left corner
    LocalDate ld = LocalDate.now(); //get the date now
    DefaultComboBoxModel<String> minutes = new DefaultComboBoxModel<>(); //date filter
    DefaultComboBoxModel<String> hours = new DefaultComboBoxModel<>(); //date filter
    
    int selectedYear;
    int Year = ld.getYear();
    int dayOfMonth = ld.getDayOfMonth(); //Get today date like dd
    int month = ld.getMonthValue(); //Get today month like MM

    String selectedDate = String.valueOf(dayOfMonth);
    String selectedRoom;
    
    //table content setup
    private String[] columnName = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private Object[][] data = {
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null}
    };
    
    //table model setup
    DefaultTableModel model = new DefaultTableModel(data, columnName) {
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    //reuseable clearTable
    public static void clearTable(DefaultTableModel model) {
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                model.setValueAt(null, row, col);
            }
        }
    }
    
    //calendar generator
    public static SelectDate Calendar(DefaultTableModel model, int rowCount, int dayToNum, int lengthOfMonth, int dayOfMonth) {
        clearTable(model);
        int day = 1;
        int selectDateR = -1;
        int selectDateC = -1;
        for (int i = 0; i < rowCount; i++){
            for (int j = dayToNum; j < 7; j++){
                model.setValueAt(String.valueOf(day), i, j); //value, row, column
                day ++;
                if (day > lengthOfMonth){
                    break;
                } else if (day == dayOfMonth+1){
                    selectDateR = i;
                    selectDateC = j;
                }
            dayToNum = 0;
            }
        }
        return new SelectDate(selectDateR, selectDateC);
    }
    
    //room generator
    public static ArrayList<String> Room(){
        Random r = new Random();
        Character blockLs[] = {'A', 'B', 'C', 'D', 'E', 'S'};
        ArrayList<Character> genBlock = new ArrayList<Character>(); 
        int blockIndex = r.nextInt(0, 6);
        int floor = r.nextInt(4, 9);
        ArrayList<Sorter> genFloor = new ArrayList<Sorter>();
        int room = r.nextInt(1, 18);
        ArrayList<RoomSorter> genRoom = new ArrayList<RoomSorter>();
        ArrayList<String> meetRoom = new ArrayList<>();
        
        Character temp = 'A';
        for (int i = blockIndex; i < blockLs.length; i = r.nextInt(i, 7)){
            temp = blockLs[i];
            genBlock.add(temp);
        }
        if (genBlock.size() < 9){
                while (genBlock.size() < 9) {
                    genBlock.add(temp);
                }
        }
        for (int i = 0; i < 9; i++){
            floor = r.nextInt(4, 10);
            genFloor.add(new Sorter(floor));
        }
        for (int i = 0; i < 9; i++){
            room = r.nextInt(1, 18);
            genRoom.add(new RoomSorter(room));
        }
        
        Collections.sort(genFloor, (p1, p2) -> Integer.compare(p1.floor, p2.floor));
        Collections.sort(genRoom, (p1, p2) -> Integer.compare(p1.room, p2.room));

        for (int i = 0; i < 9; i++){
            String formattedString = String.format("%s-%s-%s", genBlock.get(i), genFloor.get(i), genRoom.get(i));
            meetRoom.add(formattedString);
        }
        
        return meetRoom;
        
        
        
        
//        System.out.println(genFloor);
//        System.out.println(genBlock);
//        System.out.println(genRoom);
//        System.out.println(meetRoom);
//            System.out.println("Test" + i);
        
        
        
    }
    
    //generated
    public ConsultationSlot() {
        model.setColumnIdentifiers(columnName);
        initComponents();

        // KH add
//        System.out.println(date);
        Room();

        getContentPane().setBackground(new Color(0x2a3935));
        jComboBox1.setSelectedIndex(month-1);
        jComboBox2.setSelectedIndex(Year-2024);
        
        //am pm selector
        LocalTime lt = LocalTime.now();
        int currentHour = lt.getHour();
        System.out.println(currentHour);
        if (currentHour > 12) {
            currentHour -= 12;
            System.out.println(currentHour);
            jComboBox5.setSelectedItem("PM");
            if (currentHour == 0){
                currentHour = 12;
            }
        }else{
            jComboBox5.setSelectedItem("AM");
        }
        
        //minutes generate
        int currentMin = lt.getMinute();
        int Minute = 0;
        for (int i = 0; i < 12; i++) {
            minutes.addElement(String.format("%02d", Minute));
            if (currentMin <= Minute){
                int selectMin = Minute - currentMin;
                if (selectMin <= 5){
                    jComboBox4.setSelectedIndex(i);
                }
            }else if(currentMin > 55){
                jComboBox3.remove(0);
            }
            Minute +=5;
        }
//        System.out.println(currentMin);

//        LocalTime lt = LocalTime.now();
//        int currentHour = lt.getHour();

        //hour generate
        System.out.println(currentHour);
        if (currentHour > 12) {
            currentHour -= 12;
            System.out.println(currentHour);
        }
        for (int i = 1; i <= 12; i++) {
            hours.addElement(String.valueOf(i));
        }
        jComboBox3.setSelectedIndex(currentHour-1);

        jRadioButton1.setText(Room().get(0));
        jRadioButton2.setText(Room().get(1));
        jRadioButton3.setText(Room().get(2));
        jRadioButton4.setText(Room().get(3));
        jRadioButton5.setText(Room().get(4));
        jRadioButton6.setText(Room().get(5));
        jRadioButton7.setText(Room().get(6));
        jRadioButton8.setText(Room().get(7));
        jRadioButton1.setSelected(true);
        selectedRoom = jRadioButton1.getText();
        
        
        
        
        
        
    }
    
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(topLogo.getImage()
        );
        setLocation(new java.awt.Point(256, 128));
        setResizable(false);

        jTable1.setModel(model);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(hours);

        jLabel2.setForeground(new java.awt.Color(211, 239, 233));
        jLabel2.setText("Date: ");

        jLabel3.setForeground(new java.awt.Color(211, 239, 233));
        jLabel3.setText("Time: ");

        jLabel4.setForeground(new java.awt.Color(211, 239, 233));
        jLabel4.setText("Day: ");

        jComboBox4.setModel(minutes);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(211, 239, 233));
        jLabel5.setText(":");

        jLabel6.setForeground(new java.awt.Color(211, 239, 233));
        jLabel6.setText("Room: ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton1.setText("A-04-04");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton2.setText("A-04-05");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton3.setText("A-05-05");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton4.setText("A-06-06");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton5.setText("B-06-06");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton6.setText("B-07-07");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton7.setText("B-08-08");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton8.setText("S-08-01");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setForeground(new java.awt.Color(211, 239, 233));
        jRadioButton9.setText("Online Teams");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(211, 239, 233));
        jLabel7.setText("Consultation Slot");

        jLabel1.setForeground(new java.awt.Color(211, 239, 233));
        jLabel1.setText("8-11-2025");

        jLabel8.setForeground(new java.awt.Color(211, 239, 233));
        jLabel8.setText("SATURDAY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jRadioButton7)
                                            .addComponent(jRadioButton4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton9)))))))
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(187, 187, 187))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton9))))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int column = (jTable1.getSelectedColumn());
        int row = (jTable1.getSelectedRow());
        int month = jComboBox1.getSelectedIndex() + 1;
        int Year = jComboBox2.getSelectedIndex() + 2024;
        
        try {
            selectedDate = String.valueOf(model.getValueAt(row, column));
            int intDate = Integer.valueOf(selectedDate);
            LocalDate selectDate = LocalDate.of(Year, Month.of(month), intDate);
            String date = selectDate.format(formatter);
            String day = String.valueOf(selectDate.getDayOfWeek());
            if (selectDate.isBefore(ld)){
                System.out.println("Can't be select");
            }else{
                jLabel1.setText(date);
                jLabel8.setText(day);
            }
        } catch (NumberFormatException e) {
            System.out.println("selectedDate = "+ selectedDate);
        }
        
        
        
        
        
        
        System.out.println("table1 mouse released");
    }//GEN-LAST:event_jTable1MouseReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int month = jComboBox1.getSelectedIndex() + 1;
        int Year = jComboBox2.getSelectedIndex() + 2024;
        
        selectedYear = Integer.parseInt( jComboBox2.getItemAt(Year-2024) ); //2024
        LocalDate firstDayOfMonth = LocalDate.of(selectedYear, Month.of(month), 1);//get first day yyyy-MM-dd
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek(); //first day of the month like FRIDAY
        
        int lengthOfMonth = firstDayOfMonth.lengthOfMonth(); //Total days in month
        int dayToNum = firstDayOfWeek.getValue(); // get number like Sunday = 7
        
        if (dayToNum == 7){
            dayToNum = 0;
        }
        
        int rowCount = (int) Math.ceil(((double) lengthOfMonth + (double) dayToNum) / 7);
        
        SelectDate result = Calendar(model, rowCount, dayToNum, lengthOfMonth, dayOfMonth);
        
        Calendar(model, rowCount, dayToNum, lengthOfMonth, dayOfMonth);
        
//        System.out.println("null");
        SwingUtilities.invokeLater(() -> {
////            jTable1.setCellSelectionEnabled(false);
        jTable1.changeSelection(result.row, result.column , false, false);
////            jTable1.setSelectionBackground(Color.lightGray);
////        System.out.println(result.row);
////        System.out.println(result.column);
//        System.out.println(selectedDate);
        });
        


        try {
            selectedDate = String.valueOf(model.getValueAt(result.row, result.column));
            int intDate = Integer.valueOf(selectedDate);
            LocalDate selectDate = LocalDate.of(Year, Month.of(month), intDate);
            String date = selectDate.format(formatter);
            String day = String.valueOf(selectDate.getDayOfWeek());
            if (selectDate.isBefore(ld)){
                System.out.println("Can't be select");
            }else{
                jLabel1.setText(date);
                jLabel8.setText(day);
            }
        } catch (NumberFormatException e) {
            System.out.println("selectedDate = "+ selectedDate);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception");
        }
 
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int month = jComboBox1.getSelectedIndex() + 1;
        int Year = jComboBox2.getSelectedIndex() + 2024;
        
        selectedYear = Integer.parseInt( jComboBox2.getItemAt(Year-2024) ); //2024
        LocalDate firstDayOfMonth = LocalDate.of(selectedYear, Month.of(month), 1);//get first day yyyy-MM-dd
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek(); //first day of the month like FRIDAY
        
        int lengthOfMonth = firstDayOfMonth.lengthOfMonth(); //Total days in month
        int dayToNum = firstDayOfWeek.getValue(); // get number like Sunday = 7
        
        if (dayToNum == 7){
            dayToNum = 0;
        }
        
        int rowCount = (int) Math.ceil(((double) lengthOfMonth + (double) dayToNum) / 7);
        
        Calendar(model, rowCount, dayToNum, lengthOfMonth, dayOfMonth);


        try {
            int intDate = Integer.valueOf(selectedDate);
            LocalDate selectDate = LocalDate.of(Year, Month.of(month), intDate);
            String date = selectDate.format(formatter);
            String day = String.valueOf(selectDate.getDayOfWeek());
            if (selectDate.isBefore(ld)){
                System.out.println("Can't be select");
            }else{
                jLabel1.setText(date);
                jLabel8.setText(day);
            }
        } catch (NumberFormatException e) {
            System.out.println("selectedDate = "+ selectedDate);
        }
 
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        System.out.println(jComboBox5.getSelectedItem());
        
        
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton2.getText());
        selectedRoom = jRadioButton2.getText();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton3.getText());
        selectedRoom = jRadioButton3.getText();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusLost

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1MousePressed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
//        SwingUtilities.invokeLater(() -> {
//            jTable1.setCellSelectionEnabled(false);
//            jTable1.changeSelection(-1, -1, false, false);
////            jTable1.setUpdateSelectionOnSort(true);
//        });
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton1.getText());
        selectedRoom = jRadioButton1.getText();
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int intDate = Integer.valueOf(selectedDate);
        LocalDate selectDate = LocalDate.of(Year, Month.of(month), intDate);
        String date = selectDate.format(formatter);
        String day = String.valueOf(selectDate.getDayOfWeek());
        try {
            if (selectDate.isBefore(ld)){
                System.out.println("Can't be select");
            }else{
                jLabel1.setText(date);
                jLabel8.setText(day);
            }
        } catch (NumberFormatException e) {
            System.out.println("selectedDate = "+ selectedDate);
        }
        
        System.out.println(date);
        System.out.println(day);
        
        System.out.println(jComboBox3.getSelectedItem());
        System.out.println(jComboBox4.getSelectedItem());
        System.out.println(jComboBox5.getSelectedItem());
        

        int finalHour = Integer.valueOf(String.valueOf(jComboBox3.getSelectedItem()));
        int finalMinute = Integer.valueOf(String.valueOf(jComboBox4.getSelectedItem()));
        String ampm = String.valueOf(jComboBox5.getSelectedItem());
        
        LocalTime selectedTime = LocalTime.of(finalHour, finalMinute);
        int endFinalHour = finalHour +1;
        if (endFinalHour >= 13){
            endFinalHour -=12;
        }
        LocalTime endTime = LocalTime.of(endFinalHour, finalMinute);
        
        System.out.println(selectedTime);
        System.out.println(ampm);
        
        System.out.println(selectedRoom);
        
//        File slotInfo = new File("src\\TextFile\\SlotInfo");
        int bookRow = 1;
        
        try (Scanner scanner = new Scanner(slotInfo)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine(); // Read and skip the current line
                bookRow++; // Increment the counter
            }
            System.out.println("Number of rows: " + bookRow);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        try {
            if (!slotInfo.exists()) {
                slotInfo.createNewFile();
            }
            
            int bookId = bookRow++;
//            String bookId = BookId(slotInfo.length()+1);
            
            FileWriter slotWriter = new FileWriter(slotInfo, true);
            slotWriter.write(LoginSession.loginName+",B"+bookId + "," + selectedTime + " - "+endTime+" " + ampm +  "," + date + "," + day + ","+ selectedRoom + "\n");
            slotWriter.close();
        }catch(FileNotFoundException e) {
            System.out.println("Found not found");
        }catch (IOException e) {
            System.out.println("an error occur");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton4.getText());
        selectedRoom = jRadioButton4.getText();
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton5.getText());
        selectedRoom = jRadioButton5.getText();
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton6.getText());
        selectedRoom = jRadioButton6.getText();
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton7.getText());
        selectedRoom = jRadioButton7.getText();
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton8.getText());
        selectedRoom = jRadioButton8.getText();
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
        System.out.println(jRadioButton9.getText());
        selectedRoom = jRadioButton9.getText();
    }//GEN-LAST:event_jRadioButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultationSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultationSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultationSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultationSlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultationSlot().setVisible(true);

            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
