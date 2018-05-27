package com.cloud.study.eureka.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientServiceApplication {

	@Value("${local.property}")
	private String property;

	@RequestMapping("/hello")
	public String home() {
		System.out.println("project:"+property);
		return "Hello world";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServiceApplication.class, args);
	}
}
