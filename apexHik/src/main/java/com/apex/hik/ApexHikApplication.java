package com.apex.hik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@SpringBootApplication
public class ApexHikApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApexHikApplication.class, args);
	}
}
