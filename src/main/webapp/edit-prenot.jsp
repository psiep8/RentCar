<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 27/07/2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="header.css">
<html>
<head>
    <title>Modifica campi</title>
    <center>
        <h1>Modifica Campi</h1>
    </center>
    </br></br>
    <div id="left"><b><a href="<c:url value="PrenotazioneServlet"/>"> Homepage</a></b></div>
    <div id="center"><b><a href="<c:url value="list-auto-utenti.jsp"/>">Parco Auto</a></b></div>
    <div id="right"><b><a href="<c:url value="edit-form.jsp"/>">Profilo Utente</a></b></div>
    <br/><br/>
</head>

<body>

<div align="center">

    <form action="PrenotazioneServlet" method="POST">

        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Modifica Prenotazione
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="dataInizio" size="15"
                           value="<c:out value='${prenot.id}' />"
                           readonly/>
                </td>
            </tr>
            <tr>
                <th>Data Inizio:</th>
                <td>
                    <input type="text" name="dataInizio" size="15"
                           value="<c:out value='${prenot.dataInizio}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Data Fine:</th>
                <td>
                    <input type="text" name="dataFine" size="15"
                           value="<c:out value='${prenot.dataFine}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Approvata:</th>
                <td>
                    <input type="text" name="customer" size="10"
                           value="<c:out value='${prenot.approvata}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="/update" name="action"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

