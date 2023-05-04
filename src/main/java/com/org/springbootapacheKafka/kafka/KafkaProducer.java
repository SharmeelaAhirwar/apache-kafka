package com.org.springbootapacheKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;

	
	private static final Logger logger=LoggerFactory.getLogger( KafkaProducer.class);
	
	private KafkaTemplate<String, String>kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessage(String msg) {
		logger.info("sending message %s",msg);
		kafkaTemplate.send(topicName,msg);
	}
	
}
