package com.example.test.jdbc;

import com.mysql.jdbc.Connection;

/**
 * @program: springboot
 * @description:
 * @author: JiZeng
 * @create: 2019-02-14 15:11
 **/
public interface MysqlPoolInterface {

	public void init();

	public void destory();

	public Connection getConn();

	public void close();
}
