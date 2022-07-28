<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 27/07/2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Modifica campi</title>
</head>

<body>
<center>
    <h1>Modifica Campi</h1>
</center>
<div align="center">
    <c:if test="${user != null}">
    <form action="update" method="get">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="get">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.nome}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Cognome: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.cognome}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${user.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Telefono: </th>
                    <td>
                        <input type="text" name="country" size="15"
                               value="<c:out value='${user.telefono}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Data di nascita: </th>
                    <td>
                        <input type="text" name="country" size="15"
                               value="<c:out value='${user.dataNascita}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

