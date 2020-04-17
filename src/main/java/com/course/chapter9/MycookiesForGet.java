package com.course.chapter9;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MycookiesForGet {
	private String url;
	private ResourceBundle bundle;
	//用来存储cookies信息的变量
	private CookieStore store;
	
	@BeforeTest
	public void beforeTest(){
		bundle = ResourceBundle.getBundle("application",Locale.CHINA);
		url = bundle.getString("test.url");
	}
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException{
		String result;
		String uri = bundle.getString("getCookies.uri");
		String testUrl = this.url+uri;
		HttpGet get = new HttpGet(testUrl);
//		HttpClient无法获取cookies信息，所以要改成DefaultHttpClient
//		HttpClient client = new DefaultHttpClient();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(),"Utf8");
		System.out.println(result);
		
//		获取cookies信息
		this.store = client.getCookieStore();
		List<Cookie> cookieList = store.getCookies();
		for(Cookie cookie :cookieList){
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println("cookie name ="+ name + " ,cookie value = "+value);
		}		
	}
	@Test(dependsOnMethods={"testGetCookies"})
	public void testGetWithCookies() throws ClientProtocolException, IOException{
		String uri =bundle.getString("get.with.cookies");
		String testurl = this.url+uri;
		HttpGet get = new HttpGet(testurl);
		DefaultHttpClient client = new DefaultHttpClient();
		//设置cookies信息
		client.setCookieStore(this.store);
		HttpResponse response = client.execute(get);
		//获取响应的状态码
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println("statuscode:"+ statuscode);
		if(statuscode==200){
			String result = EntityUtils.toString(response.getEntity(),"Utf8");
			System.out.println(result);
		}		
	}

}
