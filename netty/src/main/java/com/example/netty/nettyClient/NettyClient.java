package com.example.netty.nettyClient;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Scanner;

@Component
@Slf4j
public class NettyClient {

	public void start() {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		//该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
		bootstrap.group(group).option(ChannelOption.TCP_NODELAY, true).channel(NioSocketChannel.class)
				.handler(new NettyClientInitializer());
		try {
			ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 9001)).sync();
			log.info("客户端成功....");
			//发送消息
			future.channel().writeAndFlush("你好啊");
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()){
				String next = sc.next();
				future.channel().writeAndFlush(next);
			}
			// 等待连接被关闭
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}

}
