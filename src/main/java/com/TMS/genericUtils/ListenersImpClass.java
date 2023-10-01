package com.TMS.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.implementation.bind.MethodNameEqualityResolver;

public class ListenersImpClass implements ITestListener{
	
ExtentReports report;
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---> Execution starts ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---> Passed");
		Reporter.log(methodName+"---> TestScript executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getMethod().getMethodName();
		System.out.println(name+" got failed");
		WebdriverUtility libW=new WebdriverUtility();
		libW.takeScreenShot(BaseClass.Sdriver,name);
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, name+"---> Failed");
		Reporter.log(name+"---> TestScript Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methosName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methosName+"---> Skipped");
		Reporter.log(methosName+"---> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("com.TMS");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Tourism Management System");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "windows-8.1 pro");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		report.setSystemInfo("Reporter Name", "Sinchana S.J");
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
