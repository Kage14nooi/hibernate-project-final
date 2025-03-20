/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.project.hibernate.gui;

import com.project.hibernate.dao.MedecinDAO;
import com.project.hibernate.dao.PatientDAO;
import com.project.hibernate.dao.VisiterDAO;
import com.project.hibernate.entity.Medecin;
import com.project.hibernate.entity.Patient;
import com.project.hibernate.entity.Visiter;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tsila
 */
public class JDialogFormVisite extends javax.swing.JDialog {
    private JComboBox<Medecin> jComboBoxMedecin;
    private JComboBox<Patient> jComboBoxPatient;
    private JSpinner dateSpinner;
    private JButton BtnAjoutVisite;
    private JLabel jLabel1, jLabel2, jLabel3;
    /**
     * Creates new form JDialogFormVisite
     */
    private Visiter visiter = new Visiter();
    static String title = "";
    VisiterDAO visiterDAO = new VisiterDAO();
    PatientDAO patientDAO = new PatientDAO();
    MedecinDAO medecinDAO = new MedecinDAO();
    public JDialogFormVisite(java.awt.Frame parent, boolean modal ,String title) {
        super(parent, modal);
        this.title = title;
        initComponents();
        setSize(300,200);
    setResizable(false);
               
    }
    //Modify
    public JDialogFormVisite(java.awt.Frame parent, boolean modal ,String title,Visiter visiter) {
        super(parent, modal);
        initComponents();
       
        this.visiter = visiter;
        this.title = title;
        jComboBoxMedecin.addItem(visiter.getMedecin());
        jComboBoxPatient.addItem(visiter.getPatient());
        dateSpinner.setValue(visiter.getDateVisite());
        BtnAjoutVisite.setText("Modifier");

        
    }
    //Delete
    public JDialogFormVisite(java.awt.Frame parent, boolean modal ,Visiter visiter,String title) {
        super(parent, modal);
        initComponents();
        
        this.visiter = visiter;
        this.title = title;
        jComboBoxMedecin.addItem(visiter.getMedecin());
        jComboBoxPatient.addItem(visiter.getPatient());
        
        dateSpinner.setValue(visiter.getDateVisite());
        BtnAjoutVisite.setText("Supprimer");

    }

    private void initComponents() {
    // Initialisation des JComboBox vides
    jComboBoxMedecin = new JComboBox<>();
    jComboBoxPatient = new JComboBox<>();

    // Charger les données depuis la BD
    chargerMedecins();
    chargerPatients();
     // Configuration du rendu personnalisé des JComboBox
        jComboBoxMedecin.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Medecin) {
                    value = ((Medecin) value).getCodemed() + " - " + ((Medecin) value).getNom();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        jComboBoxPatient.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Patient) {
                    value = ((Patient) value).getCodepat() + " - " + ((Patient) value).getNom();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

    // Configuration du JSpinner pour la date
    SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
    dateSpinner = new JSpinner(dateModel);
    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
    dateSpinner.setEditor(dateEditor);

    BtnAjoutVisite = new JButton("Ajouter");
    BtnAjoutVisite.addActionListener(this::BtnAjoutVisiteActionPerformed);

    jLabel1 = new JLabel("Médecin");
    jLabel2 = new JLabel("Patient");
    jLabel3 = new JLabel("Date de visite");

   
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLayout(new GridLayout(4, 2, 10, 10));

    add(jLabel1);
    add(jComboBoxMedecin);
    add(jLabel2);
    add(jComboBoxPatient);
    add(jLabel3);
    add(dateSpinner);
    add(new JLabel());
    add(BtnAjoutVisite);

    pack();
    setLocationRelativeTo(null);
}

 /**
     * Charge les médecins depuis la BD et remplit le JComboBox.
     */
    private void chargerMedecins() {
        List<Medecin> medecins = medecinDAO.getAllMedecins();
        for (Medecin med : medecins) {
            jComboBoxMedecin.addItem(med);
        }
    }

    /**
     * Charge les patients depuis la BD et remplit le JComboBox.
     */
    private void chargerPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        for (Patient pat : patients) {
            jComboBoxPatient.addItem(pat);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
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
            java.util.logging.Logger.getLogger(JDialogFormVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogFormVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogFormVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogFormVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogFormVisite dialog = new JDialogFormVisite(new javax.swing.JFrame(), true,null,"");
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
     * Gestion du bouton Ajouter / Modifier / Supprimer.
     */
    private void BtnAjoutVisiteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Medecin selectedMedecin = (Medecin) jComboBoxMedecin.getSelectedItem();
            Patient selectedPatient = (Patient) jComboBoxPatient.getSelectedItem();
            Date selectedDate = (Date) dateSpinner.getValue();

            if (selectedMedecin == null || selectedPatient == null) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un médecin et un patient.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            visiter.setMedecin(selectedMedecin);
            visiter.setPatient(selectedPatient);
            visiter.setDateVisite(selectedDate);

            switch (title) {
                case "New":
                    visiterDAO.ajouterRendezVous(visiter);
                    JOptionPane.showMessageDialog(this, "Visite ajoutée avec succès !");
                    break;
                case "Update":
                    visiterDAO.modifierRendezVous(visiter);
                    JOptionPane.showMessageDialog(this, "Visite modifiée avec succès !");
                    break;
                case "Delete":
                    int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette visite ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        visiterDAO.supprimerRendezVous(visiter.getId());
                        JOptionPane.showMessageDialog(this, "Visite supprimée avec succès !");
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
