package com.scm.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass_1 implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"on Test Success -------> test1");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"on Test Failure -------> test1");
		ThreadSafe.getWebdriverutility().takescreenshot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"on Test Skipped -------> test1");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailedButWithinSuccessPercentage");
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"on Start -------> test1");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"on Finish -------> test1");
	}
}
