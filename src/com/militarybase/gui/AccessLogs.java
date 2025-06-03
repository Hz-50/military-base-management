/*
 * Created by JFormDesigner on Tue May 27 09:40:24 PKT 2025
 */

package com.militarybase.gui;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import com.militarybase.model.User;
import com.militarybase.model.UserData;
import com.militarybase.service.UserDataService;
import net.miginfocom.swing.*;

/**
 * @author Latitude
 */
public class AccessLogs {
    private UserData userData;
    private User user;
    public JPanel accessLogsPanel; // Exposed panel for use in Dashboard

    private JButton addBtn;
    private JButton deleteBtn;
    private JButton viewBtn;
    private JPanel logPanel;
    private JLabel label1;
    private JTextField personnelName;
    private JLabel label2;
    private JTextField personnelD;
    private JLabel label3;
    private JComboBox<String> accessType;
    private JLabel label4;
    private JComboBox<String> gateType;
    private JLabel label6;
    private JTextField vehicleplateTextField;
    private JLabel label7;
    private JTextField timestampTextField;
    private JScrollPane scrollPane2;
    private JTextArea remarksTextArea;
    private JScrollPane scrollPane1;
    private JTable logTable;
    private DefaultTableModel tableModel;
    private int logCounter;

    public AccessLogs(User user, UserData userData) {
        this.userData = userData;
        this.user = user;
        initComponents();

        // load saved data
        for(Object[] row : userData.getAccessLogRows()) {
            tableModel.addRow(row);
        }

        // Role Based Access Control
        if ("Personnel".equalsIgnoreCase(user.getRole())) {
            logTable.setEnabled(false);
            logPanel.setVisible(false);
        }

        addBtn.addActionListener(e -> {
            logCounter++;
            String name = personnelName.getText();
            String prsId = personnelD.getText().trim();
            String accessTp = (String) accessType.getSelectedItem();
            String gateTp = (String) gateType.getSelectedItem();
            String vehicleTp = vehicleplateTextField.getText();
            String timestp = timestampTextField.getText().trim();
            String remarks = remarksTextArea.getText();
            String lognum = "LOG-" + logCounter;

            tableModel.addRow(new Object[]{lognum, name, prsId, accessTp, gateTp, timestp, vehicleTp, remarks});
            userData.getAccessLogRows().add(new Object[]{lognum, name, prsId, accessTp, gateTp, timestp, vehicleTp, remarks});
            UserDataService.saveUserData(user.getId(), userData);
        });

        viewBtn.addActionListener(e -> {
            int selectedRow = logTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(accessLogsPanel, "Please select a row to view details.");
                return;
            }
            StringBuilder details = new StringBuilder();
            for (int i = 0; i < logTable.getColumnCount(); i++) {
                details.append(logTable.getColumnName(i))
                        .append(": ")
                        .append(logTable.getValueAt(selectedRow, i))
                        .append("\n");
            }
            JOptionPane.showMessageDialog(accessLogsPanel, details.toString(), "Log Details", JOptionPane.INFORMATION_MESSAGE);
        });
        deleteBtn.addActionListener(e -> {
            int selectedRow = logTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(accessLogsPanel, "Please select a row to delete.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(
                    accessLogsPanel,
                    "Are you sure you want to delete this log entry?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                userData.getAccessLogRows().remove(selectedRow);
                UserDataService.saveUserData(user.getId(), userData);
            }
        });
    }

    private void initComponents() {
        // Main panel for use in Dashboard tabbed pane
        accessLogsPanel = new JPanel(new net.miginfocom.swing.MigLayout("fill"));

        // Log controls panel (form)
        logPanel = new JPanel(new MigLayout("hidemode 3"));
        label1 = new JLabel("Name");
        personnelName = new JTextField(8);
        label2 = new JLabel("ID");
        personnelD = new JTextField(8);
        label3 = new JLabel("Access Type");
        accessType = new JComboBox<>(new String[] {
                "Authorized Personnel Access",
                "Visitor Access",
                "Retiree and Dependent Access",
                "Emergency and First Responder Access",
                "Restricted/Controlled Access",
                "Temporary or Day Pass Access",
                "Commercial and Delivery Access"
        });
        label4 = new JLabel("Gate");
        gateType = new JComboBox<>(new String[] {
                "Main Gate",
                "VVIP/VIP Gate",
                "Unit Gate",
                "Residential/Family Gate",
                "Visitor Gate",
                "Service/Logistics Gate",
                "Contractor Gate",
                "Emergency Gate",
                "Training Area Gate",
                "Pedestrian Gate"
        });
        label6 = new JLabel("Vehicle Plate");
        vehicleplateTextField = new JTextField(8);
        label7 = new JLabel("Remarks/Purpose");
        remarksTextArea = new JTextArea(4, 20);
        remarksTextArea.setLineWrap(true);
        remarksTextArea.setWrapStyleWord(true);

        addBtn = new JButton("Add Log");
        deleteBtn = new JButton("Delete Log");
        viewBtn = new JButton("View Details");

        timestampTextField = new JTextField(16);
        // Set current timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timestampTextField.setText(sdf.format(new Date()));

        // Build form layout
        logPanel.add(label1, "cell 0 0");
        logPanel.add(personnelName, "cell 1 0");
        logPanel.add(label2, "cell 2 0");
        logPanel.add(personnelD, "cell 3 0");
        logPanel.add(label3, "cell 4 0");
        logPanel.add(accessType, "cell 5 0");
        logPanel.add(label4, "cell 6 0");
        logPanel.add(gateType, "cell 7 0");

        logPanel.add(label6, "cell 0 1");
        logPanel.add(vehicleplateTextField, "cell 1 1");
        logPanel.add(label7, "cell 2 1");
        JScrollPane remarksScroll = new JScrollPane(remarksTextArea);
        logPanel.add(remarksScroll, "cell 3 1 3 1, growx");
        logPanel.add(new JLabel("Timestamp"), "cell 6 1");
        logPanel.add(timestampTextField, "cell 7 1");

        logPanel.add(addBtn, "cell 0 2");
        logPanel.add(deleteBtn, "cell 1 2");
        logPanel.add(viewBtn, "cell 2 2");

        // Table and scroll pane
        String[] columns = {"Log ID", "Personnel Name", "ID", "Access Type", "Gate", "Timestamp", "Vehicle Plate", "Remarks/Purpose"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        logTable = new JTable(tableModel);
        logTable.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
        logTable.setRowHeight(22);
        JScrollPane tableScroll = new JScrollPane(logTable);
        // Key fix: make the scrollpane fill the parent with MigLayout
        accessLogsPanel.add(tableScroll, "grow, push, wrap");
        accessLogsPanel.add(logPanel, "dock south");
        logCounter = 0;
    }
}