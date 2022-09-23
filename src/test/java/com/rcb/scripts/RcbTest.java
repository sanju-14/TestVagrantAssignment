package com.rcb.scripts;

import com.rcb.constants.Iconstant;
import com.rcb.generic.ExtentReport;
import com.rcb.generic.Generic;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

/**
 *
 * contains test cases related to RCB Team
 * September 24, 2022
 *
 * @author Sanjay Kumar Gond
 *
 *
 * 
 */
public class RcbTest extends ExtentReport {
	
	

	Generic gr = new Generic();
	
	@Test(priority=1, description = "Validation of 4 foreign players in playing 11")
	public void verifyForeignPlayerCountTest(Method m) {

		int countryCount = gr.getCountryCount(Iconstant.COUNTRYNAME);

		Assert.assertEquals(countryCount, Iconstant.FOREIGNPLAYERCOUNT,
				"Include only " + Iconstant.FOREIGNPLAYERCOUNT + " foreign players in playing 11");

		Reporter.log(m.getName() + " is passed", true);
		
		
	}

	@Test(priority=2, description = "Validation of at least one wicket-keeper in playing 11")
	public void verifyWicketKeeperCountTest(Method m) {

		int roleCount = gr.getRoleCount(Iconstant.ROLE);
		Assert.assertTrue(roleCount >= 1, "Add atleast one wicket-keeper in playing 11");
	
		Reporter.log(m.getName() + " is passed", true);
	}
	
	


}
	

