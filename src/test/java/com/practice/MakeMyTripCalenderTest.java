package com.practice;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripCalenderTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		String MonthAndYear="December 2023";
		int date=20;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Actions a=new Actions(driver);
		Thread.sleep(8000);
		a.doubleClick().perform();
		Thread.sleep(3000);
		a.moveByOffset(0,80).click().perform();
		
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		Thread.sleep(3000);
		String actual="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		String nextArrow="//span[@aria-label='Next Month']";
		for(;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		
	}


}
