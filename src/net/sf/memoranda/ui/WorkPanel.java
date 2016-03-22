package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.util.Context;
import net.sf.memoranda.util.Local;

/**
 * 
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */

/*$Id: WorkPanel.java,v 1.9 2004/04/05 10:05:44 alexeya Exp $*/
public class WorkPanel extends JPanel {
	BorderLayout borderLayout1 = new BorderLayout();
	JToolBar toolBar = new JToolBar();
	JPanel panel = new JPanel();
	CardLayout cardLayout1 = new CardLayout();

	public JButton notesB = new JButton();
	private static TimeSheetPanel timeSheetPanel;
	public DailyItemsPanel dailyItemsPanel = new DailyItemsPanel(this);
	public ResourcesPanel filesPanel = new ResourcesPanel();
	public JButton agendaB = new JButton();
	public JButton tasksB = new JButton();
	public DefectLogPanel defectLogPanel = new DefectLogPanel();
	public TestCasePanel testCasePanel = new TestCasePanel();
	public JButton eventsB = new JButton();
	public JButton filesB = new JButton();
	public JButton timesheetB = new JButton();
	public JButton defectlogB = new JButton();
	public JButton testcaseB = new JButton();
	
	public JButton usersB = new JButton(); //Button for system users
	SystemUsersDialog sysUser; // System Users dialog
	UsersList userList = UsersList.getInstance(); //List of system users
	
	JButton currentB = null;
	Border border1;

	public WorkPanel() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	/**
	 * Get instance of time sheet panel
	 * 
	 * @return TimeSheetPanel
	 */
	public static TimeSheetPanel getTimeSheetPanel(){
		return timeSheetPanel;
	}
	
	/**
	 * Overwrite time sheet panel obj (if able).
	 * 
	 * @param tsp
	 */
	public static void setTimeSheetPanel(TimeSheetPanel tsp){
		
		if(tsp == null){
			System.out.println("[DEBUG] New Time sheet panel created.");
			tsp = new TimeSheetPanel();
		}
		else{
			System.out.println("[DEBUG] New Time sheet panel loaded from file.");
		}
		
		timeSheetPanel = tsp;
	}

	void jbInit() throws Exception {
		border1 =
			BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(
					BevelBorder.LOWERED,
					Color.white,
					Color.white,
					new Color(124, 124, 124),
					new Color(178, 178, 178)),
				BorderFactory.createEmptyBorder(0, 2, 0, 0));

		this.setLayout(borderLayout1);
		toolBar.setOrientation(JToolBar.VERTICAL);
		toolBar.setBackground(Color.white);

		toolBar.setBorderPainted(false);
		toolBar.setFloatable(false);
		panel.setLayout(cardLayout1);

		agendaB.setBackground(Color.white);
		agendaB.setMaximumSize(new Dimension(60, 80));
		agendaB.setMinimumSize(new Dimension(30, 30));

