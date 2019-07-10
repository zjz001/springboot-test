package com.example.page.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: springboot
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-06-18 14:32
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class Car implements Serializable {
	private Integer id;
	private String longitude;
	private String latitude;
	private String address;
	private String phone;
	private Integer grade;
	private Integer flag;
	private String storeName;
	private String image;
	private Date createTime;
}
