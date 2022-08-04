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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="header.css">
<html>
<head>
    <title>Homepage ADMIN</title>
    <h1 align="center"><b>Homepage ADMIN</b></h1>
    </br></br>
    <div id="left"><b> Homepage</b></div>
    <div id="center"><b><a href="<c:url value="AutoServlet"/>">Parco Auto</a></b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>
</head>
<body>
<div align="center">
    <form action="UtenteServlet" method="GET">
        <input type="submit" value="/new" name="action">
        <h1 align="center">Lista utenti:
        </h1>
    </form>
    <div align="center">
        <table border="1" cellpadding="5">
            <form action="FilterServlet" method="POST">
                <tr>
                    Campo per il filtraggio:
                    <select name="parametri">
                        <option value="Nome">Nome
                        <option value="Cognome">Cognome
                        <option value="Email">Email
                    </select>
                    Testo da cercare:<input type="text" name="text">
                    <input type="submit" name="Cerca">
                    <br/><br/>

                </tr>
                </br></br>
            </form>


            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Data Di Nascita</th>
                <th>Operazioni</th>
            </tr>
            <form action="UtenteServlet" method="POST">
                <tr>
                    <c:forEach var="user" items="${utenti}">
                    <th><c:out value="${user.id}"/></th>
                    <th><c:out value="${user.nome}"/></th>
                    <th><c:out value="${user.cognome}"/></th>
                    <th><c:out value="${user.email}"/></th>
                    <th><c:out value="${user.telefono}"/></th>
                    <th><c:out value="${user.dataNascita}"/></th>
                    <th>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="action" value="/edit"/>
                            <c:param name="id" value="${user.id}"/>
                        </c:url>">Modifica</a>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="action" value="/delete"/>
                            <c:param name="id" value="${user.id}"/>
                        </c:url>">Cancella</a>
                        <a href="<c:url value="UtenteServlet">
                            <c:param name="action" value="/view"/>
                            <c:param name="id" value="${user.id}"/>
                        </c:url>">Visualizza prenotazioni</a>
                    </th>
                </tr>
                </c:forEach>
            </form>
        </table>
    </div>

</div>
</body>
</html>
