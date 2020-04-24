package com.course.chapter10;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="/",description="这是我全部的post请求")
@RequestMapping("v1")  //如果写了v1则下面的方法访问的时候前面都要加v1
public class MyPostMethod {

	//用来存cookies信息的变量
	private Cookie cookie;
	
	//场景：用户登录成功获取到cookies，然后再访问其他接口获取到列表	
	@RequestMapping(value ="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口，成功后获取cookies信息",httpMethod="POST")
	public String login(HttpServletResponse response,
						@RequestParam(value="userName",required=true) String userName,
						@RequestParam(value="password",required=true) String password){
		if(userName.equals("sunnysnow")&&password.equals("123456")){
			Cookie cookie = new Cookie("login","true");
			response.addCookie(cookie);
			return "恭喜你登录成功了";
		}
		return "用户名或者密码错误";	
	}
	
	@RequestMapping(value="/getUserList",method=RequestMethod.POST)
	@ApiOperation(value="获取用户列表",httpMethod="POST")
	public String getUserList(HttpServletRequest request,
							@RequestBody User u){
		User user;
		//获取cookies
		Cookie[] cookies = request.getCookies();
		System.out.println(u.getUserName());
		System.out.println(u.getPassWord());
		//验证cookies是否合法
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("login")
					&& cookie.getValue().equals("true")
					&& u.getUserName().equals("sunnysnow")   // ==是比地址值
					&& u.getPassWord().equals("123456")){
				
				user = new User();
				user.setName("wangfei");
				user.setAge("52");
				user.setSex("women");
				user.setUserName("wangfei");
				user.setPassWord("123456");
				return user.toString();
			}
		}
			return "参数不合法";
								
								
		
	}
}
