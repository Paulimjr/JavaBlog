/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.controller;

import br.com.blog.dao.PostDAO;
import br.com.blog.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
public class Post extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getServletPath();
        if (url.equals("/Post/novo")) {
            String titulo = request.getParameter("titulo");
            String subtitulo = request.getParameter("subtitulo");
            String conteudo = request.getParameter("conteudo");
            Usuario usu = (Usuario) request.getSession().getAttribute("usuariologado");

            //criando objeto post para salvar
            br.com.blog.model.Post post = new br.com.blog.model.Post();

            post.setTitulo(titulo);
            post.setSubtitulo(subtitulo);
            post.setTexto(conteudo);
            post.setUsuario_id(usu);
            post.setVisualizacoes(0);

            int salvo = new PostDAO().inserir(post);

            if (salvo == 1) {
                request.setAttribute("message", "Post salvo com sucesso!");
                response.sendRedirect("/JavaBlog/criarpost.jsp");
            } else {
                request.setAttribute("message", "Houve algum erro ao salvar o post, tente novamente!");
                response.sendRedirect("/JavaBlog/criarpost.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
