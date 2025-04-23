package com.projetoAPI.controller;

import com.projetoAPI.service.ConsultaPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/enviar")
public class EnvioController {

    private final ConsultaPublisher publisher;

    public EnvioController(ConsultaPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/consulta")
    public ResponseEntity<?> enviarConsulta() {
        Map<String, Object> consulta = Map.of(
                "paciente", 1,
                "data", "2025-04-23T15:00:00",
                "observacoes", "Enviado via RabbitMQ do Spring"
        );

        publisher.enviarConsulta(consulta);
        return ResponseEntity.ok("Consulta enviada para a fila!");
    }
}

