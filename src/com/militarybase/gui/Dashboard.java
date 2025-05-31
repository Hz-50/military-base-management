/*
 * Created by JFormDesigner on Sat May 24 13:53:56 PKT 2025
 */

package com.militarybase.gui;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Latitude
 */
public class Dashboard extends JFrame {
    public Dashboard() {

        initComponents();
        // adding Guis to dashboard
        PersonnelManagement personnel = new PersonnelManagement();
        tabbedPane2.setComponentAt(0, personnel.personnelPanel.getContentPane());

        InventoryManagement inventory = new InventoryManagement();
        tabbedPane2.setComponentAt(2,inventory.inventoryPanel.getContentPane());

        UnitManagement unit = new UnitManagement();
        tabbedPane2.setComponentAt(3,unit.unitPanel.getContentPane());

        AccessLogs acl = new AccessLogs();
        tabbedPane2.setComponentAt(1,acl.logPannel.getContentPane());

        // this code add the tabbed pane to jframe, without it nothing will be displayed
        this.setLayout(new MigLayout("fill"));
        this.add(tabbedPane2, "grow, push");
        this.pack();
        this.setLocationRelativeTo(null);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
        tabbedPane2 = new JTabbedPane();
        personnelPanel = new JPanel();
        logPannel = new JPanel();
        inventoryPanel = new JPanel();
        UnitManagement = new JPanel();

        //======== tabbedPane2 ========
        {

            //======== personnelPanel ========
            {
                personnelPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
                .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
                .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
                .Color.red),personnelPanel. getBorder()));personnelPanel. addPropertyChangeListener(new java.beans.
                PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".
                equals(e.getPropertyName()))throw new RuntimeException();}});
                personnelPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane2.addTab("Personnel Management", personnelPanel);

            //======== logPannel ========
            {
                logPannel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane2.addTab("Access Logs", logPannel);

            //======== inventoryPanel ========
            {
                inventoryPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane2.addTab("Inventory Managemnt", inventoryPanel);

            //======== UnitManagement ========
            {
                UnitManagement.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));
            }
            tabbedPane2.addTab("Unit Management", UnitManagement);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad
    private JTabbedPane tabbedPane2;
    private JPanel personnelPanel;
    private JPanel logPannel;
    private JPanel inventoryPanel;
    private JPanel UnitManagement;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

            Dashboard dashboard = new Dashboard();
            dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dashboard.setVisible(true);

    }
}
