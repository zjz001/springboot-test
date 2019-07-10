package com.example.test.jdbc;

import com.mysql.jdbc.Connection;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-02-14 15:14
 **/
public class MysqlPoolImp implements MysqlPoolInterface{

	private LinkedBlockingQueue<Connection> idel;
	private LinkedBlockingQueue<Connection> busy;
	private int maxSize = 10;
	private AtomicInteger activeSize = new AtomicInteger(0);

	@Override
	public void init() {
		idel = new LinkedBlockingQueue<>();
		busy = new LinkedBlockingQueue<>();
	}

	@Override
	public void destory() {

	}

	@Override
	public Connection getConn() {
		//idel内有空闲对象
		Connection conn = idel.poll();
		if(null != conn){
			busy.offer(conn);
			return conn;
		}

		//idel没有空闲 但是activesize<10
		if(activeSize.get() < maxSize ){
			if(activeSize.incrementAndGet() <= maxSize){
				//创建连接
			}
		}
		//activeSize=10
		try {
			Connection con = idel.poll(10000, TimeUnit.MILLISECONDS);
			if(null == con){
				throw new RuntimeException("等待超时");
			}
			busy.offer(con);
			System.out.println("等到连接");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public void close() {

	}
}
