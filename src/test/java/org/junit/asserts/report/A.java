package org.junit.asserts.report;

import org.junit.Assert;
import org.junit.Test;

public class A {
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}

	@Test
	public void test2() {
		Assert.assertTrue(true);
	}

	@Test
	public void test3() {
		String str="Hello";
		Assert.assertEquals(str, "Hello");
	}

	@Test
	public void test4() {
		Assert.assertTrue(false);
	}

}
