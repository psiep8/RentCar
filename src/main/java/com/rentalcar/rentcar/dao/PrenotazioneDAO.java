package com.rentalcar.rentcar.dao;


import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PrenotazioneDAO {
    EntityManager em;

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
            e.printStackTrace();
        }
    }

    public void updatePrenotazione(Prenotazione prenotazione) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.update(prenotazione);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deletePrenotazione(int id) {
        Transaction transaction = null;
        //today = LocalDate.now();
        Prenotazione prenotazione;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            //Query q=session.createQuery("select dataInizio from Prenotazione where datediff(dataInizio,CURRENT_DATE)>2").getSingleResult();
            prenotazione = session.get(Prenotazione.class, id);
            if (prenotazione != null) {
                session.delete(prenotazione);
            }
            session.delete(prenotazione);
            // commit transaction
            transaction.commit();
           /* CriteriaBuilder queryBuilder=em.getCriteriaBuilder();
            CriteriaQuery<Prenotazione> queryDefinition = queryBuilder.createQuery(Prenotazione.class);

            Root<Prenotazione> recordSet=queryDefinition.from(Prenotazione.class);

            queryDefinition.select(recordSet).where(queryBuilder.equal(recordSet.get("dataInizio"),today));
*/

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
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            prenotazione = session.get(Prenotazione.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prenotazione;
    }

    public void between() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
            Root<Prenotazione> root = criteriaQuery.from(Prenotazione.class);
            criteriaQuery.select(root);
            List<Prenotazione> orderList = new ArrayList();


            orderList.add((Prenotazione) criteriaBuilder.desc(root.get("dataInizio")));
            orderList.add((Prenotazione) criteriaBuilder.desc(root.get("dataFine")));
            Query query = session.createQuery(criteriaQuery);

            // transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
