/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe responsável por conectar ao Banco de Dados
 *
 * @since 20/11/2017
 * @author paulo
 */
public class ConexaoBanco {

    public Statement st;
    public ResultSet rs;
    private PreparedStatement pstmt;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://localhost/blog_java";
    private final String usuario = "root";
    private final String senha = "";
    public Connection conexao;

    /**
     * Conectar ao banco de dados
     *
     * @since 25/11/2017
     * @return
     */
    public Connection conectar() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexao;
    }

    /**
     * Desconectar do banco de dados
     *
     * @since 25/11/2017
     */
    public void desconectaBanco() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Executar scripts SQL
     *
     * @since 25/11/2017
     * @param sql
     */
    public void executaSQL(String sql) {
        try {
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ConexaoBanco().conectar();
    }
}
