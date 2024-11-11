package com.musicas.desafio_padroes_projeto_spring.service;

import com.musicas.desafio_padroes_projeto_spring.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);

}
