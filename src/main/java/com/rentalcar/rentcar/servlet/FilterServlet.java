package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.FilterDAO;
import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Utente;
import com.rentalcar.rentcar.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FilterServlet", value = "/FilterServlet")
public class FilterServlet extends HttpServlet {
    private FilterDAO filterDAO = new FilterDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String parameter = request.getParameter("parametri");
        String text = request.getParameter("text");
        request.setAttribute("column", filterDAO.getColumn(parameter, text));
        RequestDispatcher dispatcher = request.getRequestDispatcher("UtenteServlet");
        dispatcher.forward(request, response);

    }

}
