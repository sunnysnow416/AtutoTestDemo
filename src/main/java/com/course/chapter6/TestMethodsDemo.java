package com.course.chapter6;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
	
	@Test
	public void test1(){
		Assert.assertEquals(1, 2);
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void test3(){
		Assert.assertEquals("aaa", "aaa");
	}
	@Test
	public void test4(){
		Assert.assertEquals("aaa", "aaa");
	}
	
	@Test
	public void logDemo(){
		Reporter.log("���������Լ�д����־");
		throw new RuntimeException("�������Լ��������쳣");
		
	}

}
