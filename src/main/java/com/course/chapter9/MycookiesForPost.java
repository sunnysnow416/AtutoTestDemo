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
	//�����洢cookies��Ϣ�ı���
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
		//����һ��client��������ִ�з���
		DefaultHttpClient client = new DefaultHttpClient();
		//����һ�����������������post����
		HttpPost post = new HttpPost(testUrl);
		//��Ӳ���
		JSONObject param = new JSONObject();
		param.put("name", "sunnysnow");
		param.put("age", "30");		
		//����������Ϣ����header
		post.setHeader("content-type","application/json");
		//��������Ϣ��ӵ�������
		StringEntity entity = new StringEntity(param.toString(),"utf-8");
		post.setEntity(entity);
		//����һ�����󣬽��д洢��Ӧ���
		String result;
		//����cookies��Ϣ
		client.setCookieStore(store);
		//ִ��post����
		HttpResponse response = client.execute(post);
		//��ȡ��Ӧ���
		result = EntityUtils.toString(response.getEntity(),"Utf8");
		System.out.println(result);
		//���������жϷ��ؽ���Ƿ����Ԥ��
		//�����ص���Ӧ����ַ���ת����Ϊjson����
		JSONObject resultjson = new JSONObject(result);
		//��ȡ�����ֵ
		String success = (String) resultjson.get("sunnysnow");
		String status = (String) resultjson.get("status");
		Assert.assertEquals(success, success);
		Assert.assertEquals(status, "1");
		
	}

}
