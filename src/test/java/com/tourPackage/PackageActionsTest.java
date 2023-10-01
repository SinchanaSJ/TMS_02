package com.tourPackage;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PackageActionsTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		String actUpdate="SUCCESS:Package Updated Successfully";
		String actWrite="Info successfully submited";
		Actions a = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualText="SUCCESS:Booked Successfully";
		String actCreate = "SUCCESS:Package Created Successfully";
		String actManage="SUCCESS:Booking Confirm successfully";
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Tour Packages')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=1']")).click();
		driver.findElement(By.xpath("//input[@name='fromdate']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='3']")).click();
		driver.findElement(By.xpath("//input[@name='todate']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='10']")).click();
		Thread.sleep(5000);
		WebElement comment = driver.findElement(By.xpath("//input[@name='comment']"));
		a.moveToElement(comment).click().perform();
		comment.sendKeys("Please Confirm the Bookings");
		driver.findElement(By.xpath("//button[.='Book']")).click();
		String expText = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		if(actualText.contains(expText)) {
			System.out.println("Tour Package Booked Successfully");
		}
		else {
			System.out.println("Tour Package not Booked");
		}
		driver.findElement(By.xpath("//li[@class='sigi']/a")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a//span[.=' Tour Packages']")).click();
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
		a.moveToElement(create).perform();
		create.click();
		
		String ExpCreate = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actCreate.contains(ExpCreate)) {
			 System.out.println("Package Updated Successfully");
		 }
		 else {
			 System.out.println("Package not Updated");
		 }
		
		driver.findElement(By.xpath("//a//span[.=' Tour Packages']")).click();
		
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
		 }
		 
		 driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
			Thread.sleep(6000);
			WebElement confirm = driver.findElement(By.xpath("//td[@data-th='Action ']/span[text()!='Cancelled']/../preceding-sibling::td[@data-th='Status ']/span[text()='Pending']/../following-sibling::td[@data-th='Action ']/span/a[.='Confirm']"));
			a.moveToElement(confirm).click().perform();
			Alert al = driver.switchTo().alert();
			al.accept();
			Thread.sleep(5000);
			String expManage=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
			if(expManage.contains(actManage)) {
				System.out.println("Booking Confirmed");
			}
			else {
				System.out.println("Booking not Confirmed");
			}
			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
			driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
			
			driver.findElement(By.xpath("//li[@class='sigi']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Test@123");
			driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
			driver.findElement(By.xpath("//li[@class='prnt']/a[.='My Tour History']")).click();
			
			//check for the confirmed tour package in MyTourHistory
			
			driver.findElement(By.xpath("//a[contains(.,' / Write Us ')]")).click();
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
			}
			driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
			driver.close();
	}
}
