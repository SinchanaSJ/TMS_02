package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String details;
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of comapany to be added");
		int n=sc.nextInt();
		Sheet sh = wb.getSheet("Organization");
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(1).getLastCellNum();
		for (int i = lastRow; i < lastRow+n; i++) {
			for (int j = 0; j < lastCell; j++) {
				if(j==0) {
					System.out.println("Enter the company name");
					details=sc.nextLine();
					sh.createRow(i).createCell(j).setCellValue(details);
				}
				else if(j==1) {
					System.out.println("Enter location");
					details=sc.nextLine();
					sh.getRow(i).createCell(j).setCellValue(details);
				}
				else {
					System.out.println("Enter contact");
					details=sc.nextLine();
					sh.getRow(i).createCell(j).setCellValue(details);
				}
				System.out.println();
			}
			
		}
		System.out.println("Data added successfully");
		/*sh.createRow(6).createCell(0).setCellValue("TCS");
		sh.getRow(6).createCell(1).setCellValue("Noida");
		sh.getRow(6).createCell(2).setCellValue("24");*/
		FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
		wb.write(fout);
	}

}
