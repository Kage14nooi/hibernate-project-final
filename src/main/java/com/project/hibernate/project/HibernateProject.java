/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.project.hibernate.project;

import com.project.hibernate.dao.MedecinDAO;
import com.project.hibernate.entity.Medecin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.project.hibernate.dao.PatientDAO;
import com.project.hibernate.entity.Patient;
import com.project.hibernate.gui.MainFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Tsila
 */
public class HibernateProject extends JFrame {
   /* private JTextField txtId, txtNom, txtPrenom, txtRecherche, txtSexe, txtAdresse;
    private JButton btnAjouter, btnModifier, btnSupprimer, btnRechercher;
    private JTable table;
    private DefaultTableModel model;
    private PatientDAO patientDAO;

    public HibernateProject() {
        patientDAO = new PatientDAO();
        setTitle("Gestion des Patients");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Formulaire
        JPanel panelForm = new JPanel(new GridLayout(5, 2)); // Grid ajusté pour 5 champs
        panelForm.add(new JLabel("ID :"));
        txtId = new JTextField();
        panelForm.add(txtId);
        
        panelForm.add(new JLabel("Nom :"));
        txtNom = new JTextField();
        panelForm.add(txtNom);
        
        panelForm.add(new JLabel("Prénom :"));
        txtPrenom = new JTextField();
        panelForm.add(txtPrenom);
        
        panelForm.add(new JLabel("Sexe :")); // Nouveau champ sexe
        txtSexe = new JTextField();
        panelForm.add(txtSexe);
        
        panelForm.add(new JLabel("Adresse :")); // Nouveau champ adresse
        txtAdresse = new JTextField();
        panelForm.add(txtAdresse);
        
        // Boutons
        JPanel panelButtons = new JPanel();
        btnAjouter = new JButton("Ajouter");
        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");
        panelButtons.add(btnAjouter);
        panelButtons.add(btnModifier);
        panelButtons.add(btnSupprimer);
        
        // Tableau
        model = new DefaultTableModel(new String[]{"ID", "Nom", "Prénom", "Sexe", "Adresse"}, 0); // Ajout des nouvelles colonnes
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Recherche
        JPanel panelRecherche = new JPanel();
        txtRecherche = new JTextField(20);
        btnRechercher = new JButton("Rechercher");
        panelRecherche.add(new JLabel("Rechercher :"));
        panelRecherche.add(txtRecherche);
        panelRecherche.add(btnRechercher);
        
        // Ajout des composants
        add(panelForm, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(panelRecherche, BorderLayout.PAGE_END);

        // Événements
        btnAjouter.addActionListener(e -> ajouterPatient());
        btnModifier.addActionListener(e -> modifierPatient());
        btnSupprimer.addActionListener(e -> supprimerPatient());
        btnRechercher.addActionListener(e -> rechercherPatient());
    }

    private void ajouterPatient() {
        Patient p = new Patient(txtNom.getText(), txtPrenom.getText(), txtSexe.getText(), txtAdresse.getText());
        patientDAO.ajouterPatient(p);
        chargerPatients();
    }

    private void modifierPatient() {
        int codepat = Integer.parseInt(txtId.getText());
        Patient p = new Patient(codepat, txtNom.getText(), txtPrenom.getText(), txtSexe.getText(), txtAdresse.getText());
        patientDAO.modifierPatient(p);
        chargerPatients();
    }

    private void supprimerPatient() {
        int codepat = Integer.parseInt(txtId.getText());
        patientDAO.supprimerPatient(codepat);
        chargerPatients();
    }

    private void rechercherPatient() {
        String nom = txtRecherche.getText();
        List<Patient> patients = patientDAO.chercherPatientParNom(nom);
        model.setRowCount(0);
        for (Patient p : patients) {
            model.addRow(new Object[]{p.getCodepat(), p.getNom(), p.getPrenom(), p.getSexe(), p.getAdresse()});
        }
    }

    private void chargerPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        model.setRowCount(0);
        for (Patient p : patients) {
            model.addRow(new Object[]{p.getCodepat(), p.getNom(), p.getPrenom(), p.getSexe(), p.getAdresse()});
        }
    }*/

   public static void main(String[] args) {
    try {
       MainFrame main = new MainFrame();
    main.setVisible(true);    } catch (Exception e) {
        e.printStackTrace(); // Affiche l'erreur si l'interface ne se lance pas
    }
   }
}

