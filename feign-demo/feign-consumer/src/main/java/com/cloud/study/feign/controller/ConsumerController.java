package com.cloud.study.feign.controller;

import com.cloud.study.fegin.dto.User;
import com.cloud.study.feign.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/29/029.
 */
@RestController
public class ConsumerController {

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI", 20)).append("\n");
        sb.append(refactorHelloService.hello(new User("MIMI", 20))).append("\n");
        return sb.toString();
    }

    @RequestMapping("/hello")
    public String hello() {
        return refactorHelloService.hello();
    }

}
