/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.model;

import java.io.Serializable;

/**
 *
 * @author paulo
 */
public class Comentario implements Serializable {
    
    private Integer id;
    private String comentario;
    private int usuario_id;
    private String dataComentario;
    private String horaComentario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(String dataComentario) {
        this.dataComentario = dataComentario;
    }

    public String getHoraComentario() {
        return horaComentario;
    }

    public void setHoraComentario(String horaComentario) {
        this.horaComentario = horaComentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", comentario=" + comentario + ", usuario_id=" + usuario_id + ", dataComentario=" + dataComentario + ", horaComentario=" + horaComentario + '}';
    }
    
}
