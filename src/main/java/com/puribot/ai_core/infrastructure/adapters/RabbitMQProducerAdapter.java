package com.puribot.ai_core.infrastructure.adapters;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RabbitMQProducerAdapter {

    private final RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "puribot.direct";
    private static final String ROUTING_KEY = "raw.text";

    public RabbitMQProducerAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarParaAnalise(String mensagemRaw) {
        String traceId = UUID.randomUUID().toString();

        System.out.println("[AUDITORIA] TraceID: " + traceId + " | Enviando para o RabbitMQ...");

        this.rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensagemRaw);

        System.out.println("[SUCESSO] Mensagem enviada para a fila de análise.");
    }
    }
