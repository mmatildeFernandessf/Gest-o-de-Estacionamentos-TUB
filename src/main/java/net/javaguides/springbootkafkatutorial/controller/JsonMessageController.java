

package net.javaguides.springbootkafkatutorial.controller;

import net.javaguides.springbootkafkatutorial.payload.Estacionamento;
import net.javaguides.springbootkafkatutorial.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private List<Estacionamento> listaEstacionamentos = new ArrayList<>();
    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Estacionamento novoEstacionamento){
        kafkaProducer.sendMessage(novoEstacionamento);
        listaEstacionamentos.add(novoEstacionamento);

        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @GetMapping("/getEstacionamento")
    public List<Estacionamento> getEstacionamento(){
        return listaEstacionamentos;
    }


}



