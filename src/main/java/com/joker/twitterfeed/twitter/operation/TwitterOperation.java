package com.joker.twitterfeed.twitter.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;

import com.joker.twitterfeed.kafka.producer.Producer;
import com.joker.twitterfeed.spark.config.SparkOperation;

@EnableScheduling
@Configuration
public class TwitterOperation {

	@Autowired
	private Producer producer;

	@Autowired
	private Twitter twitterTemplate;

	@Autowired
	private SparkOperation sparkOp;

	// @Scheduled(fixedDelay = 1000)
	public void pushTwitterData() {

		SearchResults results = twitterTemplate.searchOperations().search("@SpringBoot", 200);
		for (Tweet tweet : results.getTweets()) {
			producer.send("twiter-feed-topic", tweet.getText());
		}
	}

	@Scheduled(fixedDelay = 1000)
	public void pushTwitterdataIntoSpark() {
		sparkOp.test();
	}

}
