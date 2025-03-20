/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.hibernate.entity;

/**
 *
 * @author Tsila
 */
import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codepat;

    private String nom;
    private String prenom;
    private String sexe;
    private String adresse;

    public Patient() {}

    public Patient( int codepat,String nom, String prenom, String sexe, String adresse) {
        this.codepat = codepat;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
    }
     public Patient( String nom, String prenom, String sexe, String adresse) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
    }


    public int getCodepat() { return codepat; }
    public void setCodepat(int codepat) { this.codepat = codepat; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    @Override
    public String toString() {
    return this.getCodepat() + " - " + this.getNom();
}

}