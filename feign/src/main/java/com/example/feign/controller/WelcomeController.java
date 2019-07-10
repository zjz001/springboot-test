package com.example.feign.controller;

import com.example.feign.service.WelcomeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@RestController
public class WelcomeController {
    @Autowired
    WelcomeInterface welcomeInterface;

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(@RequestParam String name){
        return welcomeInterface.welcomeClientOne(name);
    }
}