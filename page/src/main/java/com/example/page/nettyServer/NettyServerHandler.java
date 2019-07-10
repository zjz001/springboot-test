package com.example.page.nettyServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("Channel active......");
		//.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info("服务器收到消息: {}", msg.toString());
		if(msg.toString().equals("在干嘛")){
			ctx.write("想你啊");
		}else if(msg.toString().equals("想我干嘛")){
			ctx.write("想和你在一起");
		}else if(msg.toString().equals("哦")){
			ctx.write("你愿意吗");
		}else if(msg.toString().equals("yes,I do")){
			ctx.write("~~抱抱~~");
		}else if(msg.toString().equals("你好")){
			ctx.write("你好");
		}else {
			ctx.write("~抱抱~");
		}
		ctx.flush();
		//super.channelRead(ctx, msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
		//super.exceptionCaught(ctx, cause);
	}
}
