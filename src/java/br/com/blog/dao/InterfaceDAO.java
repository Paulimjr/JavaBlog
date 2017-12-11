/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.dao;

import java.util.List;

/**
 *
 * @author paulo
 */
public interface InterfaceDAO<Object> {
    
    /**
     * Inserir objeto
     * 
     * @param obj
     * @return 
     */
    int inserir(Object obj);
    
    /**
     * Alterar objeto
     * 
     * @param obj
     * @return 
     */
    boolean alterar(Object obj);
    
    /**
     * Excluir objeto
     * 
     * @param id
     * @return 
     */
    boolean exlcuir(Integer id);
    
    /**
     * Listar todos
     */
    List<Object> listarTodos();
    
}
