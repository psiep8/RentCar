package com.rentalcar.rentcar.servlet;

import com.rentalcar.rentcar.dao.AutoDAO;
import com.rentalcar.rentcar.dao.PrenotazioneDAO;
import com.rentalcar.rentcar.entity.Auto;
import com.rentalcar.rentcar.entity.Prenotazione;
import com.rentalcar.rentcar.entity.Utente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FilterDateServlet", value = "/FilterDateServlet")
public class FilterDateServlet extends HttpServlet {
    private PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
    private AutoDAO autoDAO = new AutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
