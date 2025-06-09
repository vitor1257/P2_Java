package com.example.p2java.modal;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class FilmeDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirFilme(Filme filme) {
        String sql = "INSERT INTO filmes(nomefilme, genero, dt_lancamento, descfilme) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4];
        parametros[0] = filme.getNomefilme();
        parametros[1] = filme.getGenero();
        parametros[2] = filme.getDt_lancamento();
        parametros[3] = filme.getDescricao();
        jdbc.update(sql, parametros);
    }
    public List<Map<String,Object>> puxarTodosFilmes(){
        String sql = "SELECT * FROM filmes;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarFilme(int id){
        String sql = "SELECT * FROM filmes WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM filmes where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarFilme(Filme fil, int id){
        String sql = "UPDATE filmes SET nomefilme = ?, genero = ?, dt_lancamento = ?, descfilme = ?  WHERE id = ?;";
        Object[] parametros = new Object[5];
        parametros[0] = fil.getNomefilme();
        parametros[1] = fil.getGenero();
        parametros[2] = fil.getDt_lancamento();
        parametros[3] = fil.getDescricao();
        parametros[4] = id;
        jdbc.update(sql, parametros);
    }

}
