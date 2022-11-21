package org.testng.parallelExecution;

import org.testng.annotations.Test;

public class B {

	@Test
	private void test12() {
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	private void test22() {
		System.out.println(Thread.currentThread().getId());
	}
}
