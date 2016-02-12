package net.sf.memoranda.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Resource;
import net.sf.memoranda.util.AppList;
import net.sf.memoranda.util.CurrentStorage;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.MimeType;
import net.sf.memoranda.util.MimeTypesList;
import net.sf.memoranda.util.Util;

import java.io.*;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

/* ResourcesPanel.java,v 1.13 2007/03/20 08:22:41 alexeya Exp $*/
public class TimeSheetPanel extends JPanel {
    JToolBar toolBar = new JToolBar();
    JButton newResB = new JButton();
    ResourcesTable resourcesTable = new ResourcesTable();
    JButton removeResB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    JButton refreshB = new JButton();
  JPopupMenu resPPMenu = new JPopupMenu();
  JMenuItem ppRun = new JMenuItem();
  JMenuItem ppRemoveRes = new JMenuItem();
  JMenuItem ppNewRes = new JMenuItem();
  JMenuItem ppRefresh = new JMenuItem();
  private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  private final JPanel panel = new JPanel();
  private final JLabel lblDate = new JLabel("          Date          ");
  private final JLabel lblStart = new JLabel("          Start          ");
  private final JLabel lblStop = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase = new JLabel("          Phase          ");
  private final JLabel lblComment_1 = new JLabel("                              Comment                              ");
  private final JTextField textField = new JTextField();
  private final JTextField textField_1 = new JTextField();
  private final JTextField textField_2 = new JTextField();
  private final JTextField textField_3 = new JTextField();
  private final JTextField textField_4 = new JTextField();
  private final JTextField textField_5 = new JTextField();
  private final JTextField textField_6 = new JTextField();
  private final JTextField textField_7 = new JTextField();
  private final JTextField textField_8 = new JTextField();
  private final JTextField textField_9 = new JTextField();
  private final JTextField textField_10 = new JTextField();
  private final JTextField textField_11 = new JTextField();
  private final JTextField textField_12 = new JTextField();
  private final JTextField textField_13 = new JTextField();
  private final JTextField textField_14 = new JTextField();
  private final JTextField textField_15 = new JTextField();
  private final JTextField textField_16 = new JTextField();
  private final JTextField textField_17 = new JTextField();
  private final JTextField textField_18 = new JTextField();
  private final JTextField textField_19 = new JTextField();
  private final JTextField textField_20 = new JTextField();
  private final JTextField textField_21 = new JTextField();
  private final JTextField textField_22 = new JTextField();
  private final JTextField textField_23 = new JTextField();
  private final JTextField textField_24 = new JTextField();
  private final JTextField textField_25 = new JTextField();
  private final JTextField textField_26 = new JTextField();
  private final JTextField textField_27 = new JTextField();
  private final JTextField textField_28 = new JTextField();
  private final JTextField textField_29 = new JTextField();
  private final JTextField textField_30 = new JTextField();
  private final JTextField textField_31 = new JTextField();
  private final JTextField textField_32 = new JTextField();
  private final JTextField textField_33 = new JTextField();
  private final JTextField textField_34 = new JTextField();
  private final JTextField textField_35 = new JTextField();
  private final JTextField textField_36 = new JTextField();
  private final JTextField textField_37 = new JTextField();
  private final JTextField textField_38 = new JTextField();
  private final JTextField textField_39 = new JTextField();
  private final JTextField textField_40 = new JTextField();
  private final JTextField textField_41 = new JTextField();
  private final JTextField textField_42 = new JTextField();
  private final JTextField textField_43 = new JTextField();
  private final JTextField textField_44 = new JTextField();
  private final JTextField textField_45 = new JTextField();
  private final JTextField textField_46 = new JTextField();
  private final JTextField textField_47 = new JTextField();
  private final JTextField textField_48 = new JTextField();
  private final JTextField textField_49 = new JTextField();
  private final JTextField textField_50 = new JTextField();
  private final JTextField textField_51 = new JTextField();
  private final JTextField textField_52 = new JTextField();
  private final JTextField textField_53 = new JTextField();
  private final JTextField textField_54 = new JTextField();
  private final JTextField textField_55 = new JTextField();
  private final JTextField textField_56 = new JTextField();
  private final JTextField textField_57 = new JTextField();
  private final JTextField textField_58 = new JTextField();
  private final JTextField textField_59 = new JTextField();
  private final JTextField textField_60 = new JTextField();
  private final JTextField textField_61 = new JTextField();
  private final JTextField textField_62 = new JTextField();
  private final JTextField textField_63 = new JTextField();
  private final JTextField textField_64 = new JTextField();
  private final JTextField textField_65 = new JTextField();
  private final JTextField textField_66 = new JTextField();
  private final JTextField textField_67 = new JTextField();
  private final JTextField textField_68 = new JTextField();
  private final JTextField textField_69 = new JTextField();
  private final JTextField textField_70 = new JTextField();
  private final JTextField textField_71 = new JTextField();
  private final JTextField textField_72 = new JTextField();
  private final JTextField textField_73 = new JTextField();
  private final JTextField textField_74 = new JTextField();
  private final JTextField textField_75 = new JTextField();
  private final JTextField textField_76 = new JTextField();
  private final JTextField textField_77 = new JTextField();
  private final JTextField textField_78 = new JTextField();
  private final JTextField textField_79 = new JTextField();
  private final JTextField textField_80 = new JTextField();
  private final JTextField textField_81 = new JTextField();
  private final JTextField textField_82 = new JTextField();
  private final JTextField textField_83 = new JTextField();
  private final JTextField textField_84 = new JTextField();
  private final JTextField textField_85 = new JTextField();
  private final JTextField textField_86 = new JTextField();
  private final JTextField textField_87 = new JTextField();
  private final JTextField textField_88 = new JTextField();
  private final JTextField textField_89 = new JTextField();

