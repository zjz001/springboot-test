package com.example.page;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: springboot
 * @description: play
 * @author: Mr.Zhang
 * @create: 2019-06-17 16:54
 **/
@Controller
@RequestMapping(value = "/page")
public class ViewController {

	@GetMapping("/test")
	public String test(){
		return "hello";
	}

	@GetMapping("/test1")
	@ResponseBody
	public ModelAndView test1(){
		return new ModelAndView("hello");
	}

}
