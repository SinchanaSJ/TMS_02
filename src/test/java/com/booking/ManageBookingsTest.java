package com.booking;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ManageBookingsTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a= new Actions(driver);
		String actualText="SUCCESS:Booking Confirm successfully";
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		
		driver.findElement(By.xpath("//a[@href='manage-bookings.php']")).click();
		Thread.sleep(6000);
		WebElement confirm = driver.findElement(By.xpath("//td[@data-th='Action ']/span[text()!='Cancelled']/../preceding-sibling::td[@data-th='Status ']/span[text()='Pending']/../following-sibling::td[@data-th='Action ']/span/a[.='Confirm']"));
		a.moveToElement(confirm).click().perform();
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(5000);
		String expText=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(expText);
		if(expText.contains(actualText)) {
			System.out.println("Booking Confirmed");
		}
		else {
			System.out.println("Booking not Confirmed");
		}
		//admin logout
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
		
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//li[@class='prnt']/a[.='My Tour History']")).click();

	}
	
}
