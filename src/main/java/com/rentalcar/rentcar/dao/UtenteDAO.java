package com.rentalcar.rentcar.dao;


import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDAO {
    public void saveUtente(Utente utente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(utente);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
/*
    public List<Utente> getUtenti() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from utente", Utente.class).list();
        }
    }*/
}