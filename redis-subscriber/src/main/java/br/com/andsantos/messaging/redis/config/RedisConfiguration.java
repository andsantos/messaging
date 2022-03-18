package br.com.andsantos.messaging.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import br.com.andsantos.messaging.redis.listener.RedisListener;

@EnableRedisRepositories
@Configuration
public class RedisConfiguration {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.channel}")
    private String channel;

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
//        JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//    @Bean
//    public Jedis jedis() {
//        return new Jedis(redisHost, redisPort);
//    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
        MessageListenerAdapter listenerAdapter) {

      RedisMessageListenerContainer container = new RedisMessageListenerContainer();
      container.setConnectionFactory(connectionFactory);
      container.addMessageListener(listenerAdapter, new ChannelTopic(channel));

      return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisListener messageListener){
      return new MessageListenerAdapter(messageListener, "onReceive");
    }
}
