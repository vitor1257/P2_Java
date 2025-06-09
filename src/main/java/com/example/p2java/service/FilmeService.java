package com.example.p2java.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.p2java.modal.Filme;
import com.example.p2java.modal.FilmeDAO;

@Service
public class FilmeService {

    @Autowired
    FilmeDAO fdao;

    public void inserirFilme(Filme filme) {
        fdao.inserirFilme(filme);
    }
    
    public List<Map<String,Object>> puxarTodosFilmes(){
        return fdao.puxarTodosFilmes();
    }
 
    public Map<String,Object> puxarFilme(int id){
        return fdao.puxarFilme(id);
    }

    public void atualizarFilme(Filme fil,int id){
        fdao.atualizarFilme(fil,id);
    }

    public void deletar(int id){
        fdao.deletar(id);
    }

}