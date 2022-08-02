package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Auto;
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

@WebServlet(name = "AutoServlet", value = "/AutoServlet")
public class AutoServlet extends HttpServlet {

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
                    deleteAuto(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/insert":
                case "/update":
                    upsertAuto(request, response);
                    break;
                case "/view":
                    listPrenotazioni(request, response);
                    break;
                default:
                    listAuto(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPrenotazioni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Auto auto = autoDAO.getAuto(id);
        List<Prenotazione> list = auto.getItems();
        request.setAttribute("list2", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view-prenot-auto.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("insert-auto.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Auto existingAuto = autoDAO.getAuto(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-auto.jsp");
        request.setAttribute("autoex", existingAuto);
        dispatcher.forward(request, response);

    }

    private void deleteAuto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        autoDAO.deleteAuto(id);
        response.sendRedirect("AutoServlet");
    }

    private void upsertAuto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String marca = request.getParameter("marca");
        int cilindrata = Integer.parseInt(request.getParameter("cilindrata"));
        String modello = request.getParameter("modello");
        if (id == null) {
            Auto auto = new Auto(marca, cilindrata, modello);
            autoDAO.updateAuto(auto);
            response.sendRedirect("AutoServlet");
        } else {
            Auto auto = new Auto(id, marca, cilindrata, modello);
            autoDAO.updateAuto(auto);
            response.sendRedirect("AutoServlet");
        }
    }

    private void listAuto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Auto> auto = autoDAO.getAuto();
        request.setAttribute("auto", auto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-auto.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
