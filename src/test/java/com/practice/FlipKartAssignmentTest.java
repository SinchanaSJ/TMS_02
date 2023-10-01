package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartAssignmentTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@role='button']")).click();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("5g mobiles");
		List<WebElement> allSugg = driver.findElements(By.xpath("//a[@class='oleBil']"));
		for(WebElement s:allSugg) {
			String text=s.getText();
			System.out.println(text);
		}
		
		
	}
}
