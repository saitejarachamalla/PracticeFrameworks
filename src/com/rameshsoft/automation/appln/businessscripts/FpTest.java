package com.rameshsoft.automation.appln.businessscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;

public class FpTest extends BaseTest{

	@Test
	public void fpTest() throws InterruptedException {
		getDriver().get("https://www.flipkart.com");
		//getDriver().findElement(By.id("456")).click();
		Thread.sleep(9000);
		
		WebElement electronics = getDriver().findElement(By.xpath("//div[@class='xtXmba'][text()='Electronics']"));
		
		Actions actions = new Actions(getDriver());
		actions.moveToElement(electronics).build().perform();
		Thread.sleep(2000);
		
		WebElement gaming = getDriver().findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[5]"));
		actions.moveToElement(gaming).build().perform();
		
		Thread.sleep(9000);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
