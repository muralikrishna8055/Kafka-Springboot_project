package com.kafkaconsumer;

import com.kafkaconsumer.entity.WikimediaData;
import com.kafkaconsumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaDatabaseConsumer {

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;
    private static final Logger LOGGER= LoggerFactory.getLogger(kafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "wikimedia_onchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message -> %s",eventMessage));

        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikiEventData("EVENT MESSAGE");
        wikimediaDataRepository.save(wikimediaData);

    }
}
