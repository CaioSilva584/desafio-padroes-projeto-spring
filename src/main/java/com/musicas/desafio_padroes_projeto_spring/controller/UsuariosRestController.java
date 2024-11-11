package com.musicas.desafio_padroes_projeto_spring.controller;

import com.musicas.desafio_padroes_projeto_spring.model.Usuario;
import com.musicas.desafio_padroes_projeto_spring.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario){
        usuarioService.inserir(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, Usuario usuario){
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
}
