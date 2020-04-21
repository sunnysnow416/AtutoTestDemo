package com.course.chapter9;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MycookiesForPost {
	private String url;
	private ResourceBundle bundle;
	//用来存储cookies信息的变量
	private CookieStore store;
		
	@BeforeTest
	public void BeforeTest(){
		bundle = ResourceBundle.getBundle("application",Locale.CHINA);
		url=bundle.getString("test.url");
	}
	
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException{
		String uri = bundle.getString("getCookies.uri");
		String testUrl = this.url+uri;
		HttpGet get = new HttpGet(testUrl);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		this.store = client.getCookieStore();
		List<Cookie> cookieList = store.getCookies();		
		for(Cookie cookie:cookieList){
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println("name :"+name +" ,value :"+value);
		}		
	}
	
	@Test(dependsOnMethods={"testGetCookies"})
	public void testPostWithCookies() throws ClientProtocolException, IOException{
		String uri = bundle.getString("post.with.cookies");
		String testUrl = this.url+uri;		
		//声明一个client对象，用来执行方法
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法是post方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数
		JSONObject param = new JSONObject();
		param.put("name", "sunnysnow");
		param.put("age", "30");		
		//设置请求信息设置header
		post.setHeader("content-type","application/json");
		 //将参数信息添加到方法中
		StringEntity entity = new StringEntity(param.toString(),"utf-8");
		post.setEntity(entity);
		//声明一个对象，进行存储响应结果
		String result;
		 //设置cookies信息
		client.setCookieStore(store);
		 //执行post方法
		HttpResponse response = client.execute(post);
		//获取响应结果
		result = EntityUtils.toString(response.getEntity(),"Utf8");
		System.out.println(result);
		//处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化成为json对象
		JSONObject resultjson = new JSONObject(result);
		//获取到结果
		String success = (String) resultjson.get("sunnysnow");
		String status = (String) resultjson.get("status");
		Assert.assertEquals(success, success);
		Assert.assertEquals(status, "1");
		
	}

}
