<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 26/07/2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Homepage CUSTOMER</title>
    <h1 align="center"><b>Homepage CUSTOMER</b></h1>
    </br></br>

</head>
<body>
<div align="center">
    <form action="PrenotazioneServlet" method="get">

    <h1 align="center">Lista prenotazioni:
    </h1>
    <div align="center">
        <input type="submit" value="/new" name="action">
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Data Inizio</th>
                <th>Data Fine</th>
                <th>Operazioni</th>
            </tr>

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
                        </c:url>"> Cancella</a>
                </th>
            </tr>
            </c:forEach>
        </table>
    </div>

    </form>
</div>
</body>
</html>
