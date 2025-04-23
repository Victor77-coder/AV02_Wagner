package com.projetoAPI.service;

import com.projetoAPI.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaPublisher {
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public ConsultaPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarConsulta(Object consulta) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, consulta);
    }
}


