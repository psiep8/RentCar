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
    <title>Homepage CUSTOMER</title>
    <h1 align="center"><b>Homepage CUSTOMER</b></h1>
    </br></br>
    <div id="left"><b>Homepage</b></div>
    <div id="center"><b><a href="<c:url value="PrenotazioneServlet">
                            <c:param name="action" value="/listauto"/>

                        </c:url>"> Parco Auto</a>
    </b></div>
    <div id="right"><b><a href="<c:url value="edit-form.jsp"/>">Profilo Utente</a></b></div>
    <br/><br/>

</head>
<body>
<div align="center">
    <form action="PrenotazioneServlet" method="get">
        <input type="submit" value="/new" name="action">
        </br></br>
    </form>

    <h1 align="center">Lista prenotazioni:
    </h1>
    <div align="center">
        <form action="FilterDateServlet" method="POST">
            <tr>
                Data da cercare:<input type="inizio" name="inizio">
                Data da cercare:<input type="fine" name="fine">
                <input type="submit" name="Cerca">
                <br/><br/>

            </tr>
            </br></br>
        </form>

        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Data Inizio</th>
                <th>Data Fine</th>
                <th>Operazioni</th>
            </tr>
            <form action="UtenteServlet" method="POST">

                <tr>
                    <c:forEach var="pren" items="${prenotazioni}">
                    <th><c:out value="${pren.id}"/></th>
                    <th><c:out value="${pren.dataInizio}"/></th>
                    <th><c:out value="${pren.dataFine}"/></th>
                    <th>
                        <a href="<c:url value="PrenotazioneServlet">
                            <c:param name="action" value="/edit"/>
                            <c:param name="id" value="${pren.id}"/>
                        </c:url>"> Modifica</a>
                        <a href="<c:url value="PrenotazioneServlet">
                            <c:param name="action" value="/delete"/>
                            <c:param name="id" value="${pren.id}"/>
                            <c:param name="dataInizio" value="${pren.dataInizio}"/>
                        </c:url>"> Cancella</a>
                    </th>
                </tr>
                </c:forEach>
            </form>
        </table>
    </div>

</div>
</body>
</html>
