/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import br.com.blog.utils.Utils;
import br.com.blog.model.Post;
import java.sql.SQLException;
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
                    + "hora_criacao, usuario_id) VALUES (?,?,?,?,?,?,?)";
            ps = CONEXAO.conexao.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2, obj.getSubtitulo());
            ps.setString(3, obj.getTexto());
            ps.setString(4, Utils.retornaDataStringBR());
            ps.setString(5, Utils.retornaHoraStringBR());
            ps.setInt(6, obj.getUsuario_id());
            ps.executeUpdate();
            ps.close();
            CONEXAO.desconectaBanco();
            return 1;
            
        } catch (SQLException e) {
            System.out.println("Erro ao INSERIR post: " + e.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
