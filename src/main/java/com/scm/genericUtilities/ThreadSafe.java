package com.scm.genericUtilities;

public class ThreadSafe {

	private static ThreadLocal<WebDriverUtility> webDriverUtility=new ThreadLocal<>();
	
	public static WebDriverUtility getWebdriverutility()
	{
		return webDriverUtility.get();
	}
	
	public static void setWebdriverutility(WebDriverUtility swebDriverUtility)
	{
		webDriverUtility.set(swebDriverUtility);
	}
}
