package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class TestCaseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JTextField methodTextField;
	private JTextField expectedTF;
	private JTextField actualTextField;
	private JTextField testCaseTextField;
	private String selectedID, selectedMethod, selectedDescription, 
		selectedExpected, selectedActual, selectedTestCase, selectedStatus;

	/**
	 * Create the dialog.
	 */
	public TestCaseDialog(Frame appFrame) { 
		super(appFrame);
		run();
	}
	public void run() {
		display();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	private void display() {
		setTitle("Input Test Case Info");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel idLabel = new JLabel("ID: ");
			idLabel.setBounds(29, 30, 30, 16);
			contentPanel.add(idLabel);
		}
		
		idTextField = new JTextField();
		idTextField.setBounds(71, 27, 116, 22);
		contentPanel.add(idTextField);
		idTextField.setColumns(10);
		{
			JLabel methodLabel = new JLabel("Method:");
			methodLabel.setBounds(12, 65, 47, 16);
			contentPanel.add(methodLabel);
		}
		{
			methodTextField = new JTextField();
			methodTextField.setBounds(71, 62, 116, 22);
			contentPanel.add(methodTextField);
			methodTextField.setColumns(10);
		}
		{
			JLabel descriptionLabel = new JLabel("Description");
			descriptionLabel.setBounds(61, 103, 70, 16);
			contentPanel.add(descriptionLabel);
		}
		
		JLabel statusLabel = new JLabel("Status:");
		statusLabel.setBounds(250, 65, 56, 16);
		contentPanel.add(statusLabel);
		
	    JComboBox statusCB = new JComboBox();
		statusCB.setModel(new DefaultComboBoxModel(new String[] {"In Progress", "Passed", "Failed"}));
		statusCB.setMaximumRowCount(3);
		statusCB.setBounds(303, 62, 92, 22);
		contentPanel.add(statusCB);
		
		JLabel expectedLabel = new JLabel("Expected Result:");
		expectedLabel.setBounds(199, 135, 105, 16);
		contentPanel.add(expectedLabel);
		
		expectedTF = new JTextField();
		expectedTF.setBounds(304, 132, 116, 22);
		contentPanel.add(expectedTF);
		expectedTF.setColumns(10);
		
		JLabel actualLabel = new JLabel("Actual Result:");
		actualLabel.setBounds(206, 182, 85, 16);
		contentPanel.add(actualLabel);
		
		actualTextField = new JTextField();
		actualTextField.setBounds(304, 179, 116, 22);
		contentPanel.add(actualTextField);
		actualTextField.setColumns(10);
		{
			JLabel testCaseLabel = new JLabel("Test Case:");
			testCaseLabel.setBounds(228, 30, 63, 16);
			contentPanel.add(testCaseLabel);
		}
		{
			testCaseTextField = new JTextField();
			testCaseTextField.setBounds(304, 27, 116, 22);
			contentPanel.add(testCaseTextField);
			testCaseTextField.setColumns(10);
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(12, 132, 175, 145);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	dispose();
		            }
		        });
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	dispose();
		            }
		        });
				buttonPane.add(cancelButton);
			}
		}
	}
}