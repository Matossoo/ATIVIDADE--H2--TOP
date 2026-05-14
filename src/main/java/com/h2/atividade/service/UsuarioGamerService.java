package com.h2.atividade.service;

import com.h2.atividade.model.UsuarioGamer;
import com.h2.atividade.repository.UsuarioGamerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor

public class UsuarioGamerService {

    private final UsuarioGamerRepository repository;

    public List<UsuarioGamer> listar() {
        return repository.findAll();
    }

    public UsuarioGamer buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public UsuarioGamer salvar(UsuarioGamer usuario) {
        return repository.save(usuario);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

}