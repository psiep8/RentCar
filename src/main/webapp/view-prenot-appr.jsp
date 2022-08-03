<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 26/07/2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="header.css">
<html>
<head>
    <title>Prenotazioni</title>
    <h1 align="center"><b>Prenotazioni</b></h1>
    </br></br>
    <div id="left"><b><a href="<c:url value="UtenteServlet"/>"> Homepage</a></b></div>
    <div id="center"><b><a href="<c:url value="list-auto-utenti.jsp"/>">Parco Auto</a></b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>

</head>
<body>
<div align="center">
    <form action="UtenteServlet" method="get">
        <h1 align="center"><b>Lista prenotazioni:</b></h1>
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Data Inizio</th>
                <th>Data Inizio</th>
                <th>Customer</th>
                <th>Veicolo</th>
                <th>Approvata</th>

            </tr>

            <tr>
                <c:forEach var="pren" items="${list}">
                <th><c:out value="${pren.id}"/></th>
                <th><c:out value="${pren.dataInizio}"/></th>
                <th><c:out value="${pren.dataFine}"/></th>
                <th><c:out value="${pren.utente.nome}"/>
                    <c:out value="${pren.utente.cognome}"/></th>
                <th><c:out value="${pren.auto.marca}"/>
                    <c:out value="${pren.auto.marca}"/></th>
                <th>
                    <c:out value="${pren.approvata}"/>
                </th>


            </tr>
            </c:forEach>
    </form>
    </table>


</div>
</body>
</html>
