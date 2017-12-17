<%-- 
    Document   : novaconta
    Created on : 16/12/2017, 15:39:26
    Author     : paulo
--%>

<%@page import="br.com.blog.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="css/jquery.min.js"></script>
        <script src="css/bootstrap.min.js"></script>
        <title>Criar uma nova conta</title>
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/JavaBlog<%=Utils.urlEncryptor(request)%>">
                    <img src="img/logo_java.png" width="78px;" id="img_logo" alt="Java não é coisa de sobrinho."/>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-right" action="login.jsp<%=Utils.urlEncryptor(request)%>" method="POST">
                    <button type="submit" class="btn btn-default">Voltar</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </nav>
    <center><h1>Vamos lá, falta pouco...</h1></center>
    <div class="container-fluid">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <!-- Formulario para criar uma nova conta -->
            <form action="" method="POST" id="form_cadastrar">
                <br>
                <br>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" placeholder="Nome" class="form-control" required=""/>
                </div>
                <div class="form-group">
                    <label for="sobrenome">Sobrenome</label>
                    <input type="text" name="sobrenome" id="sobrenome" placeholder="Sobrenome" required="" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" placeholder="Email" class="form-control" required=""/>
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" id="senha" placeholder="Senha" class="form-control" required=""/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Cadastrar" class="btn btn-success"/>
                </div>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>
</body>
<script type="text/javascript">

    $("#form_cadastrar").on('submit', function () {
        $.ajax({
            type: "POST",
            url: "CriarConta/cadastrar",
            data: $("#form_cadastrar").serialize(),
            success: function (result) {
               // sucesso...
            }
        });
        alert("Operação efetuada com sucesso!");
    });


</script>
</html>
