package com.org.springbootapacheKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.org.springbootapacheKafka.payload.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate< String, User>kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) {
		LOGGER.info(String.format("sending message --> %s", user.toString()));
		
		Message<User>msg=MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "secondTopic").build();
		kafkaTemplate.send(msg);
	}

}
