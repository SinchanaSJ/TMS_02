package com.manageBookings;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyManageUser {
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
		String name = "XYZ";
		String PhNo = "7894561230";
		String email = "xyz123@gmail.com"+random;
		String pwd = "Test@123";
		String actProfile="SUCCESS:Profile Updated Successfully";
		String upMob="9987445630";
		
		String actAcc="Info successfully submited";
		driver.findElement(By.xpath("//a[contains(.,'Sign Up')]")).click();
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='mobilenumber']")).sendKeys(PhNo);
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='CREATE ACCOUNT']")).click();
		
		Thread.sleep(3000);
		String expAcc = driver.findElement(By.xpath("//div[@class='con-top animated wow fadeInUp animated animated']/h4")).getText();
		if(actAcc.contains(expAcc)) {
			System.out.println("Issue has been Submitted");
		}
		else {
			System.out.println("Issue has not been Submitted");
		}
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		
		//admin login
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='manage-users.php']")).click();
		
		//Check manage user
		
		Thread.sleep(5000);
		//String userEmail = driver.findElement(By.xpath("//div[@class='w3l-table-info']/table/tbody/descendant::span[.='"+email+"']")).getText();
		WebElement target = driver.findElement(By.xpath("//div[@class='w3l-table-info']/table/tbody/descendant::span[.='"+email+"']"));
		a.moveToElement(target).perform();
		String userEmail=target.getText();
		if(userEmail.contains(email)) {
			System.out.println("User details are present in Manage Users page");
		}
		else {
			System.out.println("User details are not present in Manage Users page");
		}
		
		WebElement toggle = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		a.moveToElement(toggle).click().perform();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
		
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		driver.findElement(By.xpath("//a[@href='profile.php']")).click();
		driver.findElement(By.xpath("//input[@name='mobileno']")).clear();
		driver.findElement(By.xpath("//input[@name='mobileno']")).sendKeys(upMob);
		WebElement update = driver.findElement(By.xpath("//button[.='Updtae']"));
		a.moveToElement(update).click().perform();
		String expProfile = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		if(actProfile.contains(expProfile)) {
			System.out.println("Profile updated Successfully");
		}
		else {
			System.out.println("Profile not updated");
		}
		driver.findElement(By.xpath("//a[contains(.,'/ Logout')]")).click();
		//admin login
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.findElement(By.xpath("//a[@href='manage-users.php']")).click();
		
		//Check manage user's updated profile
		
		Thread.sleep(5000);
		WebElement target1 = driver.findElement(By.xpath("//div[@class='w3l-table-info']/table/tbody/descendant::span[.='"+upMob+"']"));
		a.moveToElement(target1).perform();
		String userMob=target1.getText();
		if(userMob.contains(upMob)) {
			System.out.println("User details are updated in Manage Users page");
		}
		else {
			System.out.println("User details are not updated in Manage Users page");
		}
		WebElement toggle1 = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		a.moveToElement(toggle1).click().perform();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu drp-mnu']/li[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='back']/a[.='Back to home']")).click();
		driver.quit();
}
}
