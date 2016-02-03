package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.sf.memoranda.util.Local;

// Dialog for adding a new phase
// Doug Carroll

public class PhaseDialog extends JDialog {
	
	JPanel rootPanel;	// Border layout
	JPanel centerPanel; // Border layout
	JPanel buttonPanel;	// Flow layout
	JLabel phaseLabel;
	JTextField textBox;
	JButton okay;
	JButton cancel;
	boolean cancelled = true;
	
	
	public PhaseDialog(Window window, String string){
		super(window, string, Dialog.ModalityType.APPLICATION_MODAL);
		init();
	}
	
	public boolean isCancelled() {
		return cancelled;
	}

	public String getText(){
		return textBox.getText();
	}
	
	// Initialize the window
	private void init(){
		rootPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		phaseLabel = new JLabel("New Phase"); // Label here
		textBox = new JTextField();
		okay = new JButton(Local.getString("Ok"));
		cancel = new JButton(Local.getString("Cancel"));
		
		Border rootBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		this.setResizable(false);
		
		rootPanel.setBorder(rootBorder);
		textBox.setPreferredSize(new Dimension(300, 24));
		
		// Button adds
		buttonPanel.add(okay);
		buttonPanel.add(cancel);
		
		okay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	okPressed(e);
            }
        });
		
		cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cancelPressed(e);
            }
        });
		
		
		// Center adds
		centerPanel.add(textBox, BorderLayout.CENTER);
		
		// Root adds
		rootPanel.add(phaseLabel, BorderLayout.NORTH);
		rootPanel.add(buttonPanel, BorderLayout.SOUTH);
		rootPanel.add(centerPanel, BorderLayout.CENTER);
		this.add(rootPanel);
		this.pack();
	}
	
	// Runs when ok is pressed
	private void okPressed(ActionEvent e) {
		cancelled = false;
		this.dispose();
	}
	
	// Runs when cancel is pressed
	private void cancelPressed(ActionEvent e) {
		this.dispose();
	}
	
}
