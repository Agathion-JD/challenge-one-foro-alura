package com.alura.controladores;

import com.alura.modelo.Usuario;
import com.alura.repositorios.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    public UsuarioController(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return usuarioRepository.save(user);
    }
}
