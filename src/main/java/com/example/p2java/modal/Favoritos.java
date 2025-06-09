package com.example.p2java.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Favoritos {
    private int id;
    private int itemId;
    private String tipo;
    private String nome;
    private String genero;
    private Date dt_lancamento;
    private String descricao;

    public Favoritos() {
    }

    public Favoritos(int id, int itemId, String tipo, String nome, String genero, Date dt_lancamento, String descricao) {
        this.id = id;
        this.itemId = itemId;
        this.tipo = tipo;
        this.nome = nome;
        this.genero = genero;
        this.dt_lancamento = dt_lancamento;
        this.descricao = descricao;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDt_lancamento() {
        return dt_lancamento;
    }

    public void setDt_lancamento(Date dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Favoritos converterUmFavorito(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        int itemId = (Integer) registro.get("item_id");
        String tipo = (String) registro.get("tipo");
        String nome = (String) registro.get("nome");
        String genero = (String) registro.get("genero");
        Date dt_lancamento = (Date) registro.get("dt_lancamento");
        String descricao = (String) registro.get("descricao");
        return new Favoritos(id, itemId, tipo, nome, genero, dt_lancamento, descricao);
    }

    public static List<Favoritos> converterNFavoritos(List<Map<String, Object>> registros) {
        List<Favoritos> aux = new ArrayList<>();
        for (Map<String, Object> reg : registros) {
            aux.add(converterUmFavorito(reg));
        }
        return aux;
    }
}