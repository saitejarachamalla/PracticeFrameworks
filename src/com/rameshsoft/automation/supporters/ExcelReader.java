package com.rameshsoft.automation.supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;

public class ExcelReader {

	private String filePath;
	private FileInputStream fileInputStream;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String cellValue;
	
	
	public ExcelReader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		this.filePath = filePath;
		fileInputStream = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(fileInputStream);
	}
	
	public Sheet getSheetObj(String how,String howValue) throws FrameworkException {
		if (workbook!=null) {
			if (how.equalsIgnoreCase("sheetname")) {
				sheet = workbook.getSheet(howValue);
			}
			else if (how.equalsIgnoreCase("index")) {//"0" ====> 0
				int index = Integer.parseInt(howValue);
				sheet = workbook.getSheetAt(index);
			}
		}
		else {
			//throw exception
			System.out.println("WORKBOOK IS POINTING TO NULL");
			FrameworkException exception = new FrameworkException("WORKBOOK IS POINTING TO NULL");
			throw exception;
		}
		return sheet;
	}
	
	
	public int getRowsCountFromSheet(String how,String howValue) throws FrameworkException {
		sheet = getSheetObj(how, howValue);
		int rowCount = 0;
		
		if (sheet!=null) {
			rowCount = sheet.getLastRowNum();
		}
		else {
			//throw exception
			System.out.println("SHEET IS POINTING TO NULL");
		}
		return rowCount;
	}
	
	public int getCellsCountFromSheet(String how,String howValue,int rowNum) throws FrameworkException {
		sheet = getSheetObj(how, howValue);
		int cellCount = 0;
		
		if (sheet!=null) {
			row = sheet.getRow(rowNum);
			cellCount = row.getLastCellNum();
		}
		else {
			//throw exception
			System.out.println("SHEET IS POINTING TO NULL");
		}
		return cellCount;
	}
	
	public String getCellData(String how,String howValue,int rowNum,int cellNum) throws FrameworkException {
		sheet = getSheetObj(how, howValue);
		cell = sheet.getRow(rowNum).getCell(cellNum);
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			cellValue = cell.getStringCellValue();
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cellValue = cell.getNumericCellValue()+"";
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			cellValue = cell.getBooleanCellValue()+"";
		}
		return cellValue;
	}
	
	public List<String> getRowData(String how,String howValue,int rowNum) throws FrameworkException {
		List<String> rowData = new ArrayList<String>();
		sheet = getSheetObj(how, howValue);
		row = sheet.getRow(rowNum);
		if (row!=null) {
			for(int i=0; i<row.getLastCellNum();i++)
			{
				cell = row.getCell(i);
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					cellValue = cell.getStringCellValue();
					rowData.add(cellValue);
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					cellValue = cell.getNumericCellValue()+"";
					rowData.add(cellValue);
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					cellValue = cell.getBooleanCellValue()+"";
					rowData.add(cellValue);
				}
			}
		}
		else {
			//throw exception
			System.out.println("ROW IS POINTING TO NULL");
		}
		return rowData;
	}
	
	public List<String> getSheetData(String how,String howValue) throws FrameworkException {
		List<String> sheetData = new ArrayList<String>();
		sheet = getSheetObj(how, howValue);
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				cell = row.getCell(j);
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					cellValue = cell.getStringCellValue();
					sheetData.add(cellValue);
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					cellValue = cell.getNumericCellValue()+"";
					sheetData.add(cellValue);
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					cellValue = cell.getBooleanCellValue()+"";
					sheetData.add(cellValue);
				}
			}
		}
		return sheetData;
	}
	
	public Set<String> getUniqueSheetData(String how,String howValue) throws FrameworkException {
		List<String> listSheetData = getSheetData(how, howValue);
		Set<String> setSheetData = new HashSet<String>(listSheetData);
		return setSheetData;
	}
	
}
