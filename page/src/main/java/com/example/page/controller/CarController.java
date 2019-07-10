package com.example.page.controller;

import com.example.page.entity.Car;
import com.example.page.service.CarService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
	@Resource
	private CarService carService;

	@GetMapping("/hello")
	public ModelAndView hello(Model model) {
		List<Car> list = carService.findAll();
		model.addAttribute("address", list.get(0).getAddress());

		return new ModelAndView("hello");
	}


	@GetMapping("/hello1")
	public String hello1(Model model) {
		List<Car> list = carService.findAll();
		model.addAttribute("address", list.get(0).getAddress());
		return "hello";
	}
}
