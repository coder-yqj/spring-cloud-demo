package com.cloud.study.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixServiceApplication {
	private final Logger logger = LoggerFactory.getLogger(HystrixServiceApplication.class);
	@Value("${local.property}")
	private String property;

	@RequestMapping("/hello")
	public String home() throws InterruptedException {
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" +sleepTime);
		Thread.sleep(sleepTime);
		logger.info("project:"+property);
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(HystrixServiceApplication.class, args);
	}
}
