package com.cloud.study.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/5/27/027.
 */
@Service
public class HelloService {
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    @Autowired
    private RestTemplate restTemplate;

    /**
     *  Hystrix 的默认命令执行超时时间为1000毫秒
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time:" + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error call";
    }
}
