package net.sf.memoranda.ui;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerDateModel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Defect;

/**
 *
 * @author jebjohnson
 */
public class DefectEditDialog extends javax.swing.JDialog {

	
	private static final long serialVersionUID = 1L;
	// Variables declaration - do not modify                     
    private javax.swing.JButton addNewDefect;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private JSpinner newDefectDate;
    private javax.swing.JTextPane newDefectDescription;
    private EditCustomComboBox<Defect.Discovery> newDefectDiscovery;
    private EditCustomComboBox<Defect.Injection> newDefectInjection;
    private EditCustomComboBox<Defect.Severity> newDefectSeverity;
    private EditCustomComboBox<Defect.Type> newDefectType;
    // End of variables declaration 
	
	// Do not remove carrots without editing the custom combo box class
	public static final String TYPETITLE = "<Type>";
	public static final String DISTITLE = "<Discovery>";
	public static final String INJTITLE = "<Injection>";
	public static final String SEVTITLE = "<Severity>";
	
    /**
     * Creates new form NewJDialog
     */
    public DefectEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }



    public JSpinner getNewDefectDate() {
		return newDefectDate;
	}



	public void setNewDefectDate(JSpinner newDefectDate) {
		this.newDefectDate = newDefectDate;
	}



	public javax.swing.JTextPane getNewDefectDescription() {
		return newDefectDescription;
	}



	public void setNewDefectDescription(javax.swing.JTextPane newDefectDescription) {
		this.newDefectDescription = newDefectDescription;
	}



	public EditCustomComboBox<Defect.Discovery> getNewDefectDiscovery() {
		return newDefectDiscovery;
	}



	public void setNewDefectDiscovery(EditCustomComboBox<Defect.Discovery> newDefectDiscovery) {
		this.newDefectDiscovery = newDefectDiscovery;
	}



	public EditCustomComboBox<Defect.Injection> getNewDefectInjection() {
		return newDefectInjection;
	}



	public void setNewDefectInjection(EditCustomComboBox<Defect.Injection> newDefectInjection) {
		this.newDefectInjection = newDefectInjection;
	}



	public EditCustomComboBox<Defect.Severity> getNewDefectSeverity() {
		return newDefectSeverity;
	}



	public void setNewDefectSeverity(EditCustomComboBox<Defect.Severity> newDefectSeverity) {
		this.newDefectSeverity = newDefectSeverity;
	}



	public EditCustomComboBox<Defect.Type> getNewDefectType() {
		return newDefectType;
	}



	public void setNewDefectType(EditCustomComboBox<Defect.Type> newDefectType) {
		this.newDefectType = newDefectType;
	}



	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        newDefectType = new EditCustomComboBox<Defect.Type>(Defect.Type.values());
        newDefectDiscovery = new EditCustomComboBox<Defect.Discovery>(Defect.Discovery.values());
        newDefectInjection = new EditCustomComboBox<Defect.Injection>(Defect.Injection.values());
        newDefectSeverity = new EditCustomComboBox<Defect.Severity>(Defect.Severity.values());
        jScrollPane1 = new javax.swing.JScrollPane();
        newDefectDescription = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        newDefectDate = new JSpinner(new SpinnerDateModel(new Date(),null,null,Calendar.DAY_OF_WEEK));
        addNewDefect = new javax.swing.JButton();
        SimpleDateFormat sdf = new SimpleDateFormat();

        newDefectType.setRenderer(new ComboBoxRenderer(TYPETITLE));
        newDefectDiscovery.setRenderer(new ComboBoxRenderer(DISTITLE));
        newDefectInjection.setRenderer(new ComboBoxRenderer(INJTITLE));
        newDefectSeverity.setRenderer(new ComboBoxRenderer(SEVTITLE));
        
        newDefectType.setToolTipText(TYPETITLE);
        newDefectDiscovery.setToolTipText(DISTITLE);
        newDefectInjection.setToolTipText(INJTITLE);
        newDefectSeverity.setToolTipText(SEVTITLE);
        
        newDefectType.setSelectedIndex(-1);
        newDefectDiscovery.setSelectedIndex(-1);
        newDefectInjection.setSelectedIndex(-1);
        newDefectSeverity.setSelectedIndex(-1);
        
        newDefectType.setEditable(false);
        newDefectDiscovery.setEditable(false);
        newDefectInjection.setEditable(false);
        newDefectSeverity.setEditable(false);
        
        String id;
        
        if(DefectTable.getjTabbedPane().getSelectedIndex() == 0){
            JTable table = DefectTable.getOpenTable();
	    	int row = table.getSelectedRow();
	        id = (String)table.getValueAt(row,0);
        }
        else{
	        JTable table2 = DefectTable.getClosedDefectTable();
	        int rowSet2 = table2.getSelectedRow();
            id = (String)table2.getValueAt(rowSet2, 0);
   
        }
        Defect compD = CurrentProject.getDefectList().getDefect(id);
        
        //Setting values
        
        newDefectType.setSelectedItem(compD.getType());
        newDefectDiscovery.setSelectedItem(compD.getDiscovery());
        newDefectInjection.setSelectedItem(compD.getInj());
        newDefectSeverity.setSelectedItem(compD.getSeverity());
        newDefectDescription.setText(compD.getDesc());
        newDefectDate.setValue(compD.getDate().getDate());
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 255), null));

        jLabel1.setFont(new java.awt.Font("Hiragino Sans GB", 1, 36)); // NOI18N
        jLabel1.setText("Edit Defect");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 255), null));


        jScrollPane1.setViewportView(newDefectDescription);

        jLabel2.setText("Description");
        
        
        
        
        // DATE STUFF HERE
		sdf = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.SHORT);
        newDefectDate.setEditor(new JSpinner.DateEditor(newDefectDate, sdf.toPattern()));
        newDefectDate.setModel(new SpinnerDateModel((Date)newDefectDate.getModel().getValue(),null,null,Calendar.DAY_OF_WEEK));
        
        

        addNewDefect.setBackground(new java.awt.Color(204, 255, 255));
        addNewDefect.setText("Edit Defect");
        addNewDefect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("workiong at top");
                addNewDefectActionPerformed(evt, compD);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(newDefectDiscovery, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(newDefectInjection, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(newDefectDate, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        					.addComponent(newDefectSeverity, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(addNewDefect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(newDefectType, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(37)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(newDefectDiscovery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2)
        						.addComponent(newDefectSeverity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(newDefectInjection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(newDefectType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(newDefectDate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        						.addComponent(addNewDefect)))
        				.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void addNewDefectActionPerformed(java.awt.event.ActionEvent evt, Defect def) {    
    	
    	
    	DefectTable.getFunctionality().editRow(newDefectDiscovery, newDefectInjection, newDefectDate, newDefectSeverity, newDefectType, newDefectDescription, def);
    	this.dispose(); // Close the window when defect is added
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefectEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefectEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefectEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefectEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DefectEditDialog dialog = new DefectEditDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    /**
     * Allow titles to be displayed for the boxes
     * 
     * @author Douglas Carroll
     */
    class ComboBoxRenderer extends BasicComboBoxRenderer {

		private static final long serialVersionUID = 1L;
		private String boxTitle;
    	
    	public ComboBoxRenderer(String title){
    		boxTitle = title;
    	}
    	
    	// Override cell renderer
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			
			// Keep selected coloring
			if (isSelected) {
	            setBackground(list.getSelectionBackground());
	            setForeground(list.getSelectionForeground());
	        } else {
	            setBackground(list.getBackground());
	            setForeground(list.getForeground());
	        }
			
			// Set title
			if(index == -1 && value == null){
				setText(boxTitle);
			}
			else{
				setText(value.toString());
			}
			return this;
		}
    	
    }
    
    /**
     * This will ensure that the first value is returned if title is selected
     * 
     * @author Douglas Carroll
     */
    class EditCustomComboBox<T> extends JComboBox<Object>{
    	
		private static final long serialVersionUID = 1L;

		public EditCustomComboBox(T objs[]){
    		super(objs);
    	}
    	
    	public Object getItem(){
    		Object item = getSelectedItem();
    		
    		if(item == null){
    			item = getItemAt(0);
    		}
    		
    		return item;
    	}
    }
}