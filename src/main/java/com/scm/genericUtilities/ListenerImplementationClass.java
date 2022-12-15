package com.scm.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		System.out.println("execution starts from here");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		DateTimeFormatter dff=DateTimeFormatter.ofPattern("dd-mm-yyyy_hh mm ss");
		LocalDateTime now=LocalDateTime.now();
		String dateandtime = dff.format(now);
		String testName = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(StartClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./photo/"+ testName +"_"+" "+dateandtime+"" + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("execution ends here ");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub	
	}
}
