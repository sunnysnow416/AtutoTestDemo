package com.course.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SuiteConfig {
	
	@BeforeSuite
	public  void beforSuite() {
		System.out.println("beforSuite��������");
	}
	
	@AfterSuite
	public  void afterSuite() {
		System.out.println("afterSuite��������");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest��������");
		
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("afterTest��������");
		
	}
}
