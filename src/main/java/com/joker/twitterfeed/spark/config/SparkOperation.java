package com.joker.twitterfeed.spark.config;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SparkOperation {

	@Autowired
	private JavaSparkContext javaSparkContext;

	@Autowired
	private SparkSession sparkSession;

	public void test() {
		System.out.println("*********************Apache spark version : " + javaSparkContext.version());
		JavaRDD<String> rdd = javaSparkContext.textFile("E:\\software\\apachespark\\spark\\README.md");
		System.out.println("*********************Number of lines are : " + rdd.count());
	}

}
