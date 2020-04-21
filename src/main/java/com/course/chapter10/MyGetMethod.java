package com.course.chapter10;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //我是被需要扫描的包
public class MyGetMethod {

	@RequestMapping(value = "/getCookies",method =RequestMethod.GET) //访问路劲
	public  String getCookies(HttpServletResponse response)  //这个不是参数
	{
		//HttpserverletRequest 装请求信息的类
		//HttpserverletReponse 装响应信息的类
		Cookie cookie = new Cookie("login","true");
		response.addCookie(cookie);
		return "恭喜你获得cookies成功";
	}
	
	/*
	 * 要求客户端携带cookies访问
	 * 这是一个需要携带cookies信息才能访问的get请求
	 */
	@RequestMapping(value ="/get/with/cookies",method = RequestMethod.GET)
	public String getWithCookies(HttpServletRequest request ){
		String msg ="";
		Cookie[] cookies = request.getCookies();	
		if(cookies == null){
			msg= "必须携带cookies信息来";
		}else{
			for (Cookie cookie:cookies){
				if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
					msg= "这是一个需要携带cookies信息才能访问的get请求,访问成功了。";
				}
			}
		}
		return msg;	
	}

	/*
	 * 开发一个需要携带参数才能访问的get请求
	 * 第一种实现方式 url:key=value&key=value
	 * 模拟获取商品列表
	 */
	@RequestMapping(value="/get/with/param",method=RequestMethod.GET)
	public 	Map<String, Integer> getList(@RequestParam Integer start,
										@RequestParam Integer end){
		Map<String , Integer> myList = new HashMap<>();
		myList.put("鞋", 400);
		myList.put("干脆面", 1);
		myList.put("衬衫", 300);
		return myList;
		
	}
	
	/*
	 * 第二中需要携带参数访问的get请求
	 * url:ip:port/get/with/param/10/20
	 */
	@RequestMapping(value="/get/with/param/{start}/{end}")
	public 	Map<String, Integer> myGetList(@PathVariable Integer start,
										   @PathVariable Integer end){
		Map<String , Integer> myList = new HashMap<>();
		myList.put("鞋", 400);
		myList.put("干脆面", 1);
		myList.put("衬衫", 300);
		return myList;	
	}
	
}
