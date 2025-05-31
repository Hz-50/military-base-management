/*
 * Created by JFormDesigner on Thu May 22 07:31:39 PKT 2025
 */

package com.militarybase.gui;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Latitude
 */
public class LoginScreen extends JFrame {

    public LoginScreen() {
        initComponents();

        setTitle("Military Base Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
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

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
        contentPane.add(label1, "cell 5 0 8 1");

        //---- label2 ----
        label2.setText("Id:");
        contentPane.add(label2, "cell 2 2 2 1");
        contentPane.add(idField, "cell 5 2 7 1");

        //---- label3 ----
        label3.setText("Password:");
        contentPane.add(label3, "cell 2 3 3 1");
        contentPane.add(passwordField, "cell 5 3 7 1");

        //---- label4 ----
        label4.setText("Type:");
        contentPane.add(label4, "cell 2 4 3 1");

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "Personnel",
            "Base Commander"
        }));
        contentPane.add(comboBox2, "cell 5 4");

        //---- newAccountButton ----
        newAccountButton.setText("New Account");
        contentPane.add(newAccountButton, "cell 2 5");

        //---- loginButton ----
        loginButton.setText("Login");
        contentPane.add(loginButton, "cell 5 5");
        contentPane.add(scrollPane4, "cell 7 5 9 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad
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
}
