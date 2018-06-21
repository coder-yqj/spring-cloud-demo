package com.cloud.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//配合feign-demo
//http://localhost:5555/api-a/refactor/hello7
//http://localhost:5555/api-b/feign-consumer
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulDemoApplication.class, args);
	}
}
