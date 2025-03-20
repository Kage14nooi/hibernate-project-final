package com.project.hibernate.dao;

import com.project.hibernate.entity.Patient;
import com.project.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDAO {

    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void ajouterPatient(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(patient);  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void modifierPatient(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(patient);  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

   public void supprimerPatient(int id) {
    Session session = sessionFactory.openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        
        // Supprimer d'abord les visites associées au patient
        String hql = "DELETE FROM Visiter v WHERE v.patient.codepat = :id";
        session.createQuery(hql)
               .setParameter("id", id)
               .executeUpdate();
        
        // Maintenant, on peut supprimer le patient
        Patient patient = session.get(Patient.class, id);  
        if (patient != null) {
            session.delete(patient);  
        }

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();  
        e.printStackTrace();
    } finally {
        session.close();
    }
}

    public Patient chercherPatientParId(int id) {
        Session session = sessionFactory.openSession();
        Patient patient = null;
        try {
            patient = session.get(Patient.class, id);  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patient;
    }

    public List<Patient> chercherPatientParNom(String nom) {
        Session session = sessionFactory.openSession();
        List<Patient> patients = null;
        try {
            patients = session.createQuery("FROM Patient p WHERE p.nom LIKE :nom", Patient.class)
                    .setParameter("nom", "%" + nom + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patients;
    }

    public List<Patient> getAllPatients() {
        Session session = sessionFactory.openSession();
        List<Patient> patients = null;
        try {
            patients = session.createQuery("FROM Patient", Patient.class).list();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patients;
    }

    public List<Patient> chercherPatients(String searchTerm) {
        Session session = sessionFactory.openSession();
        List<Patient> patients = null;
        try {
            patients = session.createQuery(
                "FROM Patient p WHERE CAST(p.codepat AS string) LIKE :search OR p.nom LIKE :search", Patient.class)
                .setParameter("search", "%" + searchTerm + "%")
                .list();
        } catch (Exception e) {
            patients = List.of();  // Retourne une liste vide en cas d'erreur
            System.err.println("Erreur de recherche : " + e.getMessage());
        } finally {
            session.close();
        }
        return patients;
    }

    public Patient getPatientByCodepat(int codepat) {
        Session session = sessionFactory.openSession();
        Patient patient = null;
        try {
            patient = session.createQuery("FROM Patient p WHERE p.codepat = :codepat", Patient.class)
                    .setParameter("codepat", codepat)
                    .getSingleResult();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du patient avec codepat=" + codepat + " : " + e.getMessage());
        } finally {
            session.close();
        }
        return patient;
    }
}
