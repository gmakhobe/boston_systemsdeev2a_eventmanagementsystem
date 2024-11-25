/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.eventmanagementsystem;

import com.mycompany.eventmanagementsystem.Database;
import com.mycompany.eventmanagementsystem.HomeScreen;
import com.mycompany.eventmanagementsystem.InputValidation;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bbdnet2332
 */
public class VenueManagement extends javax.swing.JFrame {

    /**
     * Creates new form VenueManagement
     */
    DefaultTableModel venueManagementJTable;
    private int venueId;
    private String venueName;
    private String venueAddress;
    private String venueCapacity;
    private int venueAvailability;
    
    public VenueManagement() {
        initComponents();
        
        venueManagementJTable = (DefaultTableModel) tableVenueManagement.getModel();
        
        writeDatabaseInfoToTable(true);
        TableEventManager();
        
        this.venueId = 0;
    }
    
    public void TableEventManager(){
        tableVenueManagement.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tableVenueManagement.getSelectedRow();

                if (selectedRow != -1) {

                    // Get values from the selected row
                    int columnCount = this.venueManagementJTable.getColumnCount();
                    Vector rowData = new Vector();
                    for (int i = 0; i < columnCount; i++) {
                        rowData.add(this.venueManagementJTable.getValueAt(selectedRow, i));
                    }

                    this.venueId = Integer.parseInt((String) rowData.get(0));
                    this.venueAvailability = Integer.parseInt((String) rowData.get(4));
                    
                    
                    int availabilityValue = 0;
                    
                    if (this.venueAvailability == 1){
                        availabilityValue = 0;
                    }
                    
                    if (this.venueAvailability == 0){
                        availabilityValue = 1;
                    }
                    
                    textfieldVenueName.setText((String)rowData.get(1));
                    textfieldAddress.setText((String) rowData.get(2));
                    textfieldCapacity.setText((String) rowData.get(3));
                    comboboxAvailability.setSelectedIndex(availabilityValue);
                }
            }
        });
    }
    
    public void writeDatabaseInfoToTable(boolean initial){
        Database db = new Database();
        Vector information = db.selectAllDataFromATable("venue_management");
        Vector data = (Vector<Vector>) information.get(0);
        Vector columns = (Vector<String>) information.get(1);
        int tableRows = this.venueManagementJTable.getRowCount();
        
        for (int i = tableRows - 1; i >= 0; i--){
                this.venueManagementJTable.removeRow(i);
        }
        
        
        if (initial) {
            for (var columnName : columns){
                this.venueManagementJTable.addColumn(columnName);
            }
        }
        
        int rowsSize = data.size();
   
        for (int i = 0; i < rowsSize; i++) {
            this.venueManagementJTable.addRow((Vector<?>) data.get(i));
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

        textfieldVenueName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textfieldCapacity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVenueManagement = new javax.swing.JTable();
        comboboxAvailability = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textfieldAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonAddVenue = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        buttonEditVanue = new javax.swing.JButton();
        buttonDeleteEvent = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textfieldVenueName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldVenueNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Venue Name:");

        jLabel3.setText("Address");

        textfieldCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldCapacityActionPerformed(evt);
            }
        });

        tableVenueManagement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableVenueManagement);

        comboboxAvailability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        jLabel4.setText("Capacity");

        jLabel5.setText("Availability");

        jLabel1.setText("Event Management");

        buttonAddVenue.setText("Insert");
        buttonAddVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddVenueActionPerformed(evt);
            }
        });

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        buttonEditVanue.setText("Edit");
        buttonEditVanue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditVanueActionPerformed(evt);
            }
        });

        buttonDeleteEvent.setText("Delete");
        buttonDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteEventActionPerformed(evt);
            }
        });

        jLabel6.setText("1 means True and 0 means False on the column below");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textfieldVenueName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textfieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonAddVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(buttonEditVanue, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(buttonDeleteEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldVenueName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textfieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textfieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboboxAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddVenue)
                    .addComponent(buttonBack)
                    .addComponent(buttonEditVanue)
                    .addComponent(buttonDeleteEvent))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textfieldVenueNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldVenueNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldVenueNameActionPerformed

    private void textfieldCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldCapacityActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.show();

        this.hide();
    }//GEN-LAST:event_buttonBackActionPerformed

    private void buttonAddVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddVenueActionPerformed
        String venueName = textfieldVenueName.getText();
        String address = textfieldAddress.getText();
        String capacity = textfieldCapacity.getText();
        int availability = comboboxAvailability.getSelectedIndex();
        String venueAvailability;
        InputValidation inputVal = new InputValidation();
        
        if (availability == 0){
            venueAvailability = "TRUE";
        }else{
            venueAvailability = "FALSE";
        }
        
        if (inputVal.isFieldEmpty(venueName, "Venue Name") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(address, "Address") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(capacity, "Capacity") == true) {
            return ;
        }
        if (inputVal.isGivenValueNumber(capacity, "Capacity") == false) {
            return ;
        }
        
        Database db = new Database();
        String sqlStatement = "INSERT INTO venue_management (venue_name, address, capacity, availability)" +
                    "VALUES ('"+ venueName +"', '"+ address +"', " + capacity +", "+ venueAvailability +");";
        if (db.insertDataIntoATable(sqlStatement)){
            JOptionPane.showMessageDialog(null, "Information Captured successfully.");
        }else{
            JOptionPane.showMessageDialog(null, "Information Failed Captured.");
        }
        
        textfieldVenueName.setText("");
        textfieldAddress.setText("");
        textfieldCapacity.setText("");
        writeDatabaseInfoToTable(false);
    }//GEN-LAST:event_buttonAddVenueActionPerformed

    private void buttonEditVanueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditVanueActionPerformed
        if (this.venueId < 1) {
            JOptionPane.showMessageDialog(null, "Please select row first to edit from the table.");
            return ;
        }
        
        String venueName = textfieldVenueName.getText();
        String address = textfieldAddress.getText();
        String capacity = textfieldCapacity.getText();
        int availability = comboboxAvailability.getSelectedIndex();
        String venueAvailability;
        InputValidation inputVal = new InputValidation();
        
        if (availability == 0){
            venueAvailability = "TRUE";
        }else{
            venueAvailability = "FALSE";
        }
        
        if (inputVal.isFieldEmpty(venueName, "Venue Name") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(address, "Address") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(capacity, "Capacity") == true) {
            return ;
        }
        if (inputVal.isGivenValueNumber(capacity, "Capacity") == false) {
            return ;
        }
        
        Database db = new Database();
        String sqlStatement =   "UPDATE venue_management " +
                                "SET venue_name = '"+ venueName +"'," +
                                "address = '"+ address +"'," +
                                "capacity = "+ capacity +"," +
                                "availability = "+ venueAvailability +
                                " WHERE venue_id = "+ this.venueId +";";
        if (db.insertDataIntoATable(sqlStatement)){
            JOptionPane.showMessageDialog(null, "Information Updated successfully.");
        }else{
            JOptionPane.showMessageDialog(null, "Information Failed To Update.");
        }
        
        writeDatabaseInfoToTable(false);
        textfieldVenueName.setText("");
        textfieldAddress.setText("");
        textfieldCapacity.setText("");
        this.venueId = 0;
    }//GEN-LAST:event_buttonEditVanueActionPerformed

    private void buttonDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteEventActionPerformed
        if (this.venueId < 1) {
            JOptionPane.showMessageDialog(null, "Please select row first to delete from the table.");
            return ;
        }
        
        String venueName = textfieldVenueName.getText();
        String address = textfieldAddress.getText();
        String capacity = textfieldCapacity.getText();
        int availability = comboboxAvailability.getSelectedIndex();
        String venueAvailability;
        InputValidation inputVal = new InputValidation();
        
        if (availability == 0){
            venueAvailability = "TRUE";
        }else{
            venueAvailability = "FALSE";
        }
        
        if (inputVal.isFieldEmpty(venueName, "Venue Name") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(address, "Address") == true) {
            return ;
        }
        if (inputVal.isFieldEmpty(capacity, "Capacity") == true) {
            return ;
        }
        if (inputVal.isGivenValueNumber(capacity, "Capacity") == false) {
            return ;
        }
        
        Database db = new Database();
        String sqlStatement =   "DELETE FROM venue_management WHERE venue_id = "+ this.venueId +";";
        if (db.insertDataIntoATable(sqlStatement)){
            JOptionPane.showMessageDialog(null, "Information Deleted successfully.");
        }else{
            JOptionPane.showMessageDialog(null, "Information Failed To Delete.");
        }
        
        writeDatabaseInfoToTable(false);
        textfieldVenueName.setText("");
        textfieldAddress.setText("");
        textfieldCapacity.setText("");
        this.venueId = 0;
    }//GEN-LAST:event_buttonDeleteEventActionPerformed

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
            java.util.logging.Logger.getLogger(VenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenueManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenueManagement().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddVenue;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonDeleteEvent;
    private javax.swing.JButton buttonEditVanue;
    private javax.swing.JComboBox<String> comboboxAvailability;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVenueManagement;
    private javax.swing.JTextField textfieldAddress;
    private javax.swing.JTextField textfieldCapacity;
    private javax.swing.JTextField textfieldVenueName;
    // End of variables declaration//GEN-END:variables
}
