/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing Implementations of ITestListner
 */
package com.swaglabsmobileapp.common;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ReportListner implements ITestListener {

	/**
	 * @author sunil_s
	 * @description Implementation of onFinish ITestListner Method
	 */
	public void onFinish(ITestContext context) {

		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getPassedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			} else if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			}
		}

		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
		for (ITestResult temp : skippedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getPassedTests().getResults(method).size() > 0
					|| context.getFailedTests().getResults(method).size() > 0) {
				skippedTests.remove(temp);
			} else if (context.getSkippedTests().getResults(method).size() > 1) {
				skippedTests.remove(temp);
			}
		}
		Set<ITestResult> failedConfigs = context.getFailedConfigurations().getAllResults();
		failedConfigs.clear();

		Set<ITestResult> skippedConfigs = context.getSkippedConfigurations().getAllResults();
		skippedConfigs.clear();
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

}