    public TimeSheetPanel() {
    	textField_43.setColumns(10);
    	textField_42.setColumns(10);
    	textField_41.setColumns(10);
    	textField_40.setColumns(10);
    	textField_39.setColumns(10);
    	textField_38.setColumns(10);
    	textField_37.setColumns(10);
    	textField_36.setColumns(10);
    	textField_35.setColumns(10);
    	textField_34.setColumns(10);
    	textField_33.setColumns(10);
    	textField_32.setColumns(10);
    	textField_31.setColumns(10);
    	textField_30.setColumns(10);
    	textField_29.setColumns(10);
    	textField_28.setColumns(10);
    	textField_27.setColumns(10);
    	textField_26.setColumns(10);
    	textField_25.setColumns(10);
    	textField_24.setColumns(10);
    	textField_23.setColumns(10);
    	textField_22.setColumns(10);
    	textField_21.setColumns(10);
    	textField_20.setColumns(10);
    	textField_19.setColumns(10);
    	textField_18.setColumns(10);
    	textField_17.setColumns(10);
    	textField_16.setColumns(10);
    	textField_15.setColumns(10);
    	textField_14.setColumns(10);
    	textField_13.setColumns(10);
    	textField_12.setColumns(10);
    	textField_11.setColumns(10);
    	textField_10.setColumns(10);
    	textField_9.setColumns(10);
    	textField_8.setColumns(10);
    	textField_7.setColumns(10);
    	textField_6.setColumns(10);
    	textField_5.setColumns(10);
    	textField_4.setColumns(10);
    	textField_3.setColumns(10);
    	textField_2.setColumns(10);
    	textField_1.setColumns(10);
    	textField.setColumns(10);
        try {
            jbInit();
        }
        catch (Exception ex) {
           new ExceptionDialog(ex);
        }
    }
    void jbInit() throws Exception {


        PopupListener ppListener = new PopupListener();
        resPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
    ppRun.setFont(new java.awt.Font("Dialog", 1, 11));
    ppRun.setText(Local.getString("Open resource")+"...");
    ppRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRun_actionPerformed(e);
            }
        });
    ppRun.setEnabled(false);

    ppRemoveRes.setFont(new java.awt.Font("Dialog", 1, 11));
    ppRemoveRes.setText(Local.getString("Remove resource"));
    ppRemoveRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveRes_actionPerformed(e);
            }
        });
    ppRemoveRes.setIcon(new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/calendar.png")));
    ppRemoveRes.setEnabled(false);
    ppNewRes.setFont(new java.awt.Font("Dialog", 1, 11));
    ppNewRes.setText(Local.getString("New resource")+"...");
    ppNewRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewRes_actionPerformed(e);
            }
        });
    ppNewRes.setIcon(new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/date.png")));

    ppRefresh.setFont(new java.awt.Font("Dialog", 1, 11));
    ppRefresh.setText(Local.getString("Refresh"));
    ppRefresh.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ppRefresh_actionPerformed(e);
      }
    });
    ppRefresh.setIcon(new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/error.png")));
        resourcesTable.setSurrendersFocusOnKeystroke(true);
        resourcesTable.setShowVerticalLines(true);
        resourcesTable.setShowHorizontalLines(true);
        resourcesTable.setMaximumSize(new Dimension(32767, 32767));
        resourcesTable.setRowHeight(24);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.addMouseListener(ppListener);
        resourcesTable.addMouseListener(ppListener);
        
                resourcesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        boolean enbl = (resourcesTable.getRowCount() > 0) && (resourcesTable.getSelectedRow() > -1);
        
                        removeResB.setEnabled(enbl); ppRemoveRes.setEnabled(enbl);
                        ppRun.setEnabled(enbl);
                    }
                });
                toolBar.setFloatable(false);
                newResB.setIcon(
                    new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/alarm.png")));
                newResB.setEnabled(true);
                newResB.setMaximumSize(new Dimension(24, 24));
                newResB.setMinimumSize(new Dimension(24, 24));
                newResB.setToolTipText(Local.getString("New Timesheet"));
                newResB.setRequestFocusEnabled(false);
                newResB.setPreferredSize(new Dimension(24, 24));
                newResB.setFocusable(false);
                newResB.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newResB_actionPerformed(e);
                    }
                });
                newResB.setBorderPainted(false);
                toolBar.addSeparator(new Dimension(8, 24));
                toolBar.addSeparator(new Dimension(8, 24));
                refreshB.setBorderPainted(false);
                refreshB.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        refreshB_actionPerformed(e);
                    }
                });
                refreshB.setFocusable(false);
                refreshB.setPreferredSize(new Dimension(24, 24));
                refreshB.setRequestFocusEnabled(false);
                refreshB.setToolTipText(Local.getString("Refresh"));
                refreshB.setMinimumSize(new Dimension(24, 24));
                refreshB.setMaximumSize(new Dimension(24, 24));
                refreshB.setEnabled(true);
                refreshB.setIcon(
                    new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/refreshres.png")));
                
                    toolBar.add(newResB, null);
                    toolBar.addSeparator();
                    toolBar.add(refreshB, null);
                    removeResB.setBorderPainted(false);
                    removeResB.setFocusable(false);
                    removeResB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            removeResB_actionPerformed(e);
                        }
                    });
                    removeResB.setPreferredSize(new Dimension(24, 24));
                    removeResB.setRequestFocusEnabled(false);
                    removeResB.setToolTipText(Local.getString("Remove Time Sheet"));
                    removeResB.setMinimumSize(new Dimension(24, 24));
                    removeResB.setMaximumSize(new Dimension(24, 24));
                    removeResB.setIcon(
                        new ImageIcon(
                            net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/agenda.png")));
                    removeResB.setEnabled(false);
                    toolBar.add(removeResB, null);
                scrollPane.setViewportView(resourcesTable);
                GroupLayout groupLayout = new GroupLayout(this);
                groupLayout.setHorizontalGroup(
                	groupLayout.createParallelGroup(Alignment.LEADING)
                		.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)
                		.addGroup(groupLayout.createSequentialGroup()
                			.addGap(15)
                			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                			.addContainerGap())
                		.addGroup(groupLayout.createSequentialGroup()
                			.addContainerGap()
                			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 964, GroupLayout.PREFERRED_SIZE)
                			.addContainerGap(16, Short.MAX_VALUE))
                );
                groupLayout.setVerticalGroup(
                	groupLayout.createParallelGroup(Alignment.LEADING)
                		.addGroup(groupLayout.createSequentialGroup()
                			.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                			.addGap(5)
                			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                			.addPreferredGap(ComponentPlacement.UNRELATED)
                			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
                			.addContainerGap(128, Short.MAX_VALUE))
                );
                
                tabbedPane.addTab("January", null, panel, null);
                GridBagLayout gbl_panel = new GridBagLayout();
                gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel.setLayout(gbl_panel);
                
                GridBagConstraints gbc_lblDate = new GridBagConstraints();
                gbc_lblDate.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate.gridx = 0;
                gbc_lblDate.gridy = 1;
                panel.add(lblDate, gbc_lblDate);
                
                GridBagConstraints gbc_lblStart = new GridBagConstraints();
                gbc_lblStart.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart.gridx = 1;
                gbc_lblStart.gridy = 1;
                panel.add(lblStart, gbc_lblStart);
                
                GridBagConstraints gbc_lblStop = new GridBagConstraints();
                gbc_lblStop.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop.gridx = 2;
                gbc_lblStop.gridy = 1;
                panel.add(lblStop, gbc_lblStop);
                
                GridBagConstraints gbc_lblInterruptTime = new GridBagConstraints();
                gbc_lblInterruptTime.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime.gridx = 3;
                gbc_lblInterruptTime.gridy = 1;
                panel.add(lblInterruptTime, gbc_lblInterruptTime);
                
                GridBagConstraints gbc_lblPhase = new GridBagConstraints();
                gbc_lblPhase.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase.gridx = 4;
                gbc_lblPhase.gridy = 1;
                panel.add(lblPhase, gbc_lblPhase);
                
                GridBagConstraints gbc_lblComment_1 = new GridBagConstraints();
                gbc_lblComment_1.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_1.gridx = 5;
                gbc_lblComment_1.gridy = 1;
                panel.add(lblComment_1, gbc_lblComment_1);
                
                GridBagConstraints gbc_textField = new GridBagConstraints();
                gbc_textField.insets = new Insets(0, 0, 5, 5);
                gbc_textField.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField.gridx = 0;
                gbc_textField.gridy = 3;
                panel.add(textField, gbc_textField);
                
                GridBagConstraints gbc_textField_1 = new GridBagConstraints();
                gbc_textField_1.insets = new Insets(0, 0, 5, 5);
                gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_1.gridx = 1;
                gbc_textField_1.gridy = 3;
                panel.add(textField_1, gbc_textField_1);
                
                GridBagConstraints gbc_textField_2 = new GridBagConstraints();
                gbc_textField_2.insets = new Insets(0, 0, 5, 5);
                gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_2.gridx = 2;
                gbc_textField_2.gridy = 3;
                panel.add(textField_2, gbc_textField_2);
                
                GridBagConstraints gbc_textField_3 = new GridBagConstraints();
                gbc_textField_3.insets = new Insets(0, 0, 5, 5);
                gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_3.gridx = 3;
                gbc_textField_3.gridy = 3;
                panel.add(textField_3, gbc_textField_3);
                
                GridBagConstraints gbc_textField_4 = new GridBagConstraints();
                gbc_textField_4.insets = new Insets(0, 0, 5, 5);
                gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_4.gridx = 4;
                gbc_textField_4.gridy = 3;
                panel.add(textField_4, gbc_textField_4);
                
                GridBagConstraints gbc_textField_5 = new GridBagConstraints();
                gbc_textField_5.insets = new Insets(0, 0, 5, 0);
                gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_5.gridx = 5;
                gbc_textField_5.gridy = 3;
                panel.add(textField_5, gbc_textField_5);
                
                GridBagConstraints gbc_textField_6 = new GridBagConstraints();
                gbc_textField_6.insets = new Insets(0, 0, 5, 5);
                gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_6.gridx = 0;
                gbc_textField_6.gridy = 4;
                panel.add(textField_6, gbc_textField_6);
                
                GridBagConstraints gbc_textField_7 = new GridBagConstraints();
                gbc_textField_7.insets = new Insets(0, 0, 5, 5);
                gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_7.gridx = 1;
                gbc_textField_7.gridy = 4;
                panel.add(textField_7, gbc_textField_7);
                
                GridBagConstraints gbc_textField_8 = new GridBagConstraints();
                gbc_textField_8.insets = new Insets(0, 0, 5, 5);
                gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_8.gridx = 2;
                gbc_textField_8.gridy = 4;
                panel.add(textField_8, gbc_textField_8);
                
                GridBagConstraints gbc_textField_9 = new GridBagConstraints();
                gbc_textField_9.insets = new Insets(0, 0, 5, 5);
                gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_9.gridx = 3;
                gbc_textField_9.gridy = 4;
                panel.add(textField_9, gbc_textField_9);
                
                GridBagConstraints gbc_textField_10 = new GridBagConstraints();
                gbc_textField_10.insets = new Insets(0, 0, 5, 5);
                gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_10.gridx = 4;
                gbc_textField_10.gridy = 4;
                panel.add(textField_10, gbc_textField_10);
                
                GridBagConstraints gbc_textField_11 = new GridBagConstraints();
                gbc_textField_11.insets = new Insets(0, 0, 5, 0);
                gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_11.gridx = 5;
                gbc_textField_11.gridy = 4;
                panel.add(textField_11, gbc_textField_11);
                
                GridBagConstraints gbc_textField_12 = new GridBagConstraints();
                gbc_textField_12.insets = new Insets(0, 0, 5, 5);
                gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_12.gridx = 0;
                gbc_textField_12.gridy = 5;
                panel.add(textField_12, gbc_textField_12);
                
                GridBagConstraints gbc_textField_13 = new GridBagConstraints();
                gbc_textField_13.insets = new Insets(0, 0, 5, 5);
                gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_13.gridx = 1;
                gbc_textField_13.gridy = 5;
                panel.add(textField_13, gbc_textField_13);
                
                GridBagConstraints gbc_textField_14 = new GridBagConstraints();
                gbc_textField_14.insets = new Insets(0, 0, 5, 5);
                gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_14.gridx = 2;
                gbc_textField_14.gridy = 5;
                panel.add(textField_14, gbc_textField_14);
                
                GridBagConstraints gbc_textField_15 = new GridBagConstraints();
                gbc_textField_15.insets = new Insets(0, 0, 5, 5);
                gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_15.gridx = 3;
                gbc_textField_15.gridy = 5;
                panel.add(textField_15, gbc_textField_15);
                
                GridBagConstraints gbc_textField_16 = new GridBagConstraints();
                gbc_textField_16.insets = new Insets(0, 0, 5, 5);
                gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_16.gridx = 4;
                gbc_textField_16.gridy = 5;
                panel.add(textField_16, gbc_textField_16);
                
                GridBagConstraints gbc_textField_17 = new GridBagConstraints();
                gbc_textField_17.insets = new Insets(0, 0, 5, 0);
                gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_17.gridx = 5;
                gbc_textField_17.gridy = 5;
                panel.add(textField_17, gbc_textField_17);
                
                GridBagConstraints gbc_textField_18 = new GridBagConstraints();
                gbc_textField_18.insets = new Insets(0, 0, 5, 5);
                gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_18.gridx = 0;
                gbc_textField_18.gridy = 6;
                panel.add(textField_18, gbc_textField_18);
                
                GridBagConstraints gbc_textField_19 = new GridBagConstraints();
                gbc_textField_19.insets = new Insets(0, 0, 5, 5);
                gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_19.gridx = 1;
                gbc_textField_19.gridy = 6;
                panel.add(textField_19, gbc_textField_19);
                
                GridBagConstraints gbc_textField_20 = new GridBagConstraints();
                gbc_textField_20.insets = new Insets(0, 0, 5, 5);
                gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_20.gridx = 2;
                gbc_textField_20.gridy = 6;
                panel.add(textField_20, gbc_textField_20);
                
                GridBagConstraints gbc_textField_21 = new GridBagConstraints();
                gbc_textField_21.insets = new Insets(0, 0, 5, 5);
                gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_21.gridx = 3;
                gbc_textField_21.gridy = 6;
                panel.add(textField_21, gbc_textField_21);
                
                GridBagConstraints gbc_textField_22 = new GridBagConstraints();
                gbc_textField_22.insets = new Insets(0, 0, 5, 5);
                gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_22.gridx = 4;
                gbc_textField_22.gridy = 6;
                panel.add(textField_22, gbc_textField_22);
                
                GridBagConstraints gbc_textField_23 = new GridBagConstraints();
                gbc_textField_23.insets = new Insets(0, 0, 5, 0);
                gbc_textField_23.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_23.gridx = 5;
                gbc_textField_23.gridy = 6;
                panel.add(textField_23, gbc_textField_23);
                
                GridBagConstraints gbc_textField_24 = new GridBagConstraints();
                gbc_textField_24.insets = new Insets(0, 0, 5, 5);
                gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_24.gridx = 0;
                gbc_textField_24.gridy = 7;
                panel.add(textField_24, gbc_textField_24);
                
                GridBagConstraints gbc_textField_25 = new GridBagConstraints();
                gbc_textField_25.insets = new Insets(0, 0, 5, 5);
                gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_25.gridx = 1;
                gbc_textField_25.gridy = 7;
                panel.add(textField_25, gbc_textField_25);
                
                GridBagConstraints gbc_textField_26 = new GridBagConstraints();
                gbc_textField_26.insets = new Insets(0, 0, 5, 5);
                gbc_textField_26.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_26.gridx = 2;
                gbc_textField_26.gridy = 7;
                panel.add(textField_26, gbc_textField_26);
                
                GridBagConstraints gbc_textField_27 = new GridBagConstraints();
                gbc_textField_27.insets = new Insets(0, 0, 5, 5);
                gbc_textField_27.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_27.gridx = 3;
                gbc_textField_27.gridy = 7;
                panel.add(textField_27, gbc_textField_27);
                
                GridBagConstraints gbc_textField_28 = new GridBagConstraints();
                gbc_textField_28.insets = new Insets(0, 0, 5, 5);
                gbc_textField_28.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_28.gridx = 4;
                gbc_textField_28.gridy = 7;
                panel.add(textField_28, gbc_textField_28);
                
                GridBagConstraints gbc_textField_29 = new GridBagConstraints();
                gbc_textField_29.insets = new Insets(0, 0, 5, 0);
                gbc_textField_29.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_29.gridx = 5;
                gbc_textField_29.gridy = 7;
                panel.add(textField_29, gbc_textField_29);
                
                GridBagConstraints gbc_textField_30 = new GridBagConstraints();
                gbc_textField_30.insets = new Insets(0, 0, 5, 5);
                gbc_textField_30.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_30.gridx = 0;
                gbc_textField_30.gridy = 8;
                panel.add(textField_30, gbc_textField_30);
                
                GridBagConstraints gbc_textField_31 = new GridBagConstraints();
                gbc_textField_31.insets = new Insets(0, 0, 5, 5);
                gbc_textField_31.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_31.gridx = 1;
                gbc_textField_31.gridy = 8;
                panel.add(textField_31, gbc_textField_31);
                
                GridBagConstraints gbc_textField_32 = new GridBagConstraints();
                gbc_textField_32.insets = new Insets(0, 0, 5, 5);
                gbc_textField_32.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_32.gridx = 2;
                gbc_textField_32.gridy = 8;
                panel.add(textField_32, gbc_textField_32);
                
                GridBagConstraints gbc_textField_33 = new GridBagConstraints();
                gbc_textField_33.insets = new Insets(0, 0, 5, 5);
                gbc_textField_33.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_33.gridx = 3;
                gbc_textField_33.gridy = 8;
                panel.add(textField_33, gbc_textField_33);
                
                GridBagConstraints gbc_textField_34 = new GridBagConstraints();
                gbc_textField_34.insets = new Insets(0, 0, 5, 5);
                gbc_textField_34.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_34.gridx = 4;
                gbc_textField_34.gridy = 8;
                panel.add(textField_34, gbc_textField_34);
                
                GridBagConstraints gbc_textField_35 = new GridBagConstraints();
                gbc_textField_35.insets = new Insets(0, 0, 5, 0);
                gbc_textField_35.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_35.gridx = 5;
                gbc_textField_35.gridy = 8;
                panel.add(textField_35, gbc_textField_35);
                
                GridBagConstraints gbc_textField_36 = new GridBagConstraints();
                gbc_textField_36.insets = new Insets(0, 0, 5, 5);
                gbc_textField_36.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_36.gridx = 0;
                gbc_textField_36.gridy = 9;
                panel.add(textField_36, gbc_textField_36);
                
                GridBagConstraints gbc_textField_37 = new GridBagConstraints();
                gbc_textField_37.insets = new Insets(0, 0, 5, 5);
                gbc_textField_37.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_37.gridx = 1;
                gbc_textField_37.gridy = 9;
                panel.add(textField_37, gbc_textField_37);
                
                GridBagConstraints gbc_textField_38 = new GridBagConstraints();
                gbc_textField_38.insets = new Insets(0, 0, 5, 5);
                gbc_textField_38.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_38.gridx = 2;
                gbc_textField_38.gridy = 9;
                panel.add(textField_38, gbc_textField_38);
                
                GridBagConstraints gbc_textField_39 = new GridBagConstraints();
                gbc_textField_39.insets = new Insets(0, 0, 5, 5);
                gbc_textField_39.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_39.gridx = 3;
                gbc_textField_39.gridy = 9;
                panel.add(textField_39, gbc_textField_39);
                
                GridBagConstraints gbc_textField_40 = new GridBagConstraints();
                gbc_textField_40.insets = new Insets(0, 0, 5, 5);
                gbc_textField_40.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_40.gridx = 4;
                gbc_textField_40.gridy = 9;
                panel.add(textField_40, gbc_textField_40);
                
                GridBagConstraints gbc_textField_41 = new GridBagConstraints();
                gbc_textField_41.insets = new Insets(0, 0, 5, 0);
                gbc_textField_41.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_41.gridx = 5;
                gbc_textField_41.gridy = 9;
                panel.add(textField_41, gbc_textField_41);
                
                GridBagConstraints gbc_textField_42 = new GridBagConstraints();
                gbc_textField_42.insets = new Insets(0, 0, 5, 5);
                gbc_textField_42.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_42.gridx = 0;
                gbc_textField_42.gridy = 10;
                panel.add(textField_42, gbc_textField_42);
                
                GridBagConstraints gbc_textField_43 = new GridBagConstraints();
                gbc_textField_43.insets = new Insets(0, 0, 5, 5);
                gbc_textField_43.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_43.gridx = 1;
                gbc_textField_43.gridy = 10;
                panel.add(textField_43, gbc_textField_43);
                
                GridBagConstraints gbc_textField_44 = new GridBagConstraints();
                gbc_textField_44.insets = new Insets(0, 0, 5, 5);
                gbc_textField_44.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_44.gridx = 2;
                gbc_textField_44.gridy = 10;
                textField_44.setColumns(10);
                panel.add(textField_44, gbc_textField_44);
                
                GridBagConstraints gbc_textField_45 = new GridBagConstraints();
                gbc_textField_45.insets = new Insets(0, 0, 5, 5);
                gbc_textField_45.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_45.gridx = 3;
                gbc_textField_45.gridy = 10;
                textField_45.setColumns(10);
                panel.add(textField_45, gbc_textField_45);
                
                GridBagConstraints gbc_textField_46 = new GridBagConstraints();
                gbc_textField_46.insets = new Insets(0, 0, 5, 5);
                gbc_textField_46.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_46.gridx = 4;
                gbc_textField_46.gridy = 10;
                textField_46.setColumns(10);
                panel.add(textField_46, gbc_textField_46);
                
                GridBagConstraints gbc_textField_47 = new GridBagConstraints();
                gbc_textField_47.insets = new Insets(0, 0, 5, 0);
                gbc_textField_47.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_47.gridx = 5;
                gbc_textField_47.gridy = 10;
                textField_47.setColumns(10);
                panel.add(textField_47, gbc_textField_47);
                
                GridBagConstraints gbc_textField_48 = new GridBagConstraints();
                gbc_textField_48.insets = new Insets(0, 0, 5, 5);
                gbc_textField_48.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_48.gridx = 0;
                gbc_textField_48.gridy = 11;
                textField_48.setColumns(10);
                panel.add(textField_48, gbc_textField_48);
                
                GridBagConstraints gbc_textField_49 = new GridBagConstraints();
                gbc_textField_49.insets = new Insets(0, 0, 5, 5);
                gbc_textField_49.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_49.gridx = 1;
                gbc_textField_49.gridy = 11;
                textField_49.setColumns(10);
                panel.add(textField_49, gbc_textField_49);
                
                GridBagConstraints gbc_textField_50 = new GridBagConstraints();
                gbc_textField_50.insets = new Insets(0, 0, 5, 5);
                gbc_textField_50.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_50.gridx = 2;
                gbc_textField_50.gridy = 11;
                textField_50.setColumns(10);
                panel.add(textField_50, gbc_textField_50);
                
                GridBagConstraints gbc_textField_51 = new GridBagConstraints();
                gbc_textField_51.insets = new Insets(0, 0, 5, 5);
                gbc_textField_51.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_51.gridx = 3;
                gbc_textField_51.gridy = 11;
                textField_51.setColumns(10);
                panel.add(textField_51, gbc_textField_51);
                
                GridBagConstraints gbc_textField_52 = new GridBagConstraints();
                gbc_textField_52.insets = new Insets(0, 0, 5, 5);
                gbc_textField_52.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_52.gridx = 4;
                gbc_textField_52.gridy = 11;
                textField_52.setColumns(10);
                panel.add(textField_52, gbc_textField_52);
                
                GridBagConstraints gbc_textField_53 = new GridBagConstraints();
                gbc_textField_53.insets = new Insets(0, 0, 5, 0);
                gbc_textField_53.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_53.gridx = 5;
                gbc_textField_53.gridy = 11;
                textField_53.setColumns(10);
                panel.add(textField_53, gbc_textField_53);
                
                GridBagConstraints gbc_textField_54 = new GridBagConstraints();
                gbc_textField_54.insets = new Insets(0, 0, 5, 5);
                gbc_textField_54.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_54.gridx = 0;
                gbc_textField_54.gridy = 12;
                textField_54.setColumns(10);
                panel.add(textField_54, gbc_textField_54);
                
                GridBagConstraints gbc_textField_55 = new GridBagConstraints();
                gbc_textField_55.insets = new Insets(0, 0, 5, 5);
                gbc_textField_55.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_55.gridx = 1;
                gbc_textField_55.gridy = 12;
                textField_55.setColumns(10);
                panel.add(textField_55, gbc_textField_55);
                
                GridBagConstraints gbc_textField_56 = new GridBagConstraints();
                gbc_textField_56.insets = new Insets(0, 0, 5, 5);
                gbc_textField_56.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_56.gridx = 2;
                gbc_textField_56.gridy = 12;
                textField_56.setColumns(10);
                panel.add(textField_56, gbc_textField_56);
                
                GridBagConstraints gbc_textField_57 = new GridBagConstraints();
                gbc_textField_57.insets = new Insets(0, 0, 5, 5);
                gbc_textField_57.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_57.gridx = 3;
                gbc_textField_57.gridy = 12;
                textField_57.setColumns(10);
                panel.add(textField_57, gbc_textField_57);
                
                GridBagConstraints gbc_textField_58 = new GridBagConstraints();
                gbc_textField_58.insets = new Insets(0, 0, 5, 5);
                gbc_textField_58.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_58.gridx = 4;
                gbc_textField_58.gridy = 12;
                textField_58.setColumns(10);
                panel.add(textField_58, gbc_textField_58);
                
                GridBagConstraints gbc_textField_59 = new GridBagConstraints();
                gbc_textField_59.insets = new Insets(0, 0, 5, 0);
                gbc_textField_59.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_59.gridx = 5;
                gbc_textField_59.gridy = 12;
                textField_59.setColumns(10);
                panel.add(textField_59, gbc_textField_59);
                
                GridBagConstraints gbc_textField_60 = new GridBagConstraints();
                gbc_textField_60.insets = new Insets(0, 0, 5, 5);
                gbc_textField_60.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_60.gridx = 0;
                gbc_textField_60.gridy = 13;
                textField_60.setColumns(10);
                panel.add(textField_60, gbc_textField_60);
                
                GridBagConstraints gbc_textField_61 = new GridBagConstraints();
                gbc_textField_61.insets = new Insets(0, 0, 5, 5);
                gbc_textField_61.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_61.gridx = 1;
                gbc_textField_61.gridy = 13;
                textField_61.setColumns(10);
                panel.add(textField_61, gbc_textField_61);
                
                GridBagConstraints gbc_textField_62 = new GridBagConstraints();
                gbc_textField_62.insets = new Insets(0, 0, 5, 5);
                gbc_textField_62.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_62.gridx = 2;
                gbc_textField_62.gridy = 13;
                textField_62.setColumns(10);
                panel.add(textField_62, gbc_textField_62);
                
                GridBagConstraints gbc_textField_63 = new GridBagConstraints();
                gbc_textField_63.insets = new Insets(0, 0, 5, 5);
                gbc_textField_63.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_63.gridx = 3;
                gbc_textField_63.gridy = 13;
                textField_63.setColumns(10);
                panel.add(textField_63, gbc_textField_63);
                
                GridBagConstraints gbc_textField_64 = new GridBagConstraints();
                gbc_textField_64.insets = new Insets(0, 0, 5, 5);
                gbc_textField_64.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_64.gridx = 4;
                gbc_textField_64.gridy = 13;
                textField_64.setColumns(10);
                panel.add(textField_64, gbc_textField_64);
                
                GridBagConstraints gbc_textField_65 = new GridBagConstraints();
                gbc_textField_65.insets = new Insets(0, 0, 5, 0);
                gbc_textField_65.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_65.gridx = 5;
                gbc_textField_65.gridy = 13;
                textField_65.setColumns(10);
                panel.add(textField_65, gbc_textField_65);
                
                GridBagConstraints gbc_textField_66 = new GridBagConstraints();
                gbc_textField_66.insets = new Insets(0, 0, 5, 5);
                gbc_textField_66.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_66.gridx = 0;
                gbc_textField_66.gridy = 14;
                textField_66.setColumns(10);
                panel.add(textField_66, gbc_textField_66);
                
                GridBagConstraints gbc_textField_67 = new GridBagConstraints();
                gbc_textField_67.insets = new Insets(0, 0, 5, 5);
                gbc_textField_67.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_67.gridx = 1;
                gbc_textField_67.gridy = 14;
                textField_67.setColumns(10);
                panel.add(textField_67, gbc_textField_67);
                
                GridBagConstraints gbc_textField_68 = new GridBagConstraints();
                gbc_textField_68.insets = new Insets(0, 0, 5, 5);
                gbc_textField_68.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_68.gridx = 2;
                gbc_textField_68.gridy = 14;
                textField_68.setColumns(10);
                panel.add(textField_68, gbc_textField_68);
                
                GridBagConstraints gbc_textField_69 = new GridBagConstraints();
                gbc_textField_69.insets = new Insets(0, 0, 5, 5);
                gbc_textField_69.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_69.gridx = 3;
                gbc_textField_69.gridy = 14;
                textField_69.setColumns(10);
                panel.add(textField_69, gbc_textField_69);
                
                GridBagConstraints gbc_textField_70 = new GridBagConstraints();
                gbc_textField_70.insets = new Insets(0, 0, 5, 5);
                gbc_textField_70.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_70.gridx = 4;
                gbc_textField_70.gridy = 14;
                textField_70.setColumns(10);
                panel.add(textField_70, gbc_textField_70);
                
                GridBagConstraints gbc_textField_71 = new GridBagConstraints();
                gbc_textField_71.insets = new Insets(0, 0, 5, 0);
                gbc_textField_71.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_71.gridx = 5;
                gbc_textField_71.gridy = 14;
                textField_71.setColumns(10);
                panel.add(textField_71, gbc_textField_71);
                
                GridBagConstraints gbc_textField_72 = new GridBagConstraints();
                gbc_textField_72.insets = new Insets(0, 0, 5, 5);
                gbc_textField_72.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_72.gridx = 0;
                gbc_textField_72.gridy = 15;
                textField_72.setColumns(10);
                panel.add(textField_72, gbc_textField_72);
                
                GridBagConstraints gbc_textField_73 = new GridBagConstraints();
                gbc_textField_73.insets = new Insets(0, 0, 5, 5);
                gbc_textField_73.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_73.gridx = 1;
                gbc_textField_73.gridy = 15;
                textField_73.setColumns(10);
                panel.add(textField_73, gbc_textField_73);
                
                GridBagConstraints gbc_textField_74 = new GridBagConstraints();
                gbc_textField_74.insets = new Insets(0, 0, 5, 5);
                gbc_textField_74.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_74.gridx = 2;
                gbc_textField_74.gridy = 15;
                textField_74.setColumns(10);
                panel.add(textField_74, gbc_textField_74);
                
                GridBagConstraints gbc_textField_75 = new GridBagConstraints();
                gbc_textField_75.insets = new Insets(0, 0, 5, 5);
                gbc_textField_75.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_75.gridx = 3;
                gbc_textField_75.gridy = 15;
                textField_75.setColumns(10);
                panel.add(textField_75, gbc_textField_75);
                
                GridBagConstraints gbc_textField_76 = new GridBagConstraints();
                gbc_textField_76.insets = new Insets(0, 0, 5, 5);
                gbc_textField_76.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_76.gridx = 4;
                gbc_textField_76.gridy = 15;
                textField_76.setColumns(10);
                panel.add(textField_76, gbc_textField_76);
                
                GridBagConstraints gbc_textField_77 = new GridBagConstraints();
                gbc_textField_77.insets = new Insets(0, 0, 5, 0);
                gbc_textField_77.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_77.gridx = 5;
                gbc_textField_77.gridy = 15;
                textField_77.setColumns(10);
                panel.add(textField_77, gbc_textField_77);
                
                GridBagConstraints gbc_textField_78 = new GridBagConstraints();
                gbc_textField_78.insets = new Insets(0, 0, 5, 5);
                gbc_textField_78.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_78.gridx = 0;
                gbc_textField_78.gridy = 16;
                textField_78.setColumns(10);
                panel.add(textField_78, gbc_textField_78);
                
                GridBagConstraints gbc_textField_79 = new GridBagConstraints();
                gbc_textField_79.insets = new Insets(0, 0, 5, 5);
                gbc_textField_79.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_79.gridx = 1;
                gbc_textField_79.gridy = 16;
                textField_79.setColumns(10);
                panel.add(textField_79, gbc_textField_79);
                
                GridBagConstraints gbc_textField_80 = new GridBagConstraints();
                gbc_textField_80.insets = new Insets(0, 0, 5, 5);
                gbc_textField_80.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_80.gridx = 2;
                gbc_textField_80.gridy = 16;
                textField_80.setColumns(10);
                panel.add(textField_80, gbc_textField_80);
                
                GridBagConstraints gbc_textField_81 = new GridBagConstraints();
                gbc_textField_81.insets = new Insets(0, 0, 5, 5);
                gbc_textField_81.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_81.gridx = 3;
                gbc_textField_81.gridy = 16;
                textField_81.setColumns(10);
                panel.add(textField_81, gbc_textField_81);
                
                GridBagConstraints gbc_textField_82 = new GridBagConstraints();
                gbc_textField_82.insets = new Insets(0, 0, 5, 5);
                gbc_textField_82.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_82.gridx = 4;
                gbc_textField_82.gridy = 16;
                textField_82.setColumns(10);
                panel.add(textField_82, gbc_textField_82);
                
                GridBagConstraints gbc_textField_83 = new GridBagConstraints();
                gbc_textField_83.insets = new Insets(0, 0, 5, 0);
                gbc_textField_83.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_83.gridx = 5;
                gbc_textField_83.gridy = 16;
                textField_83.setColumns(10);
                panel.add(textField_83, gbc_textField_83);
                
                GridBagConstraints gbc_textField_84 = new GridBagConstraints();
                gbc_textField_84.insets = new Insets(0, 0, 5, 5);
                gbc_textField_84.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_84.gridx = 0;
                gbc_textField_84.gridy = 17;
                textField_84.setColumns(10);
                panel.add(textField_84, gbc_textField_84);
                
                GridBagConstraints gbc_textField_85 = new GridBagConstraints();
                gbc_textField_85.insets = new Insets(0, 0, 5, 5);
                gbc_textField_85.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_85.gridx = 1;
                gbc_textField_85.gridy = 17;
                textField_85.setColumns(10);
                panel.add(textField_85, gbc_textField_85);
                
                GridBagConstraints gbc_textField_86 = new GridBagConstraints();
                gbc_textField_86.insets = new Insets(0, 0, 5, 5);
                gbc_textField_86.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_86.gridx = 2;
                gbc_textField_86.gridy = 17;
                textField_86.setColumns(10);
                panel.add(textField_86, gbc_textField_86);
                
                GridBagConstraints gbc_textField_87 = new GridBagConstraints();
                gbc_textField_87.insets = new Insets(0, 0, 5, 5);
                gbc_textField_87.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_87.gridx = 3;
                gbc_textField_87.gridy = 17;
                textField_87.setColumns(10);
                panel.add(textField_87, gbc_textField_87);
                
                GridBagConstraints gbc_textField_88 = new GridBagConstraints();
                gbc_textField_88.insets = new Insets(0, 0, 5, 5);
                gbc_textField_88.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_88.gridx = 4;
                gbc_textField_88.gridy = 17;
                textField_88.setColumns(10);
                panel.add(textField_88, gbc_textField_88);
                
                GridBagConstraints gbc_textField_89 = new GridBagConstraints();
                gbc_textField_89.insets = new Insets(0, 0, 5, 0);
                gbc_textField_89.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_89.gridx = 5;
                gbc_textField_89.gridy = 17;
                textField_89.setColumns(10);
                panel.add(textField_89, gbc_textField_89);
                setLayout(groupLayout);
                
               
        	    
        	 
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/                
                
                
                	// remove resources using the DEL key
                	resourcesTable.addKeyListener(new KeyListener() {
                		public void keyPressed(KeyEvent e){
                			if(resourcesTable.getSelectedRows().length>0 
                				&& e.getKeyCode()==KeyEvent.VK_DELETE)
                				ppRemoveRes_actionPerformed(null);
                		}
                		public void	keyReleased(KeyEvent e){}
                		public void keyTyped(KeyEvent e){} 
                	});
    resPPMenu.add(ppRun);
    resPPMenu.addSeparator();
    resPPMenu.add(ppNewRes);
    resPPMenu.add(ppRemoveRes);
    resPPMenu.addSeparator();
    resPPMenu.add(ppRefresh);
    }
    
