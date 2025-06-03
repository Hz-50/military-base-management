package com.militarybase.gui;

import com.militarybase.model.User;
import com.militarybase.model.UserData;
import com.militarybase.service.UserDataService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PersonnelManagement  {

    JFrame personnelPanel;
    private JTable personnelTable;
    private JTextField idField, nameField, roleField;
    private JButton addButton, editButton, deleteButton;
    private DefaultTableModel tableModel;

    private UserData userData;
    private User user;

    public PersonnelManagement(User user,UserData userData) {
        this.user = user;
        this.userData = userData;
        initComponents();

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Role"}, 0);
        personnelTable.setModel(tableModel);

        // Role Based Access Control
        if (!user.getRole().equals("Base Commander")) {
            addButton.setEnabled(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }

        // load saved data
        for(Object[] row : userData.getPersonnelRows()){
            tableModel.addRow(row);
        }

        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String role = roleField.getText().trim();
            if (id.isEmpty() || name.isEmpty() || role.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");
                return;
            }
            tableModel.addRow(new Object[]{id, name, role});
            // Data persistence
            userData.getPersonnelRows().add(new Object[] {id,name,role});
            UserDataService.saveUserData(user.getId(),userData);


            idField.setText("");
            nameField.setText("");
            roleField.setText("");
        });

        deleteButton.addActionListener(e -> {
            int row = personnelTable.getSelectedRow();
            if (row != -1) {
                tableModel.removeRow(row);
                userData.getPersonnelRows().remove(row);
                UserDataService.saveUserData(user.getId(),userData);
            } else {
                JOptionPane.showMessageDialog(null, "Select a row to delete!");
            }
        });

        editButton.addActionListener(e -> {
            int row = personnelTable.getSelectedRow();
            if (row != -1) {
                idField.setText((String) tableModel.getValueAt(row, 0));
                nameField.setText((String) tableModel.getValueAt(row, 1));
                roleField.setText((String) tableModel.getValueAt(row, 2));
                tableModel.removeRow(row);
                userData.getPersonnelRows().remove(row);
                UserDataService.saveUserData(user.getId(),userData);
            } else {
                JOptionPane.showMessageDialog(null, "Select a row to edit!");
            }
        });
    }

    private void initComponents() {
        // MINIMAL MANUAL VERSION (JFormDesigner does this for you in a bigger way)
        personnelPanel = new JFrame("Personnel Management");
        personnelPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        personnelPanel.setSize(600, 400);
        personnelPanel.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        idField = new JTextField(6);
        nameField = new JTextField(10);
        roleField = new JTextField(8);
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleField);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);

        personnelTable = new JTable();

        personnelPanel.setLayout(new BorderLayout());
        personnelPanel.add(inputPanel, BorderLayout.SOUTH);
        personnelPanel.add(new JScrollPane(personnelTable), BorderLayout.CENTER);
    }


}