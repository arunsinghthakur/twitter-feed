package com.joker.twitterfeed.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${kafka.topic.twiter-feed-topic}")
	public void receive(String payload) {
		LOGGER.info("received payload='{}'", payload);
	}
}
