package com.rentalcar.rentcar.dao;


import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public void saveUtente(Utente utente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

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

    public void updateUtente(Utente utente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.saveOrUpdate(utente);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteUtente(long id) {
        Transaction transaction = null;
        Utente utente;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            utente = session.get(Utente.class, id);
            if (utente != null) {
                session.delete(utente);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Utente> getUtenti() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Utente where customer is true", Utente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
