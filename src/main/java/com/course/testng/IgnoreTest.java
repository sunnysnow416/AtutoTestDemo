package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
	@Test (enabled=true)
	public void test1(){
		System.out.println("test1ִ�в��ԡ�");
	}
	
	@Test (enabled=false)
	public void test2(){
		System.out.println("test2ִ�в��ԡ�");
	}
	
	@Test
	public void test3(){
		System.out.println("test3ִ�в��ԡ�");
	}

}
