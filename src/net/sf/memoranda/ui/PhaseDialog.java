package net.sf.memoranda.ui;

import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PhaseDialog extends JDialog {

	JPanel rootPanel;	// Border layout
	JPanel centerPanel; // Border layout
	JPanel buttonPanel;	// Flow layout
	JLabel phaseLabel;
	JTextField textBox;
	JButton okay;
	JButton cancel;
	boolean cancelled = true;
	
	public PhaseDialog(Window window, String str){
		super(window, str, Dialog.ModalityType.APPLICATION_MODAL);
	}
	
	protected abstract void init();
	
	protected abstract void okPressed(ActionEvent e);
	
	protected abstract void cancelPressed(ActionEvent e);
	
	
	
}
