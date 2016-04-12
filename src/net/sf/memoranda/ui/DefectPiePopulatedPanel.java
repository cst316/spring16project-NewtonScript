package net.sf.memoranda.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Defect;
import net.sf.memoranda.ui.DefectPieChart.Category;

/**
 * Populated panel for the defect pie chart
 * 
 * 
 * @author Douglas Carroll
 *
 */
public class DefectPiePopulatedPanel extends PieChartPopulatedPanel {
	
	private static final long serialVersionUID = 1667L;
	private JToggleButton typeButton;
	private JToggleButton disButton;
	private JToggleButton injButton;
	private JToggleButton sevButton;
	private JToggleButton ocButton;
	private DefectPieChart pie;
	private Category cat;
	
	public DefectPiePopulatedPanel(DefectPieChart pie) {
		super(pie);
		this.pie = pie;
		cat = Category.TYPE;
		init();
	}
	
	/**
	 * Constructor to set the type of chart displayed by default
	 * 
	 * @param c
	 */
	public DefectPiePopulatedPanel(DefectPieChart pie, Category c){
		super(pie);
		this.pie = pie;
		cat = c;
		init();
	}
	
	private void init(){
		typeButton = new JToggleButton();
		disButton = new JToggleButton();
		injButton = new JToggleButton();
		sevButton = new JToggleButton();
		ocButton = new JToggleButton();
		JPanel options = getOptionsPanel();
		
		// Setup buttons
		typeButton.setSelected(true);
		typeButton.setToolTipText(Category.TYPE.toString());
		typeButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieType.png"))
	            );
		typeButton.setBorder(null);
		typeButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(typeButton);
				   cat = Category.TYPE;
				   pie.update();
			   }
		});
		
		disButton.setToolTipText(Category.DIS.toString());
		disButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieDis.png"))
	            );
		disButton.setBorder(null);
		disButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(disButton);
				   cat = Category.DIS;
				   pie.update();
			   }
		});
		
		injButton.setToolTipText(Category.INJ.toString());
		injButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieInj.png"))
	            );
		injButton.setBorder(null);
		injButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(injButton);
				   cat = Category.INJ;
				   pie.update();
			   }
		});
		
		sevButton.setToolTipText(Category.SEV.toString());
		sevButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieSev.png"))
	            );
		sevButton.setBorder(null);
		sevButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(sevButton);
				   cat = Category.SEV;
				   pie.update();
			   }
		});
		
		ocButton.setToolTipText(Category.OC.toString());
		ocButton.setIcon(
	            new ImageIcon(
	            		net.sf.memoranda.ui.AppFrame.class.getResource(
	            				"resources/icons/defectPieOC.png"))
	            );
		ocButton.setBorder(null);
		ocButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   clearButtons(ocButton);
				   cat = Category.OC;
				   pie.update();
			   }
		});
		
		// Put the defect unique options on the panel
		// Uncomment below to put button on the bottom of the panel
		//options.add(Box.createVerticalGlue());
		options.add(typeButton);
		options.add(disButton);
		options.add(injButton);
		options.add(sevButton);
		options.add(ocButton);
	}
	
	// Clear all button states except the one that is selected
	private void clearButtons(JToggleButton btn){
		typeButton.setSelected(false);
		disButton.setSelected(false);
		injButton.setSelected(false);
		sevButton.setSelected(false);
		ocButton.setSelected(false);
		
		btn.setSelected(true);
	}
}
