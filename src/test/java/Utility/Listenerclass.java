package Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.basemethod;

public class Listenerclass extends basemethod implements ITestListener {
	ExtentReports reports=Extentreports.getreport();
	ExtentTest test;
	private String browsername;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		Test testannotation=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
		ITestContext context = result.getTestContext();
		browsername = context.getCurrentXmlTest().getParameter("browser"); 
		if(testannotation!=null) {
			String testname=result.getMethod().getMethodName();
			String testdescription=testannotation.description();
			
			test=reports.createTest(testname).assignAuthor("Harini").assignDevice(browsername);
			
			test.log(Status.INFO,"Description : "+testdescription);
		}else {
			test=reports.createTest("Unknown").assignAuthor("Unknown").assignDevice("Chrome");
		}
		test.log(Status.PASS,"Test Started : "+result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed : "+result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	    
	    test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	    
	    String filepath = null;
	    try {
	        filepath = takeScreenshot(result.getMethod().getMethodName(),browsername);
	        System.out.println(filepath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped"+result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL,"on Test Failed But Within Success Percentage :"+result.getMethod().getMethodName());
	}
	
//	@Override
//	public void onStart(ITestContext context) {
//		test.log(Status.INFO, "test Started : "+context.getName());
//	}
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
  
}
