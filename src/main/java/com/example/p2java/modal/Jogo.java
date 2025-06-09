package com.example.p2java.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jogo {
    private int id;
    private String descjogo;
    private String nomejogo;
    private String genero;
    private Date dt_lancamento;

    public Jogo() {

    }

    public Jogo(int id, String nomejogo, String genero, Date dt_lancamento, String descjogo) {
        this.id = id;
        this.nomejogo = nomejogo;
        this.genero = genero;
        this.dt_lancamento = dt_lancamento;
        this.descjogo = descjogo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomejogo() {
        return nomejogo;
    }
    public void setNomejogo(String nomejogo) {
        this.nomejogo = nomejogo;
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

    public String getDescjogo() {
        return descjogo;
    }
    public void setDescjogo(String descjogo) {
        this.descjogo = descjogo;
    }

    public static Jogo converterUmJogo (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nomejogo = (String) registro.get("nomejogo");
        String genero = (String) registro.get("genero");
        Date dt_lancamento = (Date) registro.get("dt_lancamento");
        String descjogo = (String) registro.get("descjogo");
        Jogo jog = new Jogo(id,nomejogo,genero,dt_lancamento,descjogo);
        return jog;
    }

    public static List<Jogo> converterNJogos(List<Map<String,Object>> registros){
        List<Jogo> aux = new ArrayList<Jogo>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmJogo(reg));
        }
        return aux;
    }
}