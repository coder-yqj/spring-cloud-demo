package com.cloud.study.feign.service;

import com.cloud.study.fegin.dto.User;
import com.cloud.study.fegin.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/6/11/011.
 *
 * 由于HelloServiceFallback也继承了HelloService，所以也就继承了注解RequestMapping，

 所以：默认有两个一样的RequestMapping，


 */
@Component
@RequestMapping("/fall_back")
public class HelloServiceFallback implements RefactorHelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "error1";
    }

    @Override
    public User hello(@RequestParam("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error2";
    }

    @Override
    public String hello() {
        return "error3";
    }

}
