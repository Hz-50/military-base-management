package com.militarybase.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;

import com.militarybase.model.User;
import com.militarybase.model.UserData;
import com.militarybase.service.UserDataService;
import com.militarybase.service.UserService;
import net.miginfocom.swing.*;

public class LoginScreen extends JFrame {

    private UserService userService = new UserService();

    public LoginScreen() {
        initComponents();
        setTitle("Military Base Login");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox2.getSelectedItem();

            User user = userService.authenticate(id, password, role);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                // after successful login, Open your dashboard and load user's data
                // Example: After verifying login credentials

                UserData userData = UserDataService.loadUserData(user.getId()); // Load or create UserData

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









    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad

        label5 = new JLabel();
        label7 = new JLabel();
        idField = new JTextField();
        label3 = new JLabel();
        passwordField = new JPasswordField();
        label4 = new JLabel();
        comboBox2 = new JComboBox<>();
        newAccountButton = new JButton();
        loginButton = new JButton();

        //======== LoginPanel ========
        {
            this.setPreferredSize(new Dimension(900, 600));
            this.setForeground(UIManager.getColor("CodeWithMe.Buttons.LinkCopied.Background"));
            this.setBackground(new Color(0x999900));
            var ContentPane = this.getContentPane();
            ContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)ContentPane.getLayout()).columnWidths = new int[] {0, 107, 0, 0, 0, 0, 0, 0, 107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)ContentPane.getLayout()).rowHeights = new int[] {0, 0, 157, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)ContentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)ContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Military Base Security & Operations Management System ");
            label5.setBackground(new Color(0x33ff33));
            label5.setIcon(null);
            label5.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 23));
            ContentPane.add(label5, new GridBagConstraints(1, 0, 19, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 7, 0), 0, 0));

            //---- label7 ----
            label7.setText("Id:");
            label7.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 13));
            ContentPane.add(label7, new GridBagConstraints(9, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
            ContentPane.add(idField, new GridBagConstraints(10, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

            //---- label3 ----
            label3.setText("Password:");
            label3.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 13));
            ContentPane.add(label3, new GridBagConstraints(9, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
            ContentPane.add(passwordField, new GridBagConstraints(10, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

            //---- label4 ----
            label4.setText("Type:");
            label4.setFont(new Font("JetBrains Mono SemiBold", Font.PLAIN, 13));
            ContentPane.add(label4, new GridBagConstraints(9, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "Personnel",
                "Base Commander"
            }));
            comboBox2.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 13));
            ContentPane.add(comboBox2, new GridBagConstraints(10, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

            //---- newAccountButton ----
            newAccountButton.setText("New Account");
            newAccountButton.setFont(new Font("JetBrains Mono ExtraBold", Font.ITALIC, 13));
            ContentPane.add(newAccountButton, new GridBagConstraints(9, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setFont(new Font("JetBrains Mono ExtraBold", Font.ITALIC, 13));
            ContentPane.add(loginButton, new GridBagConstraints(10, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad

    private JLabel label5;
    private JLabel label7;
    private JTextField idField;
    private JLabel label3;
    private JPasswordField passwordField;
    private JLabel label4;
    private JComboBox<String> comboBox2;
    private JButton newAccountButton;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen().setVisible(true));

    }


}