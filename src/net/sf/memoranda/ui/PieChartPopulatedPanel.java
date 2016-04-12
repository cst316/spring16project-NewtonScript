package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * This panel includes the PieChart with some added UI extras
 * that will be universal for every pie chart.
 * 
 * @author Douglas Carroll
 */
public class PieChartPopulatedPanel extends JPanel{
	
	private static final long serialVersionUID = 351L;
	private JPanel rightPanel;
	private JPanel optionsPanel;
	private JToggleButton rotateToggle;
	private JToggleButton labelsToggle;
	protected PieChart pie;
	
	public PieChartPopulatedPanel(PieChart pie) {
		this.pie = pie;
		init();
	}
	
	public PieChart getPie(){
		return pie;
	}
	
	public JPanel getOptionsPanel(){
		return optionsPanel;
	}
	
	private void init(){
		setLayout(new BorderLayout());
		rightPanel = new JPanel();
		optionsPanel = new JPanel();
		rotateToggle = new JToggleButton();
		labelsToggle = new JToggleButton();
		
		// Setup outer options
		rightPanel.setLayout(new BorderLayout());
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		
		// Rotate button
		rotateToggle.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/testPieRotate.png"))
	            );
		rotateToggle.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
			     toggleRotate_Action(e);
			   }
			});
		rotateToggle.setToolTipText("Enable/Disable Rotation");
		rotateToggle.setBorder(null); // Remove borders
		
		// Labels button
		labelsToggle.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/testPieLabels.png"))
	            );
		labelsToggle.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent e) {
				   toggleLabels_Action(e);
			   }
		});
		labelsToggle.setToolTipText("Enable/Disable Sticky Labels");
		labelsToggle.setBorder(null); // Remove borders
		
		
		optionsPanel.add(rotateToggle);
		optionsPanel.add(Box.createVerticalStrut(1));
		optionsPanel.add(labelsToggle);
		rightPanel.add(new JSeparator(), BorderLayout.NORTH);
		rightPanel.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
		rightPanel.add(optionsPanel, BorderLayout.EAST);
		add(rightPanel, BorderLayout.EAST);
		add(pie, BorderLayout.CENTER);
		
		setVisible(true);
	}

	/**
	 * Enable or disable options buttons on populated panel.
	 * Enabled by default.
	 * 
	 * @param enb true to enable, false to diable
	 */
	public void enableOptions(boolean enb){
		rightPanel.setVisible(enb);
	}
	
	// Handles rotation button functionality
	private void toggleRotate_Action(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			pie.toggleRotation(true);
		} 
		else if(e.getStateChange() == ItemEvent.DESELECTED){
			pie.toggleRotation(false);
		}
	}
	
	// Handles label button functionality
	private void toggleLabels_Action(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			pie.setStaticLabels(true);
		} 
		else if(e.getStateChange() == ItemEvent.DESELECTED){
			pie.setStaticLabels(false);
		}
	}
}
