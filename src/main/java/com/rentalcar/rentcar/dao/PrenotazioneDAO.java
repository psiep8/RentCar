package com.rentalcar.rentcar.dao;


import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrenotazioneDAO {
    public void savePrenotazione(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(prenotazione);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePrenotazione(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.saveOrUpdate(prenotazione);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deletePrenotazione(long id) {
        Transaction transaction = null;
        Prenotazione prenotazione;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            prenotazione = session.get(Prenotazione.class, id);

            session.delete(prenotazione);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
