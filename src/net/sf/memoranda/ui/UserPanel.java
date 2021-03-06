package net.sf.memoranda.ui;

import java.awt.Frame;

import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jebjohnson
 */
public class UserPanel extends javax.swing.JPanel {
	
	public static UserFunctionality userFunctionality;

    /**
     * Creates new form UserPage
     */
    public UserPanel() {
        initComponents();
        
        userFunctionality = new UserFunctionality();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, SystemColor.controlHighlight));
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        addUserButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();

        setBackground(Color.DARK_GRAY);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Department", "Title", "Email", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setResizable(false);
        }

        addUserButton.setText("Add");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Edit");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setText("Delete");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(deleteUserButton)
        					.addGap(18)
        					.addComponent(editUserButton)
        					.addGap(18)
        					.addComponent(addUserButton)))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(addUserButton)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE, false)
        					.addComponent(deleteUserButton)
        					.addComponent(editUserButton)))
        			.addGap(18))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(11))
        );
        this.setLayout(layout);
    }// </editor-fold>                        

    public static JTable getUserTable(){
    	
    	return userTable;
    }
    
    
    public static UserFunctionality getUserFunctionality(){
    	return userFunctionality;
    }
    
    
    
    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
       NewUserDialog userDialog = new NewUserDialog((Frame) SwingUtilities.getWindowAncestor(this), true);
       userDialog.setVisible(true);
    }                                             

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        userFunctionality.deleteRow(userTable.getSelectedRow(), userTable);
    }                                                

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        EditUserDialog editDialog = new EditUserDialog((Frame) SwingUtilities.getWindowAncestor(this), true);
        editDialog.setVisible(true);
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable userTable;
    // End of variables declaration                   
}
