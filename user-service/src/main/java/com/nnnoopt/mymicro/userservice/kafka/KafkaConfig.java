package com.nnnoopt.mymicro.userservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic userTopic() {
        return new NewTopic("test", 1, (short) 1);
    }

}
