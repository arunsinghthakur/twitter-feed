package com.joker.twitterfeed.twitter.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;

import com.joker.twitterfeed.kafka.producer.Producer;

@EnableScheduling
@Configuration
public class TwitterOperation {

	@Autowired
	private Producer producer;

	@Autowired
	private Twitter twitterTemplate;

	@Scheduled(fixedDelay = 1000)
	public void pushTwitterData() {
		producer.send("twiter-feed-topic", "Fixed delay task - " + System.currentTimeMillis());

		SearchResults results = twitterTemplate.searchOperations().search("@SpringBoot", 200);
		results.getTweets().stream().map(source -> {
			producer.send("twiter-feed-topic", source.getText());
			return null;
		});

	}

}
