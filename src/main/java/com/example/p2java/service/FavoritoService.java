package com.example.p2java.service;

import com.example.p2java.modal.FavoritosDAO;
import com.example.p2java.modal.Filme;
import com.example.p2java.modal.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FavoritoService {

    @Autowired
    private FavoritosDAO favoritosDAO;

    public void favoritarFilme(Filme filme) {
        favoritosDAO.favoritarFilme(filme);
    }

    public void favoritarJogo(Jogo jogo) {
        favoritosDAO.favoritarJogo(jogo);
    }

    public List<Map<String, Object>> puxarTodosFavoritos() {
        return favoritosDAO.puxarTodosFavoritos();
    }

    public void deletarFavorito(int id) {
        favoritosDAO.deletarFavorito(id);
    }
}