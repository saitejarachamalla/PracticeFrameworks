package com.rameshsoft.automation.appln.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDemo {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	
	//File file = new File("D:\\new10ambatch\\frameworks\\src\\com\\rameshsoft\\automation\\appln\\testdata\\TestData.xls");
	//FileInputStream fip = new FileInputStream(file);
	
	FileInputStream fip = new FileInputStream("D:\\new10ambatch\\frameworks\\src\\com\\rameshsoft\\automation\\appln\\testdata\\TestData.xls");
	
	Workbook workbook = WorkbookFactory.create(fip);
	
	//Sheet sheet = workbook.getSheetAt(0);
	Sheet sheet = workbook.getSheet("Gmail_Data");
	
	
	int totalRows = sheet.getLastRowNum();
	System.out.println("Total rows :"+totalRows);
	
	Row row0 = sheet.getRow(0);
	
	int totalCellCount = row0.getLastCellNum();
	System.out.println("0th row cell count is: "+totalCellCount);
	
	Cell cell00 = row0.getCell(0);
	
	String cell00Value = cell00.getStringCellValue();
	System.out.println(cell00Value);
	
	Cell cell01 = row0.getCell(1);
	String cell01Value = cell01.getStringCellValue();
	System.out.println(cell01Value);
	
	
	Row row1 = sheet.getRow(1);
	Cell cell10 = row1.getCell(0);
	String cell10Value = cell10.getStringCellValue();
	System.out.println(cell10Value);
	
	Cell cell11 = row1.getCell(1);
	String cell11Value = cell11.getStringCellValue();
	System.out.println(cell11Value);
	
	Row row2 = sheet.getRow(2);
	Cell cell20 = row2.getCell(0);
	//String cell20Value = cell20.getNumericCellValue()+"";
	if (cell20.getCellType() == Cell.CELL_TYPE_STRING) {
		String cell20Value = cell20.getStringCellValue();
		System.out.println(cell20Value);
	}
	else if (cell20.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
		boolean cell20Value = cell20.getBooleanCellValue();
		System.out.println(cell20Value);
	}
	else if (cell20.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		double cell20Value = cell20.getNumericCellValue();
		System.out.println(cell20Value);
	}

	
}
}
