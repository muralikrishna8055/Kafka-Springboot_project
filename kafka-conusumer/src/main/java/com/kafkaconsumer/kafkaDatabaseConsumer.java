package com.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaDatabaseConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(kafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "wikimedia_onchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message -> %s",eventMessage));

    }
}
