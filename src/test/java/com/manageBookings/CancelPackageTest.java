package com.manageBookings;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CancelPackageTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a= new Actions(driver);
		Random ran = new Random();
		int random=ran.nextInt();
		String actualText="SUCCESS:Booked Successfully";
		String actCancel="SUCCESS:Booking Cancelled successfully";
		
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[@href='tour-history.php']")).click();
		List<WebElement> text = driver.findElements(By.xpath("//table//tr/td[1]"));
		TreeSet<String> set = new TreeSet<>();
		Thread.sleep(2000);
		for (WebElement text1 : text) {
			String num=text1.getText();
			set.add(num);
		}
		int lastNum = set.size();
		//System.out.println(lastNum);
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
		
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
		
		//Recently booked package should be displayed
		
		WebElement toggle = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		a.moveToElement(toggle).click().perform();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
		
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[@href='tour-history.php']")).click();
		
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
		if(actCancel.contains(expCancel)) {
			System.out.println("Package cancelled Successfully");
		}
		else {
			System.out.println("Package not cancelled");
		}
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
		
		String path = "//table//tr/td[@data-th='Action ']";
		List<WebElement> text3 = driver.findElements(By.xpath(path));
        int count = text3.size();
        
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
		}
		
		
}
}
