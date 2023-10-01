package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalenderTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		String MonthAndYear="December 2023";
		int date=20;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		//driver.findElement(By.xpath("//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='1']")).click();
		//driver.findElement(By.xpath("//span[.='Done']")).click();
		String actual="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
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
		driver.findElement(By.xpath("//span[.='Done']")).click();
	}

}
