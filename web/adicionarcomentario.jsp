<%-- 
    Document   : adicionarcomentario
    Created on : 17/12/2017, 18:01:30
    Author     : paulo
--%>

<%@page import="br.com.blog.dao.ComentarioDAO"%>
<%@page import="br.com.blog.utils.Utils"%>
<%@page import="br.com.blog.model.Comentario"%>
<%@page import="br.com.blog.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String comentario = request.getParameter("comentario");
            int postId = Integer.parseInt(request.getParameter("id_post"));
            
            //verificando se tem permissao para comentar
            Usuario user = (Usuario) request.getSession().getAttribute("usuariologado");
            if (null == user) {
                response.sendRedirect("acessonegado.jsp");
            } else {
                
                Comentario c = new Comentario();
                c.setComentario(comentario);
                c.setUsuario_id(user);
                c.setPostId(postId);
                
                new ComentarioDAO().inserir(c);
                
                response.sendRedirect("verpost.jsp?post_id="+postId+Utils.urlEncryptor(request));
            }
        %>


    </body>
</html>
