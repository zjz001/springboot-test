package com.example.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WelcomeService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errors")
    public String welcome(String name) {
        return restTemplate.getForObject("http://client/welcome?name=" + name, String.class);
    }

    public String errors(String name) {
        return "哎呀呀，" + name + ",出错了呀!";
    }
}
