package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	public void configureReport() {
		Readconfig readconfig=new Readconfig(); 
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName="MyStoreTestReport-"+timestamp+".html";
		 htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		 report=new ExtentReports();
		 report.attachReporter(htmlReporter);
		 
		 //add system information/environment info to report
		 
		 report.setSystemInfo("Machine:", "test pc1");
		 report.setSystemInfo("OS:", "Window10");
		 report.setSystemInfo("browser:", readconfig.getbrowser());
		 report.setSystemInfo("Host:", "QA");
		 report.setSystemInfo("User Name:", "Rinkesh");
		 
		 //Configuration to Change look and feel of Reports
		 
		 htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		 htmlReporter.config().setReportName("This is my first Report");
		 htmlReporter.config().setTheme(Theme.DARK);
		 
		 
	}

	public void onStart(ITestContext Result) {

		configureReport();
		System.out.println("On Start method is invoked");
	}


	public void onFinish(ITestContext Result) {

		System.out.println("On finish method is invoked");
		report.flush();
		
	}


	public void onTestFailure(ITestResult Result) {

		System.out.println("Name of Test  method Failed:" + Result.getName());
		test=report.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+Result.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+Result.getName()+".png";
		File screenshotfile=new File(screenshotpath);
		if(screenshotfile.exists())
		{
			test.fail("captured screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
			
		}
		
		
	}


	public void onTestSkipped(ITestResult Result) {

		System.out.println("Name of Test  method Skipped:" + Result.getName());
		
		test=report.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is: "+Result.getName(), ExtentColor.YELLOW));
		
	}


	public void onTestStart(ITestResult Result) {

		System.out.println("Name of Test  method Started:" + Result.getName());
	}

	public void onTestSuccess(ITestResult Result) {

		System.out.println("Name of Test  method Successfully executed:" + Result.getName());
		
		test=report.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is: "+Result.getName(), ExtentColor.GREEN));
		
	}

	public void OnTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}









}
