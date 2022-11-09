package org.testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NormalFlow {
	@BeforeClass
	private void beforeClass() {
		System.out.println("Launch Browser");
	}
	
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Start Time");
	}
	
	@Test
	private void Test() {
		System.out.println("Test");
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("End Time");
	}
	
	@AfterClass
	private void afterClass() {
		System.out.println("Quit Browser");
	}

}
