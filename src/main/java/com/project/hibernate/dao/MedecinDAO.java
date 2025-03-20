package com.project.hibernate.dao;

import com.project.hibernate.entity.Medecin;
import com.project.hibernate.util.ComboBoxList;
import com.project.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedecinDAO {

    // Obtient la SessionFactory à partir de HibernateUtil
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private List<ComboBoxList> list = new ArrayList<>();

    public void setList(List<ComboBoxList> list) {
        this.list = list;
    }

    public List<ComboBoxList> getList() {
        return list;
    }

    public void ajouterMedecin(Medecin medecin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(medecin); 
            transaction.commit();
            System.out.println("Ajout : " + medecin);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  // Si une erreur se produit, annule la transaction
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void modifierMedecin(Medecin medecin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(medecin);  
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); 
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void supprimerMedecin(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Medecin medecin = session.get(Medecin.class, id); 
            if (medecin != null) {
                session.delete(medecin);  
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();  // Annule la transaction en cas d'erreur
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Medecin> getAllMedecins() {
        Session session = sessionFactory.openSession();
        List<Medecin> medecins = null;
        try {
            medecins = session.createQuery("FROM Medecin", Medecin.class).list();  
            System.out.println("Liste des médecins : " + medecins);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medecins;
    }

    public void comboBoxMedecin() {
        Session session = sessionFactory.openSession();
        this.setList(new ArrayList<ComboBoxList>());
        try {
            List<Medecin> medecinList = session.createQuery("FROM Medecin ORDER BY nom ASC", Medecin.class).list(); 
            for (Medecin m : medecinList) {
                this.getList().add(new ComboBoxList(m.getCodemed(), m.getNom(), m.getPrenom(), m.getGrade()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Medecin> chercherMedecins(String searchTerm) {
        Session session = sessionFactory.openSession();
        List<Medecin> medecins = null;
        try {
            medecins = session.createQuery("FROM Medecin m WHERE CAST(m.codemed AS string) LIKE :search OR m.nom LIKE :search", Medecin.class)
                    .setParameter("search", "%" + searchTerm + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Médecins trouvés : " + medecins);
        return medecins;
    }

    public Medecin getMedecinByCodemed(int codemed) {
        Session session = sessionFactory.openSession();
        Medecin medecin = null;
        try {
            medecin = session.get(Medecin.class, codemed);  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return medecin;
    }
}
