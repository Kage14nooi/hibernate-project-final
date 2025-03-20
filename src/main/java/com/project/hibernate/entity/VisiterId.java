/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.hibernate.entity;

/**
 *
 * @author Tsila
 */
import java.io.Serializable;
import java.util.Objects;

public class VisiterId implements Serializable {
    private int medecin;
    private int patient;

    public VisiterId() {}

    public VisiterId(int medecin, int patient) {
        this.medecin = medecin;
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisiterId visiterId = (VisiterId) o;
        return medecin == visiterId.medecin && patient == visiterId.patient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medecin, patient);
    }
}
