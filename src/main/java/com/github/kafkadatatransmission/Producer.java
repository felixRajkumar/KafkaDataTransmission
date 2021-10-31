package com.github.kafkadatatransmission;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class Producer {

	public static final String BOOTSTRAP_SERVER = "localhost:9092";
	public static final Logger LOGGER = LoggerFactory.getLogger(Producer.class.getName());

	public static void main(String[] args) {


		//Set Properties for Producer
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		//Create the Producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		//Create data
		final ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic_1", "hello world");

		//Send the data
		producer.send(record, new Callback() {
			public void onCompletion(RecordMetadata recordMetadata, Exception e) {
				if(e == null)
				{
					//Records are successfully sent
					LOGGER.info("Data sent successfully");
					LOGGER.info("Logging meta data " + recordMetadata.toString());
				}
				else
				{
					//throw exception
					LOGGER.error("Exception thrown while sending data " + e.getStackTrace());
				}
			}
		});

		//FLush and Close
		producer.flush();
		producer.close();

	}
}
