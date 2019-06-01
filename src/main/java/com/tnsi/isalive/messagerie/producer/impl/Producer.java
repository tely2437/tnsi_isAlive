package com.tnsi.isalive.messagerie.producer.impl;

import com.tnsi.isalive.messagerie.producer.IProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${tnsi.rabbitmq.exchange}")
    private String exchange;

    @Value("${tnsi.rabbitmq.routingkey}")
    private String routingKey;

    @Override
    public void producMessage(String message) {
        amqpTemplate.convertAndSend(exchange,routingKey,message);
        System.out.println("message envoyé =" + message);
    }
}
