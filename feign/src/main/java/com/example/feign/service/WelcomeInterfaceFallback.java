package com.example.feign.service;

/**
 * @program: springboot
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-01-15 11:42
 **/
public class WelcomeInterfaceFallback implements WelcomeInterface {
	@Override
	public String welcomeClientOne(String name) {
		return null;
	}
}
