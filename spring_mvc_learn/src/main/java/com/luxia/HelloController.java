package com.luxia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/helloName")
	public String helloName(String name, double age){
		System.out.println(name + ", " + age);
		return "hello";
	}
	
	@RequestMapping("/helloDate")
	public String helloDate(Date date){
		System.out.println(date);
		return "hello";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),true));
	}
	
	// 向前台传递参数
	@RequestMapping("/show")
	public String show(Map<String,Object> map){
		map.put("name", "luxia");
		map.put("age", 27);
		return "show";
	}
	
	// 使用redirect进行重定向
	@RequestMapping("/redirect")
	public String redirect(){
		return "redirect:hello";
	}
	
	// 使用requestParam指定参数的name
	@RequestMapping("/helloParam")
	public String helloParam(@RequestParam(value="username") String name,
			@RequestParam(value="age") double age){
		System.out.println(name + ", " + age);
		return "hello";
	}
}
