<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 27/07/2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inserimento campi</title>
</head>

<body>
<center>
    <h1>Inserimento Campi</h1>
</center>
<div align="center">

    <form action="PrenotazioneServlet" method="GET">

        <table border="1" cellpadding="5">
            <caption>
                <h2>

                    Inserimento Prenotazione


                </h2>
            </caption>
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
                           value="<c:out value='${prenot.approvata}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Approvata:</th>
                <td>
                    <input type="text" name="customer" size="10"
                           value="<c:out value='${prenot.customer}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="/insert" name="action"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

