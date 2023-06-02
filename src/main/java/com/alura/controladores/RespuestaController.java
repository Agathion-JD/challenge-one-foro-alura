package com.alura.controladores;

import com.alura.modelo.Respuesta;
import com.alura.modelo.topico.Topico;
import com.alura.modelo.Usuario;
import com.alura.repositorios.RespuestaRepository;
import com.alura.repositorios.TopicoRepository;
import com.alura.repositorios.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public RespuestaController(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta) {
        Topico topico = respuesta.getTopico();
        Usuario autor = respuesta.getAutor();
        if (topico == null || topico.getId() == null || autor == null || autor.getId() == null) {
            // Manejar el caso en el que no se proporcione el tópico o su ID, o el autor o su ID
            // Por ejemplo, lanzar una excepción o devolver un error
            return ResponseEntity.badRequest().build();
        }

        topico = topicoRepository.findById(topico.getId()).orElse(null);
        autor = usuarioRepository.findById(autor.getId()).orElse(null);

        if (topico == null || autor == null) {
            // Manejar el caso en el que no se encuentre el tópico o el autor
            // Por ejemplo, lanzar una excepción o devolver un error
            return ResponseEntity.badRequest().build();
        }

        respuesta.setTopico(topico);
        respuesta.setAutor(autor);

        Respuesta nuevaRespuesta = respuestaRepository.save(respuesta);
        return ResponseEntity.ok(nuevaRespuesta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> updateRespuesta(@PathVariable Long id, @RequestBody Respuesta updatedRespuesta) {
        Respuesta respuesta = respuestaRepository.findById(id).orElse(null);
        if (respuesta == null) {
            // Manejar el caso en el que no se encuentre la respuesta
            // Por ejemplo, lanzar una excepción o devolver un error
            return ResponseEntity.notFound().build();
        }

        // Actualizar los datos de la respuesta
        respuesta.setMensaje(updatedRespuesta.getMensaje());

        Respuesta respuestaActualizada = respuestaRepository.save(respuesta);
        return ResponseEntity.ok(respuestaActualizada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElse(null);
        if (respuesta == null) {
            // Manejar el caso en el que no se encuentre la respuesta
            // Por ejemplo, lanzar una excepción o devolver un error
            return ResponseEntity.notFound().build();
        }

        respuestaRepository.delete(respuesta);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> getRespuestaById(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElse(null);
        if (respuesta == null) {
            // Manejar el caso en el que no se encuentre la respuesta
            // Por ejemplo, lanzar una excepción o devolver un error
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(respuesta);
    }
}