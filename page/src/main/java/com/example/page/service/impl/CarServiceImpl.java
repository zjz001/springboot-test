package com.example.page.service.impl;

import com.example.page.entity.Car;
import com.example.page.mapper.CarMapper;
import com.example.page.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarMapper carMapper;

	@Override
	public List<Car> findAll() {
		return carMapper.findAll();
	}
}
