package com.puribot.ai_core.infrastructure.exceptionHandler;

import com.puribot.ai_core.domain.exceptions.PuribotException;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

@Component
public class PuribotRabbitErrorHandler implements RabbitListenerErrorHandler {

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message,
                              ListenerExecutionFailedException exception) {

        if (exception.getCause() instanceof PuribotException) {
            return null;
        }

        throw exception;
    }
}