package com.nnnoopt.mymicro.userservice.controller;

import com.nnnoopt.mymicro.userservice.kafka.KafkaProducer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@OpenAPIDefinition(info = @Info(title = "User API", version = "v1", description =
        "API для управления пользователями"))
public class Controller {

    private final KafkaProducer kafkaProducer;

    public Controller(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/test")
    @Operation(summary = "Отправка", description = "Отправка теста для теста кафки")
    public String test(){
        kafkaProducer.sendMessage("message from user-service");
        log.info("Hello!! LOG!!");
        return "test";
    }
}
