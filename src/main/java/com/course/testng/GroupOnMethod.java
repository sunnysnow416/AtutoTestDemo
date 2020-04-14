package com.course.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
	
	@Test(groups="server")
	public void test1(){
		System.out.println("���Ƿ������Ĳ��Է���111��");
	}

	@Test(groups="server")
	public void test2(){
		System.out.println("���Ƿ������Ĳ��Է���222��");
	}
	
	@Test(groups="client")
	public void test3(){
		System.out.println("���ǿͻ�����Ĳ��Է���333��");
	}
	
	@Test(groups="client")
	public void test4(){
		System.out.println("���ǿͻ�����Ĳ��Է���444��");
	}
	
	@BeforeGroups("server")
	public void berforeGroupsOnServer(){
		System.out.println("���Ƿ����������֮ǰ���еķ���");
	}
	
	@AfterGroups("server")
	public void afterGroupsOnServer(){
		System.out.println("���Ƿ����������֮�����еķ���������");
	}

}
