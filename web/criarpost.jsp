<%@page import="br.com.blog.model.Usuario"%>
<%@page import="br.com.blog.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
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
            <%
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuariologado");
                if (usuario != null) {%>  
            <form class="navbar-form navbar-right" action="sair.jsp<%=Utils.urlEncryptor(request)%>" method="POST">
                <button type="submit" class="btn btn-danger">Sair</button>
            </form>
            <form class="navbar-form navbar-right" action="/JavaBlog<%=Utils.urlEncryptor(request)%>" method="POST">
                <b style="font-family: verdana !important;">
                    Usuário: <%=usuario.getNome() + " " + usuario.getSobrenome()%></b>
                &nbsp;
                &nbsp;
                <button type="submit" class="btn btn-default">Voltar</button>

            </form>
            <% } else {%>
            <form class="navbar-form navbar-right" action="login.jsp<%=Utils.urlEncryptor(request)%>" method="POST">
                <button type="submit" class="btn btn-default">Entrar</button>
            </form>
            <% }%>
        </div><!-- /.navbar-collapse -->
    </nav>
    <div class="container-fluid" id="container_posts">
        <div class="col-sm-4"></div>
        <div class="col-sm-4 text-center text-capitalize">
            <br>
            <h3>Crie sua postagem</h3>
            <br>
            <form action="Post/novo" method="POST">
                <div class="form-group">
                    <label for="titulo">Título</label>
                    <input type="text" name="titulo" class="form-control" id="titulo" placeholder="Títutlo..." required/>  
                </div>
                <div class="form-group">
                    <label for="titulo">Subtítulo</label>
                    <input type="text" name="subtitulo" class="form-control" id="subtitulo" placeholder="Subtítulo..." required/>  
                </div>
                <div class="form-group">
                    <label for="conteudo">Conteúdo</label>
                    <textarea required style="height: 150px;" name="conteudo" id="conteudo" class="form-control"></textarea>
                </div>
                <div class="form-group">
                    <br>
                    <button type="submit" id="bt-entrar" class="btn btn-primary">Enviar post</button>
                </div>
            </form>
            <br>
            <div class="text-center">
                <%
                    String message = (String) request.getAttribute("message");
                    if (message != null && !message.equals("")) {
                        out.print("<h4>" + message + "</h4>");
                    }
                %>
            </div>
        </div>
        <div class="col-sm-4">

        </div>

    </div>
</body>
</html>
