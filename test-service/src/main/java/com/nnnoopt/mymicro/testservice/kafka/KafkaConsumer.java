package com.nnnoopt.mymicro.testservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "myConsumer")
    public void listen(String message) {
        log.info("Received message {}", message);
        System.out.println(message);
    }
}
