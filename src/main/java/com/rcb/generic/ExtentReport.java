package com.rcb.generic;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	@Test
	public void colorreports()
	
	{
		ExtentReports reports=new ExtentReports("./reports/extentreports.html", false);
		ExtentTest test = reports.startTest("RCB testcases");
		
		test.log(LogStatus.PASS, "testcase is passed");

		
		reports.endTest(test);
		
		reports.flush();
							
		
	}

}
