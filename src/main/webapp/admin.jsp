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
    <input type="submit" value="/new" name="action">
    <h1 align="center">Lista utenti:
    </h1>
    <div align="center">
        <table border="1" cellpadding="5">
            <form action="FilterServlet" method="GET">
                <tr>
                    Campo per il filtraggio:
                    <input type="checkbox" name="column" value="Nome">Nome
                    <input type="checkbox" name="column" value="Cognome">Cognome
                    <input type="checkbox" name="column" value="Email">Email
                    <input type="submit" value="Filtra">
                    <br/><br/>
                </tr>
                </br></br>
            </form>
            <form method="POST" action="FilterServlet">

                <input type="search" name="search-input" placeholder="Filtra qui...">
                <input type="submit" value="Esegui">
                </br></br>

                <c:forEach var="temp" items="${result}">
                    <c:out value="${temp}"/>
                    <%
                        String token = request.getParameter("token");
                    %>
                    <c:if test="${fn:contains(temp,token)}"> </c:if>
                    <c:url value="UtenteServlet">
                        <c:param name="action" value="/filtered"/>
                    </c:url>
                </c:forEach>

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
        </table>
    </div>


</div>
</body>
</html>
