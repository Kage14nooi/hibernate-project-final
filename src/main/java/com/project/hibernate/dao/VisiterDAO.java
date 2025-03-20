package com.project.hibernate.dao;

import com.project.hibernate.entity.Visiter;
import com.project.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VisiterDAO {

   
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void ajouterRendezVous(Visiter visiter) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(visiter);  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); 
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void modifierRendezVous(Visiter visiter) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(visiter);  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void supprimerRendezVous(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Visiter visiter = session.get(Visiter.class, id);  
            if (visiter != null) {
                session.delete(visiter);  
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Visiter getById(int id) {
        Session session = sessionFactory.openSession();
        Visiter visiter = null;
        try {
            visiter = session.get(Visiter.class, id);  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return visiter;
    }

    public List<Visiter> getAllRendezVous() {
        Session session = sessionFactory.openSession();
        List<Visiter> visites = null;
        try {
            visites = session.createQuery("FROM Visiter", Visiter.class).list();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return visites;
    }

    public List<Visiter> chercherVisites(String searchTerm) {
        Session session = sessionFactory.openSession();
        List<Visiter> visites = null;
        try {
            visites = session.createQuery(
                "FROM Visiter v WHERE CAST(v.id AS string) LIKE :search", Visiter.class)
                .setParameter("search", "%" + searchTerm + "%")
                .list();
        } catch (Exception e) {
            visites = List.of();  // Retourne une liste vide en cas d'erreur
            System.err.println("Erreur de recherche : " + e.getMessage());
        } finally {
            session.close();
        }
        return visites;
    }

    public Visiter getVisiterById(int id) {
        Session session = sessionFactory.openSession();
        Visiter visiter = null;
        try {
            visiter = session.createQuery("FROM Visiter v WHERE v.id = :id", Visiter.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du rendez-vous avec id=" + id + " : " + e.getMessage());
        } finally {
            session.close();
        }
        return visiter;
    }
}
