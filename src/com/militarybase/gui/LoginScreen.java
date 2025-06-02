package com.militarybase.gui;

import javax.swing.*;
import com.militarybase.model.User;
import com.militarybase.model.UserData;
import com.militarybase.service.UserDataService;
import com.militarybase.service.UserService;
import net.miginfocom.swing.*;

public class LoginScreen extends JFrame {
    private JLabel label1, label2, label3, label4;
    private JTextField idField;
    private JPasswordField passwordField;
    private JComboBox<String> comboBox2;
    private JButton newAccountButton, loginButton;
    private JScrollPane scrollPane4;
    private UserService userService = new UserService();

    public LoginScreen() {
        initComponents();
        setTitle("Military Base Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        label1 = new JLabel("Login Screen");
        label2 = new JLabel("Id:");
        idField = new JTextField();
        label3 = new JLabel("Password:");
        passwordField = new JPasswordField();
        label4 = new JLabel("Type:");
        comboBox2 = new JComboBox<>(new String[] { "Personnel", "Base Commander" });
        newAccountButton = new JButton("New Account");
        loginButton = new JButton("Login");
        scrollPane4 = new JScrollPane();

        setLayout(new MigLayout("hidemode 3",
                "[fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][fill]",
                "[][][][][][][][]"));

        add(label1, "cell 5 0 8 1");
        add(label2, "cell 2 2 2 1");
        add(idField, "cell 5 2 7 1");
        add(label3, "cell 2 3 3 1");
        add(passwordField, "cell 5 3 7 1");
        add(label4, "cell 2 4 3 1");
        add(comboBox2, "cell 5 4");
        add(newAccountButton, "cell 2 5");
        add(loginButton, "cell 5 5");
        add(scrollPane4, "cell 7 5 9 1");

        loginButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox2.getSelectedItem();

            User user = userService.authenticate(id, password, role);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                // after successful login, Open your dashboard and load user's data
                // Example: After verifying login credentials
                User user1 = new User(id, password, role); // Construct your User object as appropriate
                UserData userData = UserDataService.loadUserData(user1.getId()); // Load or create UserData

                new Dashboard(user, userData).setVisible(true);
                ;
                this.dispose(); // Close login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        newAccountButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox2.getSelectedItem();

            if (id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID and password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (userService.registerUser(id, password, role)) {
                JOptionPane.showMessageDialog(this, "Registration Successful! You may now login.");
            } else {
                JOptionPane.showMessageDialog(this, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen().setVisible(true));

    }
}