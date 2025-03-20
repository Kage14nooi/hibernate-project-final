/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.hibernate.util;

/**
 *
 * @author Tsila
 */
public class ComboBoxList {
    private int codemed;
    private String nom;
    private String prenom;
    private String grade;

     public ComboBoxList(int codemed,String nom, String prenom, String grade) {
        this.codemed = codemed;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }
     public String toString(){
         return this.nom;
     }
}
