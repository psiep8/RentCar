<%@ page import="com.rentalcar.rentcar.dao.UtenteDAO" %>
<%@ page import="com.rentalcar.rentcar.entity.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 26/07/2022
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Homepage ADMIN</title>
    <h1 align="center"><b>Homepage ADMIN</b></h1>
    </br></br>

</head>
<body>
<div align="center">
    <form action="UtenteServlet" method="get">
        <h1 align="center">Lista utenti:
        </h1>

        <input type="submit" value="Visualizza">
    </form>
</div>
</body>
</html>
