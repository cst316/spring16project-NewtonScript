package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.sf.memoranda.Phase;
import net.sf.memoranda.Task;
import net.sf.memoranda.util.Local;

// Dialog for adding a new phase
// Doug Carroll

public class RenamePhaseDialog extends PhaseDialog {
	
	Task ph;
	
	public RenamePhaseDialog(Window window, Task phase){
		super(window, "Rename Phase");
		ph = phase;
		init();
	}
	
	public boolean isCancelled() {
		return cancelled;
	}

	public String getText(){
		return textBox.getText();
	}
	
	// Initialize the window
	protected void init(){
		rootPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		phaseLabel = new JLabel("Rename Phase"); // Label here
		textBox = new JTextField();
		okay = new JButton(Local.getString("Ok"));
		cancel = new JButton(Local.getString("Cancel"));
		
		Border rootBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		// Set the name to the phases name
		textBox.setText(ph.getText());
		
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
	protected void okPressed(ActionEvent e) {
		String text = textBox.getText();
		ph.setText(text);
		
		// Reset the phase value for all of this phases tasks
		ArrayList<Task> tasks = new ArrayList<Task>(ph.getSubTasks());
		for(Task t : tasks){
			t.setPhaseTitle(text);
		}
		
		this.dispose();
	}
	
	// Runs when cancel is pressed
	protected void cancelPressed(ActionEvent e) {
		this.dispose();
	}
	
}
