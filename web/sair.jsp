<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<%
    HttpSession httpSession = request.getSession();

    httpSession.removeAttribute("usuariologado");
    httpSession.invalidate();
    response.sendRedirect("index.jsp");
%>