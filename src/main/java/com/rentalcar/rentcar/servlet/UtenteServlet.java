package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Utente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UtenteServlet", value = "/UtenteServlet")
public class UtenteServlet extends HttpServlet {

    private UtenteDAO utenteDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Utente> utenti = utenteDAO.getUtenti();
        request.setAttribute("utenti", utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            listUser(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
