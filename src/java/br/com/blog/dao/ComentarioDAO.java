/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import br.com.blog.model.Comentario;
import br.com.blog.utils.Utils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class ComentarioDAO extends BaseConexao implements InterfaceDAO<Comentario> {

    @Override
    public int inserir(Comentario obj) {
        try {
            CONEXAO.conectar();
            String sql = "INSERT INTO comentarios (comentario, data_comentario, hora_comentario, "
                    + "usuario_id, post_id) VALUES (?,?,?,?,?)";
            ps = CONEXAO.conexao.prepareStatement(sql);
            ps.setString(1, obj.getComentario());
            ps.setString(2, Utils.retornaDataStringBR());
            ps.setString(3, Utils.retornaHoraStringBR());
            ps.setInt(4, obj.getUsuario_id().getId());
            ps.setInt(5, obj.getPostId());
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
    public boolean alterar(Comentario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exlcuir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Pega todos os comentarios passando o ID do Post.
     * 
     * @param postId
     * @return 
     */
    List<Comentario> comentariosPeloPostId(String postId) {
        List<Comentario> comentarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comentarios WHERE post_id = '"+postId+"' ORDER BY id DESC";  
            ps = CONEXAO.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comentario c = new Comentario();
                c.setId(rs.getInt("id"));
                c.setComentario(rs.getString("comentario"));
                c.setDataComentario(rs.getString("data_comentario"));
                c.setHoraComentario(rs.getString("hora_comentario"));
                c.setUsuario_id(new UsuariosDAO().getUsuarioById(rs.getInt("usuario_id")));
                comentarios.add(c);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentarios;
    }
    
}
