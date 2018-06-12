package com.cloud.study.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/6/12/012.
 */
@FeignClient("hello-service")
public interface HelloService2 {

    @RequestMapping("/hello")
    String hello();
}
