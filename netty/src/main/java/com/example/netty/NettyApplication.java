package com.example.netty;

import com.example.netty.nettyClient.NettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
		NettyClient nettyClient = new NettyClient();
		nettyClient.start();
	}

}
