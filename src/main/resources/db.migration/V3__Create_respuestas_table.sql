CREATE TABLE respuestas (
    id BIGINT PRIMARY KEY,
    mensaje VARCHAR(500) NOT NULL,
    topico_id BIGINT,
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id BIGINT,
    solucion BOOLEAN,
    FOREIGN KEY (topico_id) REFERENCES topico(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);