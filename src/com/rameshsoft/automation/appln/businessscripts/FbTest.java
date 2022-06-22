package com.rameshsoft.automation.appln.businessscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.utilities.PojoUtility;
import com.relevantcodes.extentreports.LogStatus;

public class FbTest extends BaseTest{

	@Test
	public void fbTest() throws IOException {
		String url = PojoUtility.getPrConfObj().getPropertyValue("fb_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS, "URL is entered as : "+url);
	}
	
}
