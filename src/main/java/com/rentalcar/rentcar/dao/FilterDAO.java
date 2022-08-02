package com.rentalcar.rentcar.dao;

import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FilterDAO {

    public List<String> getNome() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
            Root<Utente> root = criteriaQuery.from(Utente.class);
            criteriaQuery.select(root.get("nome"));
            Query query = session.createQuery(criteriaQuery);
            List<String> nomi = query.getResultList();
            return nomi;

            // transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getCognome() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
            Root<Utente> root = criteriaQuery.from(Utente.class);
            criteriaQuery.select(root.get("cognome"));
            Query query = session.createQuery(criteriaQuery);
            List<String> cognomi = query.getResultList();
            return cognomi;

            // transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getEmail() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
            Root<Utente> root = criteriaQuery.from(Utente.class);
            criteriaQuery.select(root.get("email"));
            Query query = session.createQuery(criteriaQuery);
            List<String> email = query.getResultList();
            return email;

            // transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
