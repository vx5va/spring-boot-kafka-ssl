package com.vic.kafkatutorial;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vic.kafkatutorial.config.KafkaConfigProps;
import com.vic.kafkatutorial.model.CustomerVisitEvent;

@SpringBootApplication
public class KafkatutorialApplication {

	private ObjectMapper objectMapper;

	public KafkatutorialApplication(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkatutorialApplication.class, args);
	}

	// @Bean
	// public ApplicationRunner runner(final KafkaTemplate<String, String> kafkaTemplate, final KafkaConfigProps kafkaConfigProps) throws JsonProcessingException {
	// 	CustomerVisitEvent customerVisitEvent = CustomerVisitEvent.builder()
	// 		.customerId(UUID.randomUUID().toString())
	// 		.dateTime(LocalDateTime.now())
	// 		.build();

	// 	final String payload = objectMapper.writeValueAsString(customerVisitEvent);

	// 	return args -> {
	// 		kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
	// 	};
	// }

	@KafkaListener(topics = "${vic.kafka.topic}")
	public String listens(final String message) {
		System.out.println("Received message: " + message);
		return message;
	}
}
