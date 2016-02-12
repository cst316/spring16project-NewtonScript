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
  private final JTable table = new JTable();

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
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
//                GroupLayout groupLayout = new GroupLayout(this);
//                groupLayout.setHorizontalGroup(
//                	groupLayout.createParallelGroup(Alignment.LEADING)
//                		.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)
//                		.addGroup(groupLayout.createSequentialGroup()
//                			.addContainerGap()
//                			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
//                				.addComponent(table, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
//                				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)))
//                );
//                groupLayout.setVerticalGroup(
//                	groupLayout.createParallelGroup(Alignment.LEADING)
//                		.addGroup(groupLayout.createSequentialGroup()
//                			.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
//                			.addGap(5)
//                			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
//                			.addPreferredGap(ComponentPlacement.RELATED)
//                			.addComponent(table, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
//                			.addContainerGap(287, Short.MAX_VALUE))
//                );
//                setLayout(groupLayout);
                
               
        	    
        	 
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
    
    final String MONTH1 = "January";
    final String MONTH2 = "February";
	final String MONTH3 = "March";
	final String MONTH4 = "April";
	final String MONTH5 = "May";
	final String MONTH6 = "June";
	final String MONTH7 = "July";
	final String MONTH8 = "August";
	final String MONTH9 = "September";
	final String MONTH10 = "October";
	final String MONTH11 = "November";
	final String MONTH12 = "December";
 
    public void addComponentToPane(Container pane) {
		
        JTabbedPane tabbedPane = new JTabbedPane();
 
        //Create the "cards".
        JPanel card1 = new JPanel() {
            public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card2 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        
        JPanel card3 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card4 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card5 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card6 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card7 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card8 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card9 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card10 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card11 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        JPanel card12 = new JPanel(){
        	public Dimension getPreferredSize() {
            	Dimension size = super.getPreferredSize();
            	size.setSize(935,600);
            	return size;
            }
        };
        
        card1.add(new JLabel("Date                        "));
        card1.add(new JLabel("Start                       "));
        card1.add(new JLabel("       Stop                 "));
        card1.add(new JLabel("   Interruption Time        "));
        card1.add(new JLabel("       Phase                "));
        card1.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card2.add(new JLabel("Date                        "));
        card2.add(new JLabel("Start                       "));
        card2.add(new JLabel("       Stop                 "));
        card2.add(new JLabel("   Interruption Time        "));
        card2.add(new JLabel("       Phase                "));
        card2.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card3.add(new JLabel("Date                        "));
        card3.add(new JLabel("Start                       "));
        card3.add(new JLabel("       Stop                 "));
        card3.add(new JLabel("   Interruption Time        "));
        card3.add(new JLabel("       Phase                "));
        card3.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card4.add(new JLabel("Date                        "));
        card4.add(new JLabel("Start                       "));
        card4.add(new JLabel("       Stop                 "));
        card4.add(new JLabel("   Interruption Time        "));
        card4.add(new JLabel("       Phase                "));
        card4.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card5.add(new JLabel("Date                        "));
        card5.add(new JLabel("Start                       "));
        card5.add(new JLabel("       Stop                 "));
        card5.add(new JLabel("   Interruption Time        "));
        card5.add(new JLabel("       Phase                "));
        card5.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card6.add(new JLabel("Date                        "));
        card6.add(new JLabel("Start                       "));
        card6.add(new JLabel("       Stop                 "));
        card6.add(new JLabel("   Interruption Time        "));
        card6.add(new JLabel("       Phase                "));
        card6.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card7.add(new JLabel("Date                        "));
        card7.add(new JLabel("Start                       "));
        card7.add(new JLabel("       Stop                 "));
        card7.add(new JLabel("   Interruption Time        "));
        card7.add(new JLabel("       Phase                "));
        card7.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card8.add(new JLabel("Date                        "));
        card8.add(new JLabel("Start                       "));
        card8.add(new JLabel("       Stop                 "));
        card8.add(new JLabel("   Interruption Time        "));
        card8.add(new JLabel("       Phase                "));
        card8.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card9.add(new JLabel("Date                        "));
        card9.add(new JLabel("Start                       "));
        card9.add(new JLabel("       Stop                 "));
        card9.add(new JLabel("   Interruption Time        "));
        card9.add(new JLabel("       Phase                "));
        card9.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card10.add(new JLabel("Date                        "));
        card10.add(new JLabel("Start                       "));
        card10.add(new JLabel("       Stop                 "));
        card10.add(new JLabel("   Interruption Time        "));
        card10.add(new JLabel("       Phase                "));
        card10.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card11.add(new JLabel("Date                        "));
        card11.add(new JLabel("Start                       "));
        card11.add(new JLabel("       Stop                 "));
        card11.add(new JLabel("   Interruption Time        "));
        card11.add(new JLabel("       Phase                "));
        card11.add(new JLabel("Comments                                                                       "));
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        card12.add(new JLabel("Date                        "));
        card12.add(new JLabel("Start                       "));
        card12.add(new JLabel("       Stop                 "));
        card12.add(new JLabel("   Interruption Time        "));
        card12.add(new JLabel("       Phase                "));
        card12.add(new JLabel("Comments                                                                       "));
        
        tabbedPane.addTab(MONTH1, card1);
        tabbedPane.addTab(MONTH2, card2);
        tabbedPane.addTab(MONTH3, card3);
        tabbedPane.addTab(MONTH4, card4);
        tabbedPane.addTab(MONTH5, card5);
        tabbedPane.addTab(MONTH6, card6);
        tabbedPane.addTab(MONTH7, card7);
        tabbedPane.addTab(MONTH8, card8);
        tabbedPane.addTab(MONTH9, card9);
        tabbedPane.addTab(MONTH10, card10);
        tabbedPane.addTab(MONTH11, card10);
        tabbedPane.addTab(MONTH12, card12);
        
        int count = 1;
        int month= 0;
        
        while(count != 121 && month != 12){
        	if (month != 12 && count == 121){
        		month++;
        		count = 1;
        	}
        	if (count%6 == 0){
        		card1.add(new JTextField("", 30));
        		card2.add(new JTextField("", 30));
        		card3.add(new JTextField("", 30));
        		card4.add(new JTextField("", 30));
        		card5.add(new JTextField("", 30));
        		card6.add(new JTextField("", 30));
        		card7.add(new JTextField("", 30));
        		card8.add(new JTextField("", 30));
        		card9.add(new JTextField("", 30));
        		card10.add(new JTextField("", 30));
        		card11.add(new JTextField("", 30));
        		card12.add(new JTextField("", 30));
        	}
        	else if(count %6 != 0){
        		card1.add(new JTextField("", 10));
        		card2.add(new JTextField("", 10));
        		card3.add(new JTextField("", 10));
        		card4.add(new JTextField("", 10));
        		card5.add(new JTextField("", 10));
        		card6.add(new JTextField("", 10));
        		card7.add(new JTextField("", 10));
        		card8.add(new JTextField("", 10));
        		card9.add(new JTextField("", 10));
        		card10.add(new JTextField("", 10));
        		card11.add(new JTextField("", 10));
        		card12.add(new JTextField("", 10));
        			        		
        	}
        	count++;
        	
        }
 
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Time Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        TimeSheetPanel demo = new TimeSheetPanel();
        demo.addComponentToPane(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
        
    }
    
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