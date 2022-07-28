package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "PrenotazioneServlet", value = "/PrenotazioneServlet")
public class PrenotazioneServlet extends HttpServlet {

    private PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();

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
                case "/insert":
                    insertPrenotazione(request, response);
                    break;
                case "/delete":
                    deletePrenotazione(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updatePrenotazione(request, response);
                    break;
                default:
                    listPrenotazioni(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
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
        prenotazioneDAO.deletePrenotazione(id);
        response.sendRedirect("PrenotazioneServlet");
    }

    private void insertPrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String dataInizio = request.getParameter("dataInizio");
        String dataFine = request.getParameter("dataFine");
        boolean approvata = Boolean.parseBoolean(request.getParameter("approvata"));
        Prenotazione prenotazione = new Prenotazione(LocalDate.parse(dataInizio), LocalDate.parse(dataFine), approvata);
        prenotazioneDAO.savePrenotazione(prenotazione);
        response.sendRedirect("PrenotazioneServlet");
    }

    private void updatePrenotazione(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dataInizio = request.getParameter("dataInizio");
        String dataFine = request.getParameter("dataFine");
        boolean approvata = Boolean.parseBoolean(request.getParameter("approvata"));
        Prenotazione prenotazione = new Prenotazione(id, LocalDate.parse(dataInizio), LocalDate.parse(dataFine), approvata);
        prenotazioneDAO.savePrenotazione(prenotazione);
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
