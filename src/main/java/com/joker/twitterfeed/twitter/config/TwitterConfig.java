package com.joker.twitterfeed.twitter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {

	@Value("${twitter.consumer-key}")
	private String consumerKey;
	@Value("${twitter.consumer-secret}")
	private String consumerSecret;
	@Value("${twitter.access-token}")
	private String accessToken;
	@Value("${twitter.access-secret-token}")
	private String accessTokenSecret;

	@Bean
	public Twitter twitterTemplate() {
		return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
}
