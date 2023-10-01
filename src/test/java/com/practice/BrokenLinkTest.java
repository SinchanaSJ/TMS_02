package com.practice;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> listLinks = driver.findElements(By.xpath("//a"));
		System.out.println(listLinks.size());
		ArrayList<String> link = new ArrayList<String>();
		for(int i=0;i<listLinks.size();i++) {
			String eachLink=listLinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode=0;
			
			try {
				url=new URL(eachLink);
				HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
				statusCode=httpConn.getResponseCode();
				
				if(statusCode>=400) {
					link.add(eachLink);
					System.out.println(eachLink+" --> "+statusCode);
				}
			}
			catch(Exception e) {
				link.add(eachLink);
			}
		}
		
	}

}
