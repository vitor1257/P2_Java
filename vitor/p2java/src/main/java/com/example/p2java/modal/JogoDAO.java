package com.example.p2java.modal;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
    public class JogoDAO{

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirJogo(Jogo jogo){
        String sql = "INSERT INTO jogos(nomejogo, genero, dt_lancamento, descjogo) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4];
            parametros[0] = jogo.getNomejogo();
            parametros[1] = jogo.getGenero();
            parametros[2] = jogo.getDt_lancamento();
            parametros[3] = jogo.getDescjogo();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> puxarTodosJogos() {
        String sql = "SELECT * FROM jogos";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarJogo(int id){
        String sql = "SELECT * FROM jogos WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM jogos where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarJogo(Jogo jog, int id){
        String sql = "UPDATE jogos SET nomejogo = ?, genero = ?, dt_lancamento = ?, descjogo = ? WHERE id = ?;";
        Object[] parametros = new Object[5];
            parametros[0] = jog.getNomejogo();
            parametros[1] = jog.getGenero();
            parametros[2] = jog.getDt_lancamento();
            parametros[3] = jog.getDescjogo();
            parametros[4] = id;
            jdbc.update(sql, parametros);
    }
}