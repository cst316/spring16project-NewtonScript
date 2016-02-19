package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
*
* @author jebjohnson
*/
public class DefectAddDialog extends javax.swing.JDialog {

   /**
    * Creates new form NewJDialog
    */
   public DefectAddDialog(java.awt.Frame parent, boolean modal) {
       super(parent, modal);
       initComponents();
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
       jComboBox1 = new javax.swing.JComboBox();
       jComboBox7 = new javax.swing.JComboBox();
       jComboBox8 = new javax.swing.JComboBox();
       jComboBox3 = new javax.swing.JComboBox();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTextPane1 = new javax.swing.JTextPane();
       jLabel2 = new javax.swing.JLabel();
       jSpinner3 = new javax.swing.JSpinner();
       jButton2 = new javax.swing.JButton();

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

       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Type", "Documentation", "Syntax", "Build", "Package", "Assignment", "Interface", "Checking", "Data", "Function", "System", "Environment " }));
       jComboBox1.setToolTipText("Select Defect Type");

       jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Discovery", "Requirements", "Design", "Implementation", "Test" }));

       jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Defect Injection", "Requirements", "Design", "Implementation", "Test", " " }));

       jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Severity", "LOW", "MEDIUM", "HIGH" }));

       jTextPane1.setContentType("Description"); // NOI18N
       jScrollPane1.setViewportView(jTextPane1);

       jLabel2.setText("Description");

       jSpinner3.setModel(new javax.swing.SpinnerDateModel());

       jButton2.setBackground(new java.awt.Color(204, 255, 255));
       jButton2.setText("Add Defect");

       javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
       jPanel3Layout.setHorizontalGroup(
       	jPanel3Layout.createParallelGroup(Alignment.LEADING)
       		.addGroup(jPanel3Layout.createSequentialGroup()
       			.addContainerGap()
       			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
       				.addComponent(jComboBox7, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       				.addComponent(jComboBox8, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       				.addComponent(jSpinner3, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
       			.addGap(17)
       			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(jButton2)
       				.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
       					.addGroup(jPanel3Layout.createSequentialGroup()
       						.addGap(18)
       						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
       					.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
       						.addPreferredGap(ComponentPlacement.RELATED)
       						.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))))
       			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
       						.addComponent(jComboBox7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       						.addComponent(jLabel2)
       						.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       					.addGap(18)
       					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
       						.addComponent(jComboBox8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       					.addGap(18)
       					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
       						.addComponent(jSpinner3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
       						.addComponent(jButton2)))
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
           java.util.logging.Logger.getLogger(DefectAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(DefectAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(DefectAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(DefectAddDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the dialog */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               DefectAddDialog dialog = new DefectAddDialog(new javax.swing.JFrame(), true);
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
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox jComboBox3;
   private javax.swing.JComboBox jComboBox7;
   private javax.swing.JComboBox jComboBox8;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSpinner jSpinner3;
   private javax.swing.JTextPane jTextPane1;
   // End of variables declaration                   
}

