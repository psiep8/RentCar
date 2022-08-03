package com.rentalcar.rentcar.dao;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PrenotazioneDAO {

    public void savePrenotazione(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(prenotazione);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePrenotazione(int id) {
        Transaction transaction = null;
        Prenotazione prenotazione;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            prenotazione = session.get(Prenotazione.class, id);
            if (prenotazione != null) {
                session.delete(prenotazione);
            }
            session.delete(prenotazione);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Prenotazione> getPrenotazioni() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Prenotazione", Prenotazione.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Prenotazione getPrenotazione(int id) {
        Transaction transaction = null;
        Prenotazione prenotazione = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            prenotazione = session.get(Prenotazione.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazione;
    }
}
