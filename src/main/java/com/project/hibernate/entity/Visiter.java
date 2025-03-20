package com.project.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "visiter")
public class Visiter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Ajout de l'ID unique pour éviter les erreurs

    @ManyToOne
    @JoinColumn(name = "codemed", nullable = false)
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "codepat", nullable = false)
    private Patient patient;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateVisite", nullable = false)
    private Date dateVisite;

    public Visiter() {}

    public Visiter(Medecin medecin, Patient patient, Date dateVisite) {
        this.medecin = medecin;
        this.patient = patient;
        this.dateVisite = dateVisite;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) { this.medecin = medecin; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Date getDateVisite() { return dateVisite; }
    public void setDateVisite(Date dateVisite) { this.dateVisite = dateVisite; }
}
