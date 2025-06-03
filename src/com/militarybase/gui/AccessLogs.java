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
        public AccessLogs(User user, UserData userData) {
            this.userData = userData;
            this.user = user;


            initComponents();

            // load saved data
            for(Object[] row :userData.getAccessLogRows())
            {
                tableModel.addRow(row);
            }

            // Role Based Access Control
            if (user.getRole().equals("Personnel")) {
                logTable.setEnabled(false);
                logPanel.setVisible(false);

            }


            addBtn.addActionListener(e -> {

                logCounter++;
                String name = personnelName.getText();
                String prsId= personnelD.getText().trim();
                String accessTp = (String) accessType.getSelectedItem();
                String gateTp = (String) gateType.getSelectedItem();
                String vehicleTp =(String)vehicleplateTextField.getText();
                String timestp = (String)timestampTextField.getText().trim();
                String remarks = remarksTextArea.getText();
                String lognum = "LOG-"+logCounter;


                tableModel.addRow(new Object[]{lognum,name,prsId,accessTp,gateTp,timestp,vehicleTp,remarks});
                // Data persistence
                Object [] rows = new Object[] {lognum,name,prsId,accessTp,gateTp,timestp,vehicleTp,remarks};
                userData.getAccessLogRows().add(new Object[]{lognum,name,prsId,accessTp,gateTp,timestp,vehicleTp,remarks}); // add it List of userData for Data persistence
                UserDataService.saveUserData(user.getId(), userData);


            });

            viewBtn.addActionListener(e -> {
                int selectedRow = logTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(logPannel, "Please select a row to view details.");
                    return;
                }
                StringBuilder details = new StringBuilder();
                for (int i = 0; i < logTable.getColumnCount(); i++) {
                    details.append(logTable.getColumnName(i))
                            .append(": ")
                            .append(logTable.getValueAt(selectedRow, i))
                            .append("\n");
                }
                JOptionPane.showMessageDialog(logPannel, details.toString(), "Log Details", JOptionPane.INFORMATION_MESSAGE);
            });
            deleteBtn.addActionListener(e -> {
                int selectedRow = logTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(logPannel, "Please select a row to delete.");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(
                        logPannel,
                        "Are you sure you want to delete this log entry?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(selectedRow);
                    userData.getAccessLogRows().remove(selectedRow);
                    UserDataService.saveUserData(user.getId(),userData);
                }
            });
        }

        private void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
            // Generated using JFormDesigner Evaluation license - Asad
            logPannel = new JFrame();
            addBtn = new JButton();
            deleteBtn = new JButton();
            viewBtn = new JButton();
            logPanel = new JPanel();
            label1 = new JLabel();
            personnelName = new JTextField();
            label2 = new JLabel();
            personnelD = new JTextField();
            label3 = new JLabel();
            accessType = new JComboBox<>();
            label4 = new JLabel();
            gateType = new JComboBox<>();
            label6 = new JLabel();
            vehicleplateTextField = new JTextField();
            label7 = new JLabel();
            timestampTextField = new JTextField();
            scrollPane2 = new JScrollPane();
            remarksTextArea = new JTextArea();
            scrollPane1 = new JScrollPane();
            logTable = new JTable();

            //======== logPannel ========
            {
                var logPannelContentPane = logPannel.getContentPane();
                logPannelContentPane.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
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
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- addBtn ----
                addBtn.setText("Add Log");
                logPannelContentPane.add(addBtn, "cell 5 2");

                //---- deleteBtn ----
                deleteBtn.setText("Delete Log");
                logPannelContentPane.add(deleteBtn, "cell 5 2");

                //---- viewBtn ----
                viewBtn.setText("View Details");
                logPannelContentPane.add(viewBtn, "cell 5 2");

                //======== logPanel ========
                {
                    logPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
                    . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
                    . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
                    12 ), java. awt. Color. red) ,logPanel. getBorder( )) ); logPanel. addPropertyChangeListener (new java. beans
                    . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
                    getPropertyName () )) throw new RuntimeException( ); }} );
                    logPanel.setLayout(new MigLayout(
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
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- label1 ----
                    label1.setText("Name");
                    label1.setPreferredSize(new Dimension(16, 17));
                    logPanel.add(label1, "cell 0 1");
                    logPanel.add(personnelName, "cell 0 1");

                    //---- label2 ----
                    label2.setText("ID");
                    logPanel.add(label2, "cell 1 1 3 1");

                    //---- personnelD ----
                    personnelD.setPreferredSize(new Dimension(80, 34));
                    logPanel.add(personnelD, "cell 1 1 3 1");

                    //---- label3 ----
                    label3.setText("Access Type");
                    logPanel.add(label3, "cell 4 1");

                    //---- accessType ----
                    accessType.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Authorized Personnel Access",
                        "Visitor Access",
                        "Retiree and Dependent Access",
                        "Emergency and First Responder Access",
                        "Restricted/Controlled Acces",
                        "Temporary or Day Pass Access",
                        "Commercial and Delivery Access"
                    }));
                    logPanel.add(accessType, "cell 4 1");

                    //---- label4 ----
                    label4.setText("Gate");
                    logPanel.add(label4, "cell 4 1");

                    //---- gateType ----
                    gateType.setModel(new DefaultComboBoxModel<>(new String[] {
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
                    }));
                    logPanel.add(gateType, "cell 5 1");

                    //---- label6 ----
                    label6.setText("Vehicle Plate");
                    logPanel.add(label6, "cell 5 1");

                    //---- vehicleplateTextField ----
                    vehicleplateTextField.setPreferredSize(new Dimension(80, 34));
                    logPanel.add(vehicleplateTextField, "cell 6 1 2 2");

                    //---- label7 ----
                    label7.setText("Remarks/Purpose");
                    logPanel.add(label7, "cell 0 3");

                    //---- timestampTextField ----
                    timestampTextField.setPreferredSize(new Dimension(40, 34));
                    logPanel.add(timestampTextField, "cell 4 3");

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setPreferredSize(new Dimension(300, 200));

                        //---- remarksTextArea ----
                        remarksTextArea.setRows(4);
                        remarksTextArea.setTabSize(4);
                        remarksTextArea.setMinimumSize(new Dimension(10, 40));
                        remarksTextArea.setLineWrap(true);
                        remarksTextArea.setWrapStyleWord(true);
                        remarksTextArea.setColumns(30);
                        scrollPane2.setViewportView(remarksTextArea);
                    }
                    logPanel.add(scrollPane2, "cell 0 4");
                }
                logPannelContentPane.add(logPanel, "cell 5 6");

                //======== scrollPane1 ========
                {

                    //---- logTable ----
                    logTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Log ID", "Personnel Name", "ID", "Access Type", "Gate", "Timestamp", "Vehicle Plate", "Remarks/Purpose"
                        }
                    ));
                    logTable.setPreferredSize(new Dimension(800, 40));
                    logTable.setPreferredScrollableViewportSize(new Dimension(800, 900));
                    logTable.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                    scrollPane1.setViewportView(logTable);
                }
                logPannelContentPane.add(scrollPane1, "north");
                logPannel.pack();
                logPannel.setLocationRelativeTo(logPannel.getOwner());
            }
            // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
            tableModel = (DefaultTableModel) logTable.getModel();
            logCounter = 0;



            // it sets the timestamp to the current time of system when the report is logged.
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTimestamp = sdf.format(new Date());
            timestampTextField.setText(currentTimestamp);

        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
        JFrame logPannel;
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
        // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
        private DefaultTableModel tableModel;
        private int logCounter;




    }
