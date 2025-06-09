package com.example.p2java.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filme {
    private int id;
    private String nomefilme, genero, descfilme;
    private Date dt_lancamento;

    public Filme(){

    }

    public Filme(int id, String nomefilme, String genero, String descfilme, Date dt_lancamento) {
        this.id = id;
        this.nomefilme = nomefilme;
        this.genero = genero;
        this.dt_lancamento = dt_lancamento;
        this.descfilme = descfilme;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomefilme() {
        return nomefilme;
    }
    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescfilme() {
        return descfilme;
    }
    public void setDescfilme(String descfilme) {
        this.descfilme = descfilme;
    }

    public Date getDt_lancamento() {
        return dt_lancamento;
    }
    public void setDt_lancamento(Date dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
    }

    public Object getDescricao() {
        return descfilme;
    }
    public void setDescricao(String descricao) {
        this.descfilme = descricao;
    }

    //                             FILMES                            //
    public static Filme converterUmFilme(Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nomefilme = (String) registro.get("nomefilme");
        String genero = (String) registro.get("genero");
        String descfilme = (String) registro.get("descfilme");
        Date dt_lancamento = (Date) registro.get("dt_lancamento");
        Filme fil = new Filme(id, nomefilme, genero, descfilme, dt_lancamento);
        return fil;
    }
    public static List<Filme> converterNFilmes(List<Map<String,Object>> registros){
        List<Filme> aux = new ArrayList<Filme>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmFilme(reg));
        }
        return aux;
    }
    
}