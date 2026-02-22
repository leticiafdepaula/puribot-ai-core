package com.puribot.ai_core;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PuribotApplication {
	public static void main(String[] args) {
		SpringApplication.run(PuribotApplication.class, args);
	}
}