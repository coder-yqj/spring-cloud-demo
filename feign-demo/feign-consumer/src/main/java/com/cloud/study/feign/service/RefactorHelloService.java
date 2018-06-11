package com.cloud.study.feign.service;

import com.cloud.study.fegin.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/5/31/031.
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService{
}
