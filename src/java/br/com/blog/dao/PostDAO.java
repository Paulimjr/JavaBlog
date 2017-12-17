/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import br.com.blog.model.Comentario;
import br.com.blog.utils.Utils;
import br.com.blog.model.Post;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class PostDAO extends BaseConexao implements InterfaceDAO<Post> {

    @Override
    public int inserir(Post obj) {
        try {
            CONEXAO.conectar();
            String sql = "INSERT INTO post (titulo, subtitulo, texto, data_criacao, "
                    + "hora_criacao, usuario_id, visualizacoes) VALUES (?,?,?,?,?,?,?)";
            ps = CONEXAO.conexao.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getSubtitulo());
            ps.setString(3, obj.getTexto());
            ps.setString(4, Utils.retornaDataStringBR());
            ps.setString(5, Utils.retornaHoraStringBR());
            ps.setInt(6, obj.getUsuario_id().getId());
            ps.setInt(7, 0);
            ps.executeUpdate();
            ps.close();
            CONEXAO.desconectaBanco();
            return 1;

        } catch (SQLException e) {
            System.out.println("Erro ao INSERIR post: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean alterar(Post obj) {

        try {
            String sql = "UPDATE post SET titulo =?, subtitulo = ?, texto=?";

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao INSERIR post: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean exlcuir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> listarTodos() {
        List<Post> posts = new ArrayList<>();
        String sql = "";
        try {
            sql = "SELECT * FROM post ORDER BY id DESC";
            ps = CONEXAO.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setTexto(rs.getString("texto"));
                p.setData_criacao(rs.getString("data_criacao"));
                p.setHora_criacao(rs.getString("hora_criacao"));
                p.setUsuario_id(new UsuariosDAO().getUsuarioById(rs.getInt("usuario_id")));
                p.setVisualizacoes(rs.getInt("visualizacoes"));
                posts.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    /**
     * Pegar o post pelo ID;
     *
     * @param postId
     * @return
     */
    public Post getPostById(String postId) {
        Post p = new Post();
        String sql = "";
        try {
            sql = "SELECT * FROM post WHERE id = '" + postId + "'";
            ps = CONEXAO.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setSubtitulo(rs.getString("subtitulo"));
                p.setTexto(rs.getString("texto"));
                p.setData_criacao(rs.getString("data_criacao"));
                p.setHora_criacao(rs.getString("hora_criacao"));
                p.setUsuario_id(new UsuariosDAO().getUsuarioById(rs.getInt("usuario_id")));
                //pegando os comentarios;
                List<Comentario> comentarios = new ComentarioDAO().comentariosPeloPostId(postId);
                p.setComentarios(comentarios);
                p.setVisualizacoes(rs.getInt("visualizacoes"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * Incrementa as visualizacoes do Post assim que o usuario acessa a página.
     *
     * @param visualizou
     * @param postId
     */
    public synchronized void incrementaVisualizacoesPost(int visualizou, String postId) {
        int totalPassado = totalVisualizacoes(postId);
        totalPassado = totalPassado + visualizou;
        try {
            CONEXAO.conectar();
            String sql = "UPDATE post SET visualizacoes = ? WHERE id = '" + postId + "'";
            ps = CONEXAO.conexao.prepareStatement(sql);
            ps.setInt(1, totalPassado);
            ps.execute();
            ps.close();
            CONEXAO.desconectaBanco();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Somar as visualizacoes de post
     *
     * @param postId
     * @return
     */
    public synchronized int totalVisualizacoes(final String postId) {
        int total = 0;
        try {
            CONEXAO.conectar();
            String sql = "SELECT SUM(DISTINCT (visualizacoes)) AS  total_visualizacoes FROM post WHERE post.id = '" + postId + "'";
            ps = CONEXAO.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                total += rs.getInt("total_visualizacoes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
