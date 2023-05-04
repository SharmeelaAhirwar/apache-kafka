package com.org.springbootapacheKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.org.springbootapacheKafka.payload.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
	@KafkaListener(topics = "secondTopic",groupId = "myGroup")
	public void consumerss(User user) {
		LOGGER.info(String.format("meessage  recieved ---> %s", user.toString()));
		
	}

}
