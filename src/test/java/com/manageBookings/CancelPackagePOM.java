package com.manageBookings;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.ObjectRepo.BookPackagePage;
import com.TMS.ObjectRepo.MyTourHistoryPage;
import com.TMS.ObjectRepo.SigInPage;
import com.TMS.ObjectRepo.WelcomePage;
import com.TMS.genericUtils.BaseClass;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;

public class CancelPackagePOM extends BaseClass{
@Test(groups = "Regression")
public void cancelPackagePOM() throws InterruptedException, IOException {
		
		
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		
		//WebDriver driver=null;
		
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
		
		driver.get(URL);
		libW.maximizeTheBrowser(driver);
		libW.implicitWait(driver, 10);
		Actions a= new Actions(driver);*/
		int random=libJ.getRandomNumber();
		String actualText="SUCCESS:Booked Successfully";
		String actCancel="SUCCESS:Booking Cancelled successfully";
		
		SigInPage si=new SigInPage(driver);
		si.userSignin(UName, Password);
		
//		driver.findElement(By.xpath("//li[@class='sigi']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UName);
//		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(Password);
//		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		
		
		/*driver.findElement(By.xpath("//a[@href='tour-history.php']")).click();
		List<WebElement> text = driver.findElements(By.xpath("//table//tr/td[1]"));
		TreeSet<String> set = new TreeSet<>();
		Thread.sleep(2000);
		for (WebElement text1 : text) {
			String num=text1.getText();
			set.add(num);
		}
		int lastNum = set.size();*/
		MyTourHistoryPage mt=new MyTourHistoryPage(driver);
		int lastNum=mt.tour(driver);
		//System.out.println(lastNum);
		
		BookPackagePage bp = new BookPackagePage(driver);
		bp.bookPackage(driver, "Booked");
		/*driver.findElement(By.xpath("//a[contains(.,'Tour Packages')]")).click();
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
		WelcomePage w= new WelcomePage(driver);
		w.userLogOut(driver);
		AdminLoginPage ad=new AdminLoginPage(driver);
		ad.adminLogin(UN, PWD);
		
		/*driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();*/
		
		w.adminLogOut(driver);
		
		/*WebElement toggle = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		libW.mouseHoverOnElement(driver, toggle);
		//a.moveToElement(toggle).perform();
		toggle.click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();*/
		
		SigInPage sig= new SigInPage(driver);
		sig.userSignin(UName, Password);
		
		/*driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UName);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();*/
		
		
	/*	driver.findElement(By.xpath("//a[@href='tour-history.php']")).click();
		
		List<WebElement> text2 = driver.findElements(By.xpath("//table//tr/td[1]"));
		TreeSet<String> set1 = new TreeSet<>();
		Thread.sleep(2000);
		for (WebElement text12 : text2) {
			String num1=text12.getText();
			set1.add(num1);
		}
		int lastNum1 = set1.size();
		//System.out.println(lastNum1);
		if(lastNum1==lastNum+1) {
			System.out.println("Package Added");
		}
		else {
			System.out.println("Package not Added");
		}
		Thread.sleep(3000);
		WebElement cancel = driver.findElement(By.xpath("//table//tr/td[.='"+lastNum1+"']/..//a[contains(.,'Cancel')]"));
		a.scrollByAmount(0, 3000).perform();
		cancel.click();
		Alert al=driver.switchTo().alert();
		al.accept();
		String expCancel = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(expCancel);
		if(actCancel.contains(expCancel)) {
			System.out.println("Package cancelled Successfully");
		}
		else {
			System.out.println("Package not cancelled");
		}*/
		
		mt.tourH(driver, lastNum);
		
		
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		
		ad.adminLogin(UN, PWD);
		
	/*	driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();*/
		
		mt.manageBook(driver);
		/*driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
		
		String path = "//table//tr/td[@data-th='Action ']";
		List<WebElement> text3 = driver.findElements(By.xpath(path));
        int count = text3.size();
        System.out.println(count);
        Thread.sleep(3000);
        WebElement t = driver.findElement(By.xpath("("+path+")"+"["+count+"]"));
		a.scrollToElement(t).perform();
		String m = t.getText();
		//System.out.println(m);
		String s="Cancelled";
		if(s.contains(m)) {
			System.out.println("User Cancelled the Package");
		}
		else {
			System.out.println("User not Cancelled the Package");
		}*/
		//driver.quit();
		
}
}
