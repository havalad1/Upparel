package com.scm.genericUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterPractice {

	public static void main(String[]args)
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("document title");
		spark.config().setReportName("reporter name");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows 10");
		report.setSystemInfo("browser name", "chrome");
		report.setSystemInfo("browser version", "107");
		report.setSystemInfo("reporter name", "shankar");
		
		ExtentTest test1 = report.createTest("test1");
		test1.info("this information coming from script");
		test1.warning("warning message");
		test1.fail("test1 fail");
		
		report.flush();
	}
}
