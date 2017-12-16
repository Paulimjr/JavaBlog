<%-- 
    Document   : index
    Created on : 14/12/2017, 21:20:48
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
        <title>JavaBlog - Java não é coisa de sobrinho.</title>
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
                <a class="navbar-brand" href="">
                    <img src="img/logo_java.png" width="78px;" id="img_logo" alt="Java não é coisa de sobrinho."/>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <form class="navbar-form navbar-right" action="login.jsp<%=Utils.urlEncryptor(request) %>" method="POST">
                    <button type="submit" class="btn btn-default">Entrar</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </nav>

        <div class="container-fluid" id="container_posts">
           
        </div>
    </body>
</html>
