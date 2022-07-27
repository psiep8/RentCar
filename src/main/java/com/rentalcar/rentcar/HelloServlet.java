package com.rentalcar.rentcar;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Worldd!";


        UtenteDAO utenteDAO = new UtenteDAO();
        for (Utente temp : utenteDAO.getUtenti()) {
            System.out.println(temp.getNome());
        }

        //utenteDAO.getUtenteById(1);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        UtenteDAO utenteDAO = new UtenteDAO();
        // utenteDAO.saveUtente(new Utente("Giuseppe", "Romagnoli", "gr@gmail.com", "3271797913", LocalDate.of(1990, 7, 20), true));
        //utenteDAO.saveUtente(new Utente("Danilo", "Petta", "dp@gmail.com", "3271812006", LocalDate.of(1998, 02, 17), true));

        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
        // prenotazioneDAO.savePrenotazione(new Prenotazione(LocalDate.of(2022, 05, 20), LocalDate.of(2022, 05, 30), true));
        // prenotazioneDAO.savePrenotazione(new Prenotazione(LocalDate.of(2022, 04, 29), LocalDate.of(2022, 05, 22), false));

        AutoDAO autoDAO = new AutoDAO();
        //autoDAO.saveAuto(new Auto("Renault", 90, "Captur"));
        //  autoDAO.saveAuto(new Auto("Citroen", 110, "C3"));


    }


    public void destroy() {
    }
}