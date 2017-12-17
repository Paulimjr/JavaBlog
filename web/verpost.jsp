<%-- 
    Document   : index
    Created on : 14/12/2017, 21:20:48
    Author     : paulo
--%>

<%@page import="br.com.blog.model.Usuario"%>
<%@page import="br.com.blog.model.Comentario"%>
<%@page import="java.nio.charset.Charset"%>
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
    response.setCharacterEncoding("ISO-8859-1");
    response.setDateHeader("Expires", 0);
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
    <style>
        #circle {
            width: 100px !important;
            height: 100px !important;
            background: #4B69BA !important;
            -moz-border-radius: 50px !important;
            -webkit-border-radius: 50px !important;
            border-radius: 50px !important;
            text-align: center;
            color: #fff;
            padding-top: 1px !important;
            padding-left: 5px !important;
        }
    </style>
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
                <a class="navbar-brand" href="/JavaBlog/<%=Utils.urlEncryptor(request)%>">
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
        <%
            String codPost = (String) request.getParameter("post_id");
            String cod = "";
            int pos = codPost.indexOf("?");//pegando valores antes de interrogação.
            cod = codPost.substring(0, pos);

            new PostDAO().incrementaVisualizacoesPost(1, String.valueOf(cod)); // entrou na pagina dará como visualizado...

            Post post = new PostDAO().getPostById(String.valueOf(cod));
        %>
        <div class="container-fluid" id="container_posts"
             <div class="col-sm-6" style="margin-left: 20px !important;">
                <br>
                <br>
                <div id="circle">
                    <h3 style="font-size: 60px; font-weight: 800; text-align: center"><%=post.getUsuario_id().getNome().substring(0, 1).toUpperCase()%></h3>
                </div>
                <div class="row-fluid" style="font-family: verdana;">
                    <h3 style="font-weight: 800;"><%=post.getTitulo()%></h3>
                    <%
                        String subitulo = post.getSubtitulo();
                    %>
                    <h4><%=subitulo%></h4>
                    <p>
                        Publicado por <%= post.getUsuario_id().getNome()%> em: <%=post.getData_criacao() + " - " + post.getHora_criacao()%>
                    </p>
                    <br>
                    <div class="col-sm-6" style="margin-left: 15px; text-justify: auto !important padding: 10px;">
                        <%=post.getTexto()%>
                    </div>
                    <br>

                    <div class="col-sm-6">
                        <br>
                        <br>
                        <form action="adicionarcomentario.jsp" method="POST">
                            <input type="hidden" name="id_post" id="id_post" value="<%=post.getId()%>"/>
                            <div class="form-group col-lg-10">
                                <input type="text" class="form-control" name="comentario" id="comentario" required placeholder="Adicione um comentário..."/>
                            </div>
                            <div class="form-group col-lg-10">
                                <input type="submit" class="btn btn-primary" value="Comentar" name="bt_comentar" id="bt_comentar"/>
                            </div>
                        </form>
                        <br>
                        <br>
                    </div>

                    <div class="col-sm-7">
                        <hr>
                        <h4>Comentários</h4>
                        <div class="row-fluid"style="margin-left: 15px; margin-top: 20px">
                            <% List<Comentario> comentarios = post.getComentarios();
                                if (comentarios != null && !comentarios.isEmpty()) {
                                    for (int i = 0; i < comentarios.size(); i++) {%>
                            <p>
                                <b><h5 style="font-weight:900 !important;"><%=comentarios.get(i).getUsuario_id().getNome() + " " + comentarios.get(i).getUsuario_id().getSobrenome() + " - comentou " + comentarios.get(i).getDataComentario() + " - " + comentarios.get(i).getHoraComentario()%></h5></b>
                                    <%=comentarios.get(i).getComentario()%>
                            </p>
                            <hr>
                            <% } %>
                            <% } else { %>
                            Não há nenhum comentário...
                            <% }%>
                        </div>
                    </div>
                    <br>
                    <br>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
    </body>
</html>
