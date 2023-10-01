package com.login;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.ObjectRepo.WelcomePage;
import com.TMS.genericUtils.BaseClass;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;
@Listeners(com.TMS.genericUtils.ListenersImpClass.class)
public class VerifyAdminLoginPOM extends BaseClass{

	/*static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}*/
	@Test(groups = "Smoke")
	public  void verifyAdminLoginPOM() throws EncryptedDocumentException, IOException {
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		
//	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
//	Properties p = new Properties();
//	p.load(fis);
		
		
		
		
		String UN=libF.getPropertyKeyValue("adminId");
		String PWD=libF.getPropertyKeyValue("adminPwd");
		
		AdminLoginPage al=new AdminLoginPage(driver);
		al.adminLogin(UN, PWD);
		//Assert.fail();
		/*driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();*/
		WelcomePage w = new WelcomePage(driver);
		w.adminLogOut(driver);
		
		//driver.close();
	
		System.out.println("VerifyAdminLoginPOM");
	}
}
