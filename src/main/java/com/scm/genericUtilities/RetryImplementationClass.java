package com.scm.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer
{
	int count=0;
	int retry=3;

	@Override
	public boolean retry(ITestResult arg0) {
		if(count<retry)
		{
			count++;
			return true;
		}
		return false;
	}
}
