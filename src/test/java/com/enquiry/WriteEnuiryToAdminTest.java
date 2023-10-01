package com.enquiry;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WriteEnuiryToAdminTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int lastRow= sh.getLastRowNum();
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fi);
		WebDriver driver = null;
		String BROWSER=p.getProperty("Browser");
		String URL=p.getProperty("url");
		String UN=p.getProperty("adminId");
		String PWD=p.getProperty("adminPwd");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Input");
		}
		driver.get(URL);
		driver.manage().window().maximize();
		String actualText="Enquiry Successfully submited";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(.,' Enquiry ')]")).click();
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=lastRow;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}
	/*	driver.findElement(By.id("fname")).sendKeys("ABC");
		driver.findElement(By.id("email")).sendKeys("Abc@gmail.com");
		driver.findElement(By.id("mobileno")).sendKeys("9874563210");
		driver.findElement(By.id("subject")).sendKeys("Regarding package");
		driver.findElement(By.id("description")).sendKeys("Need more facilities");*/
		driver.findElement(By.xpath("//button[@name='submit1']")).click();
		Thread.sleep(5000);
		String expText=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(expText.contains(actualText)) {
			System.out.println("Enquiry Submitted");
		}
		else {
			System.out.println("Enquiry not Submitted");
		}
		
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		
		driver.findElement(By.xpath("//a[@href='manage-enquiry.php']")).click();
		//driver.close();
		
	}
}
