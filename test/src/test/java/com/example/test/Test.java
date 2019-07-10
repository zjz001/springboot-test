package com.example.test;

import com.example.test.domian.User;
import com.example.test.es.EsRepository;
import org.assertj.core.util.Lists;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import javax.annotation.Resource;

/**
 * @program: springboot
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-01-24 15:16
 **/
public class Test {
	@Resource
	private EsRepository repository;
	private static TransportClient client;

	@org.junit.Test
	public TransportClient getElasticsearchClient() {
		try {
			Settings settings = Settings.builder()
					.put("cluster.name", "manager")  //连接的集群名
					.put("client.transport.ignore_cluster_name", true)  //如果集群名不对，也能连接
					.build();
			//创建client
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));  //主机和端口号
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		@org.junit.Test
		public void ESTest () {

			ArrayList<User> userList = Lists.newArrayList();
			User user = new User();
			user.setId(666666L);
			user.setName("刘亦菲");
			user.setAge(18);
			user.setEmail("www.163.com");

			User user1 = new User();
			user1.setId(7777777L);
			user1.setName("唐嫣");
			user1.setAge(19);
			user1.setEmail("www.163.com");


			User user2 = new User();
			user2.setId(88888888L);
			user2.setName("杨幂");
			user2.setAge(20);
			user2.setEmail("www.163.com");

			userList.add(user);
			userList.add(user1);
			userList.add(user2);
			for (User user3 : userList) {
				System.out.println(user3.getId() + ":" + user3.getName() + ":" + user3.getAge() + ":" + user3.getEmail());
			}
			repository.saveAll(userList);
		}

	}
