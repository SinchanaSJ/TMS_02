package com.tms;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;

public class VerifyAdminLoginTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		
//		Properties p = new Properties();
//		p.load(fis);
		
		
		WebDriver driver =null;
		String BROWSER=libF.getPropertyKeyValue("Browser");
		String URL=libF.getPropertyKeyValue("url");
		String UN=libF.getPropertyKeyValue("adminId");
		String PWD=libF.getPropertyKeyValue("adminPwd");
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
		libW.maximizeTheBrowser(driver);
		libW.implicitWait(driver, 10);
		AdminLoginPage al=new AdminLoginPage(driver);
		al.adminLogin(UN, PWD);
		/*driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();*/
		driver.close();
		
	}
}
