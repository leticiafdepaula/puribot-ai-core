package com.puribot.ai_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})public class PuribotApplication {
	public static void main(String[] args) {
		SpringApplication.run(PuribotApplication.class, args);
	}
	}
