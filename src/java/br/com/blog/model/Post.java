/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.blog.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author paulo
 */
public class Post implements Serializable {

    private Integer id;
    private String titulo;
    private String subtitulo;
    private String texto;
    private String data_criacao;
    private String hora_criacao;
    private Usuario usuario_id;
    private List<Comentario> comentarios;
    private int visualizacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getHora_criacao() {
        return hora_criacao;
    }

    public void setHora_criacao(String hora_criacao) {
        this.hora_criacao = hora_criacao;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(int visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", texto=" + texto + ", data_criacao=" + data_criacao + ", hora_criacao=" + hora_criacao + ", usuario_id=" + usuario_id + ", comentarios=" + comentarios + ", visualizacoes=" + visualizacoes + '}';
    }

}
