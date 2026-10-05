package com.militarybase.app;

import com.militarybase.gui.LoginScreen;

import javax.swing.SwingUtilities;

public class MilitaryBaseApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen().setVisible(true));
    }
}
