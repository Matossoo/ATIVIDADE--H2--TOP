package com.h2.atividade.controller;

import com.h2.atividade.model.UsuarioGamer;
import com.h2.atividade.service.UsuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioGamerService service;

    @GetMapping("/")
    public String listar(Model model) {

        model.addAttribute("usuarios", service.listar());

        return "lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("usuarios", new UsuarioGamer());

        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(UsuarioGamer usuario) {

        service.salvar(usuario);

        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        model.addAttribute("usuarios", service.buscarPorId(id));

        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/";
    }
}