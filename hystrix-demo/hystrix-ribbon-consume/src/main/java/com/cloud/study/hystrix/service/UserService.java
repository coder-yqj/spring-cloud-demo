package com.cloud.study.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/5/28/028.
 * 使用注解实现请求合并器
 * 合并时间窗设置为100毫秒
 */
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCollapser(batchMethod = "findAll",collapserProperties = {
        @HystrixProperty(name = "timerDelayInMilliseconds",value = "100")
    })
    public Object find(Long id){
        return null;
    }

    @HystrixCommand
    public List<Object> findAll(List<Long> ids){
        return restTemplate.getForObject("http://user-service/users?ids={1}",
                List.class, StringUtils.join(ids,","));
    }
}
