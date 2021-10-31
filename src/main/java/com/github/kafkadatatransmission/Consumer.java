package com.github.kafkadatatransmission;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {

	public static void main(String[] args) {

		//Logger
		Logger logger = LoggerFactory.getLogger(Consumer.class.getName());

		//Create Properties for Consumer
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

		//Create Consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

		//Allocate the consumer for a topic
		consumer.subscribe(Collections.singleton("first_topic"));

		while(true)
		{
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

			for(ConsumerRecord record : records)
			{
				logger.info(record.key().toString());
			}
		}
	}
}
