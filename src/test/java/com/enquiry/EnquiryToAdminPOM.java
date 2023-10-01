package com.enquiry;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.EnquiryPage;
import com.TMS.ObjectRepo.SigInPage;
import com.TMS.ObjectRepo.WriteUsPage;
import com.TMS.genericUtils.BaseClass;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;

public class EnquiryToAdminPOM extends BaseClass{
	@Test(groups = "Regression")
	public void enquiryToAdminPOM() throws InterruptedException, Throwable {
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		
		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Sheet2");
//		int lastRow= sh.getLastRowNum();
		int lastRow=libE.getRowCount("Sheet2");
		
//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties p = new Properties();
//		p.load(fi);
		
		//WebDriver driver = null;
		String BROWSER=libF.getPropertyKeyValue("Browser");
		String URL=libF.getPropertyKeyValue("url");
		String UN=libF.getPropertyKeyValue("adminId");
		String PWD=libF.getPropertyKeyValue("adminPwd");
		String UName=libF.getPropertyKeyValue("username");
		String Password=libF.getPropertyKeyValue("password");
		
	/*	if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Input");
		}
		driver.get(URL);*/
		
		//driver.manage().window().maximize();
		libW.maximizeTheBrowser(driver);
		String actualText="SUCCESS:Enquiry Successfully submited";
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		libW.implicitWait(driver, 10);
		driver.findElement(By.xpath("//a[contains(.,' Enquiry ')]")).click();
		
//		HashMap<String, String> map=new HashMap<String, String>();
//		for(int i=0;i<=lastRow;i++) {
//			String key=sh.getRow(i).getCell(0).getStringCellValue();
//			String value=sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
//		
//		for(Entry<String, String> s:map.entrySet()) {
//			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
//		}
		 HashMap<String, String> map = libE.getMultipleDataFromExcel("Sheet2", 0, 1, driver);
		 EnquiryPage ep=new EnquiryPage(driver);
		 ep.writeEnquiry(map, driver, actualText);
		 
	/*	driver.findElement(By.id("fname")).sendKeys("ABC");
		driver.findElement(By.id("email")).sendKeys("Abc@gmail.com");
		driver.findElement(By.id("mobileno")).sendKeys("9874563210");
		driver.findElement(By.id("subject")).sendKeys("Regarding package");
		driver.findElement(By.id("description")).sendKeys("Need more facilities");
		driver.findElement(By.xpath("//button[@name='submit1']")).click();
		Thread.sleep(5000);
		String expText=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(expText.contains(actualText)) {
			System.out.println("Enquiry Submitted");
		}
		else {
			System.out.println("Enquiry not Submitted");
		}*/
		
		
		SigInPage si = new SigInPage(driver);
		si.userSignin(UName, Password);
		//driver.close();
		/*driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UName);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();*/
		Thread.sleep(2000);
		WriteUsPage wp = new WriteUsPage(driver);
		wp.writeUs("Booking Issues");
		/*driver.findElement(By.xpath("//a[.=' / Write Us ']")).click();
		Thread.sleep(3000);
		WebElement issues = driver.findElement(By.xpath("//select[@name='issue']"));
//		Select s=new Select(issues);
//		s.selectByVisibleText("Booking Issues");
		libW.selectDropDown("Booking Issues", issues);
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Unable to book the package");
		driver.findElement(By.xpath("//button[.='Submit']")).click();*/
	}
}
