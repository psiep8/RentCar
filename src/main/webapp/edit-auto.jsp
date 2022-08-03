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
    <div id="left"><b><a href="<c:url value="UtenteServlet"/>"> Homepage</a></b></div>
    <div id="center"><b><a href="<c:url value="list-auto.jsp"/>">Parco Auto</a></b></div>
    <div id="right"><b>Profilo Utente</b></div>
    <br/><br/>
</head>

<body>

<div align="center">

    <form action="AutoServlet" method="GET">

        <table border="1" cellpadding="5">
            <caption>
                <h2>

                    Modifica auto

                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="id" size="10"
                           value="<c:out value='${autoex.id}' />"
                           readonly/>
                </td>
            </tr>
            <tr>
                <th>Marca:</th>
                <td>
                    <input type="text" name="marca" size="45"
                           value="<c:out value='${autoex.marca}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Cilindrata:</th>
                <td>
                    <input type="text" name="cilindrata" size="45"
                           value="<c:out value='${autoex.cilindrata}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Modello:</th>
                <td>
                    <input type="text" name="modello" size="45"
                           value="<c:out value='${autoex.modello}' />"
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