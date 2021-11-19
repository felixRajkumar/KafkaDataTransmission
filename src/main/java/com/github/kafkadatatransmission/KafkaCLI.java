package com.github.kafkadatatransmission;

public class KafkaCLI {
	/*
			Zookeeper  - zookeeper-server-start config/zookeeper.properties

			Kafka Server - kafka-server-start config/server.properties

			kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 1

			kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic

			kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic

			kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning

			//When topics are considered as group load balancing will be done automatically
			kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

			kafka-consumer-groups --bootstrap-server 127.0.0.1:9092 --group my-first-application --reset-offsets --to-earliest --execute --topic first_topic
	 */
}
