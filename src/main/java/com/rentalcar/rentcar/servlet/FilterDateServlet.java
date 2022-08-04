package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.FilterDateDAO;
import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.entity.Prenotazione;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FilterDateServlet", value = "/FilterDateServlet")
public class FilterDateServlet extends HttpServlet {
    private FilterDateDAO filterDateDAO = new FilterDateDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inizio = request.getParameter("inizio");
        String fine = request.getParameter("fine");
        LocalDate dateInizio = LocalDate.parse(inizio);
        LocalDate dateFine = LocalDate.parse(fine);
        List<Prenotazione> list = filterDateDAO.getDataRange(dateInizio, dateFine);
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("filtered-date.jsp");
        dispatcher.forward(request, response);
    }
}
