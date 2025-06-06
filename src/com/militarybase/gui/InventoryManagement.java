/*
 * Created by JFormDesigner on Sat May 24 13:57:17 PKT 2025
 */

package com.militarybase.gui;

import javax.swing.*;
import javax.swing.table.*;

import com.militarybase.model.User;
import com.militarybase.model.UserData;
import com.militarybase.service.UserDataService;
import net.miginfocom.swing.*;

/**
 * @author Latitude
 */
public class InventoryManagement {
    private UserData userData;
    private User user;
    private DefaultTableModel tableModel;

    
    public InventoryManagement(User user, UserData userData) {
        this.user = user;
        this.userData = userData;


        initComponents();
        tableModel = new DefaultTableModel(new Object[] {"Item","Count","Status"},0);
        inventoryTable.setModel(tableModel);

        // Role Based Access Control
        if (user.getRole().equals("Personnel")) {
            addButton.setEnabled(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }


        // Load saved rows
        /*
        When the user logs in, you load their UserData from disk.
userData.getInventoryRows() provides all their saved inventory entries.
This loop puts each entry back into the table, so the user sees their own data right away.
         */
        for (Object[] row : userData.getInventoryRows()) {
            tableModel.addRow(row);
        }

        // event listeners
        addButton.addActionListener(e -> {
            String item = itemField.getText().trim();
            String count = countField.getText().trim();
            String availability = (String) statusBox.getSelectedItem();
            if(item.isEmpty() || count.isEmpty() || availability.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter all Fields");
                return;
            }
            // Validate count is a number
            try {
                Integer.parseInt(count);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Count must be a number");
                return;
            }

            Object[] row = new Object[] {item, count, availability}; // make new object to list:row
            tableModel.addRow(row); // display on the table
            userData.getInventoryRows().add(new Object[] {item, count, availability}); // add it List of userData for Data persistence
            UserDataService.saveUserData(user.getId(), userData); // now save data for specific user
            itemField.setText("");
            countField.setText("");
        });

        /*
        When a row is selected for editing, you load its values into the input fields.
        remove the original row from both the table and userData.getInventoryRows() so when you add the edited version,
         there’s no duplicate.
        After editing (and adding  the updated row),  call UserDataService.saveUserData(user.getId(), userData);
        to persist the changes to disk for this user.
         */
        editButton.addActionListener(e -> {
            int row = inventoryTable.getSelectedRow();
            if (row != -1) {
                itemField.setText((String) tableModel.getValueAt(row, 0));
                countField.setText((String) tableModel.getValueAt(row, 1));
                statusBox.setSelectedItem(tableModel.getValueAt(row, 2));
                tableModel.removeRow(row);
                userData.getInventoryRows().remove(row);
                UserDataService.saveUserData(user.getId(),userData);
            } else {
                JOptionPane.showMessageDialog(null,"Select a row to edit");
            }
        });

        deleteButton.addActionListener(e -> {
            int row = inventoryTable.getSelectedRow();
            if(row != -1){
                // Get the actual data for this row
                Object[] data = userData.getInventoryRows().get(row);
                tableModel.removeRow(row);
                userData.getInventoryRows().remove(data); // Remove by object, not index
                UserDataService.saveUserData(user.getId(),userData);
            } else {
                JOptionPane.showMessageDialog(null,"Select row to delete it.");
            }
        });
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
        inventoryPanel = new JFrame();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        inventoryTable = new JTable();
        label2 = new JLabel();
        itemField = new JTextField();
        label3 = new JLabel();
        countField = new JTextField();
        label4 = new JLabel();
        statusBox = new JComboBox<>();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();

        //======== inventoryPanel ========
        {
            var inventoryPanelContentPane = inventoryPanel.getContentPane();
            inventoryPanelContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Inventory Management");
            inventoryPanelContentPane.add(label1, "cell 6 0");

            //======== scrollPane1 ========
            {

                //---- inventoryTable ----
                inventoryTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Item", "Count", "Status"
                    }
                ));
                scrollPane1.setViewportView(inventoryTable);
            }
            inventoryPanelContentPane.add(scrollPane1, "cell 6 2");

            //---- label2 ----
            label2.setText("Item");
            inventoryPanelContentPane.add(label2, "cell 6 3");
            inventoryPanelContentPane.add(itemField, "cell 6 3");

            //---- label3 ----
            label3.setText("Count");
            inventoryPanelContentPane.add(label3, "cell 6 3");
            inventoryPanelContentPane.add(countField, "cell 6 3");

            //---- label4 ----
            label4.setText("Status");
            inventoryPanelContentPane.add(label4, "cell 6 3");

            //---- statusBox ----
            statusBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Available",
                "InTransit",
                "Not Available",
                "Depreciated"
            }));
            inventoryPanelContentPane.add(statusBox, "cell 6 3");

            //---- addButton ----
            addButton.setText("Add");
            inventoryPanelContentPane.add(addButton, "cell 6 4");

            //---- editButton ----
            editButton.setText("Edit");
            inventoryPanelContentPane.add(editButton, "cell 6 4");

            //---- deleteButton ----
            deleteButton.setText("Delete");
            inventoryPanelContentPane.add(deleteButton, "cell 6 4");
            inventoryPanel.pack();
            inventoryPanel.setLocationRelativeTo(inventoryPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad
    JFrame inventoryPanel;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable inventoryTable;
    private JLabel label2;
    private JTextField itemField;
    private JLabel label3;
    private JTextField countField;
    private JLabel label4;
    private JComboBox<String> statusBox;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}


