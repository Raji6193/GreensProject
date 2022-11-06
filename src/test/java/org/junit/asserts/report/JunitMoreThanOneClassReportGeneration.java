package org.junit.asserts.report;

import java.util.List;

import org.checkerframework.checker.units.qual.A;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitMoreThanOneClassReportGeneration {
	
	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(A.class,B.class);
		System.out.println(r.getFailureCount());
		System.out.println(r.getRunCount());
		System.out.println(r.getIgnoreCount());
		int passCount=r.getRunCount()-r.getFailureCount();
		System.out.println(passCount);
		
		List<Failure> failures = r.getFailures();
		for (Failure failure : failures) {
			System.out.println(failure);
		}
		
	}

}
