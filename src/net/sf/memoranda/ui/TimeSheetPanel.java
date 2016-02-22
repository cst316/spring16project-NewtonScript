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

  private final JLabel lblDate = new JLabel("          Date          ");
  private final JLabel lblStart = new JLabel("          Start          ");
  private final JLabel lblStop = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase = new JLabel("          Phase          ");
  private final JLabel lblComment_1 = new JLabel("                              Comment                              ");

  private final JLabel lblDate_2 = new JLabel("          Date          ");
  private final JLabel lblStart_2 = new JLabel("          Start          ");
  private final JLabel lblStop_2 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_2 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_2 = new JLabel("          Phase          ");
  private final JLabel lblComment_2 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_3 = new JLabel("          Date          ");
  private final JLabel lblStart_3 = new JLabel("          Start          ");
  private final JLabel lblStop_3 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_3 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_3 = new JLabel("          Phase          ");
  private final JLabel lblComment_3 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_4 = new JLabel("          Date          ");
  private final JLabel lblStart_4 = new JLabel("          Start          ");
  private final JLabel lblStop_4 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_4 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_4 = new JLabel("          Phase          ");
  private final JLabel lblComment_4 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_5 = new JLabel("          Date          ");
  private final JLabel lblStart_5 = new JLabel("          Start          ");
  private final JLabel lblStop_5 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_5 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_5 = new JLabel("          Phase          ");
  private final JLabel lblComment_5 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_6 = new JLabel("          Date          ");
  private final JLabel lblStart_6 = new JLabel("          Start          ");
  private final JLabel lblStop_6 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_6 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_6 = new JLabel("          Phase          ");
  private final JLabel lblComment_6 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_7 = new JLabel("          Date          ");
  private final JLabel lblStart_7 = new JLabel("          Start          ");
  private final JLabel lblStop_7 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_7 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_7 = new JLabel("          Phase          ");
  private final JLabel lblComment_7 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_8 = new JLabel("          Date          ");
  private final JLabel lblStart_8 = new JLabel("          Start          ");
  private final JLabel lblStop_8 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_8 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_8 = new JLabel("          Phase          ");
  private final JLabel lblComment_8 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_9 = new JLabel("          Date          ");
  private final JLabel lblStart_9 = new JLabel("          Start          ");
  private final JLabel lblStop_9 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_9 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_9 = new JLabel("          Phase          ");
  private final JLabel lblComment_9 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_10 = new JLabel("          Date          ");
  private final JLabel lblStart_10 = new JLabel("          Start          ");
  private final JLabel lblStop_10 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_10 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_10 = new JLabel("          Phase          ");
  private final JLabel lblComment_10 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_11 = new JLabel("          Date          ");
  private final JLabel lblStart_11 = new JLabel("          Start          ");
  private final JLabel lblStop_11 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_11 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_11 = new JLabel("          Phase          ");
  private final JLabel lblComment_11 = new JLabel("                              Comment                              ");
  
  private final JLabel lblDate_12 = new JLabel("          Date          ");
  private final JLabel lblStart_12 = new JLabel("          Start          ");
  private final JLabel lblStop_12 = new JLabel("          Stop          ");
  private final JLabel lblInterruptTime_12 = new JLabel("   Interrupt Time   ");
  private final JLabel lblPhase_12 = new JLabel("          Phase          ");
  private final JLabel lblComment_12 = new JLabel("                              Comment                              ");
  
  private final JPanel panel = new JPanel();
  private final JPanel panel_1 = new JPanel();
  private final JPanel panel_2 = new JPanel();
  private final JPanel panel_3 = new JPanel();
  private final JPanel panel_4 = new JPanel();
  private final JPanel panel_5 = new JPanel();
  private final JPanel panel_6 = new JPanel();
  private final JPanel panel_7 = new JPanel();
  private final JPanel panel_8 = new JPanel();
  private final JPanel panel_9 = new JPanel();
  private final JPanel panel_10 = new JPanel();
  private final JPanel panel_11 = new JPanel();
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
  private final JTextField textField_90 = new JTextField();
  private final JTextField textField_91 = new JTextField();
  private final JTextField textField_92 = new JTextField();
  private final JTextField textField_93 = new JTextField();
  private final JTextField textField_94 = new JTextField();
  private final JTextField textField_30 = new JTextField();


    public TimeSheetPanel() {

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
                			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
                			.addContainerGap())
                		.addGroup(groupLayout.createSequentialGroup()
                			.addContainerGap()
                			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 964, GroupLayout.PREFERRED_SIZE)
                			.addContainerGap(175, Short.MAX_VALUE))
                );
                groupLayout.setVerticalGroup(
                	groupLayout.createParallelGroup(Alignment.LEADING)
                		.addGroup(groupLayout.createSequentialGroup()
                			.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                			.addGap(5)
                			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                			.addPreferredGap(ComponentPlacement.UNRELATED)
                			.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                			.addContainerGap())
                );
                
                tabbedPane.addTab("January", null, panel, null);
                GridBagLayout gbl_panel = new GridBagLayout();
                gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel.rowWeights = new double[]{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
                panel.setLayout(gbl_panel);
                
                GridBagConstraints gbc_lblDate = new GridBagConstraints();
                gbc_lblDate.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate.gridx = 0;
                gbc_lblDate.gridy = 0;
                panel.add(lblDate, gbc_lblDate);
                
                GridBagConstraints gbc_lblStart = new GridBagConstraints();
                gbc_lblStart.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart.gridx = 1;
                gbc_lblStart.gridy = 0;
                panel.add(lblStart, gbc_lblStart);
                
                GridBagConstraints gbc_lblStop = new GridBagConstraints();
                gbc_lblStop.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop.gridx = 2;
                gbc_lblStop.gridy = 0;
                panel.add(lblStop, gbc_lblStop);
                
                GridBagConstraints gbc_lblInterruptTime = new GridBagConstraints();
                gbc_lblInterruptTime.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime.gridx = 3;
                gbc_lblInterruptTime.gridy = 0;
                panel.add(lblInterruptTime, gbc_lblInterruptTime);
                
                GridBagConstraints gbc_lblPhase = new GridBagConstraints();
                gbc_lblPhase.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase.gridx = 4;
                gbc_lblPhase.gridy = 0;
                panel.add(lblPhase, gbc_lblPhase);
                
                GridBagConstraints gbc_lblComment_1 = new GridBagConstraints();
                gbc_lblComment_1.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_1.gridx = 5;
                gbc_lblComment_1.gridy = 0;
                panel.add(lblComment_1, gbc_lblComment_1);

                GridBagConstraints gbc_textField = new GridBagConstraints();
                gbc_textField.insets = new Insets(0, 0, 5, 5);
                gbc_textField.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField.gridx = 0;
                gbc_textField.gridy = 1;
                panel.add(textField, gbc_textField);
                
                GridBagConstraints gbc_textField_1 = new GridBagConstraints();
                gbc_textField_1.insets = new Insets(0, 0, 5, 5);
                gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_1.gridx = 1;
                gbc_textField_1.gridy = 1;
                panel.add(textField_1, gbc_textField_1);
                
                GridBagConstraints gbc_textField_2 = new GridBagConstraints();
                gbc_textField_2.insets = new Insets(0, 0, 5, 5);
                gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_2.gridx = 2;
                gbc_textField_2.gridy = 1;
                panel.add(textField_2, gbc_textField_2);
                
                GridBagConstraints gbc_textField_3 = new GridBagConstraints();
                gbc_textField_3.insets = new Insets(0, 0, 5, 5);
                gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_3.gridx = 3;
                gbc_textField_3.gridy = 1;
                panel.add(textField_3, gbc_textField_3);
                
                GridBagConstraints gbc_textField_4 = new GridBagConstraints();
                gbc_textField_4.insets = new Insets(0, 0, 5, 5);
                gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_4.gridx = 4;
                gbc_textField_4.gridy = 1;
                panel.add(textField_4, gbc_textField_4);
                
                GridBagConstraints gbc_textField_5 = new GridBagConstraints();
                gbc_textField_5.insets = new Insets(0, 0, 5, 0);
                gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_5.gridx = 5;
                gbc_textField_5.gridy = 1;
                panel.add(textField_5, gbc_textField_5);
                
                GridBagConstraints gbc_textField_6 = new GridBagConstraints();
                gbc_textField_6.insets = new Insets(0, 0, 5, 5);
                gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_6.gridx = 0;
                gbc_textField_6.gridy = 2;
                panel.add(textField_6, gbc_textField_6);
                
                GridBagConstraints gbc_textField_7 = new GridBagConstraints();
                gbc_textField_7.insets = new Insets(0, 0, 5, 5);
                gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_7.gridx = 1;
                gbc_textField_7.gridy = 2;
                panel.add(textField_7, gbc_textField_7);
                
                GridBagConstraints gbc_textField_8 = new GridBagConstraints();
                gbc_textField_8.insets = new Insets(0, 0, 5, 5);
                gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_8.gridx = 2;
                gbc_textField_8.gridy = 2;
                panel.add(textField_8, gbc_textField_8);
                
                GridBagConstraints gbc_textField_9 = new GridBagConstraints();
                gbc_textField_9.insets = new Insets(0, 0, 5, 5);
                gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_9.gridx = 3;
                gbc_textField_9.gridy = 2;
                panel.add(textField_9, gbc_textField_9);
                
                GridBagConstraints gbc_textField_10 = new GridBagConstraints();
                gbc_textField_10.insets = new Insets(0, 0, 5, 5);
                gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_10.gridx = 4;
                gbc_textField_10.gridy = 2;
                panel.add(textField_10, gbc_textField_10);
                
                GridBagConstraints gbc_textField_11 = new GridBagConstraints();
                gbc_textField_11.insets = new Insets(0, 0, 5, 0);
                gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_11.gridx = 5;
                gbc_textField_11.gridy = 2;
                panel.add(textField_11, gbc_textField_11);
                
                GridBagConstraints gbc_textField_12 = new GridBagConstraints();
                gbc_textField_12.insets = new Insets(0, 0, 5, 5);
                gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_12.gridx = 0;
                gbc_textField_12.gridy = 3;
                panel.add(textField_12, gbc_textField_12);
                
                GridBagConstraints gbc_textField_13 = new GridBagConstraints();
                gbc_textField_13.insets = new Insets(0, 0, 5, 5);
                gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_13.gridx = 1;
                gbc_textField_13.gridy = 3;
                panel.add(textField_13, gbc_textField_13);
                
                GridBagConstraints gbc_textField_14 = new GridBagConstraints();
                gbc_textField_14.insets = new Insets(0, 0, 5, 5);
                gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_14.gridx = 2;
                gbc_textField_14.gridy = 3;
                panel.add(textField_14, gbc_textField_14);
                
                GridBagConstraints gbc_textField_15 = new GridBagConstraints();
                gbc_textField_15.insets = new Insets(0, 0, 5, 5);
                gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_15.gridx = 3;
                gbc_textField_15.gridy = 3;
                panel.add(textField_15, gbc_textField_15);
                
                GridBagConstraints gbc_textField_16 = new GridBagConstraints();
                gbc_textField_16.insets = new Insets(0, 0, 5, 5);
                gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_16.gridx = 4;
                gbc_textField_16.gridy = 3;
                panel.add(textField_16, gbc_textField_16);
                
                GridBagConstraints gbc_textField_17 = new GridBagConstraints();
                gbc_textField_17.insets = new Insets(0, 0, 5, 0);
                gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_17.gridx = 5;
                gbc_textField_17.gridy = 3;
                panel.add(textField_17, gbc_textField_17);
                
                GridBagConstraints gbc_textField_18 = new GridBagConstraints();
                gbc_textField_18.insets = new Insets(0, 0, 5, 5);
                gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_18.gridx = 0;
                gbc_textField_18.gridy = 4;
                panel.add(textField_18, gbc_textField_18);
                
                GridBagConstraints gbc_textField_19 = new GridBagConstraints();
                gbc_textField_19.insets = new Insets(0, 0, 5, 5);
                gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_19.gridx = 1;
                gbc_textField_19.gridy = 4;
                panel.add(textField_19, gbc_textField_19);
                
                GridBagConstraints gbc_textField_20 = new GridBagConstraints();
                gbc_textField_20.insets = new Insets(0, 0, 5, 5);
                gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_20.gridx = 2;
                gbc_textField_20.gridy = 4;
                panel.add(textField_20, gbc_textField_20);
                
                GridBagConstraints gbc_textField_21 = new GridBagConstraints();
                gbc_textField_21.insets = new Insets(0, 0, 5, 5);
                gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_21.gridx = 3;
                gbc_textField_21.gridy = 4;
                panel.add(textField_21, gbc_textField_21);
                
                GridBagConstraints gbc_textField_22 = new GridBagConstraints();
                gbc_textField_22.insets = new Insets(0, 0, 5, 5);
                gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_22.gridx = 4;
                gbc_textField_22.gridy = 4;
                panel.add(textField_22, gbc_textField_22);
                
                GridBagConstraints gbc_textField_23 = new GridBagConstraints();
                gbc_textField_23.insets = new Insets(0, 0, 5, 0);
                gbc_textField_23.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_23.gridx = 5;
                gbc_textField_23.gridy = 4;
                panel.add(textField_23, gbc_textField_23);
                
                GridBagConstraints gbc_textField_24 = new GridBagConstraints();
                gbc_textField_24.insets = new Insets(0, 0, 5, 5);
                gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_24.gridx = 0;
                gbc_textField_24.gridy = 5;
                panel.add(textField_24, gbc_textField_24);
                
                GridBagConstraints gbc_textField_25 = new GridBagConstraints();
                gbc_textField_25.insets = new Insets(0, 0, 5, 5);
                gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_25.gridx = 1;
                gbc_textField_25.gridy = 5;
                panel.add(textField_25, gbc_textField_25);
                
                GridBagConstraints gbc_textField_26 = new GridBagConstraints();
                gbc_textField_26.insets = new Insets(0, 0, 5, 5);
                gbc_textField_26.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_26.gridx = 2;
                gbc_textField_26.gridy = 5;
                panel.add(textField_26, gbc_textField_26);
                
                GridBagConstraints gbc_textField_27 = new GridBagConstraints();
                gbc_textField_27.insets = new Insets(0, 0, 5, 5);
                gbc_textField_27.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_27.gridx = 3;
                gbc_textField_27.gridy = 5;
                panel.add(textField_27, gbc_textField_27);
                
                GridBagConstraints gbc_textField_28 = new GridBagConstraints();
                gbc_textField_28.insets = new Insets(0, 0, 5, 5);
                gbc_textField_28.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_28.gridx = 4;
                gbc_textField_28.gridy = 5;
                panel.add(textField_28, gbc_textField_28);
                
                GridBagConstraints gbc_textField_29 = new GridBagConstraints();
                gbc_textField_29.insets = new Insets(0, 0, 5, 0);
                gbc_textField_29.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_29.gridx = 5;
                gbc_textField_29.gridy = 5;
                panel.add(textField_29, gbc_textField_29);
                
                GridBagConstraints gbc_textField_60 = new GridBagConstraints();
                gbc_textField_60.insets = new Insets(0, 0, 5, 5);
                gbc_textField_60.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_60.gridx = 0;
                gbc_textField_60.gridy = 6;
                panel.add(textField_60, gbc_textField_60);
                
                GridBagConstraints gbc_textField_61 = new GridBagConstraints();
                gbc_textField_61.insets = new Insets(0, 0, 5, 5);
                gbc_textField_61.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_61.gridx = 1;
                gbc_textField_61.gridy = 6;
                panel.add(textField_61, gbc_textField_61);
                
                GridBagConstraints gbc_textField_62 = new GridBagConstraints();
                gbc_textField_62.insets = new Insets(0, 0, 5, 5);
                gbc_textField_62.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_62.gridx = 2;
                gbc_textField_62.gridy = 6;
                panel.add(textField_62, gbc_textField_62);
                
                GridBagConstraints gbc_textField_63 = new GridBagConstraints();
                gbc_textField_63.insets = new Insets(0, 0, 5, 5);
                gbc_textField_63.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_63.gridx = 3;
                gbc_textField_63.gridy = 6;
                panel.add(textField_63, gbc_textField_63);
                
                GridBagConstraints gbc_textField_64 = new GridBagConstraints();
                gbc_textField_64.insets = new Insets(0, 0, 5, 5);
                gbc_textField_64.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_64.gridx = 4;
                gbc_textField_64.gridy = 6;
                panel.add(textField_64, gbc_textField_64);
                
                GridBagConstraints gbc_textField_65 = new GridBagConstraints();
                gbc_textField_65.insets = new Insets(0, 0, 5, 0);
                gbc_textField_65.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_65.gridx = 5;
                gbc_textField_65.gridy = 6;
                panel.add(textField_65, gbc_textField_65);
                
                GridBagConstraints gbc_textField_66 = new GridBagConstraints();
                gbc_textField_66.insets = new Insets(0, 0, 5, 5);
                gbc_textField_66.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_66.gridx = 0;
                gbc_textField_66.gridy = 7;
                panel.add(textField_66, gbc_textField_66);
                
                GridBagConstraints gbc_textField_67 = new GridBagConstraints();
                gbc_textField_67.insets = new Insets(0, 0, 5, 5);
                gbc_textField_67.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_67.gridx = 1;
                gbc_textField_67.gridy = 7;
                panel.add(textField_67, gbc_textField_67);
                
                GridBagConstraints gbc_textField_68 = new GridBagConstraints();
                gbc_textField_68.insets = new Insets(0, 0, 5, 5);
                gbc_textField_68.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_68.gridx = 2;
                gbc_textField_68.gridy = 7;
                panel.add(textField_68, gbc_textField_68);
                
                GridBagConstraints gbc_textField_69 = new GridBagConstraints();
                gbc_textField_69.insets = new Insets(0, 0, 5, 5);
                gbc_textField_69.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_69.gridx = 3;
                gbc_textField_69.gridy = 7;
                panel.add(textField_69, gbc_textField_69);
                
                GridBagConstraints gbc_textField_70 = new GridBagConstraints();
                gbc_textField_70.insets = new Insets(0, 0, 5, 5);
                gbc_textField_70.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_70.gridx = 4;
                gbc_textField_70.gridy = 7;
                panel.add(textField_70, gbc_textField_70);
                
                GridBagConstraints gbc_textField_71 = new GridBagConstraints();
                gbc_textField_71.insets = new Insets(0, 0, 5, 0);
                gbc_textField_71.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_71.gridx = 5;
                gbc_textField_71.gridy = 7;
                panel.add(textField_71, gbc_textField_71);
                
                GridBagConstraints gbc_textField_72 = new GridBagConstraints();
                gbc_textField_72.insets = new Insets(0, 0, 5, 5);
                gbc_textField_72.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_72.gridx = 0;
                gbc_textField_72.gridy = 8;
                panel.add(textField_72, gbc_textField_72);
                
                GridBagConstraints gbc_textField_73 = new GridBagConstraints();
                gbc_textField_73.insets = new Insets(0, 0, 5, 5);
                gbc_textField_73.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_73.gridx = 1;
                gbc_textField_73.gridy = 8;
                panel.add(textField_73, gbc_textField_73);
                
                GridBagConstraints gbc_textField_74 = new GridBagConstraints();
                gbc_textField_74.insets = new Insets(0, 0, 5, 5);
                gbc_textField_74.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_74.gridx = 2;
                gbc_textField_74.gridy = 8;
                panel.add(textField_74, gbc_textField_74);
                
                GridBagConstraints gbc_textField_75 = new GridBagConstraints();
                gbc_textField_75.insets = new Insets(0, 0, 5, 5);
                gbc_textField_75.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_75.gridx = 3;
                gbc_textField_75.gridy = 8;
                panel.add(textField_75, gbc_textField_75);
                
                GridBagConstraints gbc_textField_76 = new GridBagConstraints();
                gbc_textField_76.insets = new Insets(0, 0, 5, 5);
                gbc_textField_76.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_76.gridx = 4;
                gbc_textField_76.gridy = 8;
                panel.add(textField_76, gbc_textField_76);
                
                GridBagConstraints gbc_textField_77 = new GridBagConstraints();
                gbc_textField_77.insets = new Insets(0, 0, 5, 0);
                gbc_textField_77.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_77.gridx = 5;
                gbc_textField_77.gridy = 8;
                panel.add(textField_77, gbc_textField_77);
                
                GridBagConstraints gbc_textField_78 = new GridBagConstraints();
                gbc_textField_78.insets = new Insets(0, 0, 5, 5);
                gbc_textField_78.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_78.gridx = 0;
                gbc_textField_78.gridy = 9;
                panel.add(textField_78, gbc_textField_78);
                
                GridBagConstraints gbc_textField_79 = new GridBagConstraints();
                gbc_textField_79.insets = new Insets(0, 0, 5, 5);
                gbc_textField_79.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_79.gridx = 1;
                gbc_textField_79.gridy = 9;
                panel.add(textField_79, gbc_textField_79);
                
                GridBagConstraints gbc_textField_80 = new GridBagConstraints();
                gbc_textField_80.insets = new Insets(0, 0, 5, 5);
                gbc_textField_80.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_80.gridx = 2;
                gbc_textField_80.gridy = 9;
                panel.add(textField_80, gbc_textField_80);
                
                GridBagConstraints gbc_textField_81 = new GridBagConstraints();
                gbc_textField_81.insets = new Insets(0, 0, 5, 5);
                gbc_textField_81.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_81.gridx = 3;
                gbc_textField_81.gridy = 9;
                panel.add(textField_81, gbc_textField_81);
                
                GridBagConstraints gbc_textField_82 = new GridBagConstraints();
                gbc_textField_82.insets = new Insets(0, 0, 5, 5);
                gbc_textField_82.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_82.gridx = 4;
                gbc_textField_82.gridy = 9;
                panel.add(textField_82, gbc_textField_82);
                
                GridBagConstraints gbc_textField_83 = new GridBagConstraints();
                gbc_textField_83.insets = new Insets(0, 0, 5, 0);
                gbc_textField_83.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_83.gridx = 5;
                gbc_textField_83.gridy = 9;
                panel.add(textField_83, gbc_textField_83);
                
                GridBagConstraints gbc_textField_84 = new GridBagConstraints();
                gbc_textField_84.insets = new Insets(0, 0, 5, 5);
                gbc_textField_84.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_84.gridx = 0;
                gbc_textField_84.gridy = 10;
                panel.add(textField_84, gbc_textField_84);
                
                GridBagConstraints gbc_textField_85 = new GridBagConstraints();
                gbc_textField_85.insets = new Insets(0, 0, 5, 5);
                gbc_textField_85.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_85.gridx = 1;
                gbc_textField_85.gridy = 10;
                panel.add(textField_85, gbc_textField_85);
                
                GridBagConstraints gbc_textField_86 = new GridBagConstraints();
                gbc_textField_86.insets = new Insets(0, 0, 5, 5);
                gbc_textField_86.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_86.gridx = 2;
                gbc_textField_86.gridy = 10;
                panel.add(textField_86, gbc_textField_86);
                
                GridBagConstraints gbc_textField_87 = new GridBagConstraints();
                gbc_textField_87.insets = new Insets(0, 0, 5, 5);
                gbc_textField_87.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_87.gridx = 3;
                gbc_textField_87.gridy = 10;
                panel.add(textField_87, gbc_textField_87);
                
                GridBagConstraints gbc_textField_88 = new GridBagConstraints();
                gbc_textField_88.insets = new Insets(0, 0, 5, 5);
                gbc_textField_88.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_88.gridx = 4;
                gbc_textField_88.gridy = 10;
                panel.add(textField_88, gbc_textField_88);
                
                GridBagConstraints gbc_textField_89 = new GridBagConstraints();
                gbc_textField_89.insets = new Insets(0, 0, 5, 0);
                gbc_textField_89.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_89.gridx = 5;
                gbc_textField_89.gridy = 10;
                panel.add(textField_89, gbc_textField_89);
                
                GridBagConstraints gbc_textField_90 = new GridBagConstraints();
                gbc_textField_90.insets = new Insets(0, 0, 0, 5);
                gbc_textField_90.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_90.gridx = 0;
                gbc_textField_90.gridy = 11;
                panel.add(textField_90, gbc_textField_90);
                
                GridBagConstraints gbc_textField_91 = new GridBagConstraints();
                gbc_textField_91.insets = new Insets(0, 0, 0, 5);
                gbc_textField_91.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_91.gridx = 1;
                gbc_textField_91.gridy = 11;
                panel.add(textField_91, gbc_textField_91);
                
                GridBagConstraints gbc_textField_92 = new GridBagConstraints();
                gbc_textField_92.insets = new Insets(0, 0, 0, 5);
                gbc_textField_92.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_92.gridx = 2;
                gbc_textField_92.gridy = 11;
                panel.add(textField_92, gbc_textField_92);
                
                GridBagConstraints gbc_textField_93 = new GridBagConstraints();
                gbc_textField_93.insets = new Insets(0, 0, 0, 5);
                gbc_textField_93.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_93.gridx = 3;
                gbc_textField_93.gridy = 11;
                panel.add(textField_93, gbc_textField_93);
                
                GridBagConstraints gbc_textField_94 = new GridBagConstraints();
                gbc_textField_94.insets = new Insets(0, 0, 0, 5);
                gbc_textField_94.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_94.gridx = 4;
                gbc_textField_94.gridy = 11;
                panel.add(textField_94, gbc_textField_94);
                
                GridBagConstraints gbc_textField_30 = new GridBagConstraints();
                gbc_textField_30.fill = GridBagConstraints.HORIZONTAL;
                gbc_textField_30.gridx = 5;
                gbc_textField_30.gridy = 11;
                panel.add(textField_30, gbc_textField_30);
                
              
                tabbedPane.addTab("February", null, panel_1, null);
                GridBagLayout gbl_panel_1 = new GridBagLayout();
                gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_1.setLayout(gbl_panel_1);
                
                GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
                gbc_lblDate_1.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_1.gridx = 0;
                gbc_lblDate_1.gridy = 1;
                panel_1.add(lblDate_2, gbc_lblDate_1);
                
                GridBagConstraints gbc_lblStart_1 = new GridBagConstraints();
                gbc_lblStart_1.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_1.gridx = 1;
                gbc_lblStart_1.gridy = 1;
                panel_1.add(lblStart_2, gbc_lblStart_1);
                
                GridBagConstraints gbc_lblStop_1 = new GridBagConstraints();
                gbc_lblStop_1.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_1.gridx = 2;
                gbc_lblStop_1.gridy = 1;
                panel_1.add(lblStop_2, gbc_lblStop_1);
                
                GridBagConstraints gbc_lblInterruptTime_1 = new GridBagConstraints();
                gbc_lblInterruptTime_1.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_1.gridx = 3;
                gbc_lblInterruptTime_1.gridy = 1;
                panel_1.add(lblInterruptTime_2, gbc_lblInterruptTime_1);
                
                GridBagConstraints gbc_lblPhase_1 = new GridBagConstraints();
                gbc_lblPhase_1.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_1.gridx = 4;
                gbc_lblPhase_1.gridy = 1;
                panel_1.add(lblPhase_2, gbc_lblPhase_1);
                
                GridBagConstraints gbc_lblComment = new GridBagConstraints();
                gbc_lblComment.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment.gridx = 5;
                gbc_lblComment.gridy = 1;
                panel_1.add(lblComment_2, gbc_lblComment);
                
                tabbedPane.addTab("March", null, panel_2, null);
                GridBagLayout gbl_panel_2 = new GridBagLayout();
                gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_2.setLayout(gbl_panel_2);
                
                GridBagConstraints gbc_lblDate_2 = new GridBagConstraints();
                gbc_lblDate_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_2.gridx = 0;
                gbc_lblDate_2.gridy = 1;
                panel_2.add(lblDate_3, gbc_lblDate_2);
                
                GridBagConstraints gbc_lblStart_2 = new GridBagConstraints();
                gbc_lblStart_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_2.gridx = 1;
                gbc_lblStart_2.gridy = 1;
                panel_2.add(lblStart_3, gbc_lblStart_2);
                
                GridBagConstraints gbc_lblStop_2 = new GridBagConstraints();
                gbc_lblStop_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_2.gridx = 2;
                gbc_lblStop_2.gridy = 1;
                panel_2.add(lblStop_3, gbc_lblStop_2);
                
                GridBagConstraints gbc_lblInterruptTime_2 = new GridBagConstraints();
                gbc_lblInterruptTime_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_2.gridx = 3;
                gbc_lblInterruptTime_2.gridy = 1;
                panel_2.add(lblInterruptTime_3, gbc_lblInterruptTime_2);
                
                GridBagConstraints gbc_lblPhase_2 = new GridBagConstraints();
                gbc_lblPhase_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_2.gridx = 4;
                gbc_lblPhase_2.gridy = 1;
                panel_2.add(lblPhase_3, gbc_lblPhase_2);
                
                GridBagConstraints gbc_lblComment_2 = new GridBagConstraints();
                gbc_lblComment_2.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_2.gridx = 5;
                gbc_lblComment_2.gridy = 1;
                panel_2.add(lblComment_3, gbc_lblComment_2);
                
                tabbedPane.addTab("April", null, panel_3, null);
                GridBagLayout gbl_panel_3 = new GridBagLayout();
                gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_3.setLayout(gbl_panel_3);
                
                GridBagConstraints gbc_lblDate_3 = new GridBagConstraints();
                gbc_lblDate_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_3.gridx = 0;
                gbc_lblDate_3.gridy = 1;
                panel_3.add(lblDate_4, gbc_lblDate_3);
                
                GridBagConstraints gbc_lblStart_3 = new GridBagConstraints();
                gbc_lblStart_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_3.gridx = 1;
                gbc_lblStart_3.gridy = 1;
                panel_3.add(lblStart_4, gbc_lblStart_3);
                
                GridBagConstraints gbc_lblStop_3 = new GridBagConstraints();
                gbc_lblStop_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_3.gridx = 2;
                gbc_lblStop_3.gridy = 1;
                panel_3.add(lblStop_4, gbc_lblStop_3);
                
                GridBagConstraints gbc_lblInterruptTime_3 = new GridBagConstraints();
                gbc_lblInterruptTime_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_3.gridx = 3;
                gbc_lblInterruptTime_3.gridy = 1;
                panel_3.add(lblInterruptTime_4, gbc_lblInterruptTime_3);
                
                GridBagConstraints gbc_lblPhase_3 = new GridBagConstraints();
                gbc_lblPhase_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_3.gridx = 4;
                gbc_lblPhase_3.gridy = 1;
                panel_3.add(lblPhase_4, gbc_lblPhase_3);
                
                GridBagConstraints gbc_lblComment_3 = new GridBagConstraints();
                gbc_lblComment_3.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_3.gridx = 5;
                gbc_lblComment_3.gridy = 1;
                panel_3.add(lblComment_4, gbc_lblComment_3);
                
                tabbedPane.addTab("May", null, panel_4, null);
                GridBagLayout gbl_panel_4 = new GridBagLayout();
                gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_4.setLayout(gbl_panel_4);
                
                GridBagConstraints gbc_lblDate_4 = new GridBagConstraints();
                gbc_lblDate_4.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_4.gridx = 0;
                gbc_lblDate_4.gridy = 1;
                panel_4.add(lblDate_5, gbc_lblDate_4);
                
                GridBagConstraints gbc_lblStart_4 = new GridBagConstraints();
                gbc_lblStart_4.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_4.gridx = 1;
                gbc_lblStart_4.gridy = 1;
                panel_4.add(lblStart_5, gbc_lblStart_4);
                
                GridBagConstraints gbc_lblStop_4 = new GridBagConstraints();
                gbc_lblStop_4.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_4.gridx = 2;
                gbc_lblStop_4.gridy = 1;
                panel_4.add(lblStop_5, gbc_lblStop_4);
                
                GridBagConstraints gbc_lblInterruptTime_4 = new GridBagConstraints();
                gbc_lblInterruptTime_4.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_4.gridx = 3;
                gbc_lblInterruptTime_4.gridy = 1;
                panel_4.add(lblInterruptTime_5, gbc_lblInterruptTime_4);
                
                GridBagConstraints gbc_lblPhase_4 = new GridBagConstraints();
                gbc_lblPhase_4.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_4.gridx = 4;
                gbc_lblPhase_4.gridy = 1;
                panel_4.add(lblPhase_5, gbc_lblPhase_4);
                
                GridBagConstraints gbc_lblComment_4 = new GridBagConstraints();
                gbc_lblComment_4.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_4.gridx = 5;
                gbc_lblComment_4.gridy = 1;
                panel_4.add(lblComment_5, gbc_lblComment_4);

                tabbedPane.addTab("June", null, panel_5, null);
                GridBagLayout gbl_panel_5 = new GridBagLayout();
                gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_5.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_5.setLayout(gbl_panel_5);
                
                GridBagConstraints gbc_lblDate_5 = new GridBagConstraints();
                gbc_lblDate_5.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_5.gridx = 0;
                gbc_lblDate_5.gridy = 1;
                panel_5.add(lblDate_6, gbc_lblDate_5);
                
                GridBagConstraints gbc_lblStart_5 = new GridBagConstraints();
                gbc_lblStart_5.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_5.gridx = 1;
                gbc_lblStart_5.gridy = 1;
                panel_5.add(lblStart_6, gbc_lblStart_5);
                
                GridBagConstraints gbc_lblStop_5 = new GridBagConstraints();
                gbc_lblStop_5.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_5.gridx = 2;
                gbc_lblStop_5.gridy = 1;
                panel_5.add(lblStop_6, gbc_lblStop_5);
                
                GridBagConstraints gbc_lblInterruptTime_5 = new GridBagConstraints();
                gbc_lblInterruptTime_5.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_5.gridx = 3;
                gbc_lblInterruptTime_5.gridy = 1;
                panel_5.add(lblInterruptTime_6, gbc_lblInterruptTime_5);
                
                GridBagConstraints gbc_lblPhase_5 = new GridBagConstraints();
                gbc_lblPhase_5.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_5.gridx = 4;
                gbc_lblPhase_5.gridy = 1;
                panel_5.add(lblPhase_6, gbc_lblPhase_5);
                
                GridBagConstraints gbc_lblComment_5 = new GridBagConstraints();
                gbc_lblComment_5.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_5.gridx = 5;
                gbc_lblComment_5.gridy = 1;
                panel_5.add(lblComment_6, gbc_lblComment_5);

                tabbedPane.addTab("July", null, panel_6, null);
                GridBagLayout gbl_panel_6 = new GridBagLayout();
                gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_6.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_6.setLayout(gbl_panel_6);
                
                GridBagConstraints gbc_lblDate_6 = new GridBagConstraints();
                gbc_lblDate_6.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_6.gridx = 0;
                gbc_lblDate_6.gridy = 1;
                panel_6.add(lblDate_7, gbc_lblDate_6);
                
                GridBagConstraints gbc_lblStart_6 = new GridBagConstraints();
                gbc_lblStart_6.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_6.gridx = 1;
                gbc_lblStart_6.gridy = 1;
                panel_6.add(lblStart_7, gbc_lblStart_6);
                
                GridBagConstraints gbc_lblStop_6 = new GridBagConstraints();
                gbc_lblStop_6.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_6.gridx = 2;
                gbc_lblStop_6.gridy = 1;
                panel_6.add(lblStop_7, gbc_lblStop_6);
                
                GridBagConstraints gbc_lblInterruptTime_6 = new GridBagConstraints();
                gbc_lblInterruptTime_6.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_6.gridx = 3;
                gbc_lblInterruptTime_6.gridy = 1;
                panel_6.add(lblInterruptTime_7, gbc_lblInterruptTime_6);
                
                GridBagConstraints gbc_lblPhase_6 = new GridBagConstraints();
                gbc_lblPhase_6.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_6.gridx = 4;
                gbc_lblPhase_6.gridy = 1;
                panel_6.add(lblPhase_7, gbc_lblPhase_6);
                
                GridBagConstraints gbc_lblComment_6 = new GridBagConstraints();
                gbc_lblComment_6.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_6.gridx = 5;
                gbc_lblComment_6.gridy = 1;
                panel_6.add(lblComment_7, gbc_lblComment_6);

                tabbedPane.addTab("August", null, panel_7, null);
                GridBagLayout gbl_panel_7 = new GridBagLayout();
                gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_7.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_7.setLayout(gbl_panel_7);
                
                GridBagConstraints gbc_lblDate_7 = new GridBagConstraints();
                gbc_lblDate_7.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_7.gridx = 0;
                gbc_lblDate_7.gridy = 1;
                panel_7.add(lblDate_8, gbc_lblDate_7);
                
                GridBagConstraints gbc_lblStart_7 = new GridBagConstraints();
                gbc_lblStart_7.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_7.gridx = 1;
                gbc_lblStart_7.gridy = 1;
                panel_7.add(lblStart_8, gbc_lblStart_7);
                
                GridBagConstraints gbc_lblStop_7 = new GridBagConstraints();
                gbc_lblStop_7.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_7.gridx = 2;
                gbc_lblStop_7.gridy = 1;
                panel_7.add(lblStop_8, gbc_lblStop_7);
                
                GridBagConstraints gbc_lblInterruptTime_7 = new GridBagConstraints();
                gbc_lblInterruptTime_7.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_7.gridx = 3;
                gbc_lblInterruptTime_7.gridy = 1;
                panel_7.add(lblInterruptTime_8, gbc_lblInterruptTime_7);
                
                GridBagConstraints gbc_lblPhase_7 = new GridBagConstraints();
                gbc_lblPhase_7.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_7.gridx = 4;
                gbc_lblPhase_7.gridy = 1;
                panel_7.add(lblPhase_8, gbc_lblPhase_7);
                
                GridBagConstraints gbc_lblComment_7 = new GridBagConstraints();
                gbc_lblComment_7.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_7.gridx = 5;
                gbc_lblComment_7.gridy = 1;
                panel_7.add(lblComment_8, gbc_lblComment_7);

                tabbedPane.addTab("September", null, panel_8, null);
                GridBagLayout gbl_panel_8 = new GridBagLayout();
                gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_8.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_8.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_8.setLayout(gbl_panel_8);
                
                GridBagConstraints gbc_lblDate_8 = new GridBagConstraints();
                gbc_lblDate_8.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_8.gridx = 0;
                gbc_lblDate_8.gridy = 1;
                panel_8.add(lblDate_9, gbc_lblDate_8);
                
                GridBagConstraints gbc_lblStart_8 = new GridBagConstraints();
                gbc_lblStart_8.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_8.gridx = 1;
                gbc_lblStart_8.gridy = 1;
                panel_8.add(lblStart_9, gbc_lblStart_8);
                
                GridBagConstraints gbc_lblStop_8 = new GridBagConstraints();
                gbc_lblStop_8.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_8.gridx = 2;
                gbc_lblStop_8.gridy = 1;
                panel_8.add(lblStop_9, gbc_lblStop_8);
                
                GridBagConstraints gbc_lblInterruptTime_8 = new GridBagConstraints();
                gbc_lblInterruptTime_8.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_8.gridx = 3;
                gbc_lblInterruptTime_8.gridy = 1;
                panel_8.add(lblInterruptTime_9, gbc_lblInterruptTime_8);
                
                GridBagConstraints gbc_lblPhase_8 = new GridBagConstraints();
                gbc_lblPhase_8.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_8.gridx = 4;
                gbc_lblPhase_8.gridy = 1;
                panel_8.add(lblPhase_9, gbc_lblPhase_8);
                
                GridBagConstraints gbc_lblComment_8 = new GridBagConstraints();
                gbc_lblComment_8.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_8.gridx = 5;
                gbc_lblComment_8.gridy = 1;
                panel_8.add(lblComment_9, gbc_lblComment_8);

                tabbedPane.addTab("October", null, panel_9, null);
                GridBagLayout gbl_panel_9 = new GridBagLayout();
                gbl_panel_9.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_9.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_9.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_9.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_9.setLayout(gbl_panel_9);
                
                GridBagConstraints gbc_lblDate_9 = new GridBagConstraints();
                gbc_lblDate_9.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_9.gridx = 0;
                gbc_lblDate_9.gridy = 1;
                panel_9.add(lblDate_10, gbc_lblDate_9);
                
                GridBagConstraints gbc_lblStart_9 = new GridBagConstraints();
                gbc_lblStart_9.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_9.gridx = 1;
                gbc_lblStart_9.gridy = 1;
                panel_9.add(lblStart_10, gbc_lblStart_9);
                
                GridBagConstraints gbc_lblStop_9 = new GridBagConstraints();
                gbc_lblStop_9.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_9.gridx = 2;
                gbc_lblStop_9.gridy = 1;
                panel_9.add(lblStop_10, gbc_lblStop_9);
                
                GridBagConstraints gbc_lblInterruptTime_9 = new GridBagConstraints();
                gbc_lblInterruptTime_9.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_9.gridx = 3;
                gbc_lblInterruptTime_9.gridy = 1;
                panel_9.add(lblInterruptTime_10, gbc_lblInterruptTime_9);
                
                GridBagConstraints gbc_lblPhase_9 = new GridBagConstraints();
                gbc_lblPhase_9.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_9.gridx = 4;
                gbc_lblPhase_9.gridy = 1;
                panel_9.add(lblPhase_10, gbc_lblPhase_9);
                
                GridBagConstraints gbc_lblComment_9 = new GridBagConstraints();
                gbc_lblComment_9.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_9.gridx = 5;
                gbc_lblComment_9.gridy = 1;
                panel_9.add(lblComment_10, gbc_lblComment_9);

                tabbedPane.addTab("November", null, panel_10, null);
                GridBagLayout gbl_panel_10 = new GridBagLayout();
                gbl_panel_10.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_10.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_10.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_10.setLayout(gbl_panel_10);
                
                GridBagConstraints gbc_lblDate_10 = new GridBagConstraints();
                gbc_lblDate_10.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_10.gridx = 0;
                gbc_lblDate_10.gridy = 1;
                panel_10.add(lblDate_11, gbc_lblDate_10);
                
                GridBagConstraints gbc_lblStart_10 = new GridBagConstraints();
                gbc_lblStart_10.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_10.gridx = 1;
                gbc_lblStart_10.gridy = 1;
                panel_10.add(lblStart_11, gbc_lblStart_10);
                
                GridBagConstraints gbc_lblStop_10 = new GridBagConstraints();
                gbc_lblStop_10.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_10.gridx = 2;
                gbc_lblStop_10.gridy = 1;
                panel_10.add(lblStop_11, gbc_lblStop_10);
                
                GridBagConstraints gbc_lblInterruptTime_10 = new GridBagConstraints();
                gbc_lblInterruptTime_10.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_10.gridx = 3;
                gbc_lblInterruptTime_10.gridy = 1;
                panel_10.add(lblInterruptTime_11, gbc_lblInterruptTime_10);
                
                GridBagConstraints gbc_lblPhase_10 = new GridBagConstraints();
                gbc_lblPhase_10.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_10.gridx = 4;
                gbc_lblPhase_10.gridy = 1;
                panel_10.add(lblPhase_11, gbc_lblPhase_10);
                
                GridBagConstraints gbc_lblComment_10 = new GridBagConstraints();
                gbc_lblComment_10.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_10.gridx = 5;
                gbc_lblComment_10.gridy = 1;
                panel_10.add(lblComment_11, gbc_lblComment_10);

                tabbedPane.addTab("December", null, panel_11, null);
                GridBagLayout gbl_panel_11 = new GridBagLayout();
                gbl_panel_11.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                gbl_panel_11.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                gbl_panel_11.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
                gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
                panel_11.setLayout(gbl_panel_11);
                
                GridBagConstraints gbc_lblDate_11 = new GridBagConstraints();
                gbc_lblDate_11.insets = new Insets(0, 0, 5, 5);
                gbc_lblDate_11.gridx = 0;
                gbc_lblDate_11.gridy = 1;
                panel_11.add(lblDate_12, gbc_lblDate_11);
                
                GridBagConstraints gbc_lblStart_11 = new GridBagConstraints();
                gbc_lblStart_11.insets = new Insets(0, 0, 5, 5);
                gbc_lblStart_11.gridx = 1;
                gbc_lblStart_11.gridy = 1;
                panel_11.add(lblStart_12, gbc_lblStart_11);
                
                GridBagConstraints gbc_lblStop_11 = new GridBagConstraints();
                gbc_lblStop_11.insets = new Insets(0, 0, 5, 5);
                gbc_lblStop_11.gridx = 2;
                gbc_lblStop_11.gridy = 1;
                panel_11.add(lblStop_12, gbc_lblStop_11);
                
                GridBagConstraints gbc_lblInterruptTime_11 = new GridBagConstraints();
                gbc_lblInterruptTime_11.insets = new Insets(0, 0, 5, 5);
                gbc_lblInterruptTime_11.gridx = 3;
                gbc_lblInterruptTime_11.gridy = 1;
                panel_11.add(lblInterruptTime_12, gbc_lblInterruptTime_11);
                
                GridBagConstraints gbc_lblPhase_11 = new GridBagConstraints();
                gbc_lblPhase_11.insets = new Insets(0, 0, 5, 5);
                gbc_lblPhase_11.gridx = 4;
                gbc_lblPhase_11.gridy = 1;
                panel_11.add(lblPhase_12, gbc_lblPhase_11);
                
                GridBagConstraints gbc_lblComment_11 = new GridBagConstraints();
                gbc_lblComment_11.insets = new Insets(0, 0, 5, 0);
                gbc_lblComment_11.gridx = 5;
                gbc_lblComment_11.gridy = 1;
                panel_11.add(lblComment_12, gbc_lblComment_11);

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