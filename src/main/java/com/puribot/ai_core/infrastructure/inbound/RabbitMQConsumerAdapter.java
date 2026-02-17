package com.puribot.ai_core.infrastructure.inbound;

import com.puribot.ai_core.domain.exceptions.*;
import com.puribot.ai_core.domain.service.SocialShieldService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerAdapter {

    @Autowired
    private SocialShieldService socialShieldService;

    @RabbitListener(queues = "puribot.raw.text.queue")
    public void consumirMensagem(String mensagemRaw) {
        try {
            String analise = socialShieldService.analyzeText(mensagemRaw);

        } catch (FraudulentCareerPromiseException e) {
            throw new AmqpRejectAndDontRequeueException("Alerta de Fraude: " + e.getMessage());

        } catch (InvalidSystemDNAException e) {
            throw new AmqpRejectAndDontRequeueException("Erro de DNA do Sistema: " + e.getMessage());

        } catch (PuribotException e) {
            throw new AmqpRejectAndDontRequeueException("Erro interno do Puribot: " + e.getMessage());

        } catch (Exception e) {
            throw new RuntimeException("Falha técnica não mapeada no Consumer", e);
        }
    }
}