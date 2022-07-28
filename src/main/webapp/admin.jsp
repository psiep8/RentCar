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
        <input type="submit" value="Inserisci Prenotazione" name="inserisci">
        <h1 align="center">Lista utenti:
        </h1>
        <div align="center">
            <table border="1" cellpadding="5">
                <tr>

                    <input type="search" id="search-input" placeholder="Filtra qui...">
                    <button id="search">Search</button>

                </tr>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Data Di Nascita</th>
                    <th>Operazioni</th>
                </tr>

                <tr>
                    <c:forEach var="user" items="${utenti}">
                    <th><c:out value="${user.nome}"/></th>
                    <th><c:out value="${user.cognome}"/></th>
                    <th><c:out value="${user.email}"/></th>
                    <th><c:out value="${user.telefono}"/></th>
                    <th><c:out value="${user.dataNascita}"/></th>
                    <th>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="update" value="id"/>
                        </c:url>"> Modifica</a>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="view" value="id"/>
                        </c:url>"> Visualizza Prenotazioni</a>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="delete" value="id"/>
                        </c:url>"> Cancella</a>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>

    </form>
</div>
</body>
</html>
