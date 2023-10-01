package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccAssignmentTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		int mat=40;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/");
		driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']/descendant::button[contains(text(),'Rankings')]")).click();
		driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']/descendant::a[@href='/rankings/mens/team-rankings']")).click();
		
		List<WebElement> allMatches = driver.findElements(By.xpath("//tbody/tr/td[3][text()<"+mat+"]/preceding-sibling::td[1]/span[@class='u-hide-phablet']"));
		System.out.println("The teams which have been played matches less than "+mat+" are "+allMatches.size());
		for(WebElement e: allMatches)
		{
			System.out.println(e.getText());

		}
		driver.quit();
		
	}
	
}
