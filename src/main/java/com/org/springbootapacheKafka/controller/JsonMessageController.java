package com.org.springbootapacheKafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springbootapacheKafka.kafka.JsonKafkaProducer;
import com.org.springbootapacheKafka.payload.User;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {
	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	
	@PostMapping("/publish")
	public ResponseEntity<String>publish(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("message send to topic");
	}

}
