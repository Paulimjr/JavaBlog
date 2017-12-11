/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author paulo
 */
public class BaseConexao {
    
    public static final ConexaoBanco CONEXAO = new ConexaoBanco();
    public PreparedStatement ps;
    public ResultSet rs;
    public Statement st;   
}
