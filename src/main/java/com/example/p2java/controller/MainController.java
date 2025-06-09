package com.example.p2java.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.p2java.modal.Favoritos;
import com.example.p2java.modal.Filme;
import com.example.p2java.modal.Jogo;
import com.example.p2java.service.FavoritoService;
import com.example.p2java.service.FilmeService;
import com.example.p2java.service.JogoService;

@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping("/")
    public String index() {
        return "1-index";
    }

    @GetMapping("/5-favoritos")
    public String favoritos(Model model) {
        List<Map<String, Object>> todosFavoritos = favoritoService.puxarTodosFavoritos();
        List<Favoritos> favoritosConvertidos = Favoritos.converterNFavoritos(todosFavoritos);

        List<Favoritos> filmesFavoritos = favoritosConvertidos.stream()
                .filter(f -> "filme".equals(f.getTipo()))
                .collect(Collectors.toList());

        List<Favoritos> jogosFavoritos = favoritosConvertidos.stream()
                .filter(f -> "jogo".equals(f.getTipo()))
                .collect(Collectors.toList());

        model.addAttribute("filmesFavoritos", filmesFavoritos);
        model.addAttribute("jogosFavoritos", jogosFavoritos);
        return "5-favoritos";
    }

    @GetMapping("/4-salvos")
    public String listarfilmes(Model model) {
        FilmeService cs = context.getBean(FilmeService.class);
        List<Map<String, Object>> lr = cs.puxarTodosFilmes();
        List<Filme> lc = Filme.converterNFilmes(lr);
        model.addAttribute("filmes", lc);

        JogoService js = context.getBean(JogoService.class);
        List<Map<String, Object>> jr = js.puxarTodosJogos();
        List<Jogo> jc = Jogo.converterNJogos(jr);
        model.addAttribute("jogos", jc);

        return "4-salvos";
    }

    // FILMES
    @GetMapping("/2-filmes")
    public String filmes(Model model) {
        model.addAttribute("filme", new Filme());
        return "2-filmes";
    }

    @PostMapping("/filmes/manual")
    public String salvarFilme(Model model, @ModelAttribute Filme filme) {
        FilmeService js = context.getBean(FilmeService.class);
        js.inserirFilme(filme);
        return "redirect:/2-filmes";
    }

    // EDITAR FILMES
    @GetMapping("/editar/filmes/{id}")
    public String editarFilme(Model model, @PathVariable int id) {
        FilmeService fs = context.getBean(FilmeService.class);
        Map<String, Object> reg = fs.puxarFilme(id);
        Filme filme = Filme.converterUmFilme(reg);
        model.addAttribute("filme", filme);
        model.addAttribute("link", "/editar/jogos/" + id);
        model.addAttribute("nomePag", "EDITAR FILME");
        model.addAttribute("valorBtn", "Atualizar");
        return "2-filmes";
    }

    @PostMapping("/editar/filmes/{id}")
    public String editarFilme(@ModelAttribute Filme filme,
            @PathVariable int id) {
        FilmeService fs = context.getBean(FilmeService.class);
        fs.atualizarFilme(filme, id);
        return "redirect:/4-salvos";
    }

    // DELETAR FILMES
    @PostMapping("/deletar1/{id}")
    public String deletarFilme(@PathVariable int id) {
        FilmeService fs = context.getBean(FilmeService.class);
        fs.deletar(id);
        return "redirect:/4-salvos";
    }

    // JOGOS
    @GetMapping("/3-jogos")
    public String jogos(Model model) {
        model.addAttribute("jogo", new Jogo());
        return "3-jogos";
    }

    @PostMapping("/jogos/manual")
    public String salvarJogo(Model model, @ModelAttribute Jogo dadosJogo) {
        JogoService js = context.getBean(JogoService.class);
        js.inserirJogo(dadosJogo);
        return "redirect:/3-jogos";
    }

    // EDITAR JOGOS
    @GetMapping("/editar/jogos/{id}")
    public String editarJogo(Model model, @PathVariable int id) {
        JogoService js = context.getBean(JogoService.class);
        Map<String, Object> reg = js.puxarJogo(id);
        Jogo jog = Jogo.converterUmJogo(reg);
        model.addAttribute("jogo", jog);
        model.addAttribute("link", "/jogos/editar/" + id);
        model.addAttribute("nomePag", "EDITAR JOGOS");
        model.addAttribute("valorBtn", "Atualizar");
        return "3-jogos";
    }

    @PostMapping("/editar/jogos/{id}")
    public String editarJogo(@ModelAttribute Jogo jog,
            @PathVariable int id) {
        JogoService js = context.getBean(JogoService.class);
        js.atualizarJogo(jog, id);

        return "redirect:/4-salvos";
    }

    // DELETAR JOGOS
    @PostMapping("/deletar2/{id}")
    public String deletarJogo(@PathVariable int id) {
        JogoService js = context.getBean(JogoService.class);
        js.deletar(id);
        return "redirect:/4-salvos";
    }

    // FAVORITOS
    @PostMapping("/favoritar/filme/{id}")
    public String favoritarFilme(@PathVariable int id) {
        FilmeService fs = context.getBean(FilmeService.class);
        Map<String, Object> reg = fs.puxarFilme(id);
        Filme filme = Filme.converterUmFilme(reg);
        favoritoService.favoritarFilme(filme);
        return "redirect:/4-salvos";
    }

    @PostMapping("/favoritar/jogo/{id}")
    public String favoritarJogo(@PathVariable int id) {
        JogoService js = context.getBean(JogoService.class);
        Map<String, Object> reg = js.puxarJogo(id);
        Jogo jogo = Jogo.converterUmJogo(reg);
        favoritoService.favoritarJogo(jogo);
        return "redirect:/4-salvos";
    }

    @PostMapping("/desfavoritar/{id}")
    public String desfavoritar(@PathVariable int id) {
        favoritoService.deletarFavorito(id);
        return "redirect:/5-favoritos";
    }
}