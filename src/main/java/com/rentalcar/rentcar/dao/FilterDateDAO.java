package com.rentalcar.rentcar.dao;

import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class FilterDateDAO {
    private Prenotazione prenotazione = new Prenotazione();

    public List<Prenotazione> getDataRange(LocalDate inizio, LocalDate fine) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
            Root<Prenotazione> root = criteriaQuery.from(Prenotazione.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.greaterThan(root.<LocalDate>get("dataInizio"), inizio), criteriaBuilder.lessThanOrEqualTo(root.<LocalDate>get("dataFine"), fine));
            Query query = session.createQuery(criteriaQuery);
            List<Prenotazione> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
