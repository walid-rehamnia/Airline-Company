/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entity.avion;
import company.Tools;

/**
 *
 * @author R-Walid Pro_Book
 */
public class fconsultation extends javax.swing.JFrame {

    /**
     * Creates new form fconsultation
     */
    public fconsultation() {
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

        jMybutton1 = new controls.JMybutton();
        jMybutton2 = new controls.JMybutton();
        jMybutton3 = new controls.JMybutton();
        jMybutton4 = new controls.JMybutton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtchercher = new controls.JTextBox(20);
        btnchercher = new controls.JMybutton();
        jMybutton5 = new controls.JMybutton();
        jMybutton7 = new controls.JMybutton();
        jMybutton8 = new controls.JMybutton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttype = new controls.JTextBox(15);
        txtn = new controls.JTextBox(15);
        jMybutton9 = new controls.JMybutton();
        jMybutton10 = new controls.JMybutton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(742, 490));
        setMinimumSize(new java.awt.Dimension(742, 490));
        setPreferredSize(new java.awt.Dimension(742, 484));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jMybutton1.setText("Tout avions du parc");
        jMybutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton1ActionPerformed(evt);
            }
        });

        jMybutton2.setText("Avions necessite revision");
        jMybutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton2ActionPerformed(evt);
            }
        });

        jMybutton3.setText("Avions qui sont en vols");
        jMybutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton3ActionPerformed(evt);
            }
        });

        jMybutton4.setText("Avions prét");
        jMybutton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton4ActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        table.setForeground(new java.awt.Color(51, 153, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Type", "Date de mise en service", "Situation", "NBHDDREV"
            }
        ));
        table.setGridColor(new java.awt.Color(255, 0, 0));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Gestion des avions du parc d'aéronefs ");

        txtchercher.setFont(new java.awt.Font("Shonar Bangla", 1, 24)); // NOI18N
        txtchercher.setForeground(new java.awt.Color(102, 255, 255));
        txtchercher.setText("Saisir le N° d'avion");
        txtchercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchercherActionPerformed(evt);
            }
        });

        btnchercher.setText("Chercher avion");
        btnchercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchercherActionPerformed(evt);
            }
        });

        jMybutton5.setText("Interdire avion a voler");
        jMybutton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton5ActionPerformed(evt);
            }
        });

        jMybutton7.setText("Ajouter nouvelle avion");
        jMybutton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton7ActionPerformed(evt);
            }
        });

        jMybutton8.setText("Retrait avion");
        jMybutton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton8ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Numéro");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Type ");

        txttype.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txttype.setForeground(new java.awt.Color(51, 255, 51));

        txtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtn.setForeground(new java.awt.Color(51, 255, 51));

        jMybutton9.setBackground(new java.awt.Color(255, 255, 0));
        jMybutton9.setForeground(new java.awt.Color(255, 153, 51));
        jMybutton9.setText("Retour");
        jMybutton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton9ActionPerformed(evt);
            }
        });

        jMybutton10.setText("Rapport texte");
        jMybutton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMybutton10ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/back7.jpg"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(742, 484));
        jLabel4.setMinimumSize(new java.awt.Dimension(742, 484));
        jLabel4.setPreferredSize(new java.awt.Dimension(742, 484));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(txtchercher, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnchercher, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)
                                .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMybutton8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMybutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMybutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMybutton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMybutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jMybutton9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jMybutton7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jMybutton10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(txtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(jMybutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtchercher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnchercher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel3))
                                    .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addComponent(jMybutton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jMybutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jMybutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jMybutton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jMybutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102)
                        .addComponent(jMybutton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jMybutton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jMybutton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(txtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jMybutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMybutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton1ActionPerformed

        db.go.fillToJTable("select * from avion", table, true);


    }//GEN-LAST:event_jMybutton1ActionPerformed

    private void jMybutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton2ActionPerformed
        // TODO add your handling code here:
        db.go.fillToJTable("select * from avion where situation = 'necessiteRevision' ", table, true);
    }//GEN-LAST:event_jMybutton2ActionPerformed

    private void jMybutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton3ActionPerformed
        // TODO add your handling code here:
        db.go.fillToJTable("select * from avion where situation = 'enVol'", table, true);
    }//GEN-LAST:event_jMybutton3ActionPerformed

    private void jMybutton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton4ActionPerformed
        // TODO add your handling code here:
        db.go.fillToJTable("select * from avion where situation = 'pret' ", table, true);
    }//GEN-LAST:event_jMybutton4ActionPerformed

    private void txtchercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchercherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchercherActionPerformed

    private void btnchercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchercherActionPerformed
        try {
            db.go.fillToJTable("select * from avion where numav = " + Integer.parseInt(txtchercher.getText()), table, true);

        } catch (Exception ex) {
            Tools.msg("Erreur : " + ex.getMessage());
        }
    }//GEN-LAST:event_btnchercherActionPerformed

    private void jMybutton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton5ActionPerformed
        int key = 0;
        if (txtn.getText().equals("")) {
            Tools.msg("Il faut Saisir le Numéro d'avion[le N° est suffit]");
        } else {
            try {
                key = Integer.parseInt(txtn.getText());
                avion av = new avion(key);
                if (db.go.checkExistenceOf("avion", "numav", key)) {
                    av.update("situation", "interdit");
                } else {
                    Tools.msg("Vous avez taper une avion qui ne figure pas dans le parc !");
                }
            } catch (Exception ex) {
                Tools.msg("Erreur : " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jMybutton5ActionPerformed

    private void jMybutton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton7ActionPerformed
        // TODO add your handling code here:
        String n = txtn.getText();
        String type = txttype.getText();

        try {
            if (type.equals("")) {
                Tools.msg("Il faut remplir les 2 champs");
            } else {
                int z = Integer.parseInt(n);
                if (db.go.checkExistenceOf("avion", "numav", z)) {
                    Tools.msg("le numéro d'avion est déjas utiliser ");
                } else //i will save the avion
                {
                    avion av = new avion(z, type);
                    av.add();
                    Tools.clearText(this);
                    txtn.setText(db.go.getAutoNumber("avion", "numav"));
                }
            }
        } catch (Exception ex) {
            Tools.msg("Erreur : " + ex.getMessage());
        }

        //}

    }//GEN-LAST:event_jMybutton7ActionPerformed

    private void jMybutton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton8ActionPerformed
        // TODO add your handling code here:
        if (txtn.getText().equals("")) {
            Tools.msg("Il faut Saisir le Numéro d'avion[le N° est suffit]");
        } else {
            try {
                int num = Integer.parseInt(txtn.getText());
                avion av = new avion(num);
                if (db.go.checkExistenceOf("avion", "numav", num)) {
                    if (av.IsOnFlight(num) == false) {
                        av.delete();
                    } else {
                        Tools.msg("vous ne pouvez pas supprimer cet avion\n pour le moment car il est déjà en vol ! ");
                    }
                } else {
                    Tools.msg("Vous avez taper une avion qui ne figure pas dans le parc !");
                }
            } catch (Exception ex) {
                Tools.msg("Erreur :" + ex.getMessage());
            }

        }

    }//GEN-LAST:event_jMybutton8ActionPerformed

    private void jMybutton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton9ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Tools.open_form(new fmain());
    }//GEN-LAST:event_jMybutton9ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtn.setText(db.go.getAutoNumber("avion", "numav"));
    }//GEN-LAST:event_formWindowOpened

    private void jMybutton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMybutton10ActionPerformed
        // TODO add your handling code here:
        formConsulterRapport form = new formConsulterRapport();
        Tools.open_form(form);
        this.dispose();
    }//GEN-LAST:event_jMybutton10ActionPerformed

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
            java.util.logging.Logger.getLogger(fconsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fconsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fconsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fconsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fconsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private controls.JMybutton btnchercher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private controls.JMybutton jMybutton1;
    private controls.JMybutton jMybutton10;
    private controls.JMybutton jMybutton2;
    private controls.JMybutton jMybutton3;
    private controls.JMybutton jMybutton4;
    private controls.JMybutton jMybutton5;
    private controls.JMybutton jMybutton7;
    private controls.JMybutton jMybutton8;
    private controls.JMybutton jMybutton9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtchercher;
    private javax.swing.JTextField txtn;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables
}