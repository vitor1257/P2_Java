package com.example.p2java.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.p2java.modal.Jogo;
import com.example.p2java.modal.JogoDAO;


@Service
public class JogoService {

    @Autowired
    JogoDAO jdao;

    public void inserirJogo(Jogo jogo) {
        jdao.inserirJogo(jogo);
    }
    
    public List<Map<String,Object>> puxarTodosJogos(){
        return jdao.puxarTodosJogos();
    }

    public Map<String,Object> puxarJogo(int id){
        return jdao.puxarJogo(id);
    }

    public void atualizarJogo(Jogo jog,int id){
        jdao.atualizarJogo(jog,id);
    }

    public void deletar(int id){
        jdao.deletar(id);
    }


}
