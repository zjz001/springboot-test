package com.example.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


    @Service
    @FeignClient(value = "consumer-service")
    public interface WelcomeInterface {

        @RequestMapping(value = "/welcome",method = RequestMethod.GET)
        String welcomeClientOne(@RequestParam(value = "name") String name);

    }