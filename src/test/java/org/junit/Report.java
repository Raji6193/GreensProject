package org.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Report {
	
	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(JunitTest.class);
		System.out.println("Failure Count "+r.getFailureCount());
		System.out.println("Run Count "+r.getRunCount());
		int passCount=r.getRunCount()-r.getFailureCount();
		System.out.println("Pass Count " +passCount);		
	}
}
