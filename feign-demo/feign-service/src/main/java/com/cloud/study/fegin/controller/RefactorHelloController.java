package com.cloud.study.fegin.controller;

import com.cloud.study.fegin.dto.User;
import com.cloud.study.fegin.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Administrator on 2018/5/31/031.
 */
@RestController
public class RefactorHelloController implements HelloService{

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello "+ name;
    }

    @Override
    public User hello(@RequestParam("name") String name, @RequestHeader("age") Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "hello "+ user.getName() +" ,"+user.getAge();
    }

    @Override
    public String hello() {
        //测试超时
        int sleepTime = new Random().nextInt(3000);
        System.out.println("sleep time:"+ sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World";
    }
}
