package com.rentalcar.rentcar.dao;

import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterDateDAO {
    public List<Auto> getDataRange(LocalDate inizio, LocalDate fine) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
            Root<Prenotazione> root = criteriaQuery.from(Prenotazione.class);
            CriteriaQuery<Prenotazione> prenotazioni = criteriaQuery.select(root);
            Predicate datePredicateBetween = criteriaBuilder.and(criteriaBuilder.greaterThan(
                    root.<LocalDate>get("dataInizio"), inizio), criteriaBuilder.lessThanOrEqualTo(
                    root.<LocalDate>get("dataFine"), fine));
            Predicate datePredicate = criteriaBuilder.or(
                    datePredicateBetween,
                    criteriaBuilder.or(
                            criteriaBuilder.between(root.get("dataInizio"), inizio, fine),
                            criteriaBuilder.between(root.get("dataFine"), inizio, fine)
                    )
            );
            Predicate approvedPredicate = criteriaBuilder.equal(root.get("approvata"), true);
            Query query = session.createQuery(prenotazioni.where(criteriaBuilder.and(datePredicate, approvedPredicate)).distinct(true));
            List<Prenotazione> list = query.getResultList();
            List<Integer> autoList = new ArrayList<>();
            for (Prenotazione p : list) {
                int id = p.getAuto().getId();
                autoList.add(id);
            }
            CriteriaQuery<Auto> criteriaAutoQuery = criteriaBuilder.createQuery(Auto.class);
            Root<Auto> autoRoot = criteriaAutoQuery.from(Auto.class);
            CriteriaQuery<Auto> c = criteriaAutoQuery.select(autoRoot);
            if (autoList.size() == 0) {
                return session.createQuery(c).getResultList();
            } else {
                Predicate notIn = criteriaBuilder.not(autoRoot.get("id").in(autoList));
                return session.createQuery(c.where(notIn)).getResultList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}


