package com.realtimedata;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaProducer {

    private KafkaTemplate<String,String>kafkaTemplate;
    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final Logger LOGGER=LoggerFactory.getLogger(WikimediaProducer.class);

    public void sendMessage() throws InterruptedException {
        String topic ="wikimedia_onchange";

        // In this, use event source to read the realtime data

        EventHandler eventHandler=new WikkimediaEventHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";

        //create  event source that connect to the data

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource= builder.build();

        //start event source
        eventSource.start();

        //sleep set
        TimeUnit.MINUTES.sleep(10);


    }
}
