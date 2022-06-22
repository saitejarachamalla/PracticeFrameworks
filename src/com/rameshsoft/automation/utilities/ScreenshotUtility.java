package com.rameshsoft.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rameshsoft.automation.base.BaseTest;

public interface ScreenshotUtility {

	public static String takeScreenshot() throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imagePath = System.getProperty("user.dir")+"\\Screenshots\\"+BaseTest.getTcName()+".jpeg";
		FileUtils.copyFile(file, new File(imagePath));
		return imagePath;
	}
	
	public static String takeScreenshot(String tcName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imagePath = System.getProperty("user.dir")+"\\Screenshots\\"+tcName+".jpeg";
		FileUtils.copyFile(file, new File(imagePath));
		return imagePath;
	}
	
	
}
