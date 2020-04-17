package com.course.chapter9;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class MyHttpClient {
	
	@Test
	public void test1() throws ClientProtocolException, IOException{
		String result;
		HttpGet get = new HttpGet("http://www.baidu.com");
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity());
		System.out.println(result);
		
	}

}
