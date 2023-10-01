package com.TMS.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Admin
 *
 */
public class ExcelUtility extends JavaUtility{
	/**
	 * This method is to read data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNo, int cellNo ) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		 Cell cell = row.getCell(cellNo);
		 String data=cell.toString();
		 return data;
	}
	/**
	 * This method is to write data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		 Cell cell = row.createCell(cellNo);
		 cell.setCellValue(value);
		 
		 FileOutputStream fout = new FileOutputStream(IPathConstants.excelPath);
		 wb.write(fout);
		 wb.close();
	}
	/**
	 * This method is to get the count of the row in excel file
	 * @param sheetName
	 * @param rowNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn,WebDriver driver) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}
	public HashMap<String, String> getMultipleDataFromExcelByXpath(String sheetName, int keyColumn, int valueColumn,WebDriver driver) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
