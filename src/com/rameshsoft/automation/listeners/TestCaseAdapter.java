package com.rameshsoft.automation.listeners;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.rameshsoft.automation.utilities.ScreenshotUtility;

public class TestCaseAdapter extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TestCase is failed: "+arg0.getName());
		try {
			ScreenshotUtility.takeScreenshot(arg0.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("TestCase is skipped: "+arg0.getName());
		try {
			ScreenshotUtility.takeScreenshot(arg0.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TestCase is success: "+arg0.getName());
	}
	
}
