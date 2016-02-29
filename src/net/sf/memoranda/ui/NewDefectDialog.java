/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.memoranda.ui;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author jebjohnson
 */
public class NewDefectDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    public NewDefectDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    DefectFunctionality func = new DefectFunctionality();

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
        newDefectType = new javax.swing.JComboBox();
        newDefectDiscovery = new javax.swing.JComboBox();
        newDefectInjection = new javax.swing.JComboBox();
        newDefectSeverity = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        newDefectDescription = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        newDefectDate = new javax.swing.JSpinner();
        addNewDefect = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 255), null));

        jLabel1.setFont(new java.awt.Font("Hiragino Sans GB", 1, 36)); // NOI18N
        jLabel1.setText("Defect Log");

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

        newDefectType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Type", "Documentation", "Syntax", "Build", "Package", "Assignment", "Interface", "Checking", "Data", "Function", "System", "Environment " }));
        newDefectType.setToolTipText("Select Defect Type");

        newDefectDiscovery.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Discovery", "Requirements", "Design", "Implementation", "Test" }));

        newDefectInjection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Injection", "Requirements", "Design", "Implementation", "Test", " " }));

        newDefectSeverity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Severity", "LOW", "MEDIUM", "HIGH" }));

        newDefectDescription.setContentType("Description"); // NOI18N
        jScrollPane1.setViewportView(newDefectDescription);

        jLabel2.setText("Description");

        newDefectDate.setModel(new javax.swing.SpinnerDateModel());

        addNewDefect.setBackground(new java.awt.Color(204, 255, 255));
        addNewDefect.setText("Add Defect");
        addNewDefect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("workiong at top");
                addNewDefectActionPerformed(evt);
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

    private void addNewDefectActionPerformed(java.awt.event.ActionEvent evt) {    
    	
    	System.out.println("workiong again");
    	func.addRow(newDefectDiscovery, newDefectInjection, newDefectDate, newDefectSeverity, newDefectType, newDefectDescription, DefectTable.openDefectTable);
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
            java.util.logging.Logger.getLogger(NewDefectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewDefectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewDefectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewDefectDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewDefectDialog dialog = new NewDefectDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton addNewDefect;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner newDefectDate;
    private javax.swing.JTextPane newDefectDescription;
    private javax.swing.JComboBox newDefectDiscovery;
    private javax.swing.JComboBox newDefectInjection;
    private javax.swing.JComboBox newDefectSeverity;
    private javax.swing.JComboBox newDefectType;
    // End of variables declaration                   
}
