package br.com.andsantos.messaging.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisSubscriberApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisSubscriberApplication.class, args);
    }
}
