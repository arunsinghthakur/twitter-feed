package com.joker.twitterfeed.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class Test {

	@Autowired
	private Producer producer;

	@Scheduled(fixedDelay = 1000)
	public void sendDummyData() {
		producer.send("twiter-feed-topic", "Fixed delay task - " + System.currentTimeMillis());
	}
}
