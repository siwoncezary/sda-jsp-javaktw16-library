<%--
  Created by IntelliJ IDEA.
  User: cs
  Date: 13.10.2019
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="d-flex align-content-center flex-wrap">
    <div class="container w-50">
        <h1>Zaloguj się</h1>
        <form action='?' method='post'>
            <div class="form-group mb-3">
                <input class="form-control mb-3" placeholder="login" name='login'/>
                <input class="form-control mb-3" type='password' placeholder="password" name='password'/>
                <button class="btn btn-primary mb-3" type='submit'>Zaloguj</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>