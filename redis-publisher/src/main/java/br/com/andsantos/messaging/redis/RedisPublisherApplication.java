package br.com.andsantos.messaging.redis;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.andsantos.messaging.builder.ClienteBuilder;
import br.com.andsantos.messaging.builder.PedidoBuilder;
import br.com.andsantos.messaging.builder.PedidoDetalheBuilder;
import br.com.andsantos.messaging.dto.PedidoDTO;
import br.com.andsantos.messaging.redis.service.RedisPublisherService;

@SpringBootApplication
public class RedisPublisherApplication implements CommandLineRunner {

    @Autowired
    private RedisPublisherService service;

    public static void main(String[] args) {
        SpringApplication.run(RedisPublisherApplication.class, args);
    }

    public void run(String... args) throws Exception {

        PedidoDTO pedido = PedidoBuilder.builder()
                .cliente(ClienteBuilder.builder()
                        .nomeEmpresa("Wayne Enterprise")
                        .nomeContato("Bruce Wayne")
                        .email("bruce@wayne.com").build())
                .item(PedidoDetalheBuilder.builder()
                        .produto("Funko Baby Yoda")
                        .precoUnitario(new BigDecimal(100))
                        .quantidade(BigDecimal.ONE).build())
                .build();

        service.publish("pedidos", pedido);
    }

}
