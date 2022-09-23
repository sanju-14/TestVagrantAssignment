package com.rcb.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestListener implements ITestListener
{

	public static int executionCount, passCount, failCount, skipCount=0;

	
	public void onFinish(ITestContext context) {
		Reporter.log("Framework execution ends", true);
		Reporter.log("Total Scripts executed: "+executionCount , true);
		Reporter.log("Total Scripts passed: "+passCount , true);
		Reporter.log("Total Scripts failed: "+failCount , true);
		Reporter.log("Total Scripts skipped: "+skipCount , true);
	}

	
	public void onStart(ITestContext context) {
		Reporter.log("Framework execution starts: "+new Date(), true);
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}


	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+ " script is failed", true);
		
		TakesScreenshot ts=(TakesScreenshot) Baselib.driver;
		
		           File  srcFile=ts.getScreenshotAs(OutputType.FILE);
		           
		    File destFile=new File("./screenshots/"+result.getName()+ ".png");
		    
		    try
		    {
		    	Files.copy(srcFile, destFile);
		    }
		    
		    catch (IOException e)
		    {
		    	e.printStackTrace();
		    }
		    Reporter.log("Screenshot has been taken", true);
	}


	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName()+ " script is skipped", true);
	}

	
	public void onTestStart(ITestResult result) {
		
		executionCount++;
		Reporter.log(result.getName()+ "script execution starts: "+new Date(), true);
	}

	
	public void onTestSuccess(ITestResult result) {
		
		passCount++;
		Reporter.log(result.getName()+ " script is passed", true);
		
	}
	
	
}
