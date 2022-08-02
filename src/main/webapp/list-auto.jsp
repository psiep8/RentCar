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
<link rel="stylesheet" type="text/css" href="header.css">
<html>
<head>
    <title>Parco Auto</title>
    <h1 align="center"><b>Parco Auto</b></h1>
    </br></br>
    <div id="left"><b><a href="<c:url value="UtenteServlet"/>"> Homepage</a></b></div>
    <div id="center"><b>Parco Auto</b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>
</head>
<body>
<div align="center">
    <form action="AutoServlet" method="GET">
        <input type="submit" value="/new" name="action">
        <h1 align="center">Lista Auto:
        </h1>
        <div align="center">
            <table border="1" cellpadding="5">
                <tr>
                    Campo per il filtraggio: <select>
                    <option>ID</option>
                    <option>Nome</option>
                    <option>Cognome</option>
                    <option>Email</option>
                    <option>Telefono</option>
                    <option>Data di Nascita</option>

                </select>
                    <input type="search" id="search-input" placeholder="Filtra qui...">
                    <button id="search">Cerca</button>

                </tr>
                </br></br>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Cilindrata</th>
                    <th>Modello</th>
                    <th>Operazioni</th>
                </tr>

                <tr>
                    <c:forEach var="temp" items="${auto}">
                    <th><c:out value="${temp.id}"/></th>
                    <th><c:out value="${temp.marca}"/></th>
                    <th><c:out value="${temp.cilindrata}"/></th>
                    <th><c:out value="${temp.modello}"/></th>
                    <th>
                        <a href="<c:url value="AutoServlet">
                            <c:param name="action" value="/edit"/>
                            <c:param name="id" value="${temp.id}"/>
                        </c:url>">Modifica</a>
                        <a href="<c:url value="AutoServlet">
                            <c:param name="action" value="/delete"/>
                            <c:param name="id" value="${temp.id}"/>
                        </c:url>">Cancella</a>
                        <a href="<c:url value="AutoServlet">
                            <c:param name="action" value="/view"/>
                            <c:param name="id" value="${temp.id}"/>
                        </c:url>">Visualizza prenotazioni</a>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>

    </form>
</div>
</body>
</html>
