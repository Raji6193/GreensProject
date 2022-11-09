package org.testng.practice;

import org.testng.annotations.Test;

public class TestNGEnabledAndInvocationCount {
	
	@Test(enabled =false)
	private void Test1() {
		System.out.println("Test1");
	}
	
	@Test(priority = 5)
	private void Test2() {
		System.out.println("Test2");
	}
	
	@Test(invocationCount = 5)
	private void Test3() {
		System.out.println("Test3");
	}
	
	@Test
	private void Test4() {
		System.out.println("Test4");
	}
	
	@Test(priority = -5)
	private void Test5() {
		System.out.println("Test5");
	}

}
