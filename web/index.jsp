<%-- 
    Document   : index
    Created on : 14/12/2017, 21:20:48
    Author     : paulo
--%>

<%@page import="br.com.blog.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.blog.dao.PostDAO"%>
<%@page import="br.com.blog.model.Post"%>
<%@page import="br.com.blog.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setCharacterEncoding("ISO-8859-1");
%>
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
                <a class="navbar-brand" href="<%=Utils.urlEncryptor(request)%>">
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
                <form class="navbar-form navbar-right" action="criarpost.jsp<%=Utils.urlEncryptor(request)%>" method="POST">
                    <b style="font-family: verdana !important;">
                        Usuário: <%=usuario.getNome()+" "+usuario.getSobrenome() %></b>
                    &nbsp;
                    &nbsp;
                    <button type="submit" class="btn btn-info">Crie um Post</button>
             
                </form>
                <% } else {%>
                <form class="navbar-form navbar-right" action="login.jsp<%=Utils.urlEncryptor(request)%>" method="POST">
                    <button type="submit" class="btn btn-default">Entrar</button>
                </form>
                <% }%>
            </div><!-- /.navbar-collapse -->
        </nav>
        <%
            List<Post> posts = new PostDAO().listarTodos();
        %>
        <div class="container-fluid" id="container_posts">
            <h2 style="font-family: verdana; font-weight: 900;">Java não é coisa de sobrinho.</h2>
            <br>         
            <table class="table table-striped" style="font-family: verdana;">
                <thead>
                    <tr>
                        <th style="width: 800px;">Tópicos</th>
                        <th style="width: 250px;">Autores</th>
                        <th>Visualizações</th>
                    </tr>
                </thead>
                <tbody>
                    <%  if (posts != null && !posts.isEmpty()) { %>
                    <% for (int i = 0; i < posts.size(); i++) {%>
                    <tr style="padding-top: 22px !important; padding-bottom: 22px !important;">
                        <td><a style="text-decoration: none !important; color:#000;" href="verpost.jsp?post_id=<%=posts.get(i).getId()%><%=Utils.urlEncryptor(request)%>"> <b> <%= posts.get(i).getTitulo()%></b></a><br>
                            Publicado em: <%= posts.get(i).getData_criacao() + " - " + posts.get(i).getHora_criacao()%></td>
                        <td><%= posts.get(i).getUsuario_id().getNome() + " " + posts.get(i).getUsuario_id().getSobrenome()%></td>
                        <td><%= posts.get(i).getVisualizacoes()%></td>
                    </tr>
                    <% } %>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
