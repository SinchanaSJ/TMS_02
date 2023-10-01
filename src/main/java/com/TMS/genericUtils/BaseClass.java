package com.TMS.genericUtils;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.ObjectRepo.WelcomePage;

//import com.Sales.ObjectRepo.HomePage;
//import com.Sales.ObjectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	public DatabaseUtility dLib=  new DatabaseUtility();
	public static WebDriver Sdriver;

	@BeforeSuite(alwaysRun = true)
	public void confgBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("----to connect database----");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass (alwaysRun = true)
	public void confgBC() throws Throwable {
		
		
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		if(BROWSER.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else 
			System.out.println("Invalid Input");
		Sdriver=driver;
		
		wLib.maximizeTheBrowser(driver);

		wLib.implicitWait(driver, 10);
		
		System.out.println("----open the browser----");
	}
	
	@BeforeMethod (alwaysRun = true)
	public void confgBM() throws Throwable {
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		String PWD=fLib.getPropertyKeyValue("adminPwd");
		String UN=fLib.getPropertyKeyValue("adminId");
		
		driver.get(URL);
		
		/*AdminLoginPage lp=new AdminLoginPage(driver);
		lp.adminLogin(UN, PWD);
		System.out.println("----login to appl----");*/
	}
	
/*	@AfterMethod(alwaysRun = true)
	public void confgAM() {
		WelcomePage hp=new WelcomePage(driver);
		hp.adminLogOut(driver);
		System.out.println("---logout from the appl----");
	}*/

	@AfterClass(alwaysRun = true)
	public void confgAC() {
		driver.quit();
		System.out.println("---close the broswer---");
	}
	
	@AfterSuite(alwaysRun = true)
	public void confgAS() throws Throwable {
		dLib.closeDB();
		System.out.println("---Disconnect the database---");
	}
	
	
}
