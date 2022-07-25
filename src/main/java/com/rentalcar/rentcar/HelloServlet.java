package com.rentalcar.rentcar;

import com.rentalcar.rentcar.dao.UtenteDAO;
import com.rentalcar.rentcar.entity.Utente;

import java.io.*;
import java.time.LocalDate;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        UtenteDAO utenteDAO = new UtenteDAO();
        utenteDAO.saveUtente(new Utente("Giuseppe", "Romagnoli", "gr@gmail.com", "3271797913", LocalDate.of(1990,7,20), true));
    }

    public void destroy() {
    }
}