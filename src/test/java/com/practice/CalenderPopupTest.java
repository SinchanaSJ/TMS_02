package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPopupTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/");
		int date = 31;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date+"']")).click();
	}

}
