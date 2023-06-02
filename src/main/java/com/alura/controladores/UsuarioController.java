package com.alura.controladores;

import com.alura.modelo.Usuario;
import com.alura.repositorios.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario no puede ser nulo");
        }

        // Verificar si el email del usuario ya existe en otro usuario
        if (existeUsuario(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El email ya está en uso por otro usuario");
        }

        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // Método para editar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar si el email del usuario ya existe en otro usuario
        if (existeUsuarioExcepto(usuario.getEmail(), id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El email ya está en uso por otro usuario");
        }

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setContrasena(usuario.getContrasena());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Método para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.delete(usuarioExistente);
        return ResponseEntity.ok().build();
    }

    // Método para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // Método auxiliar para verificar si un email de usuario ya existe
    private boolean existeUsuario(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    // Método auxiliar para verificar si un email de usuario ya existe en otro usuario (excepto el usuario con el ID proporcionado)
    private boolean existeUsuarioExcepto(String email, Long id) {
        return usuarioRepository.existsByEmailAndIdNot(email, id);
    }
}