package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccTableRankingsTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allCountries = driver.findElements(By.xpath("//table/tbody//tr[*]//span[@class='u-hide-phablet']"));
		int count = allCountries.size();
		String country="Scotland";
		int n=0;
		for(int i=0;i<count;i++) {
			String text = allCountries.get(i).getText();
			if(text.equals(country)) {
			n++;
			break;
			}
		}
		if(n==1) {
			System.out.println("Present");
		}
		else {
			System.out.println("Not Present");
		}
	}

	
}
