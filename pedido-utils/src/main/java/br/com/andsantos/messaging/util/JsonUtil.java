package br.com.andsantos.messaging.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {
    private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
        
    }

    public static String toJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter objeto {}: {}",
                    object.toString(), e.getMessage());
        }
        return json;
    }

    public static <T> T toObject(String content, Class<T> clazz) {
        T obj = null;
        try {
            obj = (T) new ObjectMapper().readValue(content, clazz);
        } catch (JsonProcessingException e) {
            log.error("Erro ao converter string {}: {}",
                    content, e.getMessage());
        }
        return obj;
    }
}
