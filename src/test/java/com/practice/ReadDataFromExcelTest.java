package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		public static void main(String[] args) throws Throwable {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Organization");
			int count=sh.getLastRowNum();
			int lastCell = sh.getRow(1).getLastCellNum();
			System.out.println(count+" "+lastCell);
			for (int i = 1; i <=count; i++) {
				for (int j = 0; j < lastCell ; j++) {
					String value=sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(value+"  ");
				}
				System.out.println();
				
			}
		}
}
