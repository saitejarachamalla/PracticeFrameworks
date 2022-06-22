package com.rameshsoft.automation.appln.businessscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.utilities.PojoUtility;
import com.relevantcodes.extentreports.LogStatus;

public class InstTest extends BaseTest{

	@Test
	public void instTest() throws IOException {
		//BaseTest.getDriver().get("https://www.rameshsoft.com");
		
	
		String url = PojoUtility.getPrConfObj().getPropertyValue("inst_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS, "URL is entered as : "+url);
	}
	
}
