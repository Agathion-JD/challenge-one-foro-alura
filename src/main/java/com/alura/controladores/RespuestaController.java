package com.alura.controladores;

import com.alura.modelo.Respuesta;
import com.alura.repositorios.RespuestaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;

    public RespuestaController(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @GetMapping
    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    @PostMapping
    public Respuesta createRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }
}