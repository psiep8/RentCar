package com.rentalcar.rentcar.dao;

import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AutoDAO {
    public void saveAuto(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(auto);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAuto(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            session.saveOrUpdate(auto);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteAuto(long id) {
        Transaction transaction = null;
        Auto auto;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            auto = session.get(Auto.class, id);

            session.delete(auto);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
