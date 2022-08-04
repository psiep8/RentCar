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
    <div id="left"><b><a href="<c:url value="PrenotazioneServlet"/>"> Homepage</a></b></div>
    <div id="center"><b><a href="<c:url value="list-auto-utenti.jsp"/>">Parco Auto</a></b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>

</head>
<body>
<div align="center">
    <form action="FilterDateServlet" method="POST">
        <h1 align="center"><b>Lista auto:</b></h1>
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>Marca</th>
                <th>Cilindrata</th>
                <th>Modello</th>
            </tr>
            <tr>
                <c:forEach var="pren" items="${list}">
                <th><c:out value="${pren.auto.marca}"/></th>
                <th><c:out value="${pren.auto.cilindrata}"/></th>
                <th><c:out value="${pren.auto.modello}"/></th>
            </tr>
            </c:forEach>
        </table>


    </form>
</div>
</body>
</html>
