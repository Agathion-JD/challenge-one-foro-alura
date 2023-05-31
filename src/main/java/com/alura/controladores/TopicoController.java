package com.alura.controladores;

import com.alura.modelo.Topico;
import com.alura.repositorios.TopicoRepository;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }
   @GetMapping
    public ResponseEntity<List<Topico>> getAllTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }
    @PostMapping
    public ResponseEntity<?> createTopico(@RequestBody Topico topico) {
        System.out.println("holi");
        // Validar campos obligatorios
        if (StringUtils.isEmpty(topico.getTitulo()) || StringUtils.isEmpty(topico.getMensaje()) ||
                StringUtils.isEmpty(topico.getAutor()) || StringUtils.isEmpty(topico.getCurso())) {
            return ResponseEntity.badRequest().body("Todos los campos son obligatorios");
        }

        // Verificar si el tópico ya existe
        if (existeTopico(topico.getTitulo(), topico.getMensaje())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El tópico ya existe");
        }

        // Registrar el nuevo tópico
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTopico);
    }

    private boolean existeTopico(String titulo, String mensaje) {
        return topicoRepository.existsByTituloAndMensaje(titulo, mensaje);
    }
}