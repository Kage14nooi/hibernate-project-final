/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.project.hibernate.gui;

import com.project.hibernate.dao.MedecinDAO;
import com.project.hibernate.entity.Medecin;
import javax.swing.JOptionPane;

/**
 *
 * @author Tsila
 */
public class JDialogFormMedecin extends javax.swing.JDialog {

    /**
     * Creates new form JDialogFormMedecin
     */
    private Medecin medecin = new Medecin();
    static String title = "";
    MedecinDAO medecinDAO = new MedecinDAO();
    
    //New
    public JDialogFormMedecin(java.awt.Frame parent, boolean modal,String title) {
        super(parent, modal);
        this.title = title;
        initComponents();
        setLocationRelativeTo(parent);
    }
    //Update
    public JDialogFormMedecin(java.awt.Frame parent, boolean modal,String title,Medecin medecin  ) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.medecin = medecin;
        this.title = title;
        BtnAjoutFormMedecin.setText("Modifier");
        txtFieldNameMedecin.setText(medecin.getNom());
        txtFieldFirstNameMedecin.setText(medecin.getPrenom());
        txtFieldGradeMedecin.setText(medecin.getGrade());
        
    }
    //Delete
    public JDialogFormMedecin(java.awt.Frame parent, boolean modal,Medecin medecin ,String title ) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.medecin = medecin;
        this.title = title;
        BtnAjoutFormMedecin.setText("Supprimer");
        txtFieldNameMedecin.setText(medecin.getNom());
        txtFieldFirstNameMedecin.setText(medecin.getPrenom());
        txtFieldGradeMedecin.setText(medecin.getGrade());
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFieldNameMedecin = new javax.swing.JTextField();
        txtFieldFirstNameMedecin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFieldGradeMedecin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtnAjoutFormMedecin = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setEnabled(false);

        jLabel1.setText("Nom");

        txtFieldNameMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNameMedecinActionPerformed(evt);
            }
        });

        txtFieldFirstNameMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldFirstNameMedecinActionPerformed(evt);
            }
        });

        jLabel2.setText("Prénom");

        txtFieldGradeMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldGradeMedecinActionPerformed(evt);
            }
        });

        jLabel3.setText("Grade");

        BtnAjoutFormMedecin.setText("Ajouter");
        BtnAjoutFormMedecin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjoutFormMedecinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtFieldNameMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtFieldFirstNameMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtFieldGradeMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(BtnAjoutFormMedecin))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtFieldNameMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(txtFieldFirstNameMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(txtFieldGradeMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(BtnAjoutFormMedecin))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldNameMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNameMedecinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNameMedecinActionPerformed

    private void txtFieldFirstNameMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldFirstNameMedecinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldFirstNameMedecinActionPerformed

    private void txtFieldGradeMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldGradeMedecinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldGradeMedecinActionPerformed

    private void BtnAjoutFormMedecinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjoutFormMedecinActionPerformed

        try {
              String nom = txtFieldNameMedecin.getText();
              String prenom = txtFieldFirstNameMedecin.getText();
              String grade = txtFieldGradeMedecin.getText();
            
              
            if (nom == null || prenom == null || grade == null) {
                JOptionPane.showMessageDialog(this, "Veuillez bien remplire tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            medecin.setNom(nom);
            medecin.setPrenom(prenom);
            medecin.setGrade(grade);
             

            switch (title) {
                case "New":
                    medecinDAO.ajouterMedecin(this.medecin);
                    JOptionPane.showMessageDialog(this, "Médecin ajoutée avec succès !");
                    break;
                case "Update":
                    medecinDAO.modifierMedecin(this.medecin);
                    JOptionPane.showMessageDialog(this, "Médecin modifiée avec succès !");
                    break;
                case "Delete":
                    int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette Médecin ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                          medecinDAO.supprimerMedecin(this.medecin.getCodemed());
                        JOptionPane.showMessageDialog(this, "Médecin supprimée avec succès !");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Action inconnue.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnAjoutFormMedecinActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogFormMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogFormMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogFormMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogFormMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogFormMedecin dialog = new JDialogFormMedecin(new javax.swing.JFrame(), true,null,"");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnAjoutFormMedecin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtFieldFirstNameMedecin;
    private javax.swing.JTextField txtFieldGradeMedecin;
    private javax.swing.JTextField txtFieldNameMedecin;
    // End of variables declaration//GEN-END:variables
}
