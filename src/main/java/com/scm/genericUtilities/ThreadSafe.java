package com.scm.genericUtilities;

import com.aventstack.extentreports.ExtentTest;
public class ThreadSafe {

	public static ThreadLocal<WebDriverUtility> webdriverutil=new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
public static WebDriverUtility   getwebdriverutility()
{
	return webdriverutil.get();
}

public static void setwebdriverutil(WebDriverUtility swebdriverutil)
{
	 webdriverutil.set(swebdriverutil);
	
}


public static ExtentTest   gettest()
{
	return test.get();
}


public static void settest(ExtentTest stest)
{
	test.set(stest);
	
}
}
