package br.com.andsantos.messaging.redis.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.andsantos.messaging.dto.PedidoDTO;
import br.com.andsantos.messaging.dto.PedidoDetalheDTO;
import br.com.andsantos.messaging.util.JsonUtil;

@Component
public class RedisListener {
    private static Logger log = LoggerFactory.getLogger(RedisListener.class);

    public void onReceive(String message) {

        PedidoDTO dto = JsonUtil.toObject(message, PedidoDTO.class);

        if (dto != null) {
            log.info("O cliente {} solicitou ", dto.getCliente().getNomeContato());
            for(PedidoDetalheDTO det : dto.getPedidoDetalhe()) {
                log.info("{} : {} por {} ", 
                        det.getProduto().getNomeProduto(), 
                        det.getQuantidade(), 
                        det.getPrecoUnitario());
            }

        }
    }
}
