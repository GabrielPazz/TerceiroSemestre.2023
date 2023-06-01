/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restcrud;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gustavo
 */
@RestController
public class RestcrudController {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @GetMapping("/usuarios")
    public Iterable<Usuario> listarTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/novousuario")
    public Usuario salvarUsuario(@Validated @RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }
}
