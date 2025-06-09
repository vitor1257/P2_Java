package com.example.p2java.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Repository
public class FavoritosDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void favoritarFilme(Filme filme) {
        String sql = "INSERT INTO favoritos(item_id, tipo, nome, genero, dt_lancamento, descricao) VALUES(?,?,?,?,?,?)";
        Object[] parametros = new Object[6];
        parametros[0] = filme.getId();
        parametros[1] = "filme";
        parametros[2] = filme.getNomefilme();
        parametros[3] = filme.getGenero();
        parametros[4] = filme.getDt_lancamento();
        parametros[5] = filme.getDescfilme();
        jdbc.update(sql, parametros);
    }

    public void favoritarJogo(Jogo jogo) {
        String sql = "INSERT INTO favoritos(item_id, tipo, nome, genero, dt_lancamento, descricao) VALUES(?,?,?,?,?,?)";
        Object[] parametros = new Object[6];
        parametros[0] = jogo.getId();
        parametros[1] = "jogo";
        parametros[2] = jogo.getNomejogo();
        parametros[3] = jogo.getGenero();
        parametros[4] = jogo.getDt_lancamento();
        parametros[5] = jogo.getDescjogo();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> puxarTodosFavoritos() {
        String sql = "SELECT * FROM favoritos";
        return jdbc.queryForList(sql);
    }

    public void deletarFavorito(int id) {
        String sql = "DELETE FROM favoritos WHERE id = ?";
        jdbc.update(sql, id);
    }
}