package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Prenotazione;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@WebServlet(name = "PrenotazioneServlet", value = "/PrenotazioneServlet")
public class PrenotazioneServlet extends HttpServlet {

    private PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
    private AutoDAO autoDAO = new AutoDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/delete":
                    deletePrenotazione(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/insert":
                case "/update":
                    upsertPrenotazione(request, response);
                    break;
                case "/listauto":
                    listAuto(request, response);
                    break;

                default:
                    listPrenotazioni(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listAuto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Auto> auto = autoDAO.getAuto();
        request.setAttribute("auto", auto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-auto-utenti.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("insert-prenot.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Prenotazione existingPrenotazione = prenotazioneDAO.getPrenotazione(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-prenot.jsp");
        request.setAttribute("prenot", existingPrenotazione);
        dispatcher.forward(request, response);
    }

    private void deletePrenotazione(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDate dataInizio = prenotazioneDAO.getPrenotazione(id).getDataInizio();
        if (dataInizio.until(LocalDate.now(), ChronoUnit.DAYS) > 2) {
            //dao getbyid , controllo prenotazione non nulla, controllo data prenotazione almeno da due giorni, deletebyid
            prenotazioneDAO.deletePrenotazione(id);
            response.sendRedirect("PrenotazioneServlet");
        } else {
            throw new IOException("Errore, non è possibile cancellare entro due giorni dalla prenotazione");
        }
    }

    private void upsertPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String dataInizio = request.getParameter("dataInizio");
        String dataFine = request.getParameter("dataFine");
        boolean approvata = Boolean.parseBoolean(request.getParameter("approvata"));
        if (id == null) {
            Prenotazione prenotazione = new Prenotazione(LocalDate.parse(dataInizio), LocalDate.parse(dataFine), approvata);
            prenotazioneDAO.savePrenotazione(prenotazione);
        } else {
            Prenotazione prenotazione = new Prenotazione(id, LocalDate.parse(dataInizio), LocalDate.parse(dataFine), approvata);
            prenotazioneDAO.savePrenotazione(prenotazione);
        }
        response.sendRedirect("PrenotazioneServlet");
    }

    private void listPrenotazioni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Prenotazione> prenotazioni = prenotazioneDAO.getPrenotazioni();
        request.setAttribute("prenotazioni", prenotazioni);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
