package com.h2.atividade.controller;

import com.h2.atividade.model.UsuarioGamer;
import com.h2.atividade.service.UsuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/gamers")
@RequiredArgsConstructor

public class UsuarioGamerController {

    private final UsuarioGamerService service;

    @GetMapping
    public List<UsuarioGamer> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public UsuarioGamer buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public UsuarioGamer salvar(@RequestBody UsuarioGamer usuario) {
        return service.salvar(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioGamer atualizar(@PathVariable Long id,
                                  @RequestBody UsuarioGamer usuario) {

        usuario.setId(id);

        return service.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}