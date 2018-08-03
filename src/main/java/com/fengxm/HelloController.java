package com.fengxm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fengxm.model.GirlProperties;
import com.fengxm.model.GirlProperties2;

@RestController 
// 等同于同时加上了@Controller和@ResponseBody
public class HelloController {
	
	@Autowired
	private GirlProperties2 girl1;
	
	@Value("${girl.name}")
	private String name;
	
	@Value("${test}")
	private String test;
	
	// 访问/hello或者/hi任何一个地址，都会返回一样的结果
	@RequestMapping(value = { "/hello", "/hi" }, method = RequestMethod.GET)
	public String say() {
		return "hi1 " + girl1.getName() + "!!!";
	}
	
	@RequestMapping(value = {"/hi2" }, method = RequestMethod.GET)
	public String say2() {
		return "hi2 " + name + "!!!";
	}
	
	@RequestMapping(value = {"/hi3" }, method = RequestMethod.GET)
	public String say3() {
		return "hi3 " + test + "!!!";
	}
}
