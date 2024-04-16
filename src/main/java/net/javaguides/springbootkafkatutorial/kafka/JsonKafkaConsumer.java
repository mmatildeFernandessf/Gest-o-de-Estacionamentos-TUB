package net.javaguides.springbootkafkatutorial.kafka;

import net.javaguides.springbootkafkatutorial.payload.Estacionamento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Estacionamento estacionamento){
        int numLugares = estacionamento.getnumLugares();
        String localizacao = estacionamento.getlocalizacao();
        LOGGER.info(String.format("Dados do estacionamento -> %s", estacionamento.toString()));
    }
}
