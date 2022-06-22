package com.rameshsoft.automation.appln.testdata;

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

public class ExcelLoopsDemo {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
FileInputStream fip = new FileInputStream("D:\\new10ambatch\\frameworks\\src\\com\\rameshsoft\\automation\\appln\\testdata\\TestData.xls");
	
	Workbook workbook = WorkbookFactory.create(fip);
	
	//Sheet sheet = workbook.getSheetAt(0);
	Sheet sheet = workbook.getSheet("Gmail_Data");
	
	for(int i=0; i<=sheet.getLastRowNum(); i++)
	{
		Row row = sheet.getRow(i);
		for(int j=0; j<row.getLastCellNum(); j++)
		{
			Cell cell = row.getCell(j);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				String cellValue = cell.getBooleanCellValue()+"";
				System.out.println(cellValue);
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				String cellValue = cell.getNumericCellValue()+"";
				System.out.println(cellValue);
			}
		}
	}
		
}
}
