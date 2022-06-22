package com.rameshsoft.automation.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.rameshsoft.automation.utilities.ScreenshotUtility;

public class TestCaseActivity implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Suite execution is completed");
	}
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Suite execution is started");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
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
	public void onTestStart(ITestResult arg0) {
		System.out.println("TestCase is started: "+arg0.getName());
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("TestCase is success: "+arg0.getName());
	}
	
}
