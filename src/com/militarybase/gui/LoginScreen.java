/*
 * Created by JFormDesigner on Thu May 22 07:31:39 PKT 2025
 */

package com.militarybase.gui;

import javax.swing.*;

import com.militarybase.model.User;
import com.militarybase.service.UserService;
import net.miginfocom.swing.*;

import java.awt.*;

/**
 * @author Latitude
 */
public class LoginScreen extends Component {

    public LoginScreen() {
        initComponents();

        


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
        LoginPanel = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        idField = new JTextField();
        label3 = new JLabel();
        passwordField = new JPasswordField();
        label4 = new JLabel();
        comboBox2 = new JComboBox<>();
        newAccountButton = new JButton();
        loginButton = new JButton();
        scrollPane4 = new JScrollPane();

        //======== LoginPanel ========
        {
            var LoginPanelContentPane = LoginPanel.getContentPane();
            LoginPanelContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
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
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Login Screen");
            LoginPanelContentPane.add(label1, "cell 5 0 8 1");

            //---- label2 ----
            label2.setText("Id:");
            LoginPanelContentPane.add(label2, "cell 2 2 2 1");
            LoginPanelContentPane.add(idField, "cell 5 2 7 1");

            //---- label3 ----
            label3.setText("Password:");
            LoginPanelContentPane.add(label3, "cell 2 3 3 1");
            LoginPanelContentPane.add(passwordField, "cell 5 3 7 1");

            //---- label4 ----
            label4.setText("Type:");
            LoginPanelContentPane.add(label4, "cell 2 4 3 1");

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "Personnel",
                "Base Commander"
            }));
            LoginPanelContentPane.add(comboBox2, "cell 5 4");

            //---- newAccountButton ----
            newAccountButton.setText("New Account");
            LoginPanelContentPane.add(newAccountButton, "cell 2 5");

            //---- loginButton ----
            loginButton.setText("Login");
            LoginPanelContentPane.add(loginButton, "cell 5 5");
            LoginPanelContentPane.add(scrollPane4, "cell 7 5 9 1");
            LoginPanel.pack();
            LoginPanel.setLocationRelativeTo(LoginPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        loginButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox2.getSelectedItem();

            User user = userService.authenticate(id,password,role);

            if (user != null)
            {
                JOptionPane.showMessageDialog(LoginScreen.this,"Login Successful!");
                // Opening your dashboard
                new Dashboard().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(LoginScreen.this,"Invalid Credentials","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        // New Account registration logic
        newAccountButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String password = new String(passwordField.getPassword());
            String role = (String) comboBox2.getSelectedItem();

            if(id.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(LoginScreen.this,"ID and password cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(userService.registerUser(id,password,role)){
                JOptionPane.showMessageDialog(LoginScreen.this,"Registration Successful! You may now login.");
            }
            else {
                JOptionPane.showMessageDialog(LoginScreen.this,"User already exists","Error",JOptionPane.ERROR_MESSAGE);
            }

        });


    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad
    private JFrame LoginPanel;
    private JLabel label1;
    private JLabel label2;
    private JTextField idField;
    private JLabel label3;
    private JPasswordField passwordField;
    private JLabel label4;
    private JComboBox<String> comboBox2;
    private JButton newAccountButton;
    private JButton loginButton;
    private JScrollPane scrollPane4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private UserService userService = new UserService();


    public static void main(String[] args) {
        LoginScreen lg = new LoginScreen();
        lg.LoginPanel.setVisible(true);
    }
}
