package br.com.andsantos.messaging.redis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andsantos.messaging.redis.service.RedisPublisherService;
import br.com.andsantos.messaging.util.JsonUtil;
import redis.clients.jedis.Jedis;

@Service
public class RedisPublisherServiceImpl implements RedisPublisherService {
    private Logger log = LoggerFactory.getLogger(getClass());
    private Jedis jedis;

    @Autowired
    public RedisPublisherServiceImpl(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public Long publish(String channel, Object object) {
        return publish(channel, JsonUtil.toJson(object));
    }

    @Override
    public Long publish(String channel, String message) {
        Long reply = jedis.publish(channel, message);
        log.info("Canal: {},\n Mensagem: {},\n reply: {}", message, channel, reply);
        return reply;
    }
}
