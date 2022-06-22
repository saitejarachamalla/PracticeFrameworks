package com.rameshsoft.automation.appln.businessscripts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;

public class PopupTest extends BaseTest{

	@Test
	public void popUpTest() throws InterruptedException, IOException {
		
		getDriver().get("file:///C:/Users/RAMESHSOFT/Desktop/alerts4/WindowUploadfile.html");
		getDriver().findElement(By.id("1")).click();
		
		Runtime.getRuntime().exec("D:\\new10ambatch\\frameworks\\Popups\\popup.exe");
		
		
		
		
		
		//getDriver().findElement(By.id("1")).sendKeys("C:\\Users\\RAMESHSOFT\\Desktop\\IQ.txt");
		
		/*getDriver().get("file:///C:/Users/RAMESHSOFT/Desktop/alerts4/prompt.html");
		getDriver().findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
		Thread.sleep(2000);
		
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys("javaselenium");
		String alertText = alert.getText();
		System.out.println(alertText);
		
		alert.accept();
		*/
		Thread.sleep(5000);
		
		
	}
	
}
