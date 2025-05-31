/*
 * Created by JFormDesigner on Sat May 24 13:56:35 PKT 2025
 */

package com.militarybase.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author Latitude
 */
public class UnitManagement {
    public UnitManagement() {

        initComponents();
        tableModel=(DefaultTableModel)unitTable.getModel();
        addButton.addActionListener(e -> {
            String unitId = idField.getText().trim();
            String unitName = nameField.getText().trim();
            String unitPersonnelNumber = numberField.getText().trim();
            String unitCommander = commanderField.getText().trim();
            String unitType = typeField.getText().trim();
            String status = (String)StatusBox.getSelectedItem();
            if (unitId.isEmpty() || unitName.isEmpty() || unitPersonnelNumber.isEmpty() || unitCommander.isEmpty() || unitType.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all Fields to Add row");
                return;
            }
            tableModel.addRow(new Object[] {unitId,unitName,unitPersonnelNumber,unitCommander,unitType,status});
            idField.setText("");
            nameField.setText("");
            numberField.setText("");
            commanderField.setText("");
            typeField.setText("");



        });

        editButton.addActionListener(e -> {
            int row = unitTable.getSelectedRow();
            if (row != -1){
                idField.setText((String)tableModel.getValueAt(row,0));
                nameField.setText((String) tableModel.getValueAt(row,1));
                typeField.setText((String)tableModel.getValueAt(row,2));
                commanderField.setText((String)tableModel.getValueAt(row,3));
                numberField.setText((String) tableModel.getValueAt(row,4));
                StatusBox.setSelectedItem(tableModel.getValueAt(row,5));
                tableModel.removeRow(row);
            }
            else {
                JOptionPane.showMessageDialog(null,"Please select a row to edit it.");
            }

        });
        deleteUnit.addActionListener(e -> {
            int row = unitTable.getSelectedRow();
            if(row != -1)
            {
                tableModel.removeRow(row);
            }
            else {
                JOptionPane.showMessageDialog(null,"Select row to delete it");
            }
        });

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Asad
        unitPanel = new JFrame();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        unitTable = new JTable();
        separator1 = new JSeparator();
        inputPannel = new JPanel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        idField = new JTextField();
        label3 = new JLabel();
        nameField = new JTextField();
        label4 = new JLabel();
        typeField = new JTextField();
        label5 = new JLabel();
        commanderField = new JTextField();
        label6 = new JLabel();
        numberField = new JTextField();
        label7 = new JLabel();
        StatusBox = new JComboBox<>();
        addButton = new JButton();
        editButton = new JButton();
        deleteUnit = new JButton();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();

        //======== unitPanel ========
        {
            var unitPanelContentPane = unitPanel.getContentPane();
            unitPanelContentPane.setLayout(new MigLayout(
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
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Unit Management");
            unitPanelContentPane.add(label1, "cell 1 0 9 1");

            //======== scrollPane1 ========
            {

                //---- unitTable ----
                unitTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Unit ID", "Unit Name", "Type", "Commander", "Number of Personnel", "Status"
                    }
                ));
                scrollPane1.setViewportView(unitTable);
            }
            unitPanelContentPane.add(scrollPane1, "cell 1 3 11 1");
            unitPanelContentPane.add(separator1, "cell 1 3 11 1");

            //======== inputPannel ========
            {
                inputPannel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
                javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
                . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
                .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,inputPannel. getBorder( )) ); inputPannel. addPropertyChangeListener (new java. beans.
                PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
                equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
                inputPannel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
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

                //---- label2 ----
                label2.setText("ID");
                inputPannel.add(label2, "cell 0 0");

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(idField);
                }
                inputPannel.add(scrollPane2, "cell 1 0");

                //---- label3 ----
                label3.setText("Name");
                inputPannel.add(label3, "cell 0 1");
                inputPannel.add(nameField, "cell 1 1");

                //---- label4 ----
                label4.setText("Type");
                inputPannel.add(label4, "cell 0 2");
                inputPannel.add(typeField, "cell 1 2");

                //---- label5 ----
                label5.setText("Commander");
                inputPannel.add(label5, "cell 0 3");
                inputPannel.add(commanderField, "cell 1 3");

                //---- label6 ----
                label6.setText("Number");
                inputPannel.add(label6, "cell 0 4");
                inputPannel.add(numberField, "cell 1 4");

                //---- label7 ----
                label7.setText("Status");
                inputPannel.add(label7, "cell 0 5");

                //---- StatusBox ----
                StatusBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Active",
                    "Inactive",
                    "Deployed",
                    "Disbanded"
                }));
                inputPannel.add(StatusBox, "cell 1 5");

                //---- addButton ----
                addButton.setText("Add Unit");
                inputPannel.add(addButton, "cell 0 6");

                //---- editButton ----
                editButton.setText("Edit Unit");
                inputPannel.add(editButton, "cell 1 6");

                //---- deleteUnit ----
                deleteUnit.setText("Delete Unit");
                inputPannel.add(deleteUnit, "cell 0 7");
            }
            unitPanelContentPane.add(inputPannel, "cell 1 3 11 1");
            unitPanelContentPane.add(textArea1, "cell 4 6");
            unitPanel.pack();
            unitPanel.setLocationRelativeTo(unitPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Asad
    JFrame unitPanel;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable unitTable;
    private JSeparator separator1;
    private JPanel inputPannel;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTextField idField;
    private JLabel label3;
    private JTextField nameField;
    private JLabel label4;
    private JTextField typeField;
    private JLabel label5;
    private JTextField commanderField;
    private JLabel label6;
    private JTextField numberField;
    private JLabel label7;
    private JComboBox<String> StatusBox;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteUnit;
    private JTextArea textArea1;
    private JTextArea textArea2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        UnitManagement um = new UnitManagement();
        um.unitPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        um.unitPanel.setVisible(true);
    }
}
