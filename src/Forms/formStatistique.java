/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author R-Walid Pro_Book
 */
public class formStatistique extends javax.swing.JFrame {

    /**
     * Creates new form formStatistique
     */
    public formStatistique() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel321 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stat = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 520));
        setMinimumSize(new java.awt.Dimension(400, 520));
        setPreferredSize(new java.awt.Dimension(400, 520));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel321.setFont(new java.awt.Font("Algerian", 1, 30)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(0, 102, 255));
        jLabel321.setText("Statistiques");
        getContentPane().add(jLabel321);
        jLabel321.setBounds(92, 0, 229, 40);

        stat.setColumns(20);
        stat.setRows(5);
        jScrollPane1.setViewportView(stat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 58, 380, 340);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/back7.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
// TODO add your handling code here:
        stat.setText("\nLes Avion :\n"   + "\nLe nombre de tout les avions : "+db.go.getRowNumber("avion")  + "\n\n\nLes personnels :\n" + "\nLe nombre de tout les personneles : "+db.go.getRowNumber("emp"));
       // stat.setText("\nLe nombre de tout les avions : "+db.go.getRowNumber("avion"));
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(formStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formStatistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formStatistique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea stat;
    // End of variables declaration//GEN-END:variables
}