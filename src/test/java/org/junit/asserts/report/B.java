package org.junit.asserts.report;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class B {
	
	@Test
	public void test11() {
		System.out.println("Test11");
	}
	@Ignore
	@Test
	public void test12() {
		Assert.assertTrue(true);
	}

	@Test
	public void test13() {
		String str="Hello";
		Assert.assertEquals(str, "Hello");
	}

	@Test
	public void test14() {
		Assert.assertTrue(false);
	}

}
