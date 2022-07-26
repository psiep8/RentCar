<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>RentCar-Parco Noleggio Auto</title>
</head>
<body>
<style>
    #div1 {
        width: 33.33%;
        float: left;
    }

    #div2 {
        width: 133.33%;
        margin: 0 auto;

    }

    #div3 {
        float: right;
    }
</style>

<div id="div1">Homepage</div>
<div id="div2">Parco auto</div>
<div id="div3">Profilo utente</div>

<h2 align="center"><b>Autenticazione</b>
</h2>
<br/>
<div align="center">
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"></br></br>
        Password: <input type="text" name="password">
        </br></br>

        <input type="submit", value="Accedi">

    </form>
</div>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>