package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
	/*
	 * ���������������һ���쳣��ʱ�򣬱��紫���˲��Ϸ��Ĳ����������׳����쳣
	 * Ҳ����˵Ԥ�ڽ����������쳣
	 */

	//����һ�����Խ��ʧ�ܵ��쳣����
	@Test(expectedExceptions=RuntimeException.class)
	public void runTimeExceptionFailed(){
		System.out.println("����һ��ʧ�ܵ��쳣��������");
	}
	//����һ�����Խ���ɹ����쳣����
		@Test(expectedExceptions=RuntimeException.class)
		public void runTimeExceptionSuccess(){
			System.out.println("����һ���ɹ����쳣��������");
			throw new RuntimeException();
		}
	
}
