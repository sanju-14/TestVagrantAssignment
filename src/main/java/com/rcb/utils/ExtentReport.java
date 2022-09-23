package com.rcb.utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	@Test
	public void colorreports()
	{
		ExtentReports reports=new ExtentReports("./reports/extentreports.html", false);
		
		ExtentTest test = reports.startTest("RCB Team Testcases");
		
		test.log(LogStatus.PASS, "tc is passed");
		test.log(LogStatus.FAIL, "tc is failed");
		test.log(LogStatus.SKIP, "tc is skipped");
		
		reports.endTest(test);
		
		reports.flush();
							
		
	}

}
