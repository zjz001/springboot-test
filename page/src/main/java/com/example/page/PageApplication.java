package com.example.page;

import com.example.page.nettyClient.NettyClient;
import com.example.page.nettyServer.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

@MapperScan("com.example.page.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class PageApplication {
	public static void main(String[] args) {
		SpringApplication.run(PageApplication.class, args);
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(new InetSocketAddress("127.0.0.1", 9001));
	}
}
