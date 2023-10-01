package com.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EMICalculatorTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		////*[name()='path' and @class='highcharts-point highcharts-point-hover']
	}
	
}
