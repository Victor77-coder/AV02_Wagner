package com.projetoAPI.configuration;

import com.rabbitmq.client.AMQP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "nova_consulta";

    @Bean
    public AMQP.Queue filaConsulta() {
        return new AMQP.Queue();
    }
}