//    final String MONTH1 = "January";
//    final String MONTH2 = "February";
//	final String MONTH3 = "March";
//	final String MONTH4 = "April";
//	final String MONTH5 = "May";
//	final String MONTH6 = "June";
//	final String MONTH7 = "July";
//	final String MONTH8 = "August";
//	final String MONTH9 = "September";
//	final String MONTH10 = "October";
//	final String MONTH11 = "November";
//	final String MONTH12 = "December";
// 
//    public void addComponentToPane(Container pane) {
//		
//        JTabbedPane tabbedPane = new JTabbedPane();
// 
//        //Create the "cards".
//        JPanel card1 = new JPanel() {
//            public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card2 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        
//        JPanel card3 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card4 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card5 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card6 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card7 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card8 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card9 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card10 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card11 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        JPanel card12 = new JPanel(){
//        	public Dimension getPreferredSize() {
//            	Dimension size = super.getPreferredSize();
//            	size.setSize(935,600);
//            	return size;
//            }
//        };
//        
//        card1.add(new JLabel("Date                        "));
//        card1.add(new JLabel("Start                       "));
//        card1.add(new JLabel("       Stop                 "));
//        card1.add(new JLabel("   Interruption Time        "));
//        card1.add(new JLabel("       Phase                "));
//        card1.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card2.add(new JLabel("Date                        "));
//        card2.add(new JLabel("Start                       "));
//        card2.add(new JLabel("       Stop                 "));
//        card2.add(new JLabel("   Interruption Time        "));
//        card2.add(new JLabel("       Phase                "));
//        card2.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card3.add(new JLabel("Date                        "));
//        card3.add(new JLabel("Start                       "));
//        card3.add(new JLabel("       Stop                 "));
//        card3.add(new JLabel("   Interruption Time        "));
//        card3.add(new JLabel("       Phase                "));
//        card3.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card4.add(new JLabel("Date                        "));
//        card4.add(new JLabel("Start                       "));
//        card4.add(new JLabel("       Stop                 "));
//        card4.add(new JLabel("   Interruption Time        "));
//        card4.add(new JLabel("       Phase                "));
//        card4.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card5.add(new JLabel("Date                        "));
//        card5.add(new JLabel("Start                       "));
//        card5.add(new JLabel("       Stop                 "));
//        card5.add(new JLabel("   Interruption Time        "));
//        card5.add(new JLabel("       Phase                "));
//        card5.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card6.add(new JLabel("Date                        "));
//        card6.add(new JLabel("Start                       "));
//        card6.add(new JLabel("       Stop                 "));
//        card6.add(new JLabel("   Interruption Time        "));
//        card6.add(new JLabel("       Phase                "));
//        card6.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card7.add(new JLabel("Date                        "));
//        card7.add(new JLabel("Start                       "));
//        card7.add(new JLabel("       Stop                 "));
//        card7.add(new JLabel("   Interruption Time        "));
//        card7.add(new JLabel("       Phase                "));
//        card7.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card8.add(new JLabel("Date                        "));
//        card8.add(new JLabel("Start                       "));
//        card8.add(new JLabel("       Stop                 "));
//        card8.add(new JLabel("   Interruption Time        "));
//        card8.add(new JLabel("       Phase                "));
//        card8.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card9.add(new JLabel("Date                        "));
//        card9.add(new JLabel("Start                       "));
//        card9.add(new JLabel("       Stop                 "));
//        card9.add(new JLabel("   Interruption Time        "));
//        card9.add(new JLabel("       Phase                "));
//        card9.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card10.add(new JLabel("Date                        "));
//        card10.add(new JLabel("Start                       "));
//        card10.add(new JLabel("       Stop                 "));
//        card10.add(new JLabel("   Interruption Time        "));
//        card10.add(new JLabel("       Phase                "));
//        card10.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card11.add(new JLabel("Date                        "));
//        card11.add(new JLabel("Start                       "));
//        card11.add(new JLabel("       Stop                 "));
//        card11.add(new JLabel("   Interruption Time        "));
//        card11.add(new JLabel("       Phase                "));
//        card11.add(new JLabel("Comments                                                                       "));
//        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        card12.add(new JLabel("Date                        "));
//        card12.add(new JLabel("Start                       "));
//        card12.add(new JLabel("       Stop                 "));
//        card12.add(new JLabel("   Interruption Time        "));
//        card12.add(new JLabel("       Phase                "));
//        card12.add(new JLabel("Comments                                                                       "));
//        
//        tabbedPane.addTab(MONTH1, card1);
//        tabbedPane.addTab(MONTH2, card2);
//        tabbedPane.addTab(MONTH3, card3);
//        tabbedPane.addTab(MONTH4, card4);
//        tabbedPane.addTab(MONTH5, card5);
//        tabbedPane.addTab(MONTH6, card6);
//        tabbedPane.addTab(MONTH7, card7);
//        tabbedPane.addTab(MONTH8, card8);
//        tabbedPane.addTab(MONTH9, card9);
//        tabbedPane.addTab(MONTH10, card10);
//        tabbedPane.addTab(MONTH11, card10);
//        tabbedPane.addTab(MONTH12, card12);
//        
//        int count = 1;
//        int month= 0;
//        
//        while(count != 121 && month != 12){
//        	if (month != 12 && count == 121){
//        		month++;
//        		count = 1;
//        	}
//        	if (count%6 == 0){
//        		card1.add(new JTextField("", 30));
//        		card2.add(new JTextField("", 30));
//        		card3.add(new JTextField("", 30));
//        		card4.add(new JTextField("", 30));
//        		card5.add(new JTextField("", 30));
//        		card6.add(new JTextField("", 30));
//        		card7.add(new JTextField("", 30));
//        		card8.add(new JTextField("", 30));
//        		card9.add(new JTextField("", 30));
//        		card10.add(new JTextField("", 30));
//        		card11.add(new JTextField("", 30));
//        		card12.add(new JTextField("", 30));
//        	}
//        	else if(count %6 != 0){
//        		card1.add(new JTextField("", 10));
//        		card2.add(new JTextField("", 10));
//        		card3.add(new JTextField("", 10));
//        		card4.add(new JTextField("", 10));
//        		card5.add(new JTextField("", 10));
//        		card6.add(new JTextField("", 10));
//        		card7.add(new JTextField("", 10));
//        		card8.add(new JTextField("", 10));
//        		card9.add(new JTextField("", 10));
//        		card10.add(new JTextField("", 10));
//        		card11.add(new JTextField("", 10));
//        		card12.add(new JTextField("", 10));
//        			        		
//        	}
//        	count++;
//        	
//        }
// 
//        pane.add(tabbedPane, BorderLayout.CENTER);
//    }
//    
//    private static void createAndShowGUI() {
//        JFrame frame = new JFrame("Time Table");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        TimeSheetPanel demo = new TimeSheetPanel();
//        demo.addComponentToPane(frame.getContentPane());
// 
//        frame.pack();
//        frame.setVisible(true);
//        
//    }
    
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            createAndShowGUI();
//        }
//    });
    
    

    void newResB_actionPerformed(ActionEvent e) {
        AddResourceDialog dlg = new AddResourceDialog(App.getFrame(), Local.getString("New Timesheet"));
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x, (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return;
        if (dlg.localFileRB.isSelected()) {
            String fpath = dlg.pathField.getText();
            MimeType mt = MimeTypesList.getMimeTypeForFile(fpath);
            if (mt.getMimeTypeId().equals("__UNKNOWN")) {
                mt = addResourceType(fpath);
                if (mt == null)
                    return;
            }
            if (!checkApp(mt))
                return;
            // if file if projectFile, than copy the file and change url.
            if (dlg.projectFileCB.isSelected()) {
            	fpath = copyFileToProjectDir(fpath);
            	CurrentProject.getResourcesList().addResource(fpath, false, true);
            }
            else
            	CurrentProject.getResourcesList().addResource(fpath);            	     	
            
            resourcesTable.tableChanged();
        }
        else {
            if (!Util.checkBrowser())
                return;
            CurrentProject.getResourcesList().addResource(dlg.urlField.getText(), true, false);
            resourcesTable.tableChanged();
        }
    }

    void removeResB_actionPerformed(ActionEvent e) {
        int[] toRemove = resourcesTable.getSelectedRows();
        String msg = "";
        if (toRemove.length == 1)
            msg =
                Local.getString("Remove the shortcut to resource")
                    + "\n'"
                    + resourcesTable.getModel().getValueAt(toRemove[0], 0)
                    + "'";

        else
            msg = Local.getString("Remove") + " " + toRemove.length + " " + Local.getString("shortcuts");
        msg +=
            "\n"
            + Local.getString("Are you sure?");
        int n =
            JOptionPane.showConfirmDialog(
                App.getFrame(),
                msg,
                Local.getString("Remove resource"),
                JOptionPane.YES_NO_OPTION);
        if (n != JOptionPane.YES_OPTION)
            return;
        for (int i = 0; i < toRemove.length; i++) {        	
        		CurrentProject.getResourcesList().removeResource(
                        ((Resource) resourcesTable.getModel().getValueAt(toRemove[i], ResourcesTable._RESOURCE)).getPath());
        }
        resourcesTable.tableChanged();
    }

    MimeType addResourceType(String fpath) {
        ResourceTypeDialog dlg = new ResourceTypeDialog(App.getFrame(), Local.getString("Resource type"));
        Dimension dlgSize = new Dimension(420, 300);
        dlg.setSize(dlgSize);
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.ext = MimeTypesList.getExtension(fpath);
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return null;
        int ix = dlg.getTypesList().getSelectedIndex();
        MimeType mt = (MimeType) MimeTypesList.getAllMimeTypes().toArray()[ix];
        mt.addExtension(MimeTypesList.getExtension(fpath));
        CurrentStorage.get().storeMimeTypesList();
        return mt;
    }

    boolean checkApp(MimeType mt) {
        String appId = mt.getAppId();
        AppList appList = MimeTypesList.getAppList();
        File d;
        if (appId == null) {
            appId = Util.generateId();
            d = new File("/");
        }
        else {
            File exe = new File(appList.getFindPath(appId) + "/" + appList.getExec(appId));
            if (exe.isFile())
                return true;
            d = new File(exe.getParent());
            while (!d.exists())
                d = new File(d.getParent());
        }
        SetAppDialog dlg =
            new SetAppDialog(
                App.getFrame(),
                Local.getString(Local.getString("Select the application to open files of type")+" '" + mt.getLabel() + "'"));
        Dimension dlgSize = new Dimension(420, 300);
        dlg.setSize(dlgSize);
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setDirectory(d);
        dlg.appPanel.argumentsField.setText("$1");
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return false;
        File f = new File(dlg.appPanel.applicationField.getText());

        appList.addOrReplaceApp(
            appId,
            f.getParent().replace('\\', '/'),
            f.getName().replace('\\', '/'),
            dlg.appPanel.argumentsField.getText());
        mt.setApp(appId);
        /*appList.setFindPath(appId, chooser.getSelectedFile().getParent().replace('\\','/'));
        appList.setExec(appId, chooser.getSelectedFile().getName().replace('\\','/'));*/
        CurrentStorage.get().storeMimeTypesList();
        return true;
    }
    

    void runApp(String fpath) {
        MimeType mt = MimeTypesList.getMimeTypeForFile(fpath);
        if (mt.getMimeTypeId().equals("__UNKNOWN")) {
            mt = addResourceType(fpath);
            if (mt == null)
                return;
        }
        if (!checkApp(mt))
            return;
        String[] command = MimeTypesList.getAppList().getCommand(mt.getAppId(), fpath);
        if (command == null)
            return;
        /*DEBUG*/
        System.out.println("Run: " + command[0]);
        try {
            Runtime.getRuntime().exec(command);
        }
        catch (Exception ex) {
            new ExceptionDialog(ex, "Failed to run an external application <br><code>"
                    +command[0]+"</code>", "Check the application path and command line parameters for this resource type " +
                    		"(File-&gt;Preferences-&gt;Resource types).");
        }
    }

    void runBrowser(String url) {
        Util.runBrowser(url);
    }

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if ((e.getClickCount() == 2) && (resourcesTable.getSelectedRow() > -1)) {
                String path = (String) resourcesTable.getValueAt(resourcesTable.getSelectedRow(), 3);
                if (path.length() >0)
                    runApp(path);
                else
                    runBrowser((String) resourcesTable.getValueAt(resourcesTable.getSelectedRow(), 0));
            }
            //editTaskB_actionPerformed(null);
        }

                public void mousePressed(MouseEvent e) {
                    maybeShowPopup(e);
                }

                public void mouseReleased(MouseEvent e) {
                    maybeShowPopup(e);
                }

                private void maybeShowPopup(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        resPPMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }

    }
    void refreshB_actionPerformed(ActionEvent e) {
        resourcesTable.tableChanged();
    }

  void ppRun_actionPerformed(ActionEvent e) {
    String path = (String) resourcesTable.getValueAt(resourcesTable.getSelectedRow(), 3);
                if (path.length() >0)
                    runApp(path);
                else
                    runBrowser((String) resourcesTable.getValueAt(resourcesTable.getSelectedRow(), 0));
  }
  void ppRemoveRes_actionPerformed(ActionEvent e) {
    removeResB_actionPerformed(e);
  }
  void ppNewRes_actionPerformed(ActionEvent e) {
    newResB_actionPerformed(e);
  }

  void ppRefresh_actionPerformed(ActionEvent e) {
     resourcesTable.tableChanged();
  }
  
  /**
   * Copy a: file to the b directory of the current project
   * @param srcStr The path of the source file.
   * @param destStr The destination path.
   * @return The new path of the file.
   */
  String copyFileToProjectDir(String srcStr) {
	  
	  String JN_DOCPATH = Util.getEnvDir();	    
	  
	  String baseName;
	  int i = srcStr.lastIndexOf( File.separator );
		if ( i != -1 ) {
			baseName = srcStr.substring(i+1);
		} else
			baseName = srcStr;
		
	  String destStr = JN_DOCPATH + CurrentProject.get().getID() 
	  				   + File.separator + "_projectFiles" + File.separator + baseName;
	  
	  File f = new File(JN_DOCPATH + CurrentProject.get().getID() + File.separator + "_projectFiles");
	  if (!f.exists()) {
		  f.mkdirs();
	  }	  
	  System.out.println("[DEBUG] Copy file from: "+srcStr+" to: "+destStr);
	  
	  try {
         FileInputStream in = new FileInputStream(srcStr);
         FileOutputStream out = new FileOutputStream(destStr);
         byte[] buf = new byte[4096];
         int len;
         while ((len = in.read(buf)) > 0) {
           out.write(buf, 0, len);
         }
         out.close();
         in.close();
       } 
	   catch (IOException e) {
         System.err.println(e.toString());
       }
		     
  return destStr;
  }
}