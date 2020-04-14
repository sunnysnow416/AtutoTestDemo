package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
	/*
	 * 当我们期望结果是一个异常的时候，比如传入了不合法的参数，程序抛出了异常
	 * 也就是说预期结果就是这个异常
	 */

	//这是一个测试结果失败的异常测试
	@Test(expectedExceptions=RuntimeException.class)
	public void runTimeExceptionFailed(){
		System.out.println("这是一个失败的异常测试用例");
	}
	//这是一个测试结果成功的异常测试
		@Test(expectedExceptions=RuntimeException.class)
		public void runTimeExceptionSuccess(){
			System.out.println("这是一个成功的异常测试用例");
			throw new RuntimeException();
		}
	
}
