package br.com.andsantos.messaging.redis.service;

public interface RedisPublisherService {

    Long publish(String channel, Object object);

    Long publish(String channel, String message);

}