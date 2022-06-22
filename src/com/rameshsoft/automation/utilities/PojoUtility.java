package com.rameshsoft.automation.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.rameshsoft.automation.supporters.ExcelReader;
import com.rameshsoft.automation.supporters.PropertiesReader;
import com.rameshsoft.automation.supporters.TextReader;

public class PojoUtility {

	public static PropertiesReader getPrConfObj() throws IOException
	{
		PropertiesReader prConf = new PropertiesReader(FilePaths.confPath);
		return prConf;
	}
	
	public static PropertiesReader getPrOrObj() throws IOException
	{
		PropertiesReader prOr = new PropertiesReader(FilePaths.orPath);
		return prOr;
	}
	
	public static ExcelReader getExcelObj() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader = new ExcelReader(FilePaths.excelPath);
		return excelReader;
	}
	
	public static TextReader getTextObj() throws IOException
	{
		TextReader textReader = new TextReader(FilePaths.txtPath);
		return textReader;
	}
	
}
