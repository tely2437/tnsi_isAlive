package com.tnsi.isalive.messagerie.controller;

import com.tnsi.isalive.messagerie.producer.IProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private IProducer producer;

    @GetMapping("/(message)/send")
    public String sendMessage(@PathVariable("message") String message){
        producer.producMessage(message);
        return "DONE";
    }

}
