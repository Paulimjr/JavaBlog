<%-- 
    Document   : acessonegado
    Created on : 17/12/2017, 18:05:01
    Author     : paulo
--%>

<%@page import="br.com.blog.utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso Negado</title>
    </head>
    <body>
    <center><h1>Acesso negado, você precisa estar logado para adicionar um comentário</h1></center>
    <center> 
        <h3><a style="text-decoration: none; color: #000" href="/JavaBlog<%= Utils.urlEncryptor(request) %>">Voltar a página inicial</a></h3>
    </center>
</body>
</html>
