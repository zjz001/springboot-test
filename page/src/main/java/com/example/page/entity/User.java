package com.example.page.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: springboot
 * @description: 用户
 * @author: Mr.Zhang
 * @create: 2019-06-18 14:28
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class User implements Serializable {

	private Integer id;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String email;

}
