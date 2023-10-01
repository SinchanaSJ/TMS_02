package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		try {
		driver.manage().window().maximize();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	driver.findElement(By.xpath("//a[contains(.,'Groceries')]")).click();
	driver.findElement(By.xpath("//div[@class='accordion-outer top_category_list jm-list category-content-title']"));
	
	List<WebElement> allText = driver.findElements(By.xpath("//div[@class='jm-list-prefix']/parent::div[@aria-expanded='true']/following-sibling::div[@class='accordion-inner jm-pl-l category-content-text-list collapse show']/div[@class='jm-list category-content-text-list-item']"));
         System.out.println(allText .size());
	for (WebElement webElement : allText) {
		String text = webElement.getText();
		System.out.println(text);
		
	}
		}
		catch(Exception e) {
			
		}
		finally {
	
		}
	}

}
