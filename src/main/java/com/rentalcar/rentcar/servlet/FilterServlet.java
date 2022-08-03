package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.FilterDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


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
        RequestDispatcher dispatcher = request.getRequestDispatcher("filtered-admin.jsp");
        dispatcher.forward(request, response);
    }
}
