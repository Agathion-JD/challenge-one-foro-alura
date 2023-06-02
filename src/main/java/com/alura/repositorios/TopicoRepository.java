package com.alura.repositorios;

import com.alura.modelo.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensajeAndIdNot(String titulo, String mensaje, Long id);
}