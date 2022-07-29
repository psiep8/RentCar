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
    <title>Inserimento campi</title>
    <center>
        <h1>Inserimento Campi</h1>
    </center>
    </br></br>
    <div id="left"><b><a href="<c:url value="UtenteServlet"/>"> Homepage</a></b></div>
    <div id="center"><b><a href="<c:url value="list-auto.jsp"/>">Parco Auto</a></b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>
</head>

<body>

<div align="center">

    <form action="UtenteServlet" method="GET">

        <table border="1" cellpadding="5">
            <caption>
                <h2>


                    Inserimento nuovo utente

                </h2>
            </caption>
            <tr>
                <th>Nome:</th>
                <td>
                    <input type="text" name="nome" size="45"
                           value="<c:out value='${user.nome}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Cognome:</th>
                <td>
                    <input type="text" name="cognome" size="45"
                           value="<c:out value='${user.cognome}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Telefono:</th>
                <td>
                    <input type="text" name="telefono" size="15"
                           value="<c:out value='${user.telefono}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Data di nascita:</th>
                <td>
                    <input type="text" name="date" size="15"
                           value="<c:out value='${user.dataNascita}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer:</th>
                <td>
                    <input type="text" name="customer" size="10"
                           value="<c:out value='${user.customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="/insert" name="action" onclick="alert('Inserimento utente effettuato')"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

