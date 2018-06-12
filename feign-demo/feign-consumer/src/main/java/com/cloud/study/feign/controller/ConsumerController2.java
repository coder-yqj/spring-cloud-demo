package com.cloud.study.feign.controller;

import com.cloud.study.feign.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/12/012.
 */

@RestController
public class ConsumerController2 {
    @Autowired
    HelloService2 helloService2;

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService2.hello();
    }
}
