package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCmdTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void cmdTest() throws InterruptedException {
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//http://rmgtestingserver/domain/Online_Tourism_Management_System/
		driver.findElement(By.xpath("//li[@class='sigi']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='SIGNIN']")).click();
		
	}
}
