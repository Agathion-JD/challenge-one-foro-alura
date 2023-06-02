package com.alura.repositorios;

import com.alura.modelo.Respuesta;
import com.alura.modelo.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByTopico(Topico topico);
}