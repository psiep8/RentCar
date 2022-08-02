package com.rentalcar.rentcar;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @PersistenceContext(unitName = "OCDPU")
    //private EntityManager em;

    public void init() {
        //UtenteDAO utenteDAO = new UtenteDAO();
        //System.out.println(utenteDAO.getID());

        /*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Auto> criteriaQuery = criteriaBuilder.createQuery(Auto.class);
            Root<Auto> root = criteriaQuery.from(Auto.class);
            criteriaQuery.select(root.get("id"));
            Query query = session.createQuery(criteriaQuery);
            List<Integer> auto = query.getResultList();

            for (Integer tempAuto : auto) {
                System.out.println(tempAuto);
            }
            // transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "message" + "</h1>");
        out.println("</body></html>");

        UtenteDAO utenteDAO = new UtenteDAO();
        //utenteDAO.saveUtente(new Utente("Giuseppe", "Romagnoli", "gr@gmail.com", "3271797913", LocalDate.of(1990, 7, 20), true));
        //utenteDAO.saveUtente(new Utente("Danilo", "Petta", "dp@gmail.com", "3271812006", LocalDate.of(1998, 2, 17), true));
        // utenteDAO.saveUtente(new Utente("Gabriele", "Diodato", "gp@gmail.com", "23139032", LocalDate.of(1999, 8, 20), true));

        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
        //prenotazioneDAO.savePrenotazione(new Prenotazione(LocalDate.of(2022, 05, 20), LocalDate.of(2022, 05, 30), true));
        //prenotazioneDAO.savePrenotazione(new Prenotazione(LocalDate.of(2022, 04, 29), LocalDate.of(2022, 05, 22), false));
        //prenotazioneDAO.savePrenotazione(new Prenotazione(LocalDate.of(2022, 07, 29), LocalDate.of(2022, 07, 31), true));

        AutoDAO autoDAO = new AutoDAO();
        //autoDAO.saveAuto(new Auto("Renault", 90, "Captur"));
        //autoDAO.saveAuto(new Auto("Citroen", 110, "C3"));


    }


    public void destroy() {
    }
}