		agendaB.setFont(new java.awt.Font("Dialog", 1, 10));
		agendaB.setPreferredSize(new Dimension(50, 50));
		agendaB.setBorderPainted(false);
		agendaB.setContentAreaFilled(false);
		agendaB.setFocusPainted(false);
		agendaB.setHorizontalTextPosition(SwingConstants.CENTER);
		agendaB.setText(Local.getString("Agenda"));
		agendaB.setVerticalAlignment(SwingConstants.TOP);
		agendaB.setVerticalTextPosition(SwingConstants.BOTTOM);
		agendaB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendaB_actionPerformed(e);
			}
		});
		agendaB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/agenda.png")));
		agendaB.setOpaque(false);
		agendaB.setMargin(new Insets(0, 0, 0, 0));
		agendaB.setSelected(true);

		eventsB.setBackground(Color.white);
		eventsB.setMaximumSize(new Dimension(60, 80));
		eventsB.setMinimumSize(new Dimension(30, 30));

		eventsB.setFont(new java.awt.Font("Dialog", 1, 10));
		eventsB.setPreferredSize(new Dimension(50, 50));
		eventsB.setBorderPainted(false);
		eventsB.setContentAreaFilled(false);
		eventsB.setFocusPainted(false);
		eventsB.setHorizontalTextPosition(SwingConstants.CENTER);
		eventsB.setText(Local.getString("Events"));
		eventsB.setVerticalAlignment(SwingConstants.TOP);
		eventsB.setVerticalTextPosition(SwingConstants.BOTTOM);
		eventsB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventsB_actionPerformed(e);
			}
		});
		eventsB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/events.png")));
		eventsB.setOpaque(false);
		eventsB.setMargin(new Insets(0, 0, 0, 0));
		//eventsB.setSelected(true);

		tasksB.setSelected(true);
		tasksB.setFont(new java.awt.Font("Dialog", 1, 10));
		tasksB.setMargin(new Insets(0, 0, 0, 0));
		tasksB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/tasks.png")));
		tasksB.setVerticalTextPosition(SwingConstants.BOTTOM);
		tasksB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tasksB_actionPerformed(e);
			}
		});
		tasksB.setVerticalAlignment(SwingConstants.TOP);
		tasksB.setText(Local.getString("Tasks"));
		tasksB.setHorizontalTextPosition(SwingConstants.CENTER);
		tasksB.setFocusPainted(false);
		tasksB.setBorderPainted(false);
		tasksB.setContentAreaFilled(false);
		tasksB.setPreferredSize(new Dimension(50, 50));
		tasksB.setMinimumSize(new Dimension(30, 30));
		tasksB.setOpaque(false);
		tasksB.setMaximumSize(new Dimension(60, 80));
		tasksB.setBackground(Color.white);

		notesB.setFont(new java.awt.Font("Dialog", 1, 10));
		notesB.setBackground(Color.white);
		notesB.setBorder(null);
		notesB.setMaximumSize(new Dimension(60, 80));
		notesB.setMinimumSize(new Dimension(30, 30));
		notesB.setOpaque(false);
		notesB.setPreferredSize(new Dimension(60, 50));
		notesB.setBorderPainted(false);
		notesB.setContentAreaFilled(false);
		notesB.setFocusPainted(false);
		notesB.setHorizontalTextPosition(SwingConstants.CENTER);
		notesB.setText(Local.getString("Notes"));
		notesB.setVerticalAlignment(SwingConstants.TOP);
		notesB.setVerticalTextPosition(SwingConstants.BOTTOM);
		notesB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notesB_actionPerformed(e);
			}
		});
		notesB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/notes.png")));
		notesB.setMargin(new Insets(0, 0, 0, 0));
		notesB.setSelected(true);
		this.setPreferredSize(new Dimension(1073, 300));
		
		usersB.setBackground(Color.white);
		usersB.setMaximumSize(new Dimension(60, 80));
		usersB.setMinimumSize(new Dimension(30, 30));

		usersB.setFont(new java.awt.Font("Dialog", 1, 10));
		usersB.setPreferredSize(new Dimension(50, 50));
		usersB.setBorderPainted(false);
		usersB.setContentAreaFilled(false);
		usersB.setFocusPainted(false);
		usersB.setHorizontalTextPosition(SwingConstants.CENTER);
		usersB.setText(Local.getString("Users"));
		usersB.setVerticalAlignment(SwingConstants.TOP);
		usersB.setVerticalTextPosition(SwingConstants.BOTTOM);
		usersB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usersB_actionPerformed(e);
			}
		});
		usersB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/users.png")));
		usersB.setOpaque(false);
		usersB.setMargin(new Insets(0, 0, 0, 0));
		usersB.setSelected(true);

		filesB.setSelected(true);
		filesB.setMargin(new Insets(0, 0, 0, 0));
		filesB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/files.png")));
		filesB.setVerticalTextPosition(SwingConstants.BOTTOM);
		filesB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filesB_actionPerformed(e);
			}
		});
		filesB.setFont(new java.awt.Font("Dialog", 1, 10));
		filesB.setVerticalAlignment(SwingConstants.TOP);
		filesB.setText(Local.getString("Resources"));
		filesB.setHorizontalTextPosition(SwingConstants.CENTER);
		filesB.setFocusPainted(false);
		filesB.setBorderPainted(false);
		filesB.setContentAreaFilled(false);
		filesB.setPreferredSize(new Dimension(50, 50));
		filesB.setMinimumSize(new Dimension(30, 30));
		filesB.setOpaque(false);
		filesB.setMaximumSize(new Dimension(60, 80));
		/*---------------------------------------------------------------------------*/
		//changed name to time sheet and added new icon
		timesheetB.setSelected(true);
		timesheetB.setMargin(new Insets(0, 0, 0, 0));
		// TODO Changed timesheet.png to time.png.. Where is timesheet.png?
		timesheetB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/time.png")));
		timesheetB.setVerticalTextPosition(SwingConstants.BOTTOM);
		timesheetB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timesheetB_actionPerformed(e);
			}
		});
		timesheetB.setFont(new java.awt.Font("Dialog", 1, 10));
		timesheetB.setVerticalAlignment(SwingConstants.TOP);
		timesheetB.setText(Local.getString("Time Sheet"));
		timesheetB.setHorizontalTextPosition(SwingConstants.CENTER);
		timesheetB.setFocusPainted(false);
		timesheetB.setBorderPainted(false);
		timesheetB.setContentAreaFilled(false);
		timesheetB.setPreferredSize(new Dimension(50, 50));
		timesheetB.setMinimumSize(new Dimension(30, 30));
		timesheetB.setOpaque(false);
		timesheetB.setMaximumSize(new Dimension(60, 80));
		timesheetB.setBackground(Color.red);
		
		// Set the time sheet panel from file
		setTimeSheetPanel(CurrentProject.getTimeSheet());
		
		/*--------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------*/
		defectlogB.setSelected(true);
		defectlogB.setMargin(new Insets(0, 0, 0, 0));
		defectlogB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/bug3.png")));
		defectlogB.setVerticalTextPosition(SwingConstants.BOTTOM);
		defectlogB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defectlogB_actionPerformed(e);
			}
		});
		defectlogB.setFont(new java.awt.Font("Dialog", 1, 10));
		defectlogB.setVerticalAlignment(SwingConstants.TOP);
		defectlogB.setText(Local.getString("Defects"));
		defectlogB.setHorizontalTextPosition(SwingConstants.CENTER);
		defectlogB.setFocusPainted(false);
		defectlogB.setBorderPainted(false);
		defectlogB.setContentAreaFilled(false);
		defectlogB.setPreferredSize(new Dimension(50, 50));
		defectlogB.setMinimumSize(new Dimension(30, 30));
		defectlogB.setOpaque(false);
		defectlogB.setMaximumSize(new Dimension(60, 80));
		defectlogB.setBackground(Color.red);

		/*--------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------*/
		testcaseB.setSelected(true);
		testcaseB.setMargin(new Insets(0, 0, 0, 0));
		testcaseB.setIcon(
			new ImageIcon(
				net.sf.memoranda.ui.AppFrame.class.getResource(
					"resources/icons/testcase.png")));
		testcaseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		testcaseB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testcaseB_actionPerformed(e);
			}
		});
		testcaseB.setFont(new java.awt.Font("Dialog", 1, 10));
		testcaseB.setVerticalAlignment(SwingConstants.TOP);
		testcaseB.setText(Local.getString("Test Cases"));
		testcaseB.setHorizontalTextPosition(SwingConstants.CENTER);
		testcaseB.setFocusPainted(false);
		testcaseB.setBorderPainted(false);
		testcaseB.setContentAreaFilled(false);
		testcaseB.setPreferredSize(new Dimension(50, 50));
		testcaseB.setMinimumSize(new Dimension(30, 30));
		testcaseB.setOpaque(false);
		testcaseB.setMaximumSize(new Dimension(60, 80));
		testcaseB.setBackground(Color.red);

		/*--------------------------------------------------------------------------*/
		filesB.setBackground(Color.red);
		this.add(toolBar, BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		panel.add(defectLogPanel, "DEFECTLOG");
		panel.add(timeSheetPanel, "TIMESHEET");
		panel.add(dailyItemsPanel, "DAILYITEMS");
		panel.add(testCasePanel, "TESTCASES");
		panel.add(filesPanel, "FILES");
		toolBar.add(agendaB, null);
		toolBar.add(eventsB, null);
		toolBar.add(tasksB, null);
		toolBar.add(notesB, null);
		toolBar.add(filesB, null);
		toolBar.add(timesheetB, null);
		toolBar.add(defectlogB, null);
		toolBar.add(testcaseB, null);
		toolBar.add(usersB, null);
		currentB = agendaB;
		// Default blue color
		currentB.setBackground(new Color(215, 225, 250));
		currentB.setOpaque(true);

		toolBar.setBorder(null);
		panel.setBorder(null);
		dailyItemsPanel.setBorder(null);
		filesPanel.setBorder(null);

	}

	public void selectPanel(String pan) {
		if (pan != null) {
			if (pan.equals("NOTES"))
				notesB_actionPerformed(null);
			else if (pan.equals("TASKS"))
				tasksB_actionPerformed(null);
			else if (pan.equals("EVENTS"))
				eventsB_actionPerformed(null);
			else if (pan.equals("FILES"))
				filesB_actionPerformed(null);
			else if (pan.equals("TIMESHEET"))
				timesheetB_actionPerformed(null);
			else if (pan.equals("DEFECTLOG"))
				defectlogB_actionPerformed(null);
			else if (pan.equals("TESTCASES"))
				testcaseB_actionPerformed(null);
			else if (pan.equals("USERS"))
				usersB_actionPerformed(null);
		}
	}

	public void agendaB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("AGENDA");
		setCurrentButton(agendaB);
		Context.put("CURRENT_PANEL", "AGENDA");
	}

	public void notesB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("NOTES");
		setCurrentButton(notesB);
		Context.put("CURRENT_PANEL", "NOTES");
	}

	public void tasksB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("TASKS");
		setCurrentButton(tasksB);
		Context.put("CURRENT_PANEL", "TASKS");
	}

	public void eventsB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DAILYITEMS");
		dailyItemsPanel.selectPanel("EVENTS");
		setCurrentButton(eventsB);
		Context.put("CURRENT_PANEL", "EVENTS");
	}

	public void filesB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "FILES");
		setCurrentButton(filesB);
		Context.put("CURRENT_PANEL", "FILES");
	}
	public void timesheetB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "TIMESHEET");
		setCurrentButton(timesheetB);
		Context.put("CURRENT_PANEL", "FILES");
	}
	public void defectlogB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "DEFECTLOG");
		setCurrentButton(defectlogB);
		Context.put("CURRENT_PANEL", "DEFECTLOG");
	}
	public void usersB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "USERS");
		dailyItemsPanel.selectPanel("USERS");
		setCurrentButton(usersB);
		Context.put("CURRENT_PANEL", "USERS");
		sysUser = new SystemUsersDialog(App.getFrame(), "System Users");
    	sysUser.requestFocus();
    	userList.addArray(sysUser.getUsersArray());
	}
	public void testcaseB_actionPerformed(ActionEvent e) {
		cardLayout1.show(panel, "TESTCASES");
		setCurrentButton(testcaseB);
		Context.put("CURRENT_PANEL", "TESTCASES");
	}

	void setCurrentButton(JButton cb) {
		currentB.setBackground(Color.white);
		currentB.setOpaque(false);
		currentB = cb;
		// Default color blue
		currentB.setBackground(new Color(215, 225, 250));
		currentB.setOpaque(true);
	}
}