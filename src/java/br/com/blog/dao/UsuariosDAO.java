/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import br.com.blog.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author paulo
 */
public class UsuariosDAO extends BaseConexao implements InterfaceDAO<Usuario> {

    @Override
    public int inserir(Usuario obj) {
        try {
            CONEXAO.conectar();
            String sql = "INSERT INTO usuario (nome, sobrenome, email, senha) "
                    + " VALUES (?,?,?,?)";
            ps = CONEXAO.conexao.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getSobrenome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getSenha());
            ps.executeUpdate();
            ps.close();
            CONEXAO.desconectaBanco();

            return 1;

        } catch (SQLException e) {
            System.out.println("Erro ao INSERIR usuário: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public boolean alterar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exlcuir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Retornar o usuario pelo ID.
     * 
     * @param id
     * @return 
     */
    public Usuario getUsuarioById(final Integer id) {
        Usuario usu = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE id =" + id;
            ps = CONEXAO.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setSobrenome(rs.getString("sobrenome"));
                usu.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usu;
    }

}
