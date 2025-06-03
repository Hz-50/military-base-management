package com.militarybase.gui;

import javax.swing.*;
import com.militarybase.model.User;
import com.militarybase.model.UserData;
import net.miginfocom.swing.*;

public class Dashboard extends JFrame {
    private JTabbedPane tabbedPane2;
    private JPanel personnelPanel;
    private JPanel logPannel;
    private JPanel inventoryPanel;
    private JPanel unitManagementPanel;
    private UserData userData;
    private User user;

    public Dashboard(User user, UserData userData) {
        this.userData = userData;
        this.user = user;
        initComponents();

        // Set content for each default tab
        PersonnelManagement personnel = new PersonnelManagement(user, userData);
        tabbedPane2.setComponentAt(0, personnel.personnelPanel.getContentPane());

        AccessLogs acl = new AccessLogs(user, userData);
        tabbedPane2.setComponentAt(1, acl.accessLogsPanel);

        InventoryManagement inventoryManagement = new InventoryManagement(user, userData);
        tabbedPane2.setComponentAt(2, inventoryManagement.inventoryPanel.getContentPane());

        UnitManagement unit = new UnitManagement(user, userData);
        tabbedPane2.setComponentAt(3, unit.unitPanel.getContentPane());

        // Only add User Management tab if Base Commander
        String role = user.getRole().trim().toLowerCase();
        if ("base commander".equals(role) || "commander".equals(role)) {
            tabbedPane2.addTab("User Management", new UserManagement(user));
        }

        this.setLayout(new MigLayout("fill"));
        this.add(tabbedPane2, "grow, push");
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        tabbedPane2 = new JTabbedPane();
        personnelPanel = new JPanel();
        logPannel = new JPanel();
        inventoryPanel = new JPanel();
        unitManagementPanel = new JPanel();

        tabbedPane2.addTab("Personnel Management", personnelPanel);
        tabbedPane2.addTab("Access Logs", logPannel);
        tabbedPane2.addTab("Inventory Managemnt", inventoryPanel);
        tabbedPane2.addTab("Unit Management", unitManagementPanel);
    }
}