package com.realtimedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaRealtimeDataApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootKafkaRealtimeDataApplication.class, args);

	}

	@Autowired
	private WikimediaProducer wikimediaProducer;

	@Override
	public void run(String... args) throws Exception {
		wikimediaProducer.sendMessage();
	}
}
