<%@ page import="com.rentalcar.rentcar.util.HibernateUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="header.css">
<!DOCTYPE html>
<html>
<head>
    <title>RentCar-Parco Noleggio Auto</title>
</head>
<body>
<h2 align="center"><b>Autenticazione</b>
</h2>
<br/>
<div align="center">
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"></br></br>
        Password: <input type="text" name="password">
        </br></br>

        <input type="submit" , value="Accedi">

    </form>
</div>


<!--<a href="hello-servlet">Hello Servlet</a>-->
</body>
</html>