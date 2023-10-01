package com.booking;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.TMS.ObjectRepo.AdminLoginPage;
import com.TMS.ObjectRepo.MyTourHistoryPage;
import com.TMS.ObjectRepo.SigInPage;
import com.TMS.ObjectRepo.WelcomePage;
import com.TMS.genericUtils.BaseClass;
import com.TMS.genericUtils.ExcelUtility;
import com.TMS.genericUtils.FileUtility;
import com.TMS.genericUtils.JavaUtility;
import com.TMS.genericUtils.WebdriverUtility;

public class ManageBookingsPOM extends BaseClass{
	@Test(groups = "Regression")
	public void manageBookingsPOM() throws IOException, InterruptedException {
		ExcelUtility libE=new ExcelUtility();
		FileUtility libF=new FileUtility();
		JavaUtility libJ=new JavaUtility();
		WebdriverUtility libW=new WebdriverUtility();
		//to launch the browser
		//WebDriver driver=null;
		
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

		//to enter the url
		/*driver.get(URL);*/
		libW.maximizeTheBrowser(driver);
		libW.implicitWait(driver, 10);
		//to click on admin login link
		
		AdminLoginPage al = new AdminLoginPage(driver);
		al.adminLogin(UN, PWD);
		/*driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@name='login']")).click();*/

		String bookingId="#BK-25";	
		//to click on Manage Bookings link
		driver.findElement(By.xpath("//span[text()='Manage Booking']")).click();
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr/td[1]/span[text()='"+bookingId+"']"));
		Actions a=new Actions(driver);
//		a.moveToElement(ele).perform();
		libW.mouseHoverOnElement(driver, ele);
		List<WebElement> allelem = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		//System.out.println(elem.size());

		//System.out.println(i);
		a.click(driver.findElement(By.xpath("//span[text()='"+bookingId+"']/../following-sibling::td[8]/descendant::a[2]"))).perform();
		//driver.switchTo().alert().accept();
		libW.acceptAlertPopup(driver);
		
		
		
		driver.findElement(By.xpath("//div[@class='succWrap' and contains(text(),':Booking Confirm successfully') ]"));
		
		WelcomePage w= new WelcomePage(driver);
		w.adminLogOut(driver);
		/*driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
		driver.findElement(By.xpath("//a[text()='Back to home']")).click();*/
		
		//User login
		/*driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//h3[text()='Signin with your account ']/following-sibling::input[@name='email']")).sendKeys(UName);
		driver.findElement(By.xpath("//h3[text()='Signin with your account ']/following-sibling::input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='signin']")).click();*/
	
		
		
		SigInPage si = new SigInPage(driver);
		si.userSignin(UName, Password);
		
		/*driver.findElement(By.xpath("//a[text()='My Tour History']")).click();
		String userBookingId="#BK25";
		a.moveToElement(driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+userBookingId+"']"))).perform();
		List<WebElement> allStatus = driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		boolean flag=false;
		for(int i=0;i<allStatus.size();i++)
		{
			if(i==allStatus.size()-1)
			{
				String value=allStatus.get(i).getText();
				System.out.println(value);
				if(value.contains("Confirmed"))
				{
					flag=true;
					break;
				}
			}
		}
		if(flag)
			System.out.println("The admin confirmed booking is updated");
		else
			System.out.println("The admin confirmed booking is not get updated");*/
		MyTourHistoryPage mt = new MyTourHistoryPage(driver);
		mt.confirmBookings(driver);
		
		w.userLogOut(driver);
		//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	
	}
}
