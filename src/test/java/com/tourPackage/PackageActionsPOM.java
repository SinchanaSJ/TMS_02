package com.tourPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.ObjectRepo.BookPackagePage;
import com.TMS.ObjectRepo.ConfirmBookingPage;
import com.TMS.ObjectRepo.CreatePackagePage;
import com.TMS.ObjectRepo.SigInPage;
import com.TMS.ObjectRepo.WelcomePage;
import com.TMS.ObjectRepo.WriteUsPage;
import com.TMS.ObjectRepo.modifyPackagePage;
import com.TMS.genericUtils.BaseClass;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;

public class PackageActionsPOM extends BaseClass {

	@Test(groups = "Smoke")
	public void packageActionsPOM() throws InterruptedException, IOException {
		
				
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		
		WelcomePage w = new WelcomePage(driver);
		String BROWSER=libF.getPropertyKeyValue("Browser");
		String URL=libF.getPropertyKeyValue("url");
		String UN=libF.getPropertyKeyValue("adminId");
		String PWD=libF.getPropertyKeyValue("adminPwd");
		String UName=libF.getPropertyKeyValue("username");
		String Password=libF.getPropertyKeyValue("password");
		/*if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Input");
		}*/
		String actUpdate="SUCCESS:Package Updated Successfully";
		String actWrite="Info successfully submited";
		//Actions a = new Actions(driver);
		/*driver.get(URL);

		libW.maximizeTheBrowser(driver);
		libW.implicitWait(driver, 10);*/
		String actualText="SUCCESS:Booked Successfully";
		String actCreate = "SUCCESS:Package Created Successfully";
		String actManage="SUCCESS:Booking Confirm successfully";
		SigInPage si = new SigInPage(driver);
		si.userSignin(UName, Password);
		/*driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UName);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();*/
		
		
	/*	driver.findElement(By.xpath("//a[contains(.,'Tour Packages')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=1']")).click();
		driver.findElement(By.xpath("//input[@name='fromdate']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='3']")).click();
		driver.findElement(By.xpath("//input[@name='todate']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='10']")).click();
		Thread.sleep(5000);
		WebElement comment = driver.findElement(By.xpath("//input[@name='comment']"));
		libW.mouseHoverOnElement(driver, comment);
		comment.sendKeys("Please Confirm the Bookings");
		driver.findElement(By.xpath("//button[.='Book']")).click();
		String expText = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		if(actualText.contains(expText)) {
			System.out.println("Tour Package Booked Successfully");
		}
		else {
			System.out.println("Tour Package not Booked");
		}*/
		
		BookPackagePage bp=new BookPackagePage(driver);
		bp.bookPackage(driver, "Please Confirm the Bookings");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		//w.userLogOut(driver);
		/*driver.findElement(By.xpath("//li[@class='sigi']/a")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();*/
		
		AdminLoginPage al=new AdminLoginPage(driver);
		al.adminLogin(UN, PWD);
		
		CreatePackagePage cp=new CreatePackagePage(driver);
		cp.createPackage(driver, "Chikmangaluru", "Family", "Chikmangaluru", "100", "Malnad Region", "Including all Expenses");
		/*driver.findElement(By.xpath("//a//span[.=' Tour Packages']")).click();
		driver.findElement(By.xpath("//a[@href='create-package.php']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("packagename")).sendKeys("Chikmangaluru");
		driver.findElement(By.id("packagetype")).sendKeys("Family");
		driver.findElement(By.id("packagelocation")).sendKeys("Chikmangaluru");
		driver.findElement(By.id("packageprice")).sendKeys("100");
		driver.findElement(By.id("packagefeatures")).sendKeys("Including all Expenses");
		driver.findElement(By.id("packagedetails")).sendKeys("Malnad Region");
		File f=new File(".\\src\\test\\resources\\nature-background-nawpic-11.jpg");
		String absPath = f.getAbsolutePath();
		driver.findElement(By.id("packageimage")).sendKeys(absPath);
				
		WebElement create = driver.findElement(By.xpath("//button[.='Create']"));
		libW.mouseHoverOnElement(driver, create);
		create.click();
		
		String ExpCreate = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actCreate.contains(ExpCreate)) {
			 System.out.println("Package Created Successfully");
		 }
		 else {
			 System.out.println("Package not Created");
		 }*/
		
		modifyPackagePage mp= new modifyPackagePage(driver);
		mp.modifyPkg(driver, "ALL EXPENSES ARE INCLUDED");
	/*	driver.findElement(By.xpath("//a//span[.=' Tour Packages']")).click();
		
		driver.findElement(By.xpath("//a[@href='manage-packages.php']")).click();
		driver.findElement(By.xpath("(//button[.='View Details'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("packagedetails")).clear();
		WebElement update = driver.findElement(By.id("packagedetails"));
		a.moveToElement(update).click().perform();
		update.sendKeys("ALL EXPENSES ARE INCLUDED");
		
		
		 WebElement but = driver.findElement(By.xpath("//button[.='Update']"));
		 a.moveToElement(but).click().perform();
		 //class=succWrap
		 String ExpUpdate = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		 
		 if(actUpdate.contains(ExpUpdate)) {
			 System.out.println("Package Updated Successfully");
		 }
		 else {
			 System.out.println("Package not Updated");
		 }*/
		 
		ConfirmBookingPage cb=new ConfirmBookingPage(driver);
		cb.confirmBooking(driver);
		/* driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
			Thread.sleep(6000);
			WebElement confirm = driver.findElement(By.xpath("//td[@data-th='Action ']/span[text()!='Cancelled']/../preceding-sibling::td[@data-th='Status ']/span[text()='Pending']/../following-sibling::td[@data-th='Action ']/span/a[.='Confirm']"));
			libW.mouseHoverOnElement(driver, confirm);
			//Alert al = driver.switchTo().alert();
			//al.accept();
			libW.acceptAlertPopup(driver);
			Thread.sleep(5000);
			String expManage=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			if(expManage.contains(actManage)) {
				System.out.println("Booking Confirmed");
			}
			else {
				System.out.println("Booking not Confirmed");
			}*/
			Thread.sleep(3000);
		WelcomePage w1 = new WelcomePage(driver);
			w1.adminLogOut(driver);
		//	driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		//	driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		//	driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
			
			si.userSignin(UName, Password);
			/*driver.findElement(By.xpath("//li[@class='sigi']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UName);
			driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
			driver.findElement(By.xpath("//li[@class='prnt']/a[.='My Tour History']")).click();*/
		
			WriteUsPage wu=new WriteUsPage(driver);
			wu.writeUs("Unable to book");
		
		/*	driver.findElement(By.xpath("//a[contains(.,' / Write Us ')]")).click();
			Thread.sleep(3000);
			WebElement issues = driver.findElement(By.xpath("//select[@name='issue']"));
			Select s=new Select(issues);
			s.selectByVisibleText("Booking Issues");
			driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Unable to book the package");
			driver.findElement(By.xpath("//button[.='Submit']")).click();
			Thread.sleep(3000);
			String expWrite = driver.findElement(By.xpath("//div[@class='con-top animated wow fadeInUp animated animated']/h4")).getText();
			//System.out.println(expWrite);
			if(actWrite.contains(expWrite)) {
				System.out.println("Issue has been Submitted");
			}
			else {
				System.out.println("Issue has not been Submitted");
			}*/
			w1.userLogOut(driver);
			//driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		//	driver.close();
	}

}
