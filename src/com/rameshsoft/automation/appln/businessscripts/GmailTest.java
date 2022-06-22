package com.rameshsoft.automation.appln.businessscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseTest;
import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.PojoUtility;
import com.relevantcodes.extentreports.LogStatus;

public class GmailTest extends BaseTest{

	@Test
	public void gmailTest() throws IOException, EncryptedDocumentException, InvalidFormatException, FrameworkException {
		
		String unData = "";
		
		unData = PojoUtility.getExcelObj().getCellData("sheetName", "gmail_data", 0, 0);
		
		String url = PojoUtility.getPrConfObj().getPropertyValue("qa_url");
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS, "URL is entered as : "+url);
		
		String un_id = PojoUtility.getPrOrObj().getPropertyValue("un_id");
		String nxt_id = PojoUtility.getPrOrObj().getPropertyValue("nxt_id");
		WebElement userName = getDriver().findElement(By.id(un_id));
		userName.clear();
		getExtentTest().log(LogStatus.PASS, "Username element is cleared");
		
		userName.sendKeys(unData);
		getExtentTest().log(LogStatus.PASS, "Data typing action is done on username with test data: "+unData);
		WebElement nxt = getDriver().findElement(By.id(nxt_id));
		nxt.click();
		getExtentTest().log(LogStatus.PASS, "Clicked on next button");
		
	}
	
}
