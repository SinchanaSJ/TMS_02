package com.tourPackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToTourPackagePageTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		WebDriver driver = null;
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PWD=p.getProperty("password");
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualText=" TMS- Package List";
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'Tour Packages')]")).click();
		Thread.sleep(5000);
		String expText = driver.findElement(By.xpath("//h1[@class='wow zoomIn animated animated animated']")).getText();
		System.out.println(expText);
		
		if(actualText.contains(expText)) {
			System.out.println("Package List is displaying");
		}
		else {
			System.out.println("Package List is not displaying");
		}
		driver.quit();
	}

}
