package com.course.testng;

import org.testng.annotations.Test;

@Test(groups ="teacher")
public class GroupsOnClass3 {
	public void teacher1() {
		System.out.println("GroupsOnClass3中teacher1运行");	
	}
	
	public void teacher2() {
		System.out.println("GroupsOnClass3中teacher2运行");	
	}

}
