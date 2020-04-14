package com.course.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotation {
	
	@Test
	public void testCase1(){
		System.out.println("第1个测试用例");
	}
	
	@Test
	public void testCase2(){
		System.out.println("第2个测试用例");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("beforeMethod在测试方法之前运行");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("afterMethod在测试方法之后运行");
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("beforeClass在测试类之前运行");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass在测试类之后运行");
	}

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuite测试套件");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite测试套件");
	}
}
