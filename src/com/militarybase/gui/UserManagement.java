package com.militarybase.gui;

import com.militarybase.model.User;
import com.militarybase.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserManagement extends JPanel {
    private JTable userTable;
    private DefaultTableModel tableModel;
    private JTextField idField, passwordField;
    private JComboBox<String> roleBox;
    private JButton addButton, deleteButton;

    private User currentUser;
    private UserService userService;

    public UserManagement(User currentUser) {
        this.currentUser = currentUser;
        this.userService = UserService.getInstance();
        initComponents();
        loadUsers();
        setupActions();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10, 10));

        tableModel = new DefaultTableModel(new Object[]{"User ID", "Role"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable = new JTable(tableModel);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableScroll = new JScrollPane(userTable);

        idField = new JTextField(8);
        passwordField = new JTextField(8);
        roleBox = new JComboBox<>(new String[]{"personnel", "security", "commander"});

        addButton = new JButton("Add User");
        deleteButton = new JButton("Delete User");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleBox);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        this.add(tableScroll, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.SOUTH);
    }

    private void loadUsers() {
        tableModel.setRowCount(0);
        List<User> users = userService.loadUsers();
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getId(), user.getRole()});
        }
    }

    private void setupActions() {
        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = passwordField.getText().trim();
            String role = (String) roleBox.getSelectedItem();

            if (id.isEmpty() || password.isEmpty() || role == null || role.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }
            if (userService.getUserById(id) != null) {
                JOptionPane.showMessageDialog(this, "User ID already exists.");
                return;
            }
            boolean success = userService.registerUser(id, password, role);
            if (success) {
                JOptionPane.showMessageDialog(this, "User added!");
                loadUsers();
                idField.setText("");
                passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add user.");
            }
        });

        deleteButton.addActionListener(e -> {
            int row = userTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a user to delete.");
                return;
            }
            String userId = (String) tableModel.getValueAt(row, 0);
            if (userId.equals(currentUser.getId())) {
                JOptionPane.showMessageDialog(this, "You cannot delete yourself.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Delete user " + userId + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = userService.deleteUser(userId);
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "User deleted.");
                    loadUsers();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete user.");
                }
            }
        });
    }
}