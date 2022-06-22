package com.rameshsoft.automation.reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsDemo {
public static void main(String[] args) {
	
	
	
	
	
	
	
	
	ExtentReports extentReports = new ExtentReports("D:\\new10ambatch\\frameworks\\Reports\\report.html");
	Map<String, String> map = new HashMap<String,String>();
	map.put("name", "RAESHSOFT");
	map.put("user", "ramesh");
	map.put("target", "job");
	
	extentReports.addSystemInfo(map);
	//ExtentTest extentTest = extentReports.startTest("gmail","demo");
	ExtentTest extentTest = extentReports.startTest("gmail");
	
	extentTest.log(LogStatus.PASS, "Browser is opened");
	extentTest.log(LogStatus.PASS, "Entered url as: www.gmail.com");
	extentTest.log(LogStatus.PASS, "DTA is done on username with testdata: rameshsoft.9177791456@gmail.com");
	extentTest.log(LogStatus.PASS, "Browser is closed");
	
	extentReports.endTest(extentTest);
	extentReports.flush();
	extentReports.close();
	
	
	
	
	
	
	
	
	
}
}
