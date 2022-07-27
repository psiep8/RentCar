<%@ page import="com.rentalcar.rentcar.dao.UtenteDAO" %>
<%@ page import="com.rentalcar.rentcar.entity.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 26/07/2022
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of Users</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Email</th>
                    <th>Data Di Nascita</th>
                </tr>
            </table>

            <table>
                <c:forEach var="user" items="${utenti}">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.nome}"/></td>
                        <td><c:out value="${user.cognome}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.dataNascita}"/></td>
                        <td>
                            <a href="edit?id=<c:out value='${user.id}' />">Modifica</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${user.id}' />">Cancella</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${user.id}' />">Visualizza prenotazioni</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </form>
</div>
</body>
</html>
