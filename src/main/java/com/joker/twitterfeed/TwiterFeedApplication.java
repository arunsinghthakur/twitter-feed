package com.joker.twitterfeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joker.twitterfeed.producer.Sender;

@SpringBootApplication
public class TwiterFeedApplication {

	@Autowired
	private static Sender sender;
	private static final String HELLOWORLD_TOPIC = "twiter-feed-topic";

	public static void main(String[] args) {
		SpringApplication.run(TwiterFeedApplication.class, args);
		sender.send(HELLOWORLD_TOPIC, "Hello Spring Kafka!");
	}
}
