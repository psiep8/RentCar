package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "UtenteServlet", value = "/UtenteServlet")
public class UtenteServlet extends HttpServlet {

    private UtenteDAO utenteDAO = new UtenteDAO();

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
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/insert":
                case "/update":
                    upsertUser(request, response);
                    break;
                case "/view":
                    listPrenotazioni(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    // @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    private void listPrenotazioni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Utente utente = utenteDAO.getUser(id);
        List<Prenotazione> list = utente.getItems();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view-prenot.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("insert-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Utente existingUser = utenteDAO.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        utenteDAO.deleteUtente(id);
        response.sendRedirect("UtenteServlet");
    }

    private void upsertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String date = request.getParameter("date");
        boolean customer = Boolean.parseBoolean(request.getParameter("customer"));
        if (id==null){
            Utente utente = new Utente(nome, cognome, email, telefono, LocalDate.parse(date), customer);
            utenteDAO.updateUtente(utente);
            response.sendRedirect("UtenteServlet");
        }else{
            Utente utente = new Utente(id, nome, cognome, email, telefono, LocalDate.parse(date), customer);
            utenteDAO.updateUtente(utente);
            response.sendRedirect("UtenteServlet");
        }
        Utente utente = new Utente(id, nome, cognome, email, telefono, LocalDate.parse(date), customer);
        utenteDAO.updateUtente(utente);
        response.sendRedirect("UtenteServlet");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utente> utenti = utenteDAO.getUtenti();
        request.setAttribute("utenti", utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
