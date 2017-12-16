<%-- 
    Document   : login
    Created on : 15/12/2017, 19:44:05
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="css/jquery.min.js"></script>
        <script src="css/bootstrap.min.js"></script>
        <title>JavaBlog - Java não é coisa de sobrinho.</title>
    </head>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
<center><h1>Efetue seu login</h1></center>
<div class="container-fluid">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form method="POST" action="Entrar" id="form-login" class="form-group text-center">
            <br>
            <input type="text" name="usuario" class="form-control" id="usuario" placeholder="Email" required/>
            </br>
            <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha" required/>
            <br>
            <br>
            <button type="submit" id="bt-entrar" class="btn btn-primary">Entrar</button>
        </form>
        <br>
        <center><a href="CriarConta">Crie uma nova conta</a></center>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